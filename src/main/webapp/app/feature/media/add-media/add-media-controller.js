(function() {

	var AddMediaController = function($state, mediaDal) {
		var vm = this;

		vm.addMedia = function(mediaToAdd) {
			console.log("This is the value of media to add ");
			console.log(mediaToAdd);

			var mediaToJson = JSON.stringify(mediaToAdd);
			console.log(mediaToJson);

			mediaDal.saveMedia(mediaToAdd).then(function(results) {
				vm.mediaAddMessage = results;
				$state.go("getmedia");
			}, function(error) {
				vm.error = true;
				vm.errorMessage = error;
			});
		};
	};

	angular.module('mediaApp').controller('addMediaController',
			[ '$state', 'mediaDal', AddMediaController ]);
}());