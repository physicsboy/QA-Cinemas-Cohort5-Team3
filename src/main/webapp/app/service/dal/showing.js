"use strict";

(function () {

    angular.module("movieApp").service("showingDal", ["dal", ShowingDal]);

    function ShowingDal (dal) {

        this.getShowings = function () {
            return dal.http.GET("rest/showing/json");
        };

        this.saveShowing = function (showingToSave) {
            return dal.http.POST("rest/showing/json",showingToSave);
        };

        this.updateShowing = function (showingToUpdateId,showingToUpdate) {
            return dal.http.PUT("rest/showing/json/" +showingToUpdateId,showingToUpdate);
        };

        this.deleteShowing = function (showingToDeleteId) {
            return dal.http.DELETE("/rest/showing/json/" +showingToDeleteId);
        };

    }
}());
