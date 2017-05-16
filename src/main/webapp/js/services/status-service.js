angular.module('statusService', ['ngResource'])
	.factory('statusResource', function($resource) {

		return $resource('/rs/status/:statusId', null, {
			'update' : { 
				method: 'PUT'
			}
		});
	})