"use strict";

(function() {

        this.getAllMedia = function (filmId, type) {
            return dal.http.GET("rest/media/json/all" + filmId + "/" + type)
        };

        this.getSingleMedia = function (filmId, type){
            return dal.http.GET("rest/media/json/" + filmId + "/" + type)
        };

        this.saveMedia = function (mediaToSave) {
            return dal.http.POST("rest/media/json/" + mediaToSave.movieID)
        };

        this.updateMedia = function (mediaToUpdateId, mediaToUpdate) {
            return dal.http.PUT("rest/media/json/" + mediaToUpdateId, mediaToUpdate)
        };

        this.deleteMedia = function (mediaToDeleteId) {
            return dal.http.DELETE("rest/media/json/" + mediaToDeleteId)
        }

}());