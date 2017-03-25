package com.ttn.rabbitMq.controller;

import com.ttn.rabbitMq.Enums.Events;
import com.ttn.rabbitMq.service.EventPublisherService;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.LockedException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.ttn.*;

import java.beans.EventHandler;
import java.io.IOException;
import java.util.concurrent.TimeoutException;

@Controller
public class UserController {

    @Autowired
    EventPublisherService eventPublisherService;

    @RequestMapping(value = {"/", "/welcome**"}, method = RequestMethod.GET)
    public ModelAndView defaultPage() throws IOException, TimeoutException {
        eventPublisherService.publishEvent(Events.Event1, "New message for you");
        ModelAndView model = new ModelAndView();
        model.setViewName("hello");
        return model;

    }


}
