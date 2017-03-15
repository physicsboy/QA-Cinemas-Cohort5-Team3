"use strict";

(function() {
    angular.module("movieApp").service("contactDal", ["dal", contactDal]);

    var contactDal = function (dal) {

        this.sendEmail = function(emailToSend) {
            //Don't want to go to a specific page? Keep on home page
            return dal.http.POST("/cinema/rest/email/send", emailToSend);
        };

    };


}());




