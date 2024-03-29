package com.beerdemo.demo.utils;

import com.beerdemo.demo.entities.Role;
import com.beerdemo.demo.entities.User;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.HashMap;
import java.util.List;


public class JwtAuthenticationFilter extends UsernamePasswordAuthenticationFilter {

    private static final int EXPIRATION_DURATION = 4800000;
    private final AuthenticationManager authenticationManager;

    public JwtAuthenticationFilter(AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;
        ((SimpleUrlAuthenticationFailureHandler) getFailureHandler()).setDefaultFailureUrl("/login?error");
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
            throws AuthenticationException {

        String username = request.getParameter("username");
        String password = request.getParameter("password");

        return authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        username,
                        password));

    }

    @Override
    protected void successfulAuthentication(HttpServletRequest request,
                                            HttpServletResponse response,
                                            FilterChain chain,
                                            Authentication authResult) {
        String token = Jwts.builder()
                           .setSubject(((User) authResult.getPrincipal()).getUsername())
                           .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_DURATION))
                           .signWith(SignatureAlgorithm.HS256, JwtSecurityConstants.SECRET)
                           .setHeader(new HashMap<>())
                           .compact();

        System.out.println("Generated token - " + token);
        response.setContentType("application/json");
        response.addHeader("Authorization", "Bearer " + token);

        String userRole = ((List<Role>) authResult.getAuthorities()).get(0).getAuthority();
        System.out.println(userRole);

        try {
            response.getWriter()
                    .append("{\"Authorization\": \"Bearer ").append(token).append("\"")
                    .append(", \"Role\": \"").append(userRole)
                    .append("\"}\n");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

