/**
 * Created by Administrator on 13/03/2017.
 */

"use strict";

(function() {

    var contactService = function(contactDal) {

        this.sendEmail = function(emailSend) {
            return contactDal.sendEmail(emailSend);
        }
    }

    angular.module("cinemaApp").service("contactService", ["contactDal", contactService]);

}());