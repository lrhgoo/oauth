package com.mind.resource;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
public class UserController {

    @RequestMapping("/")
    @PreAuthorize("hasRole('ROLE_USER')")
    public Principal resource(Principal principal) {
        return principal;
    }

    @RequestMapping("/getUserInfo")
    @PreAuthorize("hasRole('ROLE_USER')")
    public String getUserInfo(Principal principal) {
       return principal.getName();
//        return principal;
    }

}
