angular.module('taks')
.controller('TaskController', function($scope, tasksResource, 
	$routeParams, statusResource,saveTask) {

	$scope.task = {};
	$scope.statusList = [];
	$scope.mensagem = '';

	statusResource.query(function(statusList){
		$scope.statusList = statusList;
	}, function(erro){
		console.log(erro);
	});


	if($routeParams.taskId != null){
		tasksResource.get({taskId: $routeParams.taskId},function(task){
			$scope.task = task;
			for (var i = 0; i < $scope.statusList.length; i++) {
				if( $scope.task.idStatus.id == $scope.statusList[i].id){
					$scope.task.idStatus = $scope.statusList[i];
				}
			}
		}, function(erro){
			console.log(erro);
		});
	}
	

	$scope.submeter = function() {

		if ($scope.formulario.$valid) {
			saveTask.save($scope.task)
			.then(function(dados) {
				$scope.mensagem = dados.mensagem;
				if (dados.inclusao) {
					$scope.task = {};
				}
			})
			.catch(function(erro) {
				$scope.mensagem = erro.mensagem;
			});
		}
	};
});