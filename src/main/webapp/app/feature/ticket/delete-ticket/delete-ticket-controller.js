/** @author AlexNewton */

(function() {

    var DeleteTicketController =  function($state, ticketDal) {

        var vm = this;


        vm.deleteTicket = function(ticket){
            ticketDal.deleteTicket(ticket).then(function () {
                $state.go('addticket');
            }, function (error) {
                vm.error = true;
                vm.errorMessage = error;
            });
        };
    };

    angular.module('movieApp').controller('deleteTicketController', [ '$state', 'ticketDal', DeleteTicketController]);
}());