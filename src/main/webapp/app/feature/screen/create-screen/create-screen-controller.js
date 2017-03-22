/**
 * @author Mark lester
 */

(function() {

    var CreateScreenController =  function($state, screenDal) {
        var vm = this;
        vm.createScreen = function(screenToCreate) {
            screenDal.createScreen(screenToCreate).then(
            		function (results) {
		                vm.screenCreateMessage  = results;
		                $state.go('createscreen');
		            }, 
		            function (error) {
		                vm.error = true;
		                vm.errorMessage = error;
		            }
		     );
        };
    };

    angular.module('movieApp').controller('createScreenController', ['$state','screenDal',CreateScreenController]);
}());