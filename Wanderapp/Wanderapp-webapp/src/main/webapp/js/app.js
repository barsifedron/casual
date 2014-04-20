'use strict';

/* App Module */

var wandarApp = angular.module('wandarApp', [
  'ngRoute',
  'wandarAppControllers','wanderAppServices'
]);

wandarApp.config(['$routeProvider',
  function($routeProvider) {
    $routeProvider.
      when('/notifications', {
        templateUrl: 'partials/notification-list.html',
        controller: 'NotificationListCtrl'
      }).
      when('/notifications/:notificationId', {
        templateUrl: 'partials/notification-detail.html',
        controller: 'NotificationDetailCtrl'
      }).
      otherwise({
        redirectTo: '/notifications'
      });
  }]);