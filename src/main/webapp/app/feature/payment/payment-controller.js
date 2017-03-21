/**
 * Created by Sam Jarvis on 17/03/2017.
 */
(function() {

	var PaymentController = function($stateParams, $state, movieDal,
			bookingDal, ticketDal, showingDal, $scope) {
        var vm = this;
		vm.options = [
            {value:0,name:0},
            {value:1,name:1},
            {value:2,name:2},
            {value:3,name:3},
            {value:4,name:4},
            {value:5,name:5},
            {value:6,name:6},
            {value:7,name:7},
            {value:8,name:8},
            {value:9,name:9}
        ];

        vm.numAdults=0;
        vm.numChild=0;
        vm.numCons=0;
        vm.numPremium=0;



		vm.bookingId = -1;
		vm.seatId = 173;
		vm.showingId = 32;

		/*
		 * vm.addMovie = function(movieToAdd) { console.log("This is the value
		 * of movie to add " + movieToAdd); console.log(movieToAdd); var
		 * movieToJson = JSON.stringify(movieToAdd); console.log(movieToJson);
		 * movieDal.saveMovie(movieToAdd).then(function (results) {
		 * vm.movieAddMessage = results; $state.go('getmovie'); }, function
		 * (error) { vm.error = true; vm.errorMessage = error; }); };
		 */

		vm.createTicket = function(ticketType) {
			var ticket = {
				type : ticketType
			};
			console.log("Ticket to be added:" + ticket + " to booking id:"
					+ vm.bookingId);
			bookingDal.addTicketToBooking(ticket, vm.bookingId, vm.seatId,
					vm.showingId);
		};

		vm.createTicketsForEachType = function(ticketType, number) {

			for (i = 0; i < number; i++) {
				vm.createTicket(ticketType);
			}
		};

		vm.createBooking = function(thisBooking) {

			vm.thisBooking = thisBooking;

			/*
			 * Required state params from previous page: which showing
			 */
			var time = new Date().getTime();

			var booking = {
				dateBooked : time,
				userEmail : thisBooking.userEmail,
				paymentEmail : thisBooking.paymentEmail
			};
			console.log(booking);
			bookingDal.saveBooking(booking).then(function(results) {
				vm.bookingId = parseInt(results.bookingId);
			}, function(error) {
				vm.error = true;
				vm.errorMessage = error;
			});

			waitForBookingId();

		};

		vm.addTicketsToBooking = function() {
			if ((vm.thisBooking.adult !== null) && (vm.thisBooking.adult !== 0)) {
				vm.createTicketsForEachType("ADULT", vm.thisBooking.adult);
			}
			if ((vm.thisBooking.child !== null) && (vm.thisBooking.child !== 0)) {
				vm.createTicketsForEachType("CHILD", vm.thisBooking.child);
			}
			if ((vm.thisBooking.concession !== null) && (vm.thisBooking.concession !== 0)) {
				vm.createTicketsForEachType("CONCESSION",
						vm.thisBooking.concession);
			}
			if ((vm.thisBooking.premium !== null) && (vm.thisBooking.premium !== 0)) {
				vm.createTicketsForEachType("PREMIUM", vm.thisBooking.premium);
			}

		};

		function waitForBookingId() {
			if (vm.bookingId !== -1) {
				vm.addTicketsToBooking(vm.thisBooking);
			} else {
				console.log("waiting");
				setTimeout(waitForBookingId, 250);

			}
		}

		vm.update = function(){
			console.log("In update");
			console.log(thisBooking);
            if(thisBooking !== undefined) {
                if ((vm.thisBooking.adult !== undefined)) {
                    vm.numAdults = vm.thisBooking.adult.value;
                }
                if ((vm.thisBooking.child !== undefined)) {
                    vm.numChild = vm.thisBooking.child.value;
                }
                if ((vm.thisBooking.concession !== undefined)) {
                    vm.numCons = vm.thisBooking.concession.value;
                }
                if ((vm.thisBooking.premium !== undefined)) {
                    vm.numPremium = vm.thisBooking.premium.value;
                }
                vm.calcTotal()
            }
		};
		
		vm.calcTotal = function(){
			vm.total = vm.numAdults*9.99 + vm.numChild*5.99 + vm.numCons*7.49 + vm.numPremium*12.99;
		};

	};

	angular.module('movieApp').controller(
			'paymentController',
			[ '$stateParams', '$state', 'movieDal', 'bookingDal', 'ticketDal',
					'showingDal', PaymentController ]);
}());