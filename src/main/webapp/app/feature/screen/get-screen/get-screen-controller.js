(function() {

    var GetScreenController =  function($state, screenDal) {
        var vm = this;

        vm.getScreen = function(screenToGet) {
            console.log("This is the value of screen to add " + screenToGet);
            console.log(screenToGet);
            var screenToJson = JSON.stringify(screenToGet);
            console.log(screenToJson);
            screenDal.getScreen(screenToGet).then(
	            function (results) {
	                vm.screenAddMessage  = results;
	                $state.go('getscreen');
	            }, 
	            function (error) {
	                vm.error = true;
	                vm.errorMessage = error;
            });
        };
    };

    angular.module('movieApp').controller('getScreenController', ['$state','screenDal',GetScreenController]);
}());