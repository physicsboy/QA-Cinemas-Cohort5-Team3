"use strict";

(function () {

    angular.module("movieApp").service("bookingDal", ["dal", BookingDal]);

    function BookingDal (dal) {

        this.getBookings = function () {
            return dal.http.GET("rest/booking/json");
        };

        this.saveBooking = function (bookingToSave) {
            return dal.http.POST("rest/booking/json", bookingToSave);
        };

        this.updateBooking = function (bookingToUpdateId, bookingToUpdate) {
            return dal.http.PUT("rest/booking/json/" + bookingToUpdateId, bookingToUpdate);
        };

        this.deleteBooking = function (bookingToDelete) {
            return dal.http.DELETE("/rest/booking/json/", bookingToDelete);
        };

    }
}());
