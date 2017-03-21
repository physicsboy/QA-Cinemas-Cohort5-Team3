/**
 * Created by Sam Jarvis on 17/03/2017.
 */
(function () {

    var PaymentController = function ($stateParams, $state, movieDal,
                                      bookingDal, ticketDal, showingDal, $scope) {
        var vm = this;

        paypal.Button.render({

            env: 'sandbox', // Specify 'sandbox' for the test environment

            client: {
                sandbox: 'AVjUbRR4FzoCPScS-Nn76jDt-jsh2J6qCPronyoYWvGvjKogW7bzUk1EhertWzWwYR2pjY7amWqBup08'
            },


            payment: function () {

                vm.createBooking(vm.compileBooking());

                var env = this.props.env;
                var client = this.props.client;

                return paypal.rest.payment.create(env, client, {
                    transactions: [
                        {
                            amount: {total: vm.total, currency: 'GBP'} //the total will be changed to logic once the rest of the payment process is implemented
                        }
                    ]
                });
            },

            commit: true,

            onAuthorize: function (data, actions) {
                return actions.payment.execute().then(function () {

                })
            }

        }, '#paypal-button');

        vm.options = [
            {value: 0, name: 0},
            {value: 1, name: 1},
            {value: 2, name: 2},
            {value: 3, name: 3},
            {value: 4, name: 4},
            {value: 5, name: 5},
            {value: 6, name: 6},
            {value: 7, name: 7},
            {value: 8, name: 8},
            {value: 9, name: 9}
        ];


        vm.numAdults = 0;
        vm.numChild = 0;
        vm.numCons = 0;
        vm.numPremium = 0;
        vm.userEmail = "";
        vm.paymentEmail = "";
        vm.theBooking = {
            numAdults: 0,
            numChild: 0,
            numCons: 0,
            numPremium: 0,
            userEmail: "",
            paymentEmail: ""
        };

        vm.uEVerified = false;
        vm.pEVerified = false;
        vm.nonZeroTickets = false;
        document.getElementById("paypal-button").style.visibility = "hidden";

        vm.bookingId = -1;
        vm.seatId = 173;
        vm.showingId = $stateParams.showingId;

        /*
         * vm.addMovie = function(movieToAdd) { console.log("This is the value
         * of movie to add " + movieToAdd); console.log(movieToAdd); var
         * movieToJson = JSON.stringify(movieToAdd); console.log(movieToJson);
         * movieDal.saveMovie(movieToAdd).then(function (results) {
         * vm.movieAddMessage = results; $state.go('getmovie'); }, function
         * (error) { vm.error = true; vm.errorMessage = error; }); };
         */

        vm.createTicket = function (ticketType) {
            var ticket = {
                type: ticketType
            };
            bookingDal.addTicketToBooking(ticket, vm.bookingId, vm.seatId,
                vm.showingId);
        };

        vm.createTicketsForEachType = function (ticketType, number) {

            for (i = 0; i < number; i++) {
                vm.createTicket(ticketType);
            }
        };

        vm.createBooking = function (theBooking) {
            var time = new Date().getTime();

            var booking = {
                dateBooked: time,
                userEmail: theBooking.userEmail,
                paymentEmail: theBooking.paymentEmail
            };
            bookingDal.saveBooking(booking).then(function (results) {
                vm.bookingId = parseInt(results.bookingId);
            }, function (error) {
                vm.error = true;
                vm.errorMessage = error;
            });

            waitForBookingId();

        };

        vm.addTicketsToBooking = function () {
            vm.createTicketsForEachType("ADULT", vm.theBooking.adult);

            vm.createTicketsForEachType("CHILD", vm.theBooking.child);

            vm.createTicketsForEachType("CONCESSION", vm.theBooking.cons);

            vm.createTicketsForEachType("PREMIUM", vm.theBooking.prem);
        };

        function waitForBookingId() {
            if (vm.bookingId !== -1) {
                vm.addTicketsToBooking();
            } else {
                setTimeout(waitForBookingId, 250);

            }
        }

        vm.update = function (type, newVal) {
            if (type === "adult") {
                vm.numAdults = newVal.value;
            }
            if (type === "child") {
                vm.numChild = newVal.value;
            }
            if (type === "cons") {
                vm.numCons = newVal.value;
            }
            if (type === "prem") {
                vm.numPremium = newVal.value;
            }
            if (type === "user") {
                console.log(newVal);
                vm.userEmail = newVal;
            }
            if (type === "paypal") {
                console.log(newVal);
                vm.paymentEmail = newVal;
            }
            vm.calcTotal();
            vm.checkForm();
        };

        vm.calcTotal = function () {
            vm.total = (Math.round((vm.numAdults * 9.99 + vm.numChild * 5.99 + vm.numCons * 7.49 + vm.numPremium * 12.99)*100))/100

        };

        vm.checkForm = function(){
            vm.uEVerified = validateEmail(vm.userEmail);
            vm.pEVerified = validateEmail(vm.paymentEmail);
            vm.totalTickets = vm.numCons+vm.numPremium+vm.numAdults+vm.numChild;
            if (vm.totalTickets != 0){
                vm.nonZeroTickets = true;
            } else{
                vm.nonZeroTickets = false;
            }
            if (vm.uEVerified){
                document.getElementById("uEVerified").src="_images/tick.png";
            } else{
                document.getElementById("uEVerified").src="_images/cross.png";
            };
            if (vm.pEVerified){
                document.getElementById("pEVerified").src="_images/tick.png";
            } else{
                document.getElementById("pEVerified").src="_images/cross.png";
            };
            if (vm.nonZeroTickets){
                document.getElementById("nonZeroTickets").src="_images/tick.png";
            } else{
                document.getElementById("nonZeroTickets").src="_images/cross.png";
            };

            if (vm.uEVerified&&vm.pEVerified&&vm.nonZeroTickets){
                document.getElementById("paypal-button").style.visibility = "visible";
            }else{
                document.getElementById("paypal-button").style.visibility = "hidden";
            }

        };

        function validateEmail(email) {
            var re = /^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
            console.log(re.test(email));
            return re.test(email);
        }

        vm.compileBooking = function () {
            vm.theBooking = {
                adult: vm.numAdults,
                child: vm.numChild,
                cons: vm.numCons,
                prem: vm.numPremium,
                paymentEmail: vm.paymentEmail,
                userEmail: vm.userEmail
            };
            return vm.theBooking;
        }

    };

    angular.module('movieApp').controller(
        'paymentController',
        ['$stateParams', '$state', 'movieDal', 'bookingDal', 'ticketDal',
            'showingDal', PaymentController]);
}());