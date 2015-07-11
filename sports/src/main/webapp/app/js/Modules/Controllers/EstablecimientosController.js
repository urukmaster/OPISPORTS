
/**=========================================================
 * Module: Establecimientos
 =========================================================*/

var consultarEstablecimiento = {};

App.controller('EstablecimientosController', ['$scope', 'uiGridConstants', '$http', function($scope, uiGridConstants, $http) {

    var data = [];
    gridEstablecimientos = $scope.gridEstablecimientos = {
        columnDefs: [
            { field: 'id', visible: false},
            { field: 'nombre', name: "Establecimiento"},
            { field: 'direccion', name: "Direccion"},
            { field: 'telefono', name: "Telefono"},
            {name: 'acciones', cellTemplate:'<div ng-controller="EstablecimientoModalController" >' +
            '<button ng-click="modificar(row)" class="btn btn-primary "><span class="fa fa-rocket"></span></button>'+
            '<button ng-click="consultar(row)" class="btn btn-primary "><span class="icon-ghost"></span></button>' +
            '<button ng-click="consultar(row)" class="btn btn-primary "><span class="icon-close"></span></button>' +
            '</div>'}
        ],
        data: data,
        onRegisterApi: function(gridApi) {
            $scope.gridApi = gridApi;
        }
    }

    $http.get('server/establecimientos.json')
        .success(function(data) {
            data.forEach( function(row) {
                row.registered = Date.parse(row.registered);
            });

            $scope.gridEstablecimientos.data = data;
        });

}]);

/**=========================================================
 * Module: modals.js
 * Implementa el modal de registro y modificacion
 =========================================================*/
var establecimientoModificar = {};
App.controller('EstablecimientoModalController', ['$scope', '$modal', '$state', function ($scope, $modal, $state) {

    $scope.registrar = function () {
        var RegistrarModalInstance = $modal.open({
            templateUrl: '/myEstablecimientoModalContent.html',
            controller: RegistrarEstablecimientoInstanceCtrl,
            size: 'lg'
        });

    };

    $scope.consultar = function($row){
        consultarEstablecimiento = $row;
        $state.go('app.perfilEstablecimiento');
    };

    $scope.modificar = function ($row) {
        establecimientoModificar = $row.entity;
        var ModificarModalInstance = $modal.open({
            templateUrl: '/myEstablecimientoModalContent.html',
            controller: ModificarEstablecimientoInstanceCtrl,
            size: 'lg'
        });



    };

    // Please note that $modalInstance represents a modal window (instance) dependency.
    // It is not the same as the $modal service used above.

    var RegistrarEstablecimientoInstanceCtrl = function ($scope, $modalInstance) {
        $scope.accion = "Registrar";
        $scope.establecimientoForm = {};
        $scope.establecimientoForm.registrar = function () {

            var data = {
                "id": gridEstablecimientos.excessColumns,
                "nombre": $scope.establecimientoForm.nombre,
                "direccion": $scope.establecimientoForm.direccion,
                "telefono": $scope.establecimientoForm.telefono
            };

                gridEstablecimientos.data.push(data);
                $modalInstance.close('closed');


        };

        $scope.cancel = function () {
            $modalInstance.dismiss('cancel');
        };
    };
    RegistrarEstablecimientoInstanceCtrl.$inject = ["$scope", "$modalInstance"];

    var ModificarEstablecimientoInstanceCtrl = function ($scope, $modalInstance) {
        $scope.accion = "Modificar";
        $scope.establecimientoForm = {};

        $scope.establecimientoForm = establecimientoModificar;
        $scope.establecimientoForm.modificar = function () {
            gridEstablecimientos.data[establecimientoModificar.id] = $scope.establecimientoForm;

            $modalInstance.close('closed');
        };
        $scope.cancel = function () {
            $modalInstance.dismiss('cancel');
        };
    };
    ModificarEstablecimientoInstanceCtrl.$inject = ["$scope", "$modalInstance"];

}]);