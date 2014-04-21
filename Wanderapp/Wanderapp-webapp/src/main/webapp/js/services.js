'use strict';

/* Services */

var wanderAppServices = angular.module('wanderAppServices', ['ngResource']);

wanderAppServices.factory('NotificationsResource', ['$resource',
    function($resource) {
        return $resource('/api/notifications/:notificationId', {}, {
            query: {method: 'GET', params: {notificationId: ''}, isArray: true}
        });
    }]);

wanderAppServices.factory('UserNotificationsResource', function($resource) {
    return $resource('/api/notifications/user/:userId', {}, {});
});

wanderAppServices.factory('UsersResource', function($resource) {
    return $resource('/api/users', {}, {
    })
});

//wanderAppServices.factory('NotificationMarkReadResource', function($resource) {
//    return $resource('/api/notifications/read/ ', {}, {
//    })
//});
wanderAppServices.factory('NotificationMarkReadResource', function($resource) {

    return $resource('/api/notifications/read/:notificationId ', {}, {
        update: {method: 'PUT', params: {notificationId: '@notificationId'}},
    })
    
});

wanderAppServices.factory('NotificationDeleteResource', function($resource) {
    return $resource('/api/notifications/delete/:notificationId', {}, {
    })
});


