(function() {

    var DeleteScreenController =  function($state, screenDal) {
        var vm = this;

        vm.addScreen = function(screenToDelete) {
            console.log("This is the value of screen to delete " + screenToDelete);
            console.log(screenToDelete);
            
            var screenToJson = JSON.stringify(screenToDelete);
            console.log(screenToJson);
            screenDal.deleteScreen(screenToDelete).then(
            		function (results) {
		                vm.screenDeleteMessage  = results;
		                $state.go('deletescreen');
		            }, function (error) {
		                vm.error = true;
		                vm.errorMessage = error;
		            }
		    );
        };
    };

    angular.module('movieApp').controller('deleteScreenController', ['$state','screenDal',DeleteScreenController]);
}());