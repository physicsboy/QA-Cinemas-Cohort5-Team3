"use strict";

(function () {

    angular.module("movieApp").service("screenDal", ["dal", ScreenDal]);

    function ScreenDal (dal) {

        this.getScreens = function () {
            return dal.http.GET("rest/screen/json");
        };
        
        this.getScreen = function (screenToGetId) {
            return dal.http.GET("rest/screen/json" + screenToGetId);
        };

        this.saveScreen = function (screenToSave) {
            return dal.http.POST("rest/screen/json",screenToSave);
        };

        this.updateScreen = function (screenToUpdateId,screenToUpdate) {
            return dal.http.PUT("rest/screen/json/" + screenToUpdateId,screenToUpdate);
        };

        this.deleteScreen = function (screenToDeleteId) {
            return dal.http.DELETE("/rest/screen/json/" + screenToDeleteId);
        };

    }
}());
