(function () {

    var GetMediaController = function (mediaDal) {
        var vm = this;

        vm.getAllMedia = function getAllMedia() {
            mediaDal.getAllMedia().then(function (results) {
                vm.movies = results;
            }, function (error) {
                vm.error = true;
                vm.errorMessage = error;
            });
        };
        vm.getAllMedia();

        vm.getMedia = function getMedia() {
            mediaDal.getMedia().then(function (results) {
                vm.movies = results;
            }, function (error) {
                vm.error = true;
                vm.errorMessage = error;
            });
        };
    };

    angular.module('movieApp').controller('getMediaController', ['mediaDal', GetMediaController]);
}());
