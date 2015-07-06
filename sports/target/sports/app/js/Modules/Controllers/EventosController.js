/**=========================================================
 * Module: Evento
 =========================================================*/


var gridEventos = {};

App.controller('EventosController', ['$scope', 'uiGridConstants', '$http', function($scope, uiGridConstants, $http) {

    var data = [];

    gridEventos = $scope.gridEventos = {
        columnDefs: [
            { field: 'id',visible:false},
            { field: 'nombre', name:"Evento"},
            {field: 'direccion', name:"Dirección"},
            { field: 'fecha', name:"Fecha"},
            { field: 'hora', name:"Hora"},
            {name: 'acciones', cellTemplate:'<div ng-controller="EventoModalController" >' +
            '<button ng-click="modificar(row)" class="btn btn-primary" >' +
            '<span class="fa fa-rocket"></span>' +
            '</button>'+
            '</div>'}
        ],
        data: data,
        onRegisterApi: function(gridApi) {
            $scope.gridApi = gridApi;
        }
    }
    $http.get('server/eventos.json')
        .success(function(data) {
            data.forEach( function(row) {
                row.registered = Date.parse(row.registered);
            });
            $scope.gridEventos.data = data;
        });
}]);

/**=========================================================
 * Module: modals.js Eventos
 * Implementa el modal de registro y modificacion
 =========================================================*/
var eventoModificar = {};
App.controller('EventoModalController', ['$scope', '$modal', function ($scope, $modal) {

    $scope.registrar = function () {

        var RegistrarModalInstance = $modal.open({
            templateUrl: '/myEventoModalContent.html',
            controller: RegistrarEventoInstanceCtrl,
            size: 'lg'
        });


    };

    $scope.modificar = function ($row) {
        eventoModificar = $row.entity;
        var ModificarModalInstance = $modal.open({
            templateUrl: '/myEventoModalContent.html',
            controller: ModificarEventoInstanceCtrl,
            size: 'lg'
        });
    };
//------------------------------------------------------------------------------------
    var RegistrarEventoInstanceCtrl = function ($scope, $modalInstance) {
        $scope.accion = "Registrar";
        $scope.eventoForm = {};
        $scope.eventoForm.registrar = function () {

            var data = {
                "id": gridDios.excessColumns    ,
                "nombre": $scope.eventoForm.nombre,
                "establecimiento": $scope.eventoForm.establecimiento,
                "direccion": $scope.eventoForm.direccion,
                "fecha": $scope.eventoForm.fecha,
                "hora": $scope.eventoForm.hora

            };
            gridEventos.data.push(data);
            $modalInstance.close('closed');
        };
        $scope.cancel = function () {
            $modalInstance.dismiss('cancel');
        };
    };

    RegistrarEventoInstanceCtrl.$inject = ["$scope", "$modalInstance"];
    var ModificarEventoInstanceCtrl = function ($scope, $modalInstance) {
        $scope.accion = "Modificar";
        $scope.eventoForm = {};

        $scope.eventoForm = eventoModificar;
        $scope.eventoForm.modificar = function () {
            gridEventos.data[eventoModificar.id] = $scope.eventoForm;

            $modalInstance.close('closed');
        };
        $scope.cancel = function () {
            $modalInstance.dismiss('cancel');
        };
    };
    ModificarEventoInstanceCtrl.$inject = ["$scope", "$modalInstance"];
}]);