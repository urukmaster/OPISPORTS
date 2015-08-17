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


/**==========================================================
 * Modulo: CalendarController
 * Este controlador se encarga de renderizar e inicializar el
 * calendario
 ============================================================*/
App.controller('CalendarController', ['$scope', '$http', '$timeout', function($scope, $http, $timeout ) {
    'use strict';
    if(!$.fn.fullCalendar) return;

    // global shared var to know what we are dragging
    var draggingEvent = null;
    


    // listen for the event in the relevant $scope
       $scope.$on('myEvent', function (event, data) {
    	   
    	 
         console.log(data); // 'Data to send'
         

   
 		var calendar = $('#calendar');
     	
     	console.log(data);
     	
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
            events: events
            });
        calElement.fullCalendar('show');
    }
    

    function initReservaciones(reservacionesJSON){
    
    var reservaciones = [];
    
    angular.forEach(reservacionesJSON, function(reservacionJSON, index){
    	var reservacion = {};
    	reservacion.title = reservacionJSON.title;
    	reservacion.start = new Date(reservacionJSON.start.millis);
    	reservacion.end = new Date(reservacionJSON.end.millis);
    	reservacion.backgroundColor = reservacionJSON.backgroundColor;
    	reservacion.borderColor = reservacionJSON.borderColor;
    	
    	reservaciones.push(reservacion);
    })
    
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
        	
        	console.log(reservaciones);
        	
        	initExternalEvents(calendar);

        	initCalendar(calendar, reservaciones);

      }
    
    $scope.init();
    
}]);

/**
 * Modulo Controlador reservar los servicios
 * author: Mauricio Fernandez
 * Fecha: 15/07/2015
 * Revision: 1.0
 */

App.controller('ServiciosCalendarioController', ['$scope', function($scope ) {
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


/**==========================================================
 * Modulo: ModalReservacionesController
 * Este controladorde desplegar un "Modal" para el registro
 * de reservaciones
 ============================================================*/

App.controller('ModalReservacionesController', ['$rootScope', '$scope', '$modal', '$http', '$state','toaster','$timeout','$route', function ($rootScope, $scope, $modal, $http, $state, moment,toaster,$timeout,$route) {
	var servicioActual;
	
	//Despliega el "Modal"
    $scope.open = function (size, idServicioActual) {
    	servicioActual = idServicioActual;

        var modalInstance = $modal.open({
            templateUrl: '/modalReservaciones.html',
            controller: ModalInstanceCtrl,
            size: ''
        });

        var state = $('#modal-state');
        modalInstance.result.then(function () {
            state.text('Modal dismissed with OK status');
        }, function () {
            state.text('Modal dismissed with Cancel status');
        });
    };

    var ModalInstanceCtrl = function ($scope, $modalInstance, toaster, $timeout, $route) {
    	$scope.reservacion = {};	
    	
    	//Confirmación de la reservación que se quiere registrar
        $scope.ok = function () {
        	
        	var fecha = $scope.reservacion.fecha;
        	var hora = $scope.reservacion.hora;
        	
        	var registrar = true;
        	
        	angular.forEach(establecimientoCalendario.calendario, function(reservacion, index){
        		if(validarCalendario(servicioActual, hora, fecha)){
        			registrar = false;
        		}
        	})
        	
        	if(registrar == true){
        	$scope.registrarReservacion(fecha, hora);

			
        	}else{
        		var toasterdata = {
			            type:  'error',
			            title: 'Reservación',
			            text:  'El servicio seleccionado se encuentra ocupado a la hora seleccionada. \n Intente nuevamente.'
			    };
    			$scope.pop(toasterdata);
        	}
        	
        	$modalInstance.close('closed');  
        	
            
        };

        //Cancelación de la cofirmación de la reseración
        $scope.cancel = function () {
            $modalInstance.dismiss('cancel');
        };
        
        $scope.registrarReservacion = function(fecha, hora){
        	$http.post('rest/reservaciones/save', {
    			fecha: fecha,
    			hora: hora.getTime(),
    			estado : 'Pendiente',
    			servicio : + servicioActual,
    			usuario : 1,
    			establecimiento : establecimientoCalendario.idEstablecimientoDeportivo,
    			accion:'Regsitrar'
    		 	})
    		.success(function(data){
    			var toasterdata = {
			            type:  'success',
			            title: 'Establecimiento',
			            text:  'Debe esperar a que la reservación sea aprobada\n por el administrador'
			    };
    			$scope.pop(toasterdata);
    			$timeout(function(){ $scope.callAtTimeout(); }, 2000);
    			establecimientoCalendario = data;
    			$('#calendarioContent').remove();
    			$rootScope.$broadcast("actualizar");
    		});
        }
        
        $scope.pop = function(toasterdata) {
            toaster.pop(toasterdata.type, toasterdata.title, toasterdata.text);
        };
        
        $scope.callAtTimeout = function(){
        	$route.reload();
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
    
    
    ModalInstanceCtrl.$inject = ["$scope", "$modalInstance", "toaster","$timeout", "$route"];

}]);