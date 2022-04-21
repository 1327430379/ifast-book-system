'use strict';
(function()
{
	var stdRouteApp = angular.module('std.route.app');

	stdRouteApp.config(['$stateProvider','$urlRouterProvider', config]);

	function config($stateProvider, $urlRouterProvider)
	{
		$urlRouterProvider.otherwise('/book');
		$stateProvider.state('book',
			{
				url: '/book',
				views:
					{
						'header': { templateUrl: _applicationPath + '/template/header.htm' },
						'footer': { templateUrl: _applicationPath + '/template/footer.htm' },
						'content' :
							{
								templateUrl: _applicationPath + '/book/book.html',
							}
					},
			});
	}



})();
