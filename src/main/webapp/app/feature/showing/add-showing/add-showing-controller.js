/**
 * @author AlexNewton
 */
(function () {

    var addShowingController = function ($state, showingDal) {
        var vm = this;

        var showTimes = [
            "9:00", "9:30", "10:00", "10:30", "11:00", "11:30", "12:00", "12:30", "13:00", "13:30", "14:00", "14:30",
            "15:00", "15:30", "16:00", "16:30", "17:00", "17:30", "18:00", "18:30", "19:00", "19:30", "20:00", "20:30"
        ];


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