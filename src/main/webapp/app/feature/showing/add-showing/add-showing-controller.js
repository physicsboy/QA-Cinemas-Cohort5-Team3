/**
 * @author AlexNewton
 */
(function () {

    var addShowingController = function ($state, showingDal) {
        var vm = this;

        vm.showTimes = [];
        vm.getTimes = function getTimes(){
            var time = new moment().set('hour', 9).set('minute', 0);

            //each 30 mins all day
            for(var i=0; i<25; i++){
                vm.showTimes.push({"value": time.format("HH:mm")});
                time.add(30, 'minute');
            }
        };
        vm.getTimes();


        vm.dates = [];
        vm.getUpcomingDates = function getUpcomingDates() {
            var currentDate = new moment().subtract(1, 'days');

            //go 3 weeks ahead
            for (var i = 0; i < 21; i++) {
                currentDate.add(1, 'days');
                vm.dates.push({"value": currentDate.format("dddd Do MMM YY")});
            }
        };
        vm.getUpcomingDates();


        var originalShowingTime;
        vm.addShowing = function (movie, date, time) {

            console.log("INSIDE METHOD");
            var showingDateTime = moment(time.value + " " + date.value, "HH:mm dddd Do MMM YY");
            var showingEpoch = showingDateTime.valueOf();
            originalShowingTime = showingEpoch;
            vm.createShowing(movie, showingEpoch);

        };

        vm.createShowing = function(movie, showingEpoch){

            console.log("INSIDE METHOD 2");

            vm.showing = {
                "dateShowing": showingEpoch,
                "movie": movie,
                "screen": {"screenId": 0}
            };

            vm.checkForValidity();
        };


        vm.checkForValidity = function checkForValidity(){
            var endOfShowing = moment(vm.showing.dateShowing).add(vm.showing.movie.length , 'minute');
            var startOfShowingDay = moment(vm.showing.dateShowing).set('hour', 9).set('minute', 0).set('second', 0).set('millisecond', 0);

            console.log("start of day: " + startOfShowingDay.format("HH:mm dddd Do MMM YY"));
            console.log("end of film: " + endOfShowing.format("HH:mm dddd Do MMM YY"));

            getShowingsBetweenTimes(startOfShowingDay, endOfShowing);
        };


        var getShowingsBetweenTimes = function(time1, time2){
            showingDal.getShowingsBetweenTimes(time1, time2).then(function (results) {
                if (!isShowingValid(results)) {
                    vm.message = "Unable to create showing at that time...";
                } else {
                    if(checkIfSameShowing()) {
                        saveShowing();
                    }
                }
                return results;
            }, function (error) {
                vm.error = true;
                vm.errorMessage = error;
            });
        };


        var isShowingValid = function (conflictingShowings) {
            var showingStartTime = moment(vm.showing.dateShowing);
            var showingEndTime = moment(vm.showing.dateShowing).add(vm.showing.movie.length, 'minute');

            //filter out all which aren't conflicting
            for(var i=conflictingShowings.length -1; i>=0; i--){

                var conflictStartTime = moment(conflictingShowings[i].dateShowing);
                var conflictEndTime = moment(conflictStartTime.valueOf()).add(conflictingShowings[i].movie.length, 'minute');

                var isConflict = false;

                //conflict starts during showing
                if(conflictStartTime >= showingStartTime && conflictStartTime <= showingEndTime){
                    isConflict = true;
                }
                //showing starts during conflict
                if(conflictEndTime >= showingStartTime && conflictEndTime <= showingEndTime){
                    isConflict = true;
                }
                //conflict encompasses showing
                if(showingStartTime >= conflictStartTime && showingEndTime <= conflictEndTime){
                    isConflict = true;
                }
                //showing encompasses conflict
                if(conflictStartTime >= showingStartTime && conflictEndTime <= showingEndTime){
                    isConflict = true;
                }

                //remove non-conflicting issues
                if(!isConflict){
                    conflictingShowings.splice(i, 1);
                }
            }


            var screenIDs = [{"id": 1}, {"id": 2}, {"id":3}];
            for(var i=0; i<conflictingShowings.length; i++){
                screenIDs = screenIDs.filter(function( obj ) {
                    return obj.id !== conflictingShowings[i].screen.screenId;
                });
            }

            //return a valid showing
            if(screenIDs.length > 0){
                vm.showing.screen.screenId = screenIDs[0].id;
                return vm.showing;
            }

            //not a valid showing
            var newShowingTime = moment(vm.showing.dateShowing).add(30, 'minute');
            if(newShowingTime.get('hour') == 21 && newShowingTime.get('minute') == 30){
                newShowingTime.add(1, 'day').set('hour', 9).set('minute', 0);
            }

            vm.showing.dateShowing = newShowingTime.valueOf();
            return vm.createShowing(vm.showing.movie, vm.showing.dateShowing);
        };


        var checkIfSameShowing = function(){
            var dateTime = moment(vm.showing.dateShowing);
            vm.date = dateTime.format("dddd MMM YY");
            vm.time = dateTime.format("HH:mm");

            if(originalShowingTime === vm.showing.dateShowing){
                vm.message = "Showing saved successfully";
                return true;
            }
            else{
                vm.message = "Unable to save that showing. The next available showing is at:";
                return false;
            }
        };

        var saveShowing = function(){
            console.log("SAVED");
            showingDal.saveShowing(vm.showing).then(function (results) {}, function (error) {
                vm.error = true;
                vm.message = error;
            });
        };

    };

    angular.module('movieApp').controller('addShowingController', ['$state', 'showingDal', addShowingController]);
}());