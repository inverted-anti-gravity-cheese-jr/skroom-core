package org.skroom.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.skroom.model.UserMetadata;
import org.springframework.http.MediaType;
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
    
    @RequestMapping(method = RequestMethod.GET, produces = { MediaType.APPLICATION_JSON_VALUE })
    public List<UserMetadata> getAccounts() {
        return AuthenticationController.users
                .stream()
                .map(userPair -> userPair.getKey())
                .collect(Collectors.toList());
    }

    @RequestMapping(value = "/{name}", method = RequestMethod.GET)
    public Optional<UserMetadata> getAccount(@PathVariable("name") String name) {
        return AuthenticationController.users
                .stream()
                .filter(userPair -> userPair.getKey().getUserName().equals(name))
                .findAny()
                .map(userPair -> userPair.getKey());
    }
}