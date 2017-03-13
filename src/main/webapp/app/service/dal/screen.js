"use strict";

(function () {

    angular.module("movieApp").service("screenDal", ["dal", ScreenDal]);

    function ScreenDal (dal) {

        this.getAllScreens = function () {
            return dal.http.GET("rest/screen/json");
        };
        
        this.getScreen = function () {
            return dal.http.GET("rest/screen/json"  + screenToGetId);
        };

        this.createScreen = function (screenToCreate) {
            return dal.http.POST("rest/screen/json", screenToCreate);
        };

        this.updateScreen = function (screenToUpdateId,screenToUpdate) {
            return dal.http.PUT("rest/screen/json/" + screenToUpdateId, screenToUpdate);
        };

        this.deleteScreen = function (screenToDelete) {
            return dal.http.DELETE("/rest/screen/json/", screenToDelete);
        };

    }
}());
