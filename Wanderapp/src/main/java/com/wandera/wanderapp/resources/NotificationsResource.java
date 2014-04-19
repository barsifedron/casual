/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wandera.wanderapp.resources;

import com.wandera.wanderapp.core.Notification;
import com.wandera.wanderapp.dao.NotificationDAO;
import com.wandera.wanderapp.resources.views.IndexView;
import io.dropwizard.hibernate.UnitOfWork;
import java.util.List;
import java.util.UUID;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author jmt
 */
@Path("/notifications")
@Produces(MediaType.APPLICATION_JSON)
public class NotificationsResource {

    private final NotificationDAO notificationDAO;

    public NotificationsResource(NotificationDAO notificationDAO) {
        this.notificationDAO = notificationDAO;
    }

    @POST
    @UnitOfWork
    public Notification createNotification(Notification person) {
        return notificationDAO.create(person);
    }

    @GET
    @UnitOfWork
    public List<Notification> listNotifications() {
        return notificationDAO.findAll();
    }

    @GET
    @UnitOfWork
    @Path("/view")
    @Produces(MediaType.TEXT_HTML)
    public IndexView index() {
        return new IndexView();
    }

    @GET
    @UnitOfWork
    @Path("/{notificationUuid}")
    public Notification getNotification(@PathParam("notificationUuid") UUID notificationUuid) {
        return notificationDAO.findByNotificationUuid(notificationUuid).get();
    }

    @POST
    @UnitOfWork
    @Path("/delete/{notificationUuid}")
    public void deleteNotification(@PathParam("notificationUuid") UUID notificationUuid) {
        notificationDAO.deleteNotification(notificationUuid);
    }

    @POST
    @UnitOfWork
    @Path("/read/{notificationUuid}")
    public void markNotificationRead(@PathParam("notificationUuid") UUID notificationUuid, @QueryParam("read") boolean read) {
        notificationDAO.markNotificationRead(notificationUuid, read);
    }

}
