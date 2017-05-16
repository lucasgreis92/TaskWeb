angular.module('taks')
.controller('HomeController', function($scope, tasksResource,statusResource,taskStatusResource) {
	
	$scope.tasks = [];
	$scope.filtro = '';
	$scope.filtroStatus = '';
	$scope.mensagem = '';
	$scope.statusList = [];


	statusResource.query(function(statusList){
		$scope.statusList = statusList;
	}, function(erro){
		console.log(erro);
	});
	$scope.statusChange = function(){
		if($scope.filtroStatus != null && $scope.filtroStatus != ''){
			taskStatusResource.query({statusId: $scope.filtroStatus.id},function(tasks){
				$scope.tasks = tasks;
				console.log(tasks);
			}, function(erro){
				console.log(erro);
			});
		}else{
			tasksResource.query(function(tasks){
				$scope.tasks = tasks;
				console.log(tasks);
			}, function(erro){
				console.log(erro);
			});
		}
	}
	$scope.statusChange();
	$scope.remover = function(task) {

		tasksResource.delete({taskId: task.id}, function() {
			var indiceDaTask = $scope.tasks.indexOf(task);
			$scope.tasks.splice(indiceDaTask, 1);
			$scope.mensagem = 'Task ' + task.titulo + ' successfully removed!';
		}, function(erro) {
			console.log(erro);
			$scope.mensagem = 'Task could not be deleted ' + task.titulo;
		});
	};

});