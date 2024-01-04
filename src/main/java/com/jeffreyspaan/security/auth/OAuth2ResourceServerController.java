package com.jeffreyspaan.security.auth;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OAuth2ResourceServerController {

    @GetMapping("/demo")
    public String demo() {
        return "Hello, this is a non secured demo endpoint";
    }

    @GetMapping("/user")
//    @PreAuthorize("hasRole('client_user')")
    public String user(@AuthenticationPrincipal Jwt jwt) {
        return String.format("Hello, %s! This is the secured user endpoint.", jwt.getClaimAsString("preferred_username"));
    }

    @GetMapping("/moderator")
//    @PreAuthorize("hasRole('client_user')")
    public String moderator(@AuthenticationPrincipal Jwt jwt) {
        return String.format("Hello, %s! This is the secured moderator endpoint.", jwt.getClaimAsString("preferred_username"));
    }

    @GetMapping("/admin")
//    @PreAuthorize("hasRole('client_admin')")
    public String hello(@AuthenticationPrincipal Jwt jwt) {
        return String.format("Hello, %s! This is the secured admin endpoint.", jwt.getClaimAsString("preferred_username"));
    }
}