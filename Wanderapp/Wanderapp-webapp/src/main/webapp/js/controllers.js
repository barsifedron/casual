'use strict';

/* Controllers */

var wandarAppControllers = angular.module('wandarAppControllers', []);




wandarAppControllers.controller('NotificationListCtrl', ['$scope', 'NotificationsResource', function($scope,    NotificationsResource) {
$scope.notifications = NotificationsResource.query();
$scope.orderProp = 'eventTimestamp';
}]);




wandarAppControllers.controller('NotificationDetailCtrl', ['$scope', '$routeParams', , 'NotificationsResource', function($scope, $routeParams, NotificationsResource) {
        $scope.notification = NotificationsResource.get({notificationId: $routeParams.notificationId}, function(notification) {
        });
    }]);
//    
//
//
//
//

//wandarAppControllers.controller('NotificationListCtrl', ['$scope', '$http',
//    function($scope, $http) {
//
//
//        $http.get('notifications/notifications.json').success(function(data) {
//            $scope.notifications = data;
//        });
//
//        $scope.orderProp = 'eventTimestamp';
//
//    }]);


wandarAppControllers.controller('NotificationDetailCtrl', ['$scope', '$routeParams', '$http',
    function($scope, $routeParams, $http) {
        $http.get('notifications/' + $routeParams.notificationId + '.json').success(function(data) {
            $scope.notification = data;
        });
    }]);




//phonecatControllers.controller('PhoneDetailCtrl', ['$scope', '$routeParams', 'Phone', function($scope, $routeParams, Phone) {
//        $scope.phone = Phone.get({phoneId: $routeParams.phoneId}, function(phone) {
//            $scope.mainImageUrl = phone.images[0];
//        });
//
//        $scope.setImage = function(imageUrl) {
//            $scope.mainImageUrl = imageUrl;
//        }
//    }]);