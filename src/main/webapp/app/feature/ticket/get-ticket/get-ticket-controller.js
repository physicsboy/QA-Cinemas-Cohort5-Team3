/** @author AlexNewton */

(function() {

    var GetTicketController =  function(ticketDal) {
    	
        var vm = this;

        vm.getAllTickets = function getAllTickets() {
            ticketDal.getAllTickets().then(function (results) {
                vm.tickets = results;
            }, function (error) {
                vm.error = true;
                vm.errorMessage = error;
            });
        };


        vm.getTicketForBooking = function(id){
            ticketDal.getAllTicketsForBooking(id).then(function (results) {
                vm.tickets = results;
            }, function (error) {
                vm.error = true;
                vm.errorMessage = error;
            });

        };


        vm.getTicketByID = function(id){
            ticketDal.getTicketByID(id).then(function (results) {
                vm.tickets = results;
            }, function (error) {
                vm.error = true;
                vm.errorMessage = error;
            });
        };
    };

    angular.module('movieApp').controller('getTicketController', ['ticketDal', GetTicketController]);
}());