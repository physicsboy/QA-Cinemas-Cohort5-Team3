/** @author AlexNewton */

(function() {

    var UpdateTicketController =  function($state, ticketDal) {

        var vm = this;

        vm.updateTicket = function(ticket){
            ticketDal.updateTicket(ticket).then(function () {
                $state.go('addticket');
            }, function (error) {
                vm.error = true;
                vm.errorMessage = error;
            });
        };
    };

    angular.module('movieApp').controller('updateTicketController', [ '$state', 'ticketDal', UpdateTicketController]);
}());