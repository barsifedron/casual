/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wandera.wanderapp.dao;

import com.wandera.wanderapp.core.Notification;
import io.dropwizard.hibernate.AbstractDAO;
import com.google.common.base.Optional;
import java.util.List;
import java.util.UUID;
import org.hibernate.SessionFactory;

/**
 *
 * @author jmt
 */
public class NotificationDAO extends AbstractDAO<Notification> {

    public NotificationDAO(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

    public List<Notification> findAll() {
        return list(namedQuery("com.wandera.wanderapp.core.Notification.findAll"));
    }

    public List<Notification> findByUserUuid(UUID userUUid) {
        return list(namedQuery("com.wandera.wanderapp.core.Notification.findByUserUuid").
                setParameter("userGuid", userUUid));
    }

    public Optional<Notification> findByNotificationUuid(UUID notificationUuid) {
        return Optional.fromNullable(get(notificationUuid));
    }

    public Notification create(Notification notification) {

        return persist(notification);
    }

    public void deleteNotification(UUID notificationUuid) {
        Optional<Notification> foundNotification = findByNotificationUuid(notificationUuid);
        if (foundNotification.isPresent()) {
            currentSession().delete(foundNotification.get());
        }
    }

    public void markNotificationRead(UUID notificationUuid, boolean read) {
        Optional<Notification> findByNotificationUuid = findByNotificationUuid(notificationUuid);
        if (findByNotificationUuid.isPresent() && findByNotificationUuid.get().isReadByUser() != read) {
            findByNotificationUuid.get().setReadByUser(read);
            persist(findByNotificationUuid.get());
        }
    }

}
