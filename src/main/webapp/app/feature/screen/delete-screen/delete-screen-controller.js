(function() {

    var delteScreenController =  function($state, screenDal) {
        var vm = this;

        vm.addScreen = function(mcreenToAdd) {
            console.log("This is the value of screen to add " + screenToAdd);
            console.log(screenToAdd);
            
            var screenToJson = JSON.stringify(screenToAdd);
            console.log(screenToJson);
            screenDal.saveScreen(screenToAdd).then(
            		function (results) {
		                vm.screenAddMessage  = results;
		                $state.go('deletescreen');
		            }, function (error) {
		                vm.error = true;
		                vm.errorMessage = error;
		            }
		    );
        };
    };

    angular.module('screenApp').controller('deleteScreenController', ['$state','screenDal',DeleteScreenController]);
}());