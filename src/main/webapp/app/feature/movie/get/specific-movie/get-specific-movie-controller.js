(function () {

    var GetSpecificMovieController = function (movieDal, showingDal, $stateParams) {
        var vm = this;
        var param = $stateParams;

        vm.getMovieById = function getMovieById() {
            movieDal.getMovieById($stateParams.movieId).then(function (results) {
                vm.movies = results;
            }, function (error) {
                vm.error = true;
                vm.errorMessage = error;
            });
        };
        vm.getMovieById();

        vm.getShowingByMovie = function () {
            showingDal.getShowingByMovie($stateParams.movieId).then(function (results) {
                vm.showings = results;
            }, function (error) {
                vm.error = true;
                vm.errorMessage = error;
            });
        };
        vm.getShowingByMovie()

        var data=(new Function("return " + json ));
        $(function(){
            var json = '{"point_in_time": new Date({{showings.dateShowing}})}';
            var data = $.parseJSON(json);
            console.log(data);
        });

    };
    angular.module('movieApp').controller('getSpecificMovieController', ['movieDal', 'showingDal', '$stateParams', GetSpecificMovieController]);
}());

