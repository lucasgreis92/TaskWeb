angular.module('tasksService', ['ngResource'])
	.factory('tasksResource', function($resource) {

		return $resource('/rs/tasks/:taskId', null, {
			'update' : { 
				method: 'PUT'
			}
		});
	})
	.factory("saveTask", function(tasksResource, $q, $rootScope) {
		
		var evento = 'taskCadastrada';

		var service = {};

		service.save = function(task) {
			return $q(function(resolve, reject) {
				console.log(task.id);
				if(task.id) {
					tasksResource.save(task, function() {

						$rootScope.$broadcast(evento);
						resolve({
							mensagem: 'Task ' + task.titulo + ' updated successfully.',
							inclusao: false
						});
					}, function(erro) {
						console.log(erro);
						reject({
							mensagem: 'Unable to save task ' + task.titulo + '.'
						});
					});

				} else {
					tasksResource.save(task, function() {
						$rootScope.$broadcast(evento);
						resolve({
							mensagem: 'Task ' + task.titulo + ' successfully included.',
							inclusao: true
						});
					}, function(erro) {
						console.log(erro);
						reject({
							mensagem: 'Unable to save task ' + task.titulo + '.'
						});
					});
				}
			});
		};
		return service;
    });