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


        vm.createShowing = function (movie, date, time) {
            var showingDateTime = moment( time.value + " " + date.value, "HH:mm Do MMM YY");
            var showingEpoch = showingDateTime.valueOf();

            var showing = {
                "dateShowing": showingEpoch,
                "movie": movie,
                "screen": {"screenId": 0}
            };

            vm.checkForValidity(showing);
        };


        vm.getNearestPossibleShowing = function (showing) {

        };

        vm.checkForValidity = function checkForValidity(showing){
            var endOfShowing = moment(showing.dateShowing).add(showing.movie.length , 'minute');
            var startOfShowingDay = moment(showing.dateShowing).set().set('hour', 9).set('minute', 0).set('second', 0).set('millisecond', 0);

            console.log(startOfShowingDay.format("Do MMM YYYY HH:mm"));
            console.log(endOfShowing.format("Do MMM YYYY HH:mm"));
            getShowingsBetweenTimes(showing, startOfShowingDay, endOfShowing);
        };


        var getShowingsBetweenTimes = function(showing, time1, time2){
            showingDal.getShowingsBetweenTimes(time1, time2).then(function (results) {
                if (!isShowingValid(showing, results)) {
                    vm.message = "Unable to create showing at that time...";
                    vm.getNearestPossibleShowing(showing);
                } else {
                    showingDal.saveShowing(showing).then(function (results) {
                        vm.message = "Showing saved successfully at screen number " + showing.screen.screenId
                    }, function (error) {
                        vm.error = true;
                        vm.message = error;
                    });
                }
                return results;
            }, function (error) {
                vm.error = true;
                vm.errorMessage = error;
            });
        };


        var isShowingValid = function (showing, conflictingShowings) {
            var showingStartTime = moment(showing.dateShowing);
            var showingEndTime = moment(showing.dateShowing).add(showing.movie.length, 'minute');



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


            if(screenIDs.length > 0){
                showing.screen.screenId = screenIDs[0].id;
                return showing;
            }
            return false;
        };


    };

    angular.module('movieApp').controller('addShowingController', ['$state', 'showingDal', addShowingController]);
}());