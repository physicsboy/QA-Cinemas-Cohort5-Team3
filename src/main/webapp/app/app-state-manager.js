"use strict";

(function() {

angular
.module('movieApp')
.config(
function($stateProvider, $urlRouterProvider) {

	$urlRouterProvider.otherwise("/dashboard");

	$stateProvider.state("dashboard",{
	url : "/dashboard",
		templateUrl : "app/feature/dashboard/dashboard-partial.html"
		}).state("getmovie",{url : "/getmovie",
		templateUrl : "app/feature/movie/get-movie/get-movie.html"
		}).state("getbooking",{url : "/getbooking",
		templateUrl : "app/feature/booking/get/get-booking.html"
		}).state("addbooking",{url : "/addbooking",
		templateUrl : "app/feature/booking/add/add-booking.html"
		}).state("getscreen",{url : "/getscreen",
		templateUrl : "app/feature/screen/get-screen/get-screen.html"
		}).state("getticket",{url : "/getticket",
		templateUrl : "app/feature/ticket/get-ticket/get-ticket.html"
		}).state("adduser",{url : "/adduser",
		templateUrl : "app/feature/user/add-user/add-u.html"
		}).state("getuser",{url : "/getuser",
		templateUrl : "app/feature/user/get-user/add-u.html"
		}).state("getshowing",{url : "/getshowing",
		templateUrl : "app/feature/showing/get-showing/get-showing.html"
		}).state("getscreen",{url : "/getscreen",
		templateUrl : "app/feature/showing/get-showing/get-showing.html"
		}).state("getscreens",{url : "/getscreens",
		templateUrl : "app/feature/showing/get-showing/get-showing.html"
		}).state("createscreen",{url : "/createscreen",
		templateUrl : "app/feature/showing/get-showing/get-showing.html"
		}).state("updatescreen",{url : "/updatescreen",
		templateUrl : "app/feature/showing/get-showing/get-showing.html"
		}).state("deletescreen",{url : "/deletescreen",
		templateUrl : "app/feature/showing/get-showing/get-showing.html"
		})
		
	});
}());