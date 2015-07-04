/**=========================================================
 * Module: TipoServicio
 =========================================================*/


var gridTipoServicio = {};

App.controller('TipoServicioController', ['$scope', 'uiGridConstants', '$http', function($scope, uiGridConstants, $http) {

    var data = [];

    gridTipoServicio = $scope.gridTipoServicio = {
        columnDefs: [
            { field: 'id',visible:false},
            { field: 'nombre', name:"Tipo de Servicio"},
            {name: 'acciones', cellTemplate:'<div ng-controller="TipoServicioModalController" >' +
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
    $http.get('server/TipoServicio.json')
        .success(function(data) {
            data.forEach( function(row) {
                row.registered = Date.parse(row.registered);
            });
            $scope.gridTipoServicio.data = data;
        });
}]);

/**=========================================================
 * Module: modals.js TipoServicio
 * Implementa el modal de registro y modificacion
 =========================================================*/
var tipoServicioModificar = {};
App.controller('TipoServicioModalController', ['$scope', '$modal', function ($scope, $modal) {

    $scope.registrar = function () {

        var RegistrarModalInstance = $modal.open({
            templateUrl: '/myTipoServicioModalContent.html',
            controller: RegistrarTipoServicioInstanceCtrl,
            size: 'lg'
        });


    };

    $scope.modificar = function ($row) {
        tipoServicioModificar = $row.entity;
        var ModificarModalInstance = $modal.open({
            templateUrl: '/myTipoServicioModalContent.html',
            controller: ModificarTipoServicioInstanceCtrl,
            size: 'lg'
        });
    };
//------------------------------------------------------------------------------------
    var RegistrarTipoServicioInstanceCtrl = function ($scope, $modalInstance) {
        $scope.accion = "Registrar";
        $scope.tipoServicioForm = {};
        $scope.tipoServicioForm.registrar = function () {

            var data = {
                "id": gridTipoServicio.excessColumns    ,
                "nombre": $scope.tipoServicioForm.nombre,
            };
            gridTipoServicio.data.push(data);
            $modalInstance.close('closed');
        };
        $scope.cancel = function () {
            $modalInstance.dismiss('cancel');
        };
    };

    RegistrarTipoServicioInstanceCtrl.$inject = ["$scope", "$modalInstance"];
    var ModificarTipoServicioInstanceCtrl = function ($scope, $modalInstance) {
        $scope.accion = "Modificar";
        $scope.tipoServicioForm = {};

        $scope.tipoServicioForm.nombre = tipoServicioModificar.nombre;
        $scope.tipoServicioForm.modificar = function () {
            gridTipoServicio.data[tipoServicioModificar.id-1] = $scope.tipoServicioForm;

            $modalInstance.close('closed');
        };
        $scope.cancel = function () {
            $modalInstance.dismiss('cancel');
        };
    };
    ModificarTipoServicioInstanceCtrl.$inject = ["$scope", "$modalInstance"];
}]);