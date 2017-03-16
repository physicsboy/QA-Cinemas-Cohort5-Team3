(function () {

    var GetMovieController = function (movieDal, $stateParams) {
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

        vm.getMovieById = function getMovieById() {
            movieDal.getMovieById($stateParams.movieId).then(function (results) {
                vm.movies = results;
            }, function (error) {
                vm.error = true;
                vm.errorMessage = error;
            });
        };

        vm.getMovieByTitle = function getMovieByTitle(title) {
            movieDal.getMovieByTitle(title).then(function (results) {
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
    };

    angular.module('movieApp').controller('getMovieController', ['movieDal', GetMovieController]);
}());

