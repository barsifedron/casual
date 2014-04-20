'use strict';

/* Services */

var wanderAppServices = angular.module('wanderAppServices', ['ngResource']);

wanderAppServices.factory('NotificationsResource', ['$resource',
    function($resource) {
        return $resource('/api/notifications/:notificationId', {}, {
            query: {method: 'GET', params: {notificationId: ''}, isArray: true}

//        return $resource('/notifications/:notificationId.json', {}, {
//            query: {method: 'GET', params: {notificationId: 'notifications'}, isArray: true}
            
        });
    }]);




//wanderAppServices.factory('NotificationsResource', function($resource) {
//    return $resource('/api/notifications', {}, {});
//});
//wanderAppServices.factory('NotificationsResource', function($resource) {
//    return $resource('/notifications/:notificationId', {}, {});
//});