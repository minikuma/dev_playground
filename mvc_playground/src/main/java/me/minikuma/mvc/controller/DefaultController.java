package me.minikuma.mvc.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DefaultController implements Controller {
    private final String defaultPath;

    public DefaultController(String defaultPath) {
        this.defaultPath = defaultPath;
    }

    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
        return defaultPath;
    }
}
