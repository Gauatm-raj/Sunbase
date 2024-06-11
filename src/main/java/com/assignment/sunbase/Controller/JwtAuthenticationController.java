package com.assignment.sunbase.Controller;

import com.assignment.sunbase.Model.JwtRequest;
import com.assignment.sunbase.Model.JwtResponse;
import com.assignment.sunbase.Service.JwtUserDetailsService;
import com.assignment.sunbase.Util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class JwtAuthenticationController {

    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private JwtUtil jwtUtil;
    @Autowired
    private JwtUserDetailsService userDetailsService;
    @PostMapping("/authenticate")
    public JwtResponse createAuthenticationToken(@RequestBody
                                                 JwtRequest authenticationRequest) throws Exception {
        authenticate(authenticationRequest.getUsername(),
                authenticationRequest.getPassword());
        final UserDetails userDetails =
                userDetailsService.loadUserByUsername(authenticationRequest.getUsername());
        final String token =
                jwtUtil.generateToken(userDetails.getUsername());
        return new JwtResponse(token);
    }
    private void authenticate(String username, String password) throws
            Exception {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
        } catch (AuthenticationException e) {
            throw new Exception("INVALID_CREDENTIALS", e);
        }
    }
}
