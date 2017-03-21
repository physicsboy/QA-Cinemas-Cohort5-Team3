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


        // vm.getDay = function () {
        //     showingDal.getShowingByMovie($stateParams.movieId).then(function (results) {
        //
        //         var timestamp = results.dateShowing
        //         var a = new Date(timestamp*1000);
        //         var days = ['Sunday','Monday','Tuesday','Wednesday','Thursday','Friday','Saturday'];
        //         var dayOfWeek = days[a.getDay()]
        //
        //         vm.showings = dayOfWeek;
        //         // console.log(dayOfWeek)
        //     }, function (error) {
        //         vm.error = true;
        //         vm.errorMessage = error;
        //     });
        // };
        // vm.getDay()
    };
    angular.module('movieApp').controller('getSpecificMovieController', ['movieDal', 'showingDal', '$stateParams', GetSpecificMovieController]);
}());

