/**
 * @author Sam Jarvis
 */

(function() {
	var UpdateBookingController = function($state, bookingDal) {
		var vm = this;

		vm.updateBooking = function(bookingToUpdate) {
			console.log("This is the value of booking to Update..." + bookingToUpdate);
			console.log(bookingToUpdate);
			var bookingToJson = JSON.stringify(bookingToUpdate);
			console.log(bookingToJson);
			bookingDal.updateBooking(bookingToUpdate).then(function(results) {
				vm.bookingUpdateMessage = results;
				$state.go('getbooking');
			}, function(error) {
				vm.error = true;
				vm.errorMessage = error;
			});
		};
	};
	angular.module('movieApp').controller('updateBookingController', [ '$state', 'bookingDal', UpdateBookingController ]);
}());