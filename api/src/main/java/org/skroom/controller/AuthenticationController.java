package org.skroom.controller;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.CopyOnWriteArrayList;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.tuple.Pair;
import org.skroom.dto.ErrorDto;
import org.skroom.model.UserMetadata;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(ControllerPaths.AUTHENTICATION)
public class AuthenticationController {
    
    static List<Pair<UserMetadata, String>> users = new CopyOnWriteArrayList<>();
    
    public AuthenticationController() {
        if (users.isEmpty()) {
            var user = new UserMetadata();
            user.setUserName("admin");
            users.add(Pair.of(user, "admin123"));
        }
    }
    
    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<UserMetadata> getCurrentUser(HttpServletRequest request) {
        var user = (UserMetadata) request.getSession().getAttribute("user");
        if (user == null) {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<UserMetadata> login(@RequestBody UserRequest user, HttpServletRequest request) {
        Optional<Pair<UserMetadata, String>> userPair = users.stream()
                .filter(u -> user.userName.equals(u.getKey().getUserName()))
                .findAny();
        if (userPair.isPresent() && userPair.get().getRight().equals(user.password)) {
            request.getSession().setAttribute("user", userPair.get().getKey());
            return new ResponseEntity<UserMetadata>(userPair.get().getKey(), HttpStatus.OK);
        } else {
            return new ResponseEntity<UserMetadata>(HttpStatus.UNAUTHORIZED);
        }
    }
    
    @RequestMapping(method = RequestMethod.PUT)
    public ResponseEntity<ErrorDto> register(@RequestBody UserRequest user) {
        users.add(Pair.of(user.user, user.password));
        return new ResponseEntity<>(HttpStatus.OK);
    }
    
    private static class UserRequest {
        public String userName;
        public String password;
        public UserMetadata user;
    }
    
}
