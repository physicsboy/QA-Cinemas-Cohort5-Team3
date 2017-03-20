(function () {

    var GetSpecificMovieController = function (movieDal, $stateParams) {
        var vm = this;
        var param = $stateParams;
        console.log(param);

        vm.getMovieById = function getMovieById() {
            movieDal.getMovieById($stateParams.movieId).then(function (results) {
                vm.movies = results;
            }, function (error) {
                vm.error = true;
                vm.errorMessage = error;
            });
        };
        vm.getMovieById();
    };

    angular.module('movieApp').controller('getSpecificMovieController', ['movieDal', '$stateParams', GetSpecificMovieController]);
}());

