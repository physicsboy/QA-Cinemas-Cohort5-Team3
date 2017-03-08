(function() {

    var GetUserController =  function(userDal)
    {
        var vm = this;
        vm.test = "test";

        function init() {
            userDal.getUsers().then(function (results) {
                vm.users  = results;
            }, function (error) {
                vm.error = true;
                vm.errorMessage = error;
            });
        }
        init();
    };
    angular.module('cinema').controller('getUserController', ['userDal', GetUserController]);
}());