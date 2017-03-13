            "use strict";

            (function() {

            angular
            .module('movieApp')
            .config(
            function($stateProvider, $urlRouterProvider) {


            $urlRouterProvider.otherwise("/dashboard");

            $stateProvider.state("home",{
            url : "/index.html",
            	templateUrl : "index.html"
            }).state("getbooking",{url : "/getbooking",
            	templateUrl : "app/feature/booking/get/get-booking.html"
            }).state("addbooking",{url : "/addbooking",
            	templateUrl : "app/feature/booking/add/add-booking.html"
            }).state("updatebooking",{url : "/updatebooking",
            	templateUrl : "app/feature/booking/update/update-booking.html"
            }).state("deletebooking",{url : "/deletebooking",
                templateUrl : "app/feature/booking/delete/delete-booking.html"
            }).state("getmovie",{url : "/getmovie",
            	templateUrl : "app/feature/movie/get/get-movie.html"
            }).state("addmovie",{url : "/addmovie",
            	templateUrl : "app/feature/movie/add/add-movie.html"
            }).state("updatemovie",{url : "/updatemovie",
            	templateUrl : "app/feature/movie/update/update-movie.html"
            }).state("deletemovie",{url : "/deletemovie",
                templateUrl : "app/feature/movie/delete/delete-movie.html"
            }).state("createscreen",{url : "/createscreen",
				templateUrl : "app/feature/screen/create-screen/create-screen.html"
			}).state("getscreen",{url : "/getscreen",
				templateUrl : "app/feature/screen/get-screen/get-screen.html"
			}).state("getscreens",{url : "/getscreens",
				templateUrl : "app/feature/screen/get-all-screens/get-all-screens.html"
			}).state("updatescreen",{url : "/updatescreen",
				templateUrl : "app/feature/screen/update-screen/update-screen.html"
			}).state("deletescreen",{url : "/deletescreen",
				templateUrl : "app/feature/screen/delete-screen/delete-showing.html"
			}).state("getticket",{url : "/getticket",
            	templateUrl : "app/feature/ticket/get/get.html"
            }).state("addticket",{url : "/addticket",
            	templateUrl : "app/feature/ticket/add/add-ticket.html"
            }).state("updateticket",{url : "/updateticket",
            	templateUrl : "app/feature/ticket/update/update.html"
            }).state("deleteticket",{url : "/deleteticket",
                templateUrl : "app/feature/ticket/delete/delete.html"
            }).state("getuser",{url : "/getuser",
            	templateUrl : "app/feature/user/get/get-user.html"
            }).state("adduser",{url : "/adduser",
            	templateUrl : "app/feature/user/add/add-user.html"
            }).state("updateuser",{url : "/updateuser",
            	templateUrl : "app/feature/user/update/update-user.html"
            }).state("deleteuser",{url : "/deleteuser",
                templateUrl : "app/feature/user/delete/delete-user.html"
            }).state("getshowing",{url : "/getshowing",
            	templateUrl : "app/feature/showing/get/get-showing.html"
            }).state("addshowing",{url : "/addshowing",
            	templateUrl : "app/feature/showing/add/add-showing.html"
            }).state("updateshowing",{url : "/updateshowing",
            	templateUrl : "app/feature/showing/update/update-showing.html"
            }).state("deleteshowing",{url : "/deleteshowing",
                templateUrl : "app/feature/showing/delete/delete-showing.html"
            }).state("getspecificmovie",{url : "/getspecificmovie",
                templateUrl : "app/feature/movie/get/specific-movie/get-specific-movie.html"
            })
       });
 }());

