package me.minikuma.mvc;

import me.minikuma.mvc.controller.*;

import java.util.HashMap;
import java.util.Map;

/**
 * URL Path > 어떤 컨트롤러로 맵핑할 지 결정
 */
public class MyRequestMapping {
    private Map<MyRequestCondition, Controller> mappings = new HashMap<>();

    /**
     * default mapping 인 경우 WelcomeController 로 이동
     */
    void init() {
        mappings.put(new MyRequestCondition(MyRequestMethod.GET, "/"), new WelcomeController());
        mappings.put(new MyRequestCondition(MyRequestMethod.GET, "/members"), new MemberController());
    }

    public Controller findHandler(MyRequestCondition condition) {
        return mappings.get(condition);
    }
}
