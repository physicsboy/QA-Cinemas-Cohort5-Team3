(function() {

    var DeleteMovieController =  function($state, movieDal) {
        var vm = this;

        vm.deleteMovie = function(movieToDelete) {
            console.log("This is the value of movie to delete:");
            console.log(movieToDelete);
            
            movieDal.deleteMovie(movieToDelete).then(
            		function (results) {
		                vm.movieDeleteMessage  = results;
		                $state.go('getmovie');
		            }, function (error) {
		                vm.error = true;
		                vm.errorMessage = error;
		            }
		    );
        };
    };

    angular.module('movieApp').controller('deleteMovieController', ['$state','movieDal',DeleteMovieController]);
}());