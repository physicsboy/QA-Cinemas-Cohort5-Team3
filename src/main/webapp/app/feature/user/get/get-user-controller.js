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
        
        vm.getUserByID = function(id){
            userDal.getUserByID(id).then(function (results) {
                vm.users = results;
            }, function (error) {
                vm.error = true;
                vm.errorMessage = error;
            });
        };
        
    };
    angular.module('movieApp').controller('getUserController', ['userDal', GetUserController]);
}());