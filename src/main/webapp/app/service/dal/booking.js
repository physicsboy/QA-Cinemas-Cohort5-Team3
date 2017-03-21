"use strict";

(function () {

    angular.module("movieApp").service("bookingDal", ["dal", BookingDal]);

    function BookingDal (dal) {

        this.getBookings = function () {
            return dal.http.GET("rest/booking/json");
        };

        this.getBookingByID = function(id){
            return dal.http.GET("rest/booking/json/" + id);
        };

        this.getBookingsByUserID = function(id){
            return dal.http.GET("rest/booking/json/user/" +id);
        };

        this.saveBooking = function (bookingToSave) {
            console.log(bookingToSave);
            var x = dal.http.POST("rest/booking/json", bookingToSave);
            console.log(x);
            return x;
        };

        this.updateBooking = function (bookingToUpdateId, bookingToUpdate) {
            return dal.http.PUT("rest/booking/json/" + bookingToUpdateId, bookingToUpdate);
        };

        this.deleteBooking = function (bookingToDelete) {
            return dal.http.DELETE("rest/booking/json/", bookingToDelete);
        };
        
        this.addTicketToBooking = function(ticket,bookingId,seatId,showingId){
            console.log("ticket:"+ticket);
            var x = dal.http.POST("rest/booking/json/"+bookingId+"/"+showingId+"/"+seatId, ticket);
            console.log(x);
            return x;
        }

    }
}());
