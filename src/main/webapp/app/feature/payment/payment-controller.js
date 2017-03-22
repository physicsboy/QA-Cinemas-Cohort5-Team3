/**
 * Created by Sam Jarvis on 17/03/2017.
 */
(function () {

    var PaymentController = function ($stateParams, $state, movieDal,
                                      bookingDal, ticketDal, showingDal, $scope) {
        var vm = this;

        /*paypal.Button.render({

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

         }, '#paypal-button');*/

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

        vm.bookingId = -1;
        vm.showingId = $stateParams.showingId;
        vm.showing = "";
        vm.showingTitle= "init";
        vm.showingDate = "init";
        vm.showingTime = "init";


        vm.numAdults = 0;
        vm.numChild = 0;
        vm.numCons = 0;
        vm.numPremium = 0;
        vm.total = "00.00";
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
        document.getElementById("adultDropDown").style.background = "#9f2a27";
        document.getElementById("childDropDown").style.background = "#9f2a27";
        document.getElementById("consDropDown").style.background = "#9f2a27";
        document.getElementById("premDropDown").style.background = "#9f2a27";


        vm.seatId = 173;



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
                vm.numAdults = (Math.round(newVal.value) * 100) / 100;
            }
            if (type === "child") {
                vm.numChild = (Math.round((newVal.value) * 100)) / 100;
            }
            if (type === "cons") {
                vm.numCons = (Math.round((newVal.value) * 100)) / 100;
            }
            if (type === "prem") {
                vm.numPremium = (Math.round((newVal.value) * 100)) / 100;
            }
            if (type === "user") {
                vm.userEmail = newVal;
            }
            if (type === "paypal") {
                vm.paymentEmail = newVal;
            }
            vm.calcTotal();
            vm.checkForm();
        };

        vm.calcTotal = function () {
            vm.total = (Math.round((vm.numAdults * 9.99 + vm.numChild * 5.99 + vm.numCons * 7.49 + vm.numPremium * 12.99) * 100)) / 100

        };

        vm.checkForm = function () {
            var pay = document.getElementById("paypal-button");
            var totalTable = document.getElementById("totalTable");
            vm.uEVerified = validateEmail(vm.userEmail);
            vm.pEVerified = validateEmail(vm.paymentEmail);
            vm.totalTickets = vm.numCons + vm.numPremium + vm.numAdults + vm.numChild;
            if (vm.totalTickets != 0) {
                vm.nonZeroTickets = true;
            } else {
                vm.nonZeroTickets = false;
            }
            if (vm.uEVerified) {
                document.getElementById("uEVerified").src = "_images/tick.png";
                document.getElementById("user").style.background = "#43a848";
            } else {
                document.getElementById("uEVerified").src = "_images/cross.png";
                document.getElementById("user").style.background = "#9f2a27";
            }
            ;
            if (vm.pEVerified) {
                document.getElementById("pEVerified").src = "_images/tick.png";
                document.getElementById("paypal").style.background = "#43a848";
            } else {
                document.getElementById("pEVerified").src = "_images/cross.png";
                document.getElementById("paypal").style.background = "#9f2a27";
            }
            ;
            if (vm.nonZeroTickets) {
                document.getElementById("nonZeroTickets").src = "_images/tick.png";
                document.getElementById("adultDropDown").style.background = "#43a848";
                document.getElementById("childDropDown").style.background = "#43a848";
                document.getElementById("consDropDown").style.background = "#43a848";
                document.getElementById("premDropDown").style.background = "#43a848";
            } else {
                document.getElementById("nonZeroTickets").src = "_images/cross.png";
                document.getElementById("adultDropDown").style.background = "#9f2a27";
                document.getElementById("childDropDown").style.background = "#9f2a27";
                document.getElementById("consDropDown").style.background = "#9f2a27";
                document.getElementById("premDropDown").style.background = "#9f2a27";
            }
            ;

            if (vm.uEVerified && vm.pEVerified && vm.nonZeroTickets) {
                pay.style.display = "none";
                pay.classList.add('available');
                totalTable.classList.add('available');
            } else {
                pay.style.display = "table";
                pay.classList.remove('available');
                totalTable.classList.remove('available');
            }

        };

        function validateEmail(email) {
            var re = /^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
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
        };
        vm.init = function () {
            showingDal.getShowingById(vm.showingId).then(function (results) {
                console.log(results);
                vm.showing = results;
                console.log(vm.showing);
                var tmp = vm.showing.movie.title;
                console.log(tmp);
                vm.showingTitle = vm.showing.movie.title;
            }, function (error) {
                vm.error = true;
                vm.errorMessage = error;
            });
            vm.checkForm();
        };
        vm.init();

    };

    angular.module('movieApp').controller(
        'paymentController',
        ['$stateParams', '$state', 'movieDal', 'bookingDal', 'ticketDal',
            'showingDal', PaymentController]);
}());