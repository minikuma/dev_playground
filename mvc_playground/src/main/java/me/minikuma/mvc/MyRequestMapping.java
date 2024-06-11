package me.minikuma.mvc;

import me.minikuma.mvc.controller.Controller;
import me.minikuma.mvc.controller.WelcomeController;

import java.util.HashMap;
import java.util.Map;

/**
 * URL Path > 어떤 컨트롤러로 맵핑할 지 결정
 */
public class MyRequestMapping {
    private Map<String, Controller> mappings = new HashMap<>();

    /**
     * default mapping 인 경우 WelcomeController 로 이동
     */
    void init() {
        mappings.put("/", new WelcomeController());
    }

    public Controller findHandler(String path) {
        return mappings.get(path);
    }
}
