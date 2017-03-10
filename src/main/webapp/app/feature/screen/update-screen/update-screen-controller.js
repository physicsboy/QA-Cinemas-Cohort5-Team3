(function() {

    var updateScreenController =  function($state, screenDal) {
        var vm = this;

        vm.addScreen = function(screenToUpdate) {
            console.log("This is the value of screen to add " + screenToUpdate);
            console.log(screenToUpdate);
            var screenToJson = JSON.stringify(screenToUpdate);
            console.log(screenToJson);
            screenDal.saveScreen(screenToUpdate).then(function (results) {
                vm.screenAddMessage  = results;
                $state.go('updatescreen');
            }, function (error) {
                vm.error = true;
                vm.errorMessage = error;
            });
        };
    };

    angular.module('screenApp').controller('updateScreenController', ['$state','screenDal',UpdateScreenController]);
}());