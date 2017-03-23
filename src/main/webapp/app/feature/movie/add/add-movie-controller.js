(function() {

	var AddMovieController = function($state, movieDal) {
		var vm = this;

		vm.addMovie = function(movieToAdd, media) {
			console.log("This is the value of movie to add ");
			console.log(movieToAdd);
			console.log(media);

			var movieToJson = JSON.stringify(movieToAdd);
			console.log(movieToJson);

			movieDal.saveMovie(movieToAdd).then(function(results) {
				vm.movieAddMessage = results;
				$state.go("getmovie"); //TODO Movie data needs to include media 
			}, function(error) {
				vm.error = true;
				vm.errorMessage = error;
			});
		};
	};

	angular.module('movieApp').controller('addMovieController',
			[ '$state', 'movieDal', AddMovieController ]);
}());