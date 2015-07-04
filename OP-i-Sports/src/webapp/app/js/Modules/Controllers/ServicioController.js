/**=========================================================
 * Module: Servicio
 =========================================================*/


var gridServicio = {};

App.controller('ServicioController', ['$scope', 'uiGridConstants', '$http', function($scope, uiGridConstants, $http) {

    var data = [];

    gridServicio = $scope.gridServicio = {
        columnDefs: [
            { field: 'id',visible:false},
            { field: 'nombre', name:"Servicio"},
            { field: 'actividadDeportiva' , name:'Actividad deportiva'},
            { field: 'precio' , name:'Precio'},
            { field: 'horaApertura' , name:'Hora de apertura'},
            { field: 'horaCierre' , name:'Hora de cierre'},
            { field: 'arbitro' , name:'Arbitro'},
            {name: 'acciones', cellTemplate:'<div ng-controller="ServicioModalController" >' +
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
    $http.get('server/servicio.json')
        .success(function(data) {
            data.forEach( function(row) {
                row.registered = Date.parse(row.registered);
            });
            $scope.gridServicio.data = data;
        });
}]);

/**=========================================================
 * Module: modals.js Servicio
 * Implementa el modal de registro y modificacion
 =========================================================*/
var servicioModificar = {};
App.controller('ServicioModalController', ['$scope', '$modal', function ($scope, $modal) {

    $scope.registrar = function () {

        var RegistrarModalInstance = $modal.open({
            templateUrl: '/myServicioModalContent.html',
            controller: RegistrarServicioInstanceCtrl,
            size: 'lg'
        });


    };

    $scope.modificar = function ($row) {
        servicioModificar = $row.entity;
        var ModificarModalInstance = $modal.open({
            templateUrl: '/myServicioModalContent.html',
            controller: ModificarServicioInstanceCtrl,
            size: 'lg'
        });
    };
//------------------------------------------------------------------------------------
    var RegistrarServicioInstanceCtrl = function ($scope, $modalInstance) {
        $scope.accion = "Registrar";
        $scope.servicioForm = {};
        $scope.servicioForm.registrar = function () {

            var data = {
                "id": gridServicio.excessColumns    ,
                "nombre": $scope.servicioForm.nombre,
                "precio": $scope.servicioForm.precio,
                "horaApertura": $scope.servicioForm.horaApertura,
                "horaCierre": $scope.servicioForm.horaCierre,
                "arbitro": $scope.servicioForm.arbitro,
                "parqueo": $scope.servicioForm.parqueo

            };
            gridServicio.data.push(data);
            $modalInstance.close('closed');
        };
        $scope.cancel = function () {
            $modalInstance.dismiss('cancel');
        };
    };

    RegistrarServicioInstanceCtrl.$inject = ["$scope", "$modalInstance"];
    var ModificarServicioInstanceCtrl = function ($scope, $modalInstance) {
        $scope.accion = "Modificar";
        $scope.servicioForm = {};

        $scope.servicioForm.nombre = servicioModificar.nombre;
        $scope.servicioForm.modificar = function () {
            gridServicio.data[servicioModificar.id-1] = $scope.servicioForm;

            $modalInstance.close('closed');
        };
        $scope.cancel = function () {
            $modalInstance.dismiss('cancel');
        };
    };
    ModificarServicioInstanceCtrl.$inject = ["$scope", "$modalInstance"];
}]);