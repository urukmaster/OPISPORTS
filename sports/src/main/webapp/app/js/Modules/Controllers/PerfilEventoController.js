/**=========================================================
 * Module: modals.js Inscripcion a eventos
 * Implementa el modal de inscricpion a un evento
 =========================================================*/

    App.controller('InscripcionModalController', ['$scope', '$modal', function ($scope, $modal) {

        $scope.registrarInscripcion = function () {
            var RegistrarModalInstance = $modal.open({
                templateUrl: '/myInscripcionModalContent.html',
                controller: RegistrarInscripcionInstanceCtrl,
                size: 'lg'
            });

        };

    // Please note that $modalInstance represents a modal window (instance) dependency.
    // It is not the same as the $modal service used above.

    var RegistrarInscripcionInstanceCtrl = function ($scope, $modalInstance) {
        $scope.accion = "Registrar";
        $scope.inscripcionForm = {};
        $scope.inscripcionForm.registrar = function () {

            var data = {
                "id": gridDios.excessColumns    ,
                "nombre": $scope.inscripcionForm.nombre,
            };
            if ($scope.inscripcion.$valid) {
                gridDios.data.push(data);
                $modalInstance.close('closed');
            }

        };

        $scope.cancel = function () {
            $modalInstance.dismiss('cancel');
        };
    };
        
    RegistrarInscripcionInstanceCtrl.$inject = ["$scope", "$modalInstance"];

}]);