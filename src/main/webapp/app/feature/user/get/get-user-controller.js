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


        vm.validateUser = function validateUser(userName, password){
            
        };
    };
    angular.module('movieApp').controller('getUserController', ['userDal', GetUserController]);
}());