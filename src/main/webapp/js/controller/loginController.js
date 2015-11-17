layout.controller("loginControl",["$scope","$resource", function($scope, $resource) {
	$scope.usuario='';
	$scope.senha='';
	
	  
	  $scope.saveLogin = function() {
		  if($scope.usuario!='' && $scope.senha!=''){
			  var _resource = $resource("/projectDoc/rest/api/login/novo", {}, {
				  create: {method: "POST"}
			  });
			  _resource.create({login:$scope.usuario,senha:$scope.senha});
		  }
	  };
	
}]);