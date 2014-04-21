'use strict';

/* Controllers */

var wandarAppControllers = angular.module('wandarAppControllers', []);




wandarAppControllers.controller('UserNotificationListCtrl', ['$scope', '$routeParams',
    'NotificationMarkReadResource', 'NotificationDeleteResource', 'UserNotificationsResource', function($scope, $routeParams, NotificationMarkReadResource, NotificationDeleteResource, UserNotificationsResource) {

        $scope.notifications = UserNotificationsResource.get({userId: $routeParams.userId});
        $scope.orderProp = 'eventTimestamp';


        $scope.requestNotification = function(notification) {

            $scope.notifications = UserNotificationsResource.get({notificationId: notification.notificationGuid});


        }

        $scope.markNotificationRead = function(notification) {


            notification.readByUser = "true";
            NotificationMarkReadResource.save(notification).$promise.then(function() {
                $scope.notifications = UserNotificationsResource.query();
            });


        }


        $scope.deleteNotification = function(notification) {


            NotificationDeleteResource.delete({notificationId: notification.notificationGuid}).$promise.then(function() {
                $scope.notifications = UserNotificationsResource.query();
            });


        }

    }]);


wandarAppControllers.controller('NotificationListCtrl', ['$scope', 'NotificationMarkReadResource',
    'NotificationDeleteResource', 'NotificationsResource', function($scope, NotificationMarkReadResource, NotificationDeleteResource, NotificationsResource) {

        $scope.notifications = NotificationsResource.query();
        $scope.orderProp = 'eventTimestamp';


        $scope.requestNotification = function(notification) {

            $scope.notification = NotificationsResource.get({notificationId: notification.notificationGuid});


        }

        $scope.markNotificationRead = function(notification) {


            notification.readByUser = "true";
            NotificationMarkReadResource.save(notification).$promise.then(function() {
                $scope.notifications = NotificationsResource.query();
            });


        }


        $scope.deleteNotification = function(notification) {


            NotificationDeleteResource.delete({notificationId: notification.notificationGuid}).$promise.then(function() {
                $scope.notifications = NotificationsResource.query();
            });


        }
    }]);


wandarAppControllers.controller('UserNotificationsCtrl', ['$scope', '$routeParams', 'NotificationMarkReadResource',
    'NotificationDeleteResource', 'UserNotificationsResource', function($scope, $routeParams, NotificationMarkReadResource, NotificationDeleteResource, UserNotificationsResource) {
        $scope.mynotifications = UserNotificationsResource.query({userId: $routeParams.userId})




        $scope.markNotificationRead = function(notification) {


            notification.readByUser = "true";
            NotificationMarkReadResource.save(notification).$promise.then(function() {
                $scope.mynotifications = UserNotificationsResource.query({userId: $routeParams.userId})
            });


        }


        $scope.deleteNotification = function(notification) {


            NotificationDeleteResource.delete({notificationId: notification.notificationGuid}).$promise.then(function() {
                $scope.mynotifications = UserNotificationsResource.query({userId: $routeParams.userId})
            });


        }
    }]);

wandarAppControllers.controller('UsersCtrl', ['$scope', 'UsersResource', function($scope, UsersResource) {
        $scope.users = UsersResource.query();
    }]);

wandarAppControllers.controller('NotificationDetailCtrl', ['$scope', '$routeParams', 'NotificationsResource',
    function($scope, $routeParams, NotificationsResource) {
        $scope.notification = NotificationsResource.get({notificationId: $routeParams.notificationId});
    }]);

