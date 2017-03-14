/**
 * Created by AlexD on 13/03/2017.
 */

(function () {

    var contactController = function(contactService) {

        var vm = this;
        var string = [];

        vm.sendEmail = function(emailToSend) {
            contactService.sendEmail(emailToSend);
        };

    }

    angular.module('cinemaApp').controller('contactController', ['contactService', contactController]);

}());