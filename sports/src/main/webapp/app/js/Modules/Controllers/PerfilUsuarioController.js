/**=========================================================
skype * Module: PerfilUsuario
 =========================================================*/
App.controller('PerfilUsuarioController', ['$scope', 'uiGridConstants', '$http','$rootScope', function($scope, uiGridConstants, $http,$rootScope) {
	$scope.nombre = $rootScope.usuario.nombre;
	$scope.apellido = $rootScope.usuario.apellido;
	$scope.correo = $rootScope.usuario.correo;
	$scope.telefono = $rootScope.usuario.telefono; 
}]);

