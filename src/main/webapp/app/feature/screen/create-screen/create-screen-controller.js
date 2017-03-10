(function() {

    var createScreenController =  function($state, screenDal) {
        var vm = this;

        vm.createScreen = function(screenToCreate) {
            console.log("This is the value of screen to add " + screenToCreate);
            console.log(screenToCreate);
            
            var screenToJson = JSON.stringify(screenToCreate);
            console.log(screenToJson);
            screenDal.saveScreen(screenToCreate).then(
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

    angular.module('screenApp').controller('createScreenController', ['$state','screenDal',CreateScreenController]);
}());