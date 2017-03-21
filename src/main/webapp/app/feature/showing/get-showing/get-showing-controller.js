/** @author James Lamkin */
(function() {

    var GetShowingController =  function($state, $stateParams, showingDal) {
        var vm = this;

        function init(){
            showingDal.getShowings().then(function (results) {
                vm.showings = results;
            }, function (error) {
                vm.error = true;
                vm.errorMessage = error;
            })
        }
        init();

        vm.getShowingByDate = function(id, dateShowing){
            console.log(id);
            showingDal.getShowingByDate(id, dateShowing).then(function (results) {
                vm.showings = results;
            }, function (error) {
                vm.error = true;
                vm.errorMessage = error;
            });
        };


        vm.getShowingByMovie = function(id){
            console.log(id);
            showingDal.getShowingByMovie(id).then(function (results) {
                vm.showings = results;
            }, function (error) {
                vm.error = true;
                vm.errorMessage = error;
            });
        };

        vm.getShowingById = function(id){
            showingDal.getShowingsById(id).then(function (results) {
                vm.showings = results;
            }, function (error) {
                vm.error = true;
                vm.errorMessage = error;
            });
        };

    };

    angular.module('movieApp').controller('getShowingController', ['$state', '$stateParams', 'showingDal', GetShowingController]);
}());