'use strict';

/* App Module */

var wandarApp = angular.module('wandarApp', [
    'ngRoute',
    'wandarAppControllers', 'wanderAppFilters', 'wanderAppServices'
]);

wandarApp.config(['$routeProvider',
    function($routeProvider) {
        $routeProvider.
                when('/users', {
                    templateUrl: 'partials/users-list.html',
                    controller: 'UsersCtrl'
                }).
                when('/notifications', {
                    templateUrl: 'partials/notification-list.html',
                    controller: 'NotificationListCtrl'
                }).
                when('/notifications/user/:userId', {
                    templateUrl: 'partials/user-notifications-list.html',
                    controller: 'UserNotificationsCtrl'
                }).
                when('/notifications/:notificationId', {
                    templateUrl: 'partials/notification-detail.html',
                    controller: 'NotificationDetailCtrl'
                }).
                otherwise({
                    redirectTo: '/users'
                });
    }]);