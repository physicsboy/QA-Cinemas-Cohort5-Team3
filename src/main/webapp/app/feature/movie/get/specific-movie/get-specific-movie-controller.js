(function () {

    var GetSpecificMovieController = function (movieDal, mediaDal, $stateParams) {
        var vm = this;
        var param = $stateParams;
        console.log(param);

        vm.getMovieById = function getMovieById() {
            movieDal.getMovieById(param.movieId).then(function (results) {
                vm.movies = results;
            }, function (error) {
                vm.error = true;
                vm.errorMessage = error;
            });
        };
        vm.getMovieById();

        vm.trustSrc = function trustSrc(src) {
            return $sce.trustAsResourceUrl(src);
        }
    };

    angular.module('movieApp').controller('getSpecificMovieController', ['movieDal', 'mediaDal', '$stateParams', GetSpecificMovieController]);
}());

