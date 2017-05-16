angular.module('taskStatusService', ['ngResource'])
	.factory('taskStatusResource', function($resource) {

		return $resource('/rs/taskstatus/:statusId', null, {
			'update' : { 
				method: 'PUT'
			}
		});
	})