/**=========================================================
 * Module: Usuarios
 =========================================================*/

var gridUsuarios = {};

App.controller('UsuariosController', ['$scope', 'uiGridConstants', '$http', function($scope, uiGridConstants, $http) {
	
    var data = [];
    gridUsuarios = $scope.gridUsuarios = {

        columnDefs: [
            {field: 'id', visible:false},
            {field: 'correo', name: 'Correo', displayName: 'Correo Electrónico'},
            {field: 'nombre', name: 'Nombre'},
            {field: 'apellido', name: 'Apellido'},
            {field: 'fechaNacimiento', name: 'Fecha Nacimiento'},
            {field: 'genero', name: 'Género'},
            {name: 'acciones', cellTemplate:'<div ng-controller="UsuarioModalController" >' +
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
    $http.get('server/usuarios.json')
        .success(function(data) {
            data.forEach( function(row) {
                row.registered = Date.parse(row.registered);
            });

            $scope.gridUsuarios.data = data;
        });
}]);

/**==========================================================
 * Module: modals.js
 * Implementa el modal de registro y modificacion de Usuario
 ============================================================*/
var usuarioModificar = {};
App.controller('UsuarioModalController', ['$scope', '$modal',function ($scope, $modal) {

    $scope.registrar = function () {
        var RegistrarModalInstance = $modal.open({
            templateUrl: '/myUsuarioModalContent.html',
            controller: RegistrarUsuarioInstanceCtrl,
            size: 'lg'
        });


    };

    $scope.modificar = function ($row) {
        usuarioModificar = $row.entity;
        var ModificarModalInstance = $modal.open({
            templateUrl: '/myUsuarioModalContent.html',
            controller: ModificarUsuarioInstanceCtrl,
            size: 'lg'
        });

    };

    // Please note that $modalInstance represents a modal window (instance) dependency.
    // It is not the same as the $modal service used above.

    var RegistrarUsuarioInstanceCtrl = function ($scope, $modalInstance) {
        $scope.accion = "Registrar";
        $scope.usuarioForm = {};
        $scope.usuarioForm.registrar = function () {

            var data = {
                "id": gridUsuarios.excessColumns,
                "correo": $scope.usuarioForm.correo,
                "nombre": $scope.usuarioForm.nombre,
                "apellido": $scope.usuarioForm.apellido,
                "fechaNacimiento": $scope.usuarioForm.fechaNacimiento,
                "genero": $scope.usuarioForm.genero,
                "credencial": {
                    "contraseña": $scope.usuarioForm.contrasenna
                }
            };
            gridUsuarios.data.push(data);
            $modalInstance.close('closed');
        };
        
        $scope.cancel = function () {
            $modalInstance.dismiss('cancel');
        };

    };
    RegistrarUsuarioInstanceCtrl.$inject = ["$scope", "$modalInstance"];

    var ModificarUsuarioInstanceCtrl = function ($scope, $modalInstance) {
        $scope.accion = "Modificar";
        $scope.usuarioForm = {};
        //Carga del Form de Modificar
        $scope.usuarioForm.correo = usuarioModificar.correo;
        $scope.usuarioForm.nombre = usuarioModificar.nombre;
        $scope.usuarioForm.apellido = usuarioModificar.apellido;
        $scope.usuarioForm.genero = usuarioModificar.genero;
        $scope.usuarioForm.fechaNacimiento = usuarioModificar.fechaNacimiento;


        $scope.usuarioForm.modificar = function () {
        	gridUsuarios.data[usuarioModificar.id] = $scope.usuarioForm;
            $modalInstance.close('closed');
        };
        $scope.cancel = function () {
            $modalInstance.dismiss('cancel');
        };
    };
    ModificarUsuarioInstanceCtrl.$inject = ["$scope", "$modalInstance"];

}]);