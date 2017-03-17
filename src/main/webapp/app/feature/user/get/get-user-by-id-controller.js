(function() {

	var GetUserByIdController = function(userDal, $stateParams) {
		var vm = this;
        var param = $stateParams;

		vm.getUserById = function getUserById() {
			console.log("This is the id " + $stateParams.userId);
			userDal.getUserById($stateParams.userId).then(function(results) {
				vm.users = results;
				console.log("This is the result: ");
				console.log( results);
			}, function(error) {
				vm.error = true;
				vm.errorMessage = error;
			});
		};
		//vm.getUserById();
	};
	angular.module('movieApp').controller('getUserByIdController',
			[ 'userDal', '$stateParams', GetUserByIdController ]);
}());