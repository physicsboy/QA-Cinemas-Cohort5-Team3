(function () {

    var GetMediaController = function (mediaDal) {
        var vm = this;

        vm.getAllMedia = function getAllMedia(filmId, type) {
            mediaDal.getAllMedia(filmId, type).then(function (results) {
                vm.movies = results;
            }, function (error) {
                vm.error = true;
                vm.errorMessage = error;
            });
        };
        vm.getAllMedia();

        vm.getMedia = function getMedia(filmId, type) {
            mediaDal.getMedia(filmId, type).then(function (results) {
                vm.movies = results;
            }, function (error) {
                vm.error = true;
                vm.errorMessage = error;
            });
        };
    };

    angular.module('movieApp').controller('getMediaController', ['mediaDal', GetMediaController]);
}());
