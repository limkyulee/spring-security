package com.kyuleeim.SpringSecurity.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author limkyulee
 * @version 1.0, 7/3/25
 * @see {참조}
 */
@RestController
public class HelloController {

    @GetMapping("/")
    public String sayHello(HttpServletRequest request) {
        return "Hello World!" + request.getSession().getId();
    }
}
