/**
 * @author Matt Gordon
 */

(function() {
	var UpdateMovieController = function($state, movieDal) {
		var vm = this;

		vm.updateMovie = function(updatedMovieValues, selectedMovie) {
			console.log("These are the user updates request for MOVIES:");
			console.log(updatedMovieValues);
			console.log("This is the value of the selected movie:");
			console.log(selectedMovie);
			console.log(JSON.stringify(selectedMovie));

			angular.forEach(selectedMovie, function(sValue, sKey) {
				angular.forEach(updatedMovieValues, function(mValue, mKey) {
					if (sKey.match(mKey)) {
						selectedMovie[mKey] = mValue;
					}

				})
			})

			console.log("This is the value of updated movie to update:");
			console.log(selectedMovie);

			console.log(JSON.stringify(selectedMovie));

			movieDal.updateMovie(selectedMovie.id, selectedMovie).then(function(results) {
				vm.movieUpdateMessage = results;
				$state.go('getmovie');
			}, function(error) {
				vm.error = true;
				vm.errorMessage = error;
			});
		};
	};
	angular.module('movieApp').controller('updateMovieController',
			[ '$state', 'movieDal', UpdateMovieController ]);
}());
