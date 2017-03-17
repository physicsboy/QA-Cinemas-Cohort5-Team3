"use strict";

(function () {

    angular.module("movieApp").service("movieDal", ["dal", MovieDal]);

    function MovieDal (dal) {

        this.getMovies = function () {
            return dal.http.GET("rest/movie/json");
        };

        this.getMovieById = function (id) {
            return dal.http.GET("rest/movie/json/" + id);
        };

        this.getMovieByTitle = function (title) {
            return dal.http.GET("rest/movie/title/json/" + title)
        };

        this.saveMovie = function (movieToSave) {
            return dal.http.POST("rest/movie/json/", movieToSave);
        };

        this.updateMovie = function (movieToUpdateId, movieToUpdate) {
            return dal.http.PUT("rest/movie/json/" + movieToUpdateId, movieToUpdate);
        };

        this.deleteMovie = function (movieToDeleteId) {
            return dal.http.DELETE("/rest/movie/json/", movieToDeleteId);
        };
    }
}());
