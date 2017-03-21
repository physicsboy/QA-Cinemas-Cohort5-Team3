/**
 * @author Matt Gordon
 */

(function() {
	var UpdateMovieController = function($state, movieDal) {
		var vm = this;

		vm.updateMovie = function(movieToUpdate) {
			console.log("This is the value of movie to Update..." + movieToUpdate);
			console.log(movieToUpdate);
			var movieToJson = JSON.stringify(movieToUpdate);
			console.log(movieToJson);
			movieDal.updateMovie(movieToUpdate).then(function(results) {
				vm.movieUpdateMessage = results;
				$state.go('getmovie');
			}, function(error) {
				vm.error = true;
				vm.errorMessage = error;
			});
		};
	};
	angular.module('movieApp').controller('updateMovieController', [ '$state', 'movieDal', UpdateMovieController]);
}());
