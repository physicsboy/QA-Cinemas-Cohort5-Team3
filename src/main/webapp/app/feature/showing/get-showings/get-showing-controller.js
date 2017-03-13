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

        vm.getShowingByMovie = function(id){
            showingDal.getShowingByMovie(id).then(function (results) {
                vm.showings = results;
            }, function (error) {
                vm.error = true;
                vm.errorMessage = error;
            });
        };

        vm.getShowingById = function(id){
            showingDal.getShowingById(id).then(function (results) {
                vm.showings = results;
            }, function (error) {
                vm.error = true;
                vm.errorMessage = error;
            });
        };

    };

    angular.module('movieApp').controller('getShowingController', [getShowingController]);
}());