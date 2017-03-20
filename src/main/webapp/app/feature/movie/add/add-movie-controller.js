(function() {

    var AddMovieController =  function($state, movieDal, mediaDal) {
        var vm = this;

        vm.addMovie = function(movieToAdd, mediaToAdd) {
            console.log("This is the value of movie to add ");
            console.log(movieToAdd);
            console.log("This is the value of media to add ");
            console.log(mediaToAdd);
            
            var movieToJson = JSON.stringify(movieToAdd);
            console.log(movieToJson);
            var mediaToJson = JSON.stringify(mediaToAdd);
            console.log(mediaToJson);
            
            movieDal.saveMovie(movieToAdd).then(function (results) {
                vm.movieAddMessage  = results;
            }, function (error) {
                vm.error = true;
                vm.errorMessage = error;
            })
            mediaDal.saveMedia(mediaToAdd).then(function (results) {
            	vm.mediaAddMessage  = results;
            	$state.go('getmovie');
            }, function (error) {
            	vm.error = true;
            	vm.errorMessage = error;
            });
        };
    };

    angular.module('movieApp').controller('addMovieController', ['$state','movieDal','mediaDal',AddMovieController]);
}());