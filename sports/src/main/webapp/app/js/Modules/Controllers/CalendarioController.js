App.controller('CalendarController', ['$scope', '$http', '$timeout', function($scope, $http, $timeout) {
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

        // check to remove elements from the list
        calElement.fullCalendar({
        	isRTL: $scope.app.layout.isRTL,
            header: {
                left:   'prev,next',
                center: 'title'
            },
            buttonIcons: { // note the space at the beginning
                prev:    ' fa fa-caret-left',
                next:    ' fa fa-caret-right'
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
        
    $scope.init = function(){
    	
    		var calendar = $('#calendar');
        	
        	var reservaciones = initReservaciones(establecimientoCalendario.calendario);
        	
        	initExternalEvents(calendar);

        	initCalendar(calendar, reservaciones);

      }
    
    $scope.init();

    
}]);

App.controller('ServiciosCalendarioController', ['$scope', function($scope ) {
	$scope.Servicios = establecimientoCalendario.servicios;

}]);


/**=========================================================
 * Module: modals.js
 * Provides a simple way to implement bootstrap modals from templates
 =========================================================*/

App.controller('ModalReservacionesController', ['$scope', '$modal', '$http', function ($scope, $modal, $http) {
	var servicioActual;
    $scope.open = function (size, idServicioActual) {
    	servicioActual = idServicioActual;

        var modalInstance = $modal.open({
            templateUrl: '/modalReservaciones.html',
            controller: ModalInstanceCtrl,
            size: size
        });

        var state = $('#modal-state');
        modalInstance.result.then(function () {
            state.text('Modal dismissed with OK status');
        }, function () {
            state.text('Modal dismissed with Cancel status');
        });
    };

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
        });
        
    }
    
    // Please note that $modalInstance represents a modal window (instance) dependency.
    // It is not the same as the $modal service used above.

    var ModalInstanceCtrl = function ($scope, $modalInstance) {
    	$scope.reservacion = {};
    	
        $scope.ok = function () {
        	
        	/*alert(servicioActual);
        	
        	alert($scope.reservacion.fecha);
        	
        	alert(new Date().getTime());
        	
        	alert($scope.reservacion.hora);
        	
        	alert(new Date().getTime());*/
        	
        	$scope.registrarReservacion();
            
            $modalInstance.close('closed');
        };

        $scope.cancel = function () {
            $modalInstance.dismiss('cancel');
        };
        
/*HAY QUE CAMBIAR EL FORMATO PARA QE SE REGISTRE*/
        
        
        $scope.registrarReservacion = function(){
        	$http.post('rest/reservaciones/save', {
    			fecha: new Date().getTime(),
    			hora: new Date().getTime(),
    			ocurrencia : 'Normal',
    			servicio : + servicioActual,
    			usuario : 1
    		 	})
    		.success(function(data){
    			$('calendar').fullCalendar('renderEvent', initReservaciones(data.jsoncalendar));
    			$('calendar').fullCalendar('render');
    		});
        }
    };
    ModalInstanceCtrl.$inject = ["$scope", "$modalInstance"];

}]);