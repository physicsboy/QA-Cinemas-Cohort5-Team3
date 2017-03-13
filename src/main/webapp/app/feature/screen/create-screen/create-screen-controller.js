/**
 * @author Mark lester
 */

(function() {

    var CreateScreenController =  function($state, screenDal) {
        var vm = this;

        vm.createScreen = function(screenToCreate) {
            console.log("This is the value of screen to add " + screenToCreate);
            console.log(screenToCreate);
            
            var screenToJson = JSON.stringify(screenToCreate);
            console.log(screenToJson);
            screenDal.createScreen(screenToCreate).then(
            		function (results) {
		                vm.screenCreateMessage  = results;
		                $state.go('createscreen');
		                console.log(" CreateScreenController saving ");
		            }, 
		            function (error) {
		                vm.error = true;
		                vm.errorMessage = error;
		                console.log("CreateScreenController throwing error");
		                console.log("ScreenTo create = " + screenToCreate);
		                console.log(vm.errorMessage);
		            }
		     );
        };
    };

    angular.module('movieApp').controller('createScreenController', ['$state','screenDal',CreateScreenController]);
}());