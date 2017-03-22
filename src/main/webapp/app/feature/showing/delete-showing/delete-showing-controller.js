/**
 * Created by James Lamkin
 */
(function() {
    var DeleteShowingController = function($state, showingDal) {
        var vm = this;

        vm.deleteShowing = function(showingToDelete) {
            console.log("This is the value of showing to delete..." + showingToDelete);
            showingDal.deleteShowing(showingToDelete).then(function(results) {
                vm.showingDeleteMessage = results;
                $state.go('getshowing');
            }, function(error) {
                vm.error = true;
                vm.errorMessage = error;
            });
        };
    };
    angular.module('movieApp').controller('deleteShowingController', ['$state', 'showingDal', DeleteShowingController ]);
}());