(function() {

    var getScreenController =  function($state, screenDal) {
        var vm = this;

        vm.addScreen = function(mcreenToGet) {
            console.log("This is the value of screen to add " + screenToGet);
            console.log(screenToGet);
            var screenToJson = JSON.stringify(screenToGet);
            console.log(screenToJson);
            screenDal.saveScreen(screenToAdd).then(function (results) {
                vm.screenAddMessage  = results;
                $state.go('getscreen');
            }, function (error) {
                vm.error = true;
                vm.errorMessage = error;
            });
        };
    };

    angular.module('screenApp').controller('getScreenController', ['$state','screenDal',GetScreenController]);
}());