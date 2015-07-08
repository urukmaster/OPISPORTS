/**=========================================================
 * Module: Distribucion
 =========================================================*/
App.controller('CentroDistribucionController', ['$scope', 'uiGridConstants', '$http', function($scope, uiGridConstants, $http) {

    var data = [];
    gridDistribucion = $scope.gridDistribucion = {

        columnDefs: [
            {field: 'id', visible:false},
            {field: 'nombre', name: 'Nombre'},
            {field: 'direccion', name: 'Direccion'},
            {field: 'telefono', name: 'Telefono'},
            {field: 'correo', name: 'Correo'},
            {name: 'acciones', cellTemplate:'<div ng-controller="DistribucionModalController" >' +
            '<button ng-click="modificar(row)" class="btn btn-primary" >' +
            '<span class="fa fa-rocket"></span>' +
            '</button>'+
            '</div>'}
        ],
        data: data,
        onRegisterApi: function (gridApi) {
            $scope.gridApi = gridApi;
        }


    };
    $http.get('server/centrosDistribucion.json')
        .success(function(data) {
            data.forEach( function(row) {
                row.registered = Date.parse(row.registered);
            });

            $scope.gridDistribucion.data = data;
        });
}]);

/**=========================================================
 * Module: modals.js
 * Implementa el modal de registro y modificacion
 =========================================================*/
var distribucionModificar = {};
App.controller('DistribucionModalController', ['$scope', '$modal', function ($scope, $modal) {

    $scope.registrar = function () {
        var RegistrarModalInstance = $modal.open({
            templateUrl: '/myDistribucionModalContent.html',
            controller: RegistrarDistribucionInstanceCtrl,
            size: 'lg'
        });
    };
//-------------------------------------------------------------------------------------------------------
    $scope.modificar = function ($row) {
        distribucionModificar = $row.entity;
        var ModificarModalInstance = $modal.open({
            templateUrl: '/myDistribucionModalContent.html',
            controller: ModificarDistribucionInstanceCtrl,
            size: 'lg'
        });

    };

//-------------------------------------------------------------------------------------------------------
//-------------------------------------------------------------------------------------------------------
    
var RegistrarDistribucionInstanceCtrl = function ($scope, $modalInstance) {
    $scope.accion = "Registrar";
    $scope.distribucionForm = {};
    $scope.distribucionForm.registrar = function () {
        var data = {
            "id": gridDistribucion.excessColumns    ,
            "nombre": $scope.distribucionForm.nombre,
            "direccion": $scope.distribucionForm.direccion,
            "telefono": $scope.distribucionForm.telefono,
            "correo": $scope.distribucionForm.correo
        };
            gridDistribucion.data.push(data);
            $modalInstance.close('closed');
    };
    $scope.cancel = function () {
        $modalInstance.dismiss('cancel');
    };
};
RegistrarDistribucionInstanceCtrl.$inject = ["$scope", "$modalInstance"];

//---------------------------------------------------------------------------------------
var ModificarDistribucionInstanceCtrl = function ($scope, $modalInstance) {
    $scope.accion = "Modificar";
    $scope.distribucionForm = {};

    $scope.distribucionForm = distribucionModificar;
    $scope.distribucionForm.modificar = function () {
        gridDistribucion.data[distribucionModificar.id] = $scope.distribucionForm;
        $modalInstance.close('closed');
    };
    $scope.cancel = function () {
        $modalInstance.dismiss('cancel');
    };
};
ModificarDistribucionInstanceCtrl.$inject = ["$scope", "$modalInstance"];

}]);