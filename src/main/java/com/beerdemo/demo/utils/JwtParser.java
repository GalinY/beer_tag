package com.beerdemo.demo.utils;


import com.beerdemo.demo.entities.User;
import com.beerdemo.demo.services.UserService;
import io.jsonwebtoken.Jwts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

@Component
public class JwtParser {

    private UserService userService;

    @Autowired
    public JwtParser(UserService userService) {
        this.userService = userService;
    }

    public String getUsernameFromToken(HttpServletRequest request) {

        String header = request.getHeader("Authorization");

        return Jwts.parser()
                   .setSigningKey(JwtSecurityConstants.SECRET)
                   .parseClaimsJws(header.replace("Bearer ", ""))
                   .getBody()
                   .getSubject();
    }

    public long getByUsernameFromToken(HttpServletRequest request) {
        String username = getUsernameFromToken(request);
        User user = userService.loadUserByUsername(username);

        return user.getUser_id();
    }
}


