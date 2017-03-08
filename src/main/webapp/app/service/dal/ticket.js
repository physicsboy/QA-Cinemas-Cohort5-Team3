"use strict";

(function () {

    angular.module("movieApp").service("ticketDal", ["dal", TicketDal]);

    function TicketDal (dal) {

        this.getTickets = function () {
            return dal.http.GET("rest/ticket/json");
        };

        this.saveTicket = function (ticketToSave) {
            return dal.http.POST("rest/ticket/json",ticketToSave);
        };

        this.updateTicket = function (ticketToUpdateId,ticketToUpdate) {
            return dal.http.PUT("rest/ticket/json/" +ticketToUpdateId,ticketToUpdate);
        };

        this.deleteTicket = function (ticketToDeleteId) {
            return dal.http.DELETE("/rest/ticket/json/" +ticketToDeleteId);
        };

    }
}());
