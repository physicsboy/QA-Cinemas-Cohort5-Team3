/**
 * Created by AlexD on 13/03/2017.
 */

(function () {

    var ContactController = function(contactService, contactdal) {

        var vm = this;
        var string = [];

        vm.sendEmail = function(emailToSend) {
            contactService.sendEmail(emailToSend);
        };

    };

    angular.module('movieApp').controller('contactController', ['contactService', ContactController]);

}());