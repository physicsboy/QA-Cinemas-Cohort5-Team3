"use strict";

(function () {

    function TicketDal (dal) {

        this.getAllTickets = function () {
            return dal.http.GET("rest/ticket/json");
        };

        this.getAllTicketsForBooking = function(id){
            return dal.http.GET("rest/ticket/json/booking/" + id)
        };
        
        this.getTicketByID = function(id){
        	return dal.http.GET("rest/ticket/json/" + id)
        };

        this.saveTicket = function (ticketToSave) {
            return dal.http.POST("rest/ticket/json", ticketToSave);
        };

        this.updateTicket = function (ticketToUpdateId, ticketToUpdate) {
            return dal.http.PUT("rest/ticket/json/" + ticketToUpdateId, ticketToUpdate);
        };

        this.deleteTicket = function (ticketToDelete) {
            return dal.http.DELETE("/rest/ticket/json/", ticketToDelete);
        };
    }


    angular.module("movieApp").service("ticketDal", ["dal", TicketDal]);

}());
