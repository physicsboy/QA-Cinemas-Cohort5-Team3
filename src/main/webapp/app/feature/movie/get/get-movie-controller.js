(function () {

    var GetMovieController = function (movieDal) {
        var vm = this;

        vm.getMovies = function getMovies() {
            movieDal.getMovies().then(function (results) {
                vm.movies = results;
            }, function (error) {
                vm.error = true;
                vm.errorMessage = error;
            });
        };

        vm.getMovies();


        vm.getMovieByTitle = function getMovieByTitle() {
            movieDal.getMovieByTitle().then(function (results) {
                vm.movies = results;
            }, function (error) {
                vm.error = true;
                vm.errorMessage = error;
            });
        };

        vm.getMovieByGenre = function getMovieByGenre() {
            movieDal.getMovieByGenre().then(function (results) {
                vm.movies = results;
            }, function (error) {
                vm.error = true;
                vm.errorMessage = error;
            });
        };

        vm.getMovieByYear = function getMovieByYear() {
            movieDal.getMovieByYear().then(function (results) {
                vm.movies = results;
            }, function (error) {
                vm.error = true;
                vm.errorMessage = error;
            });
        }
    };

    angular.module('movieApp').controller('getMovieController', ['movieDal', GetMovieController]);
}());