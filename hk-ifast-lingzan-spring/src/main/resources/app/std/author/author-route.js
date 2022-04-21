'use strict';
(function()
{
	var stdRouteApp = angular.module('std.route.app');

	stdRouteApp.config(['$stateProvider','$urlRouterProvider', config]);

	function config($stateProvider, $urlRouterProvider)
	{
		$urlRouterProvider.otherwise('/author');
		$stateProvider.state('author',
			{
				url: '/author',
				views:
					{
						'header': { templateUrl: _applicationPath + '/template/header.htm' },
						'footer': { templateUrl: _applicationPath + '/template/footer.htm' },
						'content' :
							{
								templateUrl: _applicationPath + '/author/author.html',
							}
					},
			});
	}



})();
