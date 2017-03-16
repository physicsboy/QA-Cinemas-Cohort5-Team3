(function() {

    var UpdateScreenController =  function($state, screenDal) {
        var vm = this;

        vm.updateScreen = function(screenToUpdate) {
            console.log("This is the value of screen to add " + screenToUpdate);
            console.log(screenToUpdate);
            var screenToJson = JSON.stringify(screenToUpdate);
            console.log(screenToJson);
            screenDal.updateScreen(screenToUpdate).then(function (results) {
            	console.log("Looking good");
                vm.screenUpdateMessage  = results;
                $state.go('updatescreen');
            }, function (error) {
            	console.log("Looking bad");
                vm.error = true;
                vm.errorMessage = error;
            });
        };
    };

    angular.module('movieApp').controller('updateScreenController', ['$state','screenDal',UpdateScreenController]);
}());