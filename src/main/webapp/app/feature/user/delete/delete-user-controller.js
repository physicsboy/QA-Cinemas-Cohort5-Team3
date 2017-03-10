/**
 * @author Matt Gordon
 */

(function() {
	var DeleteUserController = function($state, userDal) {
		var vm = this;

		vm.deleteUser = function(userToDelete) {
			console.log("This is the value of user to Update..." + userToDelete);
			console.log(userToDelete);
			var userToJson = JSON.stringify(userToDelete);
			console.log(userToJson);
			userDal.deleteUser(userToDelete).then(function(results) {
				vm.userDeleteMessage = results;
				$state.go('getuser');
			}, function(error) {
				vm.error = true;
				vm.errorMessage = error;
			});
		};
	};
	angular.module('movieApp').controller('deleteUserController', [ '$state', 'userDal', DeleteUserController ]);
}());