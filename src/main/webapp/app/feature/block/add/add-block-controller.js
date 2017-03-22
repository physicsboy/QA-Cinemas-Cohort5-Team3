/**
 * @author Mark lester
 */

(function() {

    var AddBlockController =  function($state, blockDal) {
        var vm = this;

        vm.addBlock = function(blockToAdd) {
        	
        	
            console.log("This is the value of screen to add " + blockToAdd);
            console.log(screenToCreate);
            var blockToJson = JSON.stringify(blockToAdd);
            console.log(blockToJson);
            
            
            blockDal.addBlock(blockToAdd).then(
            		function (results) {
		                vm.blockAddMessage  = results;
		                $state.go('createscreen');
		                console.log(" CreateScreenController saving ");
		            }, 
		            function (error) {
		                vm.error = true;
		                vm.errorMessage = error;
		                console.log("AddBlockController throwing error");
		            }
		     );
        };
    };

    angular.module('movieApp').controller('addblockController', ['$state','blockDal',AddBlockController]);
}());