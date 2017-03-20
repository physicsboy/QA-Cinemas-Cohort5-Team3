/**
 * @author AlexNewton
 */
(function () {

    var addShowingController = function ($state, showingDal) {
        var vm = this;


        vm.createShowing = function(showing){
            if(isShowingValid(showing)){
                showingDal.saveShowing(showing).then(function (results) {
                    vm.message = "Showing saved successfully"
                }, function (error) {
                    vm.error = true;
                    vm.message = error;
                });
            }else{
                getNearestPossibleShowing(showing);
            }
        };

        vm.isShowingValid = function(showing){

        };

        vm.getNearestPossibleShowing = function(showing){

        };

    };

    angular.module('movieApp').controller('addShowingController', ['$state', 'showingDal', addShowingController]);
}());