(function() {

    var GetScreensController =  function(screenDal) {
        var vm = this;

        function init() {
            screenDal.getScreen().then(
	            function (results) {
	                vm.screens  = results;
	            }, function (error) {
	                vm.error = true;
	                vm.errorMessage = error;
	            }
	        );
        }
        init();
    };

    angular.module('movieApp').controller('getScreensController', ['screenDal', GetScreensController]);
}());