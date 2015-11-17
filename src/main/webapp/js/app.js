//Inicializando o aplicativo
var layout = angular.module("layout", ["ngRoute","ngResource","ui.bootstrap"]);

layout.config(['$routeProvider',function($routeProvider){
	$routeProvider.when("/", {
		templateUrl: "./pages/index.html",
		controller : "loginControl"
	});
	$routeProvider.when("/login", {
		templateUrl: "./pages/login/login.html",
		controller : "loginControl"
	});
}]);

angular.module('layout').config(['$controllerProvider', function($controllerProvider) {
    $controllerProvider.allowGlobals();
 }]);

//Configurando requisições ajax
layout.config(["$httpProvider",  function($httpProvider){
	
	//Adicionando interceptador para loading
	$httpProvider.interceptors.push('loadingHttpInterceptor');
}]);

//Interceptor http (Loading
layout.factory('loadingHttpInterceptor', function ($q, $window) {
	return{
		//Momento da requisição
		request: function(config){
			 $("#loading").show();
			 
			return config;
		},
		
		//Momento da resposta
		response:   function(config){
			$("#loading").hide();
			return config;
		},
		
		//Tratamento de erro
		responseError: function (response) {
			$("#loading").hide();
            return $q.reject(response);
        }
	}
});
