/**
 * Created by Sam Jarvis on 17/03/2017.
 */
(function () {

    var PaymentController = function ($stateParams, $state, movieDal, bookingDal, ticketDal, showingDal) {
        var vm = this;
        vm.bookingId = -1;
        vm.Params = $stateParams;

        /*        vm.addMovie = function(movieToAdd) {
         console.log("This is the value of movie to add " + movieToAdd);
         console.log(movieToAdd);
         var movieToJson = JSON.stringify(movieToAdd);
         console.log(movieToJson);
         movieDal.saveMovie(movieToAdd).then(function (results) {
         vm.movieAddMessage  = results;
         $state.go('getmovie');
         }, function (error) {
         vm.error = true;
         vm.errorMessage = error;
         });
         };*/


        vm.createTicket = function (ticketType) {
            console.log(vm.Params);
            var ticket = {
                //id : 1,
                //seat: {"column": 1, "row": 'a', "type": "STANDARD"},
                seat_seatid: 1,
                type: ticketType,
                Booking_bookingID: vm.bookingId
            };
            console.log(ticket);
            ticketDal.saveTicket(ticket);
        };

        vm.createTicketsForEachType = function (ticketType, number) {

            for (i = 0; i < number; i++) {
                vm.createTicket(ticketType);
            }
        };

        vm.createBooking = function ($stateParams, howManyTickets, newUserEmail, newPaymentEmail) {

            /*Required state params from previous page:
             * which movie
             * which showing
             */
            var time = new Date().getTime();

            var booking = {
                dateBooked: time,
                userEmail: newUserEmail,
                paymentEmail: newPaymentEmail
            };
            console.log(booking);
            bookingDal.saveBooking(booking).then(function (results) {
                console.log(results);
                vm.bookingId = parseInt(results.bookingId);
                console.log(vm.bookingId);
            }, function (error) {
                vm.error = true;
                vm.errorMessage = error;
            });


        };
        vm.createBooking($stateParams, 1, "blah1", "blah@blah.com");

        vm.addTicketsToBooking = function (howManyTickets) {
            vm.createTicketsForEachType("ADULT", howManyTickets.adultTickets)

        };

        waitForBookingId();


        function waitForBookingId(){
            if(vm.bookingId !== -1){
                vm.addTicketsToBooking({adultTickets:1});
            }
            else{
                console.log("waiting");
                console.log(vm.bookingId);
                setTimeout(waitForBookingId, 250);


            }
        }


    };

    angular.module('movieApp').controller('paymentController', ['$stateParams', '$state', 'movieDal', 'bookingDal', 'ticketDal', 'showingDal', PaymentController]);
}());