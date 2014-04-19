/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wandera.wanderapp.resources.views;

import com.wandera.wanderapp.core.Notification;
import io.dropwizard.views.View;

/**
 *
 * @author jmt
 */
public class NotificationView extends View {

    private final Notification notification;

    public NotificationView(Notification notification) {
        super("notification.mustache");
        this.notification = notification;
    }

    public Notification getNotification() {
        return notification;
    }

    
    
}
