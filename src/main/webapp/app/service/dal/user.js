"use strict";

(function () {

    angular.module("movieApp").service("userDal", ["dal", UserDal]);

    function UserDal (dal) {

        this.getUsers = function () {
            return dal.http.GET("rest/user/json");
        };

        this.saveUser = function (userToSave) {
            return dal.http.POST("rest/user/json", userToSave);
        };

        this.updateUser = function (userToUpdateId, userToUpdate) {
            return dal.http.PUT("rest/user/json/" + userToUpdateId, userToUpdate);
        };

        this.deleteUser = function (userToDelete) {
            return dal.http.DELETE("/rest/user/json/",  userToDelete);
        };

    }
}());