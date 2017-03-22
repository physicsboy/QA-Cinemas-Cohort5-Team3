/**
 * @author Matt Gordon
 */

(function() {
	var UpdateMovieController = function($state, movieDal) {
		var vm = this;

		vm.updateMovie = function(updatedValues, selectedMovie) {
			console.log("This is the value of movie to Update...");
			console.log(updatedValues);
			console.log(selectedMovie);

			console.log("break");

			angular.forEach(selectedMovie, function(sValue, sKey) {
				angular.forEach(updatedValues, function(mValue, mKey) {
					 if (sKey.match(mKey)) {						
						 selectedMovie[mKey]= mValue;
					 }
				})
			})
			
			console.log(selectedMovie);

			var movieToJson = JSON.stringify(selectedMovie);
			console.log(movieToJson);

			movieDal.updateMovie(selectedMovie).then(function(results) {
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
