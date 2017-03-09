/** @author AlexNewton */

(function() {

    var AddTicketController =  function($state, ticketDal) {

        var vm = this;

        vm.addTicket = function(ticket){
            ticketDal.saveTicket(ticket).then(function () {
                $state.go('addticket');
            }, function (error) {
                vm.error = true;
                vm.errorMessage = error;
            });
        };
    };

    angular.module('movieApp').controller('addTicketController', [ '$state', 'ticketDal', AddTicketController]);
}());