/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wandera.wanderapp.resources;

import com.wandera.wanderapp.core.Notification;
import com.wandera.wanderapp.dao.NotificationDAO;
import io.dropwizard.hibernate.UnitOfWork;
import java.util.List;
import java.util.UUID;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author jmt
 */
@Path("/notifications/user/{userUuid}")
@Produces(MediaType.APPLICATION_JSON)
public class UserNotificationresource {

    private final NotificationDAO notificationDAO;

    public UserNotificationresource(NotificationDAO notificationDAO) {
        this.notificationDAO = notificationDAO;
    }

    @GET
    @UnitOfWork
    public List<Notification> getNotification(@PathParam("userUuid") UUID userUuid) {
        return notificationDAO.findByUserUuid(userUuid);
    }



}
