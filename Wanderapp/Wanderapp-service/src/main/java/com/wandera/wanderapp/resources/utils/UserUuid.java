/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wandera.wanderapp.resources.utils;

import java.util.UUID;

/**
 *
 * Convenience class for transport through jackson
 *
 * @author jmt
 */
public class UserUuid {

    private UUID userUuid;

    public UserUuid(UUID userUuid) {
        this.userUuid = userUuid;
    }

    public UUID getUserUuid() {
        return userUuid;
    }

    public void setUserUuid(UUID userUuid) {
        this.userUuid = userUuid;
    }

}
