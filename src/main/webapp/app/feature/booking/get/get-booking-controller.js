/**
 * @author Sam Jarvis
 */

(function() {

	var GetBookingController = function($state, bookingDal) {
		var vm = this;

		function init() {
			bookingDal.getBookings().then(function(results) {
				vm.bookings = results;
			}, function(error) {
				vm.error = true;
				vm.errorMessage = error;
			});
		}
		init();
		
		
	};

	angular.module('bookingApp').controller('getBookingController', [ '$state', 'bookingDal', GetBookingController ]);
}());