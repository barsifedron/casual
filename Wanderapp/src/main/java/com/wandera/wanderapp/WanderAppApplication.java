/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wandera.wanderapp;

import com.wandera.wanderapp.core.Notification;
import com.wandera.wanderapp.dao.NotificationDAO;
import com.wandera.wanderapp.resources.NotificationsResource;
import com.wandera.wanderapp.resources.UserNotificationresource;
import io.dropwizard.Application;
import io.dropwizard.db.DataSourceFactory;
import io.dropwizard.hibernate.HibernateBundle;
import io.dropwizard.migrations.MigrationsBundle;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import io.dropwizard.views.ViewBundle;

/**
 *
 * @author jmt
 */
public class WanderAppApplication extends Application<WanderAppConfiguration> {

    public static void main(String[] args) throws Exception {
        new WanderAppApplication().run(args);
    }

    private final HibernateBundle<WanderAppConfiguration> hibernateBundle
            = new HibernateBundle<WanderAppConfiguration>(Notification.class) {
                @Override
                public DataSourceFactory getDataSourceFactory(WanderAppConfiguration configuration) {
                    return configuration.getDataSourceFactory();
                }
            };

    @Override
    public void initialize(Bootstrap<WanderAppConfiguration> bootstrap) {

        bootstrap.addBundle(new MigrationsBundle<WanderAppConfiguration>() {
            @Override
            public DataSourceFactory getDataSourceFactory(WanderAppConfiguration configuration) {
                return configuration.getDataSourceFactory();
            }
        });
        bootstrap.addBundle(hibernateBundle);
        bootstrap.addBundle(new ViewBundle());
    }

    @Override
    public void run(WanderAppConfiguration wanderAppConfiguration, Environment environment) throws ClassNotFoundException {

        final NotificationDAO notificationDAO = new NotificationDAO(hibernateBundle.getSessionFactory());
        environment.jersey().register(new NotificationsResource(notificationDAO));
        environment.jersey().register(new UserNotificationresource(notificationDAO));

    }

}
