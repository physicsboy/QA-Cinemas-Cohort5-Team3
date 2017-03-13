"use strict";

(function () {

    angular.module("movieApp").service("movieDal", ["dal", MovieDal]);

    function MovieDal (dal) {

        this.getMovies = function () {
            return dal.http.GET("rest/movie/json");
        };

        this.getMovieByTitle = function (title) {
            return dal.http.GET("rest/movie/title/json/" + title)
        };

        this.saveMovie = function (movieToSave) {
            return dal.http.POST("rest/movie/json", movieToSave);
        };

        this.updateMovie = function (movieToUpdateId, movieToUpdate) {
            return dal.http.PUT("rest/movie/json/" + movieToUpdateId, movieToUpdate);
        };

        this.deleteMovie = function (movieToDelete) {
            return dal.http.DELETE("/rest/movie/json/", movieToDeleteId);
        };

    }
}());
