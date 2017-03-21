var movieApp = angular.module('movieApp',['ui.router'])
    .config(function ($sceDelegateProvider){
        $sceDelegateProvider.resourceUrlWhitelist([
            'self',
            '*://www.youtube.com/**'
        ]);
    });