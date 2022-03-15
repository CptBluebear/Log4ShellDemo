package org.corodiak.l4jspring.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.corodiak.l4jspring.etc.ModelAndViewFactoryImpl;
import org.corodiak.l4jspring.exception.MemberNotFoundException;
import org.corodiak.l4jspring.service.MemberService;
import org.corodiak.l4jspring.vo.MemberVo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@RequiredArgsConstructor
@Controller
@Slf4j
public class HomeController extends ModelAndViewFactoryImpl {

    private final MemberService memberService;

    @RequestMapping(value = "/")
    public RedirectView index() {
        return new RedirectView("/main");
    }

    @RequestMapping(value = "/main", method = RequestMethod.GET)
    public String main() {
        return "main";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login() {
        return "login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public RedirectView loginProcess(
            @RequestParam("id") String id,
            @RequestParam("password") String password,
            HttpServletRequest request
    ) throws MemberNotFoundException {
        log.info("Login Request : {}", id);
        MemberVo memberVo = memberService.login(id, password);
        request.getSession().setAttribute("memberInfo", memberVo);
        return new RedirectView("/main");
    }

    @RequestMapping(value = "/logout")
    public RedirectView logout(HttpServletRequest request) {
        HttpSession session = request.getSession();
        session.invalidate();
        return new RedirectView("/login");
    }
}
