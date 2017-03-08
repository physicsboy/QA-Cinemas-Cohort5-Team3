/**
 * @author Sam Jarvis
 */

(function() {
	var DeleteBookingController = function($state, bookingDal) {
		var vm = this;

		vm.deleteBooking = function(bookingToDelete) {
			console.log("This is the value of booking to Update..." + bookingToDelete);
			console.log(bookingToDelete);
			var bookingToJson = JSON.stringify(bookingToDelete);
			console.log(bookingToJson);
			bookingDal.deleteBooking(bookingToDelete).then(function(results) {
				vm.bookingDeleteMessage = results;
				$state.go('getbooking');
			}, function(error) {
				vm.error = true;
				vm.errorMessage = error;
			});
		};
	};
	angular.module('cinema').controller('deleteBookingController', [ '$state', 'bookingDal', DeleteBookingController ]);
}());