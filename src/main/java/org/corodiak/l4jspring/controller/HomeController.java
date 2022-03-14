package org.corodiak.l4jspring.controller;

import org.corodiak.l4jspring.etc.ModelAndViewFactoryImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class HomeController extends ModelAndViewFactoryImpl {

    Logger logger = LoggerFactory.getLogger(HomeController.class);

    @Value("${data.dummy}")
    String value;

    @RequestMapping(value = "/")
    public RedirectView index() {
        return new RedirectView("/main");
    }

    @RequestMapping(value = "/main", method = RequestMethod.GET)
    public String main() {
        return "index";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login() {
        return "login";
    }

    @RequestMapping(value = "login", method = RequestMethod.POST)
    public RedirectView loginProcess(@RequestParam("id") String id, @RequestParam("password") String password) {

        return new RedirectView("/main");
    }
}
