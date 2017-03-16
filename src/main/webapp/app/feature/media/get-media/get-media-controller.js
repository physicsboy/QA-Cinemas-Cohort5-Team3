(function() {

	var GetMediaController = function(mediaDal) {
		var vm = this;

		vm.getAllMedia = function getAllMedia(filmId, type) {
			mediaDal.getAllMedia(filmId, type).then(function(results) {
				vm.media = results;
			}, function(error) {
				vm.error = true;
				vm.errorMessage = error;
			});
		};

		vm.getSingleMedia = function getMedia(filmId, type) {
			mediaDal.getSingleMedia(filmId, type).then(function(results) {
				vm.media = results;
				console.log(vm.media);
			}, function(error) {
				vm.error = true;
				vm.errorMessage = error;
			});
		};

	};

	angular.module('movieApp').controller('getMediaController',
			[ 'mediaDal', GetMediaController ]);
}());
