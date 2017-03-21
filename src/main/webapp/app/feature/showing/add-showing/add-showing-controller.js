/**
 * @author AlexNewton
 */
(function () {

    var addShowingController = function ($state, showingDal, movieDal) {
        var vm = this;

        vm.showTimes = [
            {"value": "9:00"}, {"value": "9:30"}, {"value": "10:00"}, {"value": "10:30"}, {"value": "11:00"},
            {"value": "11:30"}, {"value": "12:00"}, {"value": "12:30"}, {"value": "13:00"}, {"value": "13:30"},
            {"value": "14:00"}, {"value": "14:30"}, {"value": "15:00"}, {"value": "15:30"}, {"value": "16:00"},
            {"value": "16:30"}, {"value": "17:00"}, {"value": "17:30"}, {"value": "18:00"}, {"value": "18:30"},
            {"value": "19:00"}, {"value": "19:30"}, {"value": "20:00"}, {"value": "20:30"}
        ];

        vm.dates = [];
        vm.getUpcomingDates = function getUpcomingDates() {
            var currentDate = new moment();
            console.log(currentDate);
            console.log(vm.dates);

            for (var i = 0; i < 21; i++) {
                currentDate.add(i, 'days');
                console.log(currentDate.format("Do MMM YY"));
                vm.dates.push(currentDate.format("Do MMM YY"));
            }

            console.log(vm.dates)
        };
        vm.getUpcomingDates();


        vm.createShowing = function (showing) {
            if (isShowingValid(showing)) {
                showingDal.saveShowing(showing).then(function (results) {
                    vm.message = "Showing saved successfully"
                }, function (error) {
                    vm.error = true;
                    vm.message = error;
                });
            } else {
                getNearestPossibleShowing(showing);
            }
        };

        vm.isShowingValid = function (showing) {

        };

        vm.getNearestPossibleShowing = function (showing) {

        };
    };

    angular.module('movieApp').controller('addShowingController', ['$state', 'showingDal', 'movieDal', addShowingController]);
}());