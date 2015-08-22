/**
 * Modulo Controlador para traer los datos de registar evento * 
 * author: Mauricio Fernandez
 * Fecha: 27/07/2015
 * Revision: 1.0
 *//**
 * Modulo Controlador para traer los datos de registar evento * 
 * author: Mauricio Fernandez
 * Fecha: 31/07/2015
 * Revision: 1.1
 */

/**==========================================================
 * Modulo: EventoModalController
 * Este controlador se encarga de desplegar un "Modal" 
 * para registrar un evento en la base de datos 
 ============================================================*/
App.controller('EventoModalController', ['$scope', '$rootScope','$modal', "$timeout" ,"$http", "$state", 'toaster', function ($scope, $rootScope,$modal, $timeout ,$http, $state, toaster) {
   
	//Depliega el "Modal"
	$scope.registrar = function () {	
        var RegistrarModalInstance = $modal.open({
            templateUrl: '/myEventoModalContent.html',
            controller: RegistrarEventoInstanceCtrl,
            size: 'lg'
        });

    };
    
    $scope.validarUsuarioRol = function(){	
		
		if(angular.equals({},$rootScope.usuario)){
			return false;
		}else{			
			for(i=0;i<$rootScope.usuario.roles.length;i++){				
					if($rootScope.usuario.roles[i].rol == "Administrador"){
						return true;
					}
					if($rootScope.usuario.roles[i].rol == "Administrador Evento"){
						return true;
					}
					if($rootScope.usuario.roles[i].rol == "Administrador Establecimiento"){
						return true;
					}
				
			}					
		}
		
	};

//------------------------------------------------------------------------------------
    var RegistrarEventoInstanceCtrl = function ($scope, $modalInstance) {

        //Valida el formulario de registro
          $scope.submitted = false;
          $scope.validateInput = function(name, type) {
              var input = $scope.formRegistrarEvento[name];
              return (input.$dirty || $scope.submitted) && input.$error[type];
          };
          
        //Envío del formulario
          $scope.submitForm = function() {
              $scope.submitted = true;
              if ($scope.formRegistrarEvento.$valid) {

              	var data = {
              		"nombre": $scope.eventoForm.nombre,
                      "precio": $scope.eventoForm.precio,
                      "hora": $scope.eventoForm.hora.getTime(),
                      "fecha": $scope.eventoForm.fecha,
                      "informacion": $scope.eventoForm.informacion,
                      "tipoEvento" : 1,
                      "establecimiento" : 1,
                      "active": 1,
                      "cupo" : $scope.eventoForm.cupo,
                      "diasParaRetiro": $scope.eventoForm.diasParaRetiro,
                      "direccion" : $scope.eventoForm.direccion,
                      "accion" : "Registrar"
                  };
                  
              	//Manda a salvar el evento
                  $http.post('rest/evento/save', data).
                  success(function(data){
                	  if(data.code = 200){
                  	var toasterdata = {
      			            type:  'success',
      			            title: 'Evento',
      			            text:  'Se registro el evento correctamente.'
      			    };
          			$scope.pop(toasterdata);
            			$timeout(function(){ $scope.callAtTimeout(); }, 2000);
                  	$modalInstance.dismiss('cancel');
                	  }else{
                  		$rootScope.errorMessage = data.codeMessage;
                  		$state.go('page.error');
                  	}
                  });
                  
            	  }
              }
    	
    	
    	$scope.eventoForm = {};
        $scope.eventoForm.hora = new Date();
        $scope.eventoForm.fecha = new Date();  
        
        $scope.cancel = function () {
            $modalInstance.dismiss('cancel');
        };
        
        //Despliegue de confirmación    
        $scope.pop = function(toasterdata) {
            toaster.pop(toasterdata.type, toasterdata.title, toasterdata.text);
        };
        
        $scope.callAtTimeout = function(){
        	$state.reload();
        }
        
    };
    RegistrarEventoInstanceCtrl.$inject = ["$scope", "$modalInstance", "$http"];
    
}]);

/**==========================================================
 * Modulo: CalendarControllerEventos
 * Este controlador se encarga de renderizar e inicializar
 * el calendario de eventos deportivos
 ============================================================*/
App.controller('CalendarControllerEventos', ['$scope', '$rootScope','$http', '$timeout', '$state', '$modal', function($scope, $rootScope,$http, $timeout, $state, $modal) {
    'use strict';
    if(!$.fn.fullCalendar) return;

    // global shared var to know what we are dragging
    var draggingEvent = null;


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

    	calElement.fullCalendar({
            isRTL: $scope.app.layout.isRTL,
            monthNames: ['Enero','Febrero','Marzo','Abril','Mayo','Junio','Julio','Agosto','Septiembre','Octubre','Noviembre','Diciembre'],
            monthNamesShort: ['Ene','Feb','Mar','Abr','May','Jun','Jul','Ago','Sep','Oct','Nov','Dic'],
            dayNames: ['Domingo','Lunes','Martes','Miércoles','Jueves','Viernes','Sábado'],
            dayNamesShort: ['Dom','Lun','Mar','Mié','Jue','Vie','Sáb'],
            header: {
                left:   'prev,next today',
                center: 'title',
                right:  ''
            },
            buttonIcons: { // note the space at the beginning
                prev:    ' fa fa-caret-left',
                next:    ' fa fa-caret-right'
            },
            buttonText: {
                today: 'hoy',
                month: 'mes',
                week:  'semana',
                day:   'dia'
            },
            eventClick:  function(evento, jsEvent, view) {
                $state.go('app.perfilEvento',{id: evento.idEvento});
                
            },
            events: events
        });
    }   

    

    function initEventos(eventosJSON){
    
    var eventos = [];
    
    angular.forEach(eventosJSON, function(eventoJSON, index){
    	var evento = {};
    	evento.title = eventoJSON.title;
    	evento.start = new Date(eventoJSON.start.millis);
    	evento.end = new Date(eventoJSON.end.millis);
    	evento.backgroundColor = eventoJSON.backgroundColor;
    	evento.borderColor = eventoJSON.borderColor;
    	evento.idEvento = eventoJSON.idEvento;
    	
    	eventos.push(evento);
    })
    
    return eventos;
    
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
    
    $scope.init = function(){
    	
    	$http.get('rest/evento/getAll')
        .success(function(data) {
        	
        	if(data.code == 200){
        	var calendar = $('#calendar');
               	
        	var eventos = initEventos(data.jsoncalendar);
        	
        	initExternalEvents(calendar);

        	initCalendar(calendar, eventos);
        	
        	}else{
        		$rootScope.errorMessage = data.codeMessage;
        		$state.go('page.error');
        	}

        });	
    	
    };
    
    $scope.init();    
    
}]);