/**
 * Modulo Controlador para calendario
 * author: Luis Esteban López Ramírez
 * Fecha: 8/07/2015
 * Revision: 1.0
 * 
 * Modulo Controlador para calendario
 * author: Mauricio Fernandez
 * Fecha: 16/07/2015
 * Revision: 1.1 
 */

var reservacionModificar = {};
    

App.controller('CalendarController', ['$scope', '$rootScope', '$state', '$http', '$timeout', '$modal', 'toaster', '$stateParams', function($scope, $rootScope,$state ,$http, $timeout, $modal, toaster, $stateParams) {
    'use strict';
    if(!$.fn.fullCalendar) return;

    // global shared var to know what we are dragging
    var draggingEvent = null;
    
    

    // listen for the event in the relevant $scope
       $scope.$on('myEvent', function (event, data) {
  
    	   var calendar = $('#calendar');
    	   initExternalEvents(calendar);
    	   initCalendar(calendar, data);
       });

    /**
     * ExternalEvent object
     * @param jQuery Object elements Set of element as jQuery objects
     */
    var ExternalEvent = function (elements) {

        if (!elements) return;

        elements.each(function() {
            var $this = $(this);
            // create an Event Object (http://arshaw.com/fullcalendar/docs/event_data/Event_Object/)
            // it doesn't need to have a start or end
            var calendarEventObject = {
                title: $.trim($this.text()) // use the element's text as the event title
            };

            // store the Event Object in the DOM element so we can get to it later
            $this.data('calendarEventObject', calendarEventObject);

            // make the event draggable using jQuery UI
            $this.draggable({
                zIndex: 1070,
                revert: true, // will cause the event to go back to its
                revertDuration: 0  //  original position after the drag
            });

        });
    };

    
    /**
     * Invoke full calendar plugin and attach behavior
     * @param  jQuery [calElement] The calendar dom element wrapped into jQuery
     * @param  EventObject [events] An object with the event list to load when the calendar displays
     */
    function initCalendar(calElement, events) {

        // check to remove elements from the list
        calElement.fullCalendar({
            monthNames: ['Enero','Febrero','Marzo','Abril','Mayo','Junio','Julio','Agosto','Septiembre','Octubre','Noviembre','Diciembre'],
            monthNamesShort: ['Ene','Feb','Mar','Abr','May','Jun','Jul','Ago','Sep','Oct','Nov','Dic'],
            dayNames: ['Domingo','Lunes','Martes','Miércoles','Jueves','Viernes','Sábado'],
            dayNamesShort: ['Dom','Lun','Mar','Mié','Jue','Vie','Sáb'],
        	isRTL: $scope.app.layout.isRTL,
            header: {
                left:   'prev,next',
                center: 'title',
            },
            buttonIcons: { // note the space at the beginning
                prev:    ' fa fa-caret-left',
                next:    ' fa fa-caret-right'
            },
            buttonText: {
                today: 'Hoy',
            },
            allDaySlot: false,
            defaultView:'agendaWeek',
            firstDay: 1,
            businessHours :{start: 8, end: 23},
            height: 700,
            events: events,
            eventClick:  function(evento, jsEvent, view) {
            	$http.post('rest/reservaciones/getReservacion', {idCalendario: evento.idReservacion})
                .success(function(data){
                	if(data.code = 200){
                	reservacionModificar.servicio = data.servicio;
                	reservacionModificar.reservacion = data.reservacion;
                	reservacionModificar.torneo = data.torneo;
                	var ModificarModalInstance = $modal.open({
                        templateUrl: '/modalReservaciones.html',
                        controller: ModificarReservacionInstanceCtrl,
                        size: 'lg'
                    });
                	}else{
                		$rootScope.errorMessage = data.codeMessage;
                		$state.go('page.error');
                	}
                });
                }
            });
        calElement.fullCalendar('show');
    }
    

    function initReservaciones(reservacionesJSON){
    
    var reservaciones = [];
    
    angular.forEach(reservacionesJSON, function(reservacionJSON, index){
    	var reservacion = {};
    	reservacion.title = reservacionJSON.title;
    	
    	reservacion.start = new Date(reservacionJSON.start.millis);
    	if(reservacionJSON.end != null){
    	reservacion.end = new Date(reservacionJSON.end.millis);
    	}
    	reservacion.backgroundColor = reservacionJSON.backgroundColor;
    	reservacion.borderColor = reservacionJSON.borderColor;
    	reservacion.idReservacion = reservacionJSON.idCalendario;
    	
    	reservaciones.push(reservacion);
    });
    
    return reservaciones;
    }
     /**
     * Inits the external events panel
     * @param  jQuery [calElement] The calendar dom element wrapped into jQuery
     */
    function initExternalEvents(calElement){
        // Panel with the external events list
        var externalEvents = $('.external-events');

        // init the external events in the panel
        new ExternalEvent(externalEvents.children('div'));

        // External event color is danger-red by default
        var currColor = '#f6504d';
        // Color selector button
        var eventAddBtn = $('.external-event-add-btn');
        // New external event name input
        var eventNameInput = $('.external-event-name');
        // Color switchers
        var eventColorSelector = $('.external-event-color-selector .circle');

        // Trash events Droparea 
        $('.external-events-trash').droppable({
            accept:       '.fc-event',
            activeClass:  'active',
            hoverClass:   'hovered',
            tolerance:    'touch',
            drop: function(event, ui) {

                // You can use this function to send an ajax request
                // to remove the event from the repository

                if(draggingEvent) {
                    var eid = draggingEvent.id || draggingEvent._id;
                    // Remove the event
                    calElement.fullCalendar('removeEvents', eid);
                    // Remove the dom element
                    ui.draggable.remove();
                    // clear
                    draggingEvent = null;
                }
            }
        });

        eventColorSelector.click(function(e) {
            e.preventDefault();
            var $this = $(this);

            // Save color
            currColor = $this.css('background-color');
            // De-select all and select the current one
            eventColorSelector.removeClass('selected');
            $this.addClass('selected');
        });

        eventAddBtn.click(function(e) {
            e.preventDefault();

            // Get event name from input
            var val = eventNameInput.val();
            // Dont allow empty values
            if ($.trim(val) === '') return;

            // Create new event element
            var newEvent = $('<div/>').css({
                'background-color': currColor,
                'border-color':     currColor,
                'color':            '#fff'
            })
                .html(val);

            // Prepends to the external events list
            externalEvents.prepend(newEvent);
            // Initialize the new event element
            new ExternalEvent(newEvent);
            // Clear input
            eventNameInput.val('');
        });
    }

    /**
     * Creates an array of events to display in the first load of the calendar
     * Wrap into this function a request to a source to get via ajax the stored events
     * @return Array The array with the events
     */
    
    $scope.$on('actualizar', function(){
    	$('#calendario').append('<div id="calendarioContent">' +
						'<div id="calendar"></div>' +
					'</div>');
    	
    	$scope.init();
    })
    
    $scope.init = function(){
    	
    		var calendar = $('#calendar');
        	
        	var reservaciones = initReservaciones(establecimientoCalendario.calendario);
        	
        	initExternalEvents(calendar);

        	initCalendar(calendar, reservaciones);

      }
    
    $scope.init();
    
    var ModificarReservacionInstanceCtrl = function ($scope, $modalInstance) {
    	$scope.isTorneo = false;
    	
    	$scope.reservacion = {};
    	
    	$scope.reservacion.idReservacion = reservacionModificar.reservacion.idCalendario;    	
    	
    	if(reservacionModificar.torneo != null){
    		$scope.isTorneo = true;
    		$scope.torneoForm = {};
    		$scope.torneoForm = reservacionModificar.torneo;
    		$scope.reservacion.idReservacion = $scope.torneoForm.idTorneo;
    	}
    	
    	$scope.reservacion.fecha = new Date(reservacionModificar.reservacion.start.millis);
    	$scope.reservacion.fecha.setMinutes(0);
    	$scope.reservacion.hora = new Date(reservacionModificar.reservacion.start.millis);
    	$scope.reservacion.hora.setMinutes(0);
        $scope.accion = "Modificar";
        
      
        
        $scope.modificar = function () {
        	
        	var fecha = $scope.reservacion.fecha;
        	var hora = $scope.reservacion.hora;
        	
        	var registrar = true;
        	
        	angular.forEach(establecimientoCalendario.calendario, function(reservacion, index){
        		if(validarCalendario(servicioActual, hora, fecha)){
        			registrar = false;
        		}
        	});
        	
        	if(registrar == true){
        		$scope.modificarReservacion();
        	}else{
        		var toasterdata = {
			            type:  'error',
			            title: 'Reservación',
			            text:  'El servicio seleccionado se encuentra ocupado a la hora seleccionada. \n Intente nuevamente.'
			    };
    			$scope.pop(toasterdata);
        	}
        	
        	 $scope.pop = function(toasterdata) {
                 toaster.pop(toasterdata.type, toasterdata.title, toasterdata.text);
             };
            
        	
        	$modalInstance.close('closed');  
        	
            
        };

        $scope.cancel = function () {
            $modalInstance.dismiss('cancel');
        };
        
        $scope.ok = function(){
        	var data = {
        			fecha: $scope.reservacion.fecha,
        			hora: $scope.reservacion.hora.getTime(),
        			estado : 'Reservado',
        			servicio : reservacionModificar.servicio.idServicio,
        			usuario : 1,
        			establecimiento : establecimientoCalendario.idEstablecimientoDeportivo,
        			accion:'Modificar',
        			idCalendario: $scope.reservacion.idReservacion,
        			torneo : $scope.isTorneo
        		 	};
        	if($scope.isTorneo){
        		data.nombre = $scope.torneoForm.torneo;
        		data.cupos = $scope.torneoForm.cupos;
        		data.horasTorneos = $scope.torneoForm.horasTorneos;
        	}
        	
        	$http.post('rest/reservaciones/save', data)
    		.success(function(data){
    			if(data.code = 200){
    			var toasterdata = {
			            type:  'success',
			            title: 'Reservaciones',
			            text:  'La reservación se modificó correctamnte'
			    };
    			$scope.pop(toasterdata);
    			$timeout(function(){ $scope.callAtTimeout(); }, 2000);
    			$http.get('rest/establecimientoDeportivo/getAll')
        		.success(function(response) {
        			if(response.code == 200){
        			var establecimientos = response.establecimientosDeportivos;
        			for (var i = 0; i < establecimientos.length; i++) {
                        if (establecimientos[i].idEstablecimientoDeportivo == $stateParams.mid){
                            establecimientoCalendario = establecimientos[i];
                        }
                    }
        			}else{
                		$rootScope.errorMessage = response.codeMessage;
                		$state.go('page.error');
                	}
        		});
            	$('#calendarioContent').remove();
    			}else{
            		$rootScope.errorMessage = data.codeMessage;
            		$state.go('page.error');
            	}
    		});
        	$modalInstance.close('closed');  
        	
        }
        $scope.pop = function(toasterdata) {
            toaster.pop(toasterdata.type, toasterdata.title, toasterdata.text);
        };
        
        $scope.eliminar = function(){
    		$http.post('rest/reservaciones/delete', {
    			idCalendario : $scope.reservacion.idReservacion,
    			establecimiento : establecimientoCalendario.idEstablecimientoDeportivo,
    			torneo : false
    	 	}).success(function(data){
    	 		if(data.code = 200){
    	 		var toasterdata = {
    					type:  'success',
    					title: 'Establecimiento',
    					text:  'Se ha aceptado la reservacion correctamente'
    			};
    	 		$scope.pop(toasterdata);
    			$timeout(function(){ $scope.callAtTimeout(); }, 2000);
    			$http.get('rest/establecimientoDeportivo/getAll')
        		.success(function(response) {
        			if(response.code == 200){
        			var establecimientos = response.establecimientosDeportivos;
        			for (var i = 0; i < establecimientos.length; i++) {
                        if (establecimientos[i].idEstablecimientoDeportivo == $stateParams.mid){
                            establecimientoCalendario = establecimientos[i];
                        }
                    }
        			}else{
                		$rootScope.errorMessage = response.codeMessage;
                		$state.go('page.error');
                	}
        		});
            	$route.reload();
            	}else{
            		$rootScope.errorMessage = data.codeMessage;
            		$state.go('page.error');
            	}
    			$('#calendarioContent').remove();
    	 	
    	 	})
    	}
        
        $scope.pop = function(toasterdata) {
            toaster.pop(toasterdata.type, toasterdata.title, toasterdata.text);
        };
        
        $scope.callAtTimeout = function(){
        	$state.reload();
        }
        
        function validarCalendario(servicio, hora, fecha){
        	var valido = false;
        	angular.forEach(establecimientoCalendario.servicios, function(servicioEstablecimiento, index){
        		if(servicioEstablecimiento.idServicio == servicio){
        			angular.forEach(servicioEstablecimiento.reservaciones, function(reservacion, index){
        				var horaReservacion = hora.toTimeString();
        				mes = function(){
        					if(fecha.getMonth()+1 > 10){
        						return '0'+ fecha.getMonth()+1; 
        					}else{
        						return fecha.getMonth()+1;
        					}
        				}
        				var fechaReservacion = fecha.getFullYear() + '-' + mes +
        				fecha.getDate();
        				
        				horaReservacion = horaReservacion.split(' ')[0];
        				if(reservacion.hora == horaReservacion && fechaReservacion == reservacion.fecha){
        					valido = true;
        				}
        			});
        		}
        	});
        	return valido;
        }
        
       };
    //ModificarReservacionInstanceCtrl.$inject = ["$scope", '$rootScope' ,"$modalInstance"];
}]);




/**
 * Modulo Controlador reservar los servicios
 * author: Mauricio Fernandez
 * Fecha: 15/07/2015
 * Revision: 1.0
 */

App.controller('ServiciosCalendarioController', ['$scope', '$rootScope',function($scope, $rootScope ) {
	$scope.Servicios = establecimientoCalendario.servicios;
}]);

$(function() {
	  var $container = $('.contenedorServicios');
	  var $b = $('body');
	  $.waypoints.settings.scrollThrottle = 0;
	  $container.waypoint({
	    handler: function(e, d) {
	      $b.toggleClass('sticky', d === 'down');
	      e.preventDefault();
	    }
	  });
	});


/**=========================================================
 * Module: modals.js
 * Provides a simple way to implement bootstrap modals from templates
 =========================================================*/

