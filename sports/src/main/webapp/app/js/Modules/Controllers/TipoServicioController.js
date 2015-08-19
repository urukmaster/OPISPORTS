/**
 * Fecha: 20-07-2015 version 1.0
 * 
 * @author Luis Esteban López Ramírez
 * 
 *Sprint #4 Descripción: Controlador para gestioanr los tipos de servicios
 */
var gridTipoServicio = {};

App.controller('TipoServicioController', ['$scope', '$rootScope','uiGridConstants', '$http', function($scope, $rootScope,uiGridConstants, $http) {

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
    $http.get('rest/tipoServicio/getAll')
        .success(function(data) {
        	if(data.code == 200){
            data.tipoServicio.forEach( function(row) {
                row.registered = Date.parse(row.registered);
           
            });
            $scope.gridTipoServicio.data = data;
        	 }else{
             	$rootScope.errorMessage = data.codeMessage;
             	$state.go('page.error');
             }
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