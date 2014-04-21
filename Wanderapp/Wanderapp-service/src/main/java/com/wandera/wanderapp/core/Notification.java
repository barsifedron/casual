/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wandera.wanderapp.core;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.math.BigInteger;
import java.util.UUID;
import javax.persistence.*;

/**
 *
 * @author jmt
 */
@Entity
@Table(name = "notifications")
@NamedQueries({
    @NamedQuery(
            name = "com.wandera.wanderapp.core.Notification.findAll",
            query = "SELECT n FROM Notification n ORDER BY eventType , eventTimestamp DESC"
    ),
    @NamedQuery(
            name = "com.wandera.wanderapp.core.Notification.findByUserUuid",
            query = "SELECT n FROM Notification n WHERE n.userGuid = :userGuid ORDER BY eventType , eventTimestamp DESC"
    ),
    @NamedQuery(
            name = "com.wandera.wanderapp.core.Notification.findByNotificationUuid",
            query = "SELECT n FROM Notification n WHERE n.notificationGuid = :notificationGuid"
    )
})
public class Notification {

    @Id
    @Column(name = "notificationGuid", unique = true, nullable = false)
    private UUID notificationGuid = UUID.randomUUID();
    //
    @Column(name = "deviceGuid", nullable = false)
    private UUID deviceGuid;
    @JsonProperty
    @Column(name = "userGuid", nullable = false)
    private UUID userGuid;
    @Column(name = "eventType", nullable = false)
    private String eventType;
    @Column(name = "eventSubtype")
    private String eventSubtype;
    @Column(name = "geofenceLat")
    private double geofenceLat;
    @Column(name = "geofenceLon")
    private double geofenceLon;
    @Column(name = "geofenceRadiusMetres")
    private int geofenceRadiusMetres;
    @Column(name = "title", nullable = false)
    private String title;
    @Column(name = "content", nullable = false)
    private String content;
    @Column(name = "eventTimestamp", nullable = false)
    private BigInteger eventTimestamp;
    @Column(name = "sentTimestamp", nullable = false)
    private BigInteger sentTimestamp;
    @Column(name = "readByUser", nullable = false)
    private Boolean readByUser;

    public UUID getNotificationGuid() {
        return notificationGuid;
    }

    public UUID getDeviceGuid() {
        return deviceGuid;
    }

    public UUID getUserGuid() {
        return userGuid;
    }

    public String getEventType() {
        return eventType;
    }

    public String getEventSubtype() {
        return eventSubtype;
    }

    public double getGeofenceLat() {
        return geofenceLat;
    }

    public double getGeofenceLon() {
        return geofenceLon;
    }

    public int getGeofenceRadiusMetres() {
        return geofenceRadiusMetres;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public BigInteger getEventTimestamp() {
        return eventTimestamp;
    }

    public BigInteger getSentTimestamp() {
        return sentTimestamp;
    }

    public Boolean isReadByUser() {
        return readByUser;
    }

    public void setNotificationGuid(UUID notificationGuid) {
        this.notificationGuid = notificationGuid;
    }

    public void setDeviceGuid(UUID deviceGuid) {
        this.deviceGuid = deviceGuid;
    }

    public void setUserGuid(UUID userGuid) {
        this.userGuid = userGuid;
    }

    public void setEventType(String eventType) {
        this.eventType = eventType;
    }

    public void setEventSubtype(String eventSubtype) {
        this.eventSubtype = eventSubtype;
    }

    public void setGeofenceLat(double geofenceLat) {
        this.geofenceLat = geofenceLat;
    }

    public void setGeofenceLon(double geofenceLon) {
        this.geofenceLon = geofenceLon;
    }

    public void setGeofenceRadiusMetres(int geofenceRadiusMetres) {
        this.geofenceRadiusMetres = geofenceRadiusMetres;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setEventTimestamp(BigInteger eventTimestamp) {
        this.eventTimestamp = eventTimestamp;
    }

    public void setSentTimestamp(BigInteger sentTimestamp) {
        this.sentTimestamp = sentTimestamp;
    }

    public void setReadByUser(Boolean readByUser) {
        this.readByUser = readByUser;
    }

}
