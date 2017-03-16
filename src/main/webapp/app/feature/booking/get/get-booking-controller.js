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

        vm.getBookingByID = function(id){
            bookingDal.getBookingByID(id).then(function (results) {
                vm.bookings = results;
            }, function (error) {
                vm.error = true;
                vm.errorMessage = error;
            });
        };

        vm.getBookingsByUserID = function(id){
            bookingDal.getBookingsByUserID(id).then(function (results) {
                vm.bookings = results;
            }, function (error) {
                vm.error = true;
                vm.errorMessage = error;
            });
        };
		
	};

	angular.module('movieApp').controller('getBookingController', [ '$state', 'bookingDal', GetBookingController ]);
}());