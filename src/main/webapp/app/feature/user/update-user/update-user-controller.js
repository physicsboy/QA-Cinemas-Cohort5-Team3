/**
 * @author Matt Gordon
 */

(function() {
	var UpdateUserController = function($state, userDal) {
		var vm = this;

		vm.updateUser = function(userToUpdate) {
			console.log("This is the value of user to Update..." + userToUpdate);
			console.log(userToUpdate);
			var userToJson = JSON.stringify(userToUpdate);
			console.log(userToJson);
			userDal.updateUser(userToUpdate).then(function(results) {
				vm.userUpdateMessage = results;
				$state.go('getuser');
			}, function(error) {
				vm.error = true;
				vm.errorMessage = error;
			});
		};
	};
	angular.module('movieApp').controller('updateUserController', [ '$state', 'userDal', UpdateUserController ]);
}());