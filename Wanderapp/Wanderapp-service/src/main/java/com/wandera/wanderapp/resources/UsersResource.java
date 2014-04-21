/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wandera.wanderapp.resources;

import com.wandera.wanderapp.resources.utils.UserUuid;
import com.wandera.wanderapp.dao.NotificationDAO;
import io.dropwizard.hibernate.UnitOfWork;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author jmt
 */
@Path("/users/")
@Produces(MediaType.APPLICATION_JSON)
public class UsersResource {

    private final NotificationDAO notificationDAO;

    public UsersResource(NotificationDAO notificationDAO) {
        this.notificationDAO = notificationDAO;
    }

    @GET
    @UnitOfWork
    public List<UserUuid> getAll() {

        List<UserUuid> list = new ArrayList<UserUuid>();
        for (UUID uuid : notificationDAO.getUserUuids()) {
            list.add(new UserUuid(uuid));
        }
        return list;
    }

}
