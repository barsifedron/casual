/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wandera.wanderapp.resources.views;

import com.wandera.wanderapp.core.Notification;
import io.dropwizard.views.View;
import java.util.List;

/**
 *
 * @author jmt
 */
public class NotificationsView extends View {

    private final List<Notification> notifications;
    

    public NotificationsView(List<Notification> notifications) {
        super("notifications.mustache");
        this.notifications = notifications;
    }

    public List<Notification> getNotifications() {
        return notifications;
    }

}
