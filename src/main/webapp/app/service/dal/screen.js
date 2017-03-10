"use strict";

(function () {

    angular.module("movieApp").service("screenDal", ["dal", ScreenDal]);

    function ScreenDal (dal) {

        this.getScreens = function () {
            return dal.http.GET("rest/screen/json");
        };

        this.saveScreen = function (screenToSave) {
            return dal.http.POST("rest/screen/json",screenToSave);
        };

        this.updateScreen = function (screenToUpdateId,screenToUpdate) {
            return dal.http.PUT("rest/screen/json/" + screenToUpdateId, screenToUpdate);
        };

        this.deleteScreen = function (screenToDelete) {
            return dal.http.DELETE("/rest/screen/json/", screenToDelete);
        };

    }
}());
