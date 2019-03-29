package org.skroom.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * AccountsController
 */
@RestController
@RequestMapping(ControllerPaths.ACCOUNTS)
public class AccountsController {

    public static List<Integer> ACCOUNTS = Arrays.asList(7, 8, 1, 4, 5, 7, 1, 2);

    
    @RequestMapping(method = RequestMethod.GET, produces = { MediaType.APPLICATION_JSON_VALUE })
    public List<Integer> getAccounts() {
        return ACCOUNTS;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Integer getAccount(@PathVariable("id") int id) {
        return ACCOUNTS.get(id);
    }
}