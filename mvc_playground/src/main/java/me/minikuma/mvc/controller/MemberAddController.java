package me.minikuma.mvc.controller;

import me.minikuma.mvc.model.Member;
import me.minikuma.mvc.repository.MemberRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MemberAddController implements Controller {
    private static final Logger log = LoggerFactory.getLogger(MemberAddController.class);

    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
        log.info("MemberAddController handleRequest");
        MemberRepository.save(new Member(request.getParameter("memberId"), request.getParameter("name")));
        return "redirect:/members";
    }
}
