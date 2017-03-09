(function() {

    var GetScreenController =  function(screenDal) {
        var vm = this;

        function init() {
            movieDal.getScreen().then(
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

    angular.module('screenApp').controller('getScreenController', ['screenDal', GetScreenController]);
}());