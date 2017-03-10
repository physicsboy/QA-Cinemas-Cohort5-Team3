/** @author James Lamkin */
(function() {

    var getShowingController =  function(showingDal) {
        var vm = this;
        vm.test = "test";

        function init(){
            showingDal.getShowing().then(function (results) {
                vm.showing = results;
            }, function (error) {
                vm.error = true;
                vm.errorMessage = error;
            })
        }
        init();
    };

    angular.module('movieApp').controller('getShowingController', [getShowingController]);
}());