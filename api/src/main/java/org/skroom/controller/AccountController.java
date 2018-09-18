package org.skroom.controller;

import com.google.inject.Inject;
import com.google.inject.assistedinject.Assisted;

import ro.pippo.controller.GET;

/**
 * AccountController
 */

public class AccountController {

    private final Integer id;

    @Inject
    public AccountController(@Assisted Integer id) {
        this.id = id;
    }

    @GET
    public Integer getAccount() {
        return AccountsController.ACCOUNTS.get(id);
    }

    
}