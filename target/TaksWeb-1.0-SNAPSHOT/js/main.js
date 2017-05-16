angular.module('taks', ['minhasDiretivas','ngAnimate', 'ngRoute', 
	'ngResource', 'tasksService','statusService','taskStatusService'])
	.config(function($routeProvider, $locationProvider) {

		$locationProvider.html5Mode(true);

		$routeProvider.when('/home', {
			templateUrl: 'partials/home.html',
			controller: 'HomeController'
		});

		$routeProvider.when('/task/new', {
			templateUrl: 'partials/task.html',
			controller: 'TaskController'
		});

		$routeProvider.when('/task/edit/:taskId', {
			templateUrl: 'partials/task.html',
			controller: 'TaskController'

		});

		$routeProvider.otherwise({redirectTo: '/home'});

	});