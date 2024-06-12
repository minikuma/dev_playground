package me.minikuma.mvc;

import me.minikuma.mvc.controller.Controller;
import me.minikuma.mvc.common.MyRequestCondition;
import me.minikuma.mvc.common.MyRequestMethod;
import me.minikuma.mvc.handler.MyRequestHandlerMapping;
import me.minikuma.mvc.view.JspViewResolver;
import me.minikuma.mvc.view.View;
import me.minikuma.mvc.view.ViewResolver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

@WebServlet("/")
public class DispatcherServlet extends HttpServlet {
    private static final Logger log = LoggerFactory.getLogger(DispatcherServlet.class);
    private MyRequestHandlerMapping requestMapping;
    private List<ViewResolver> viewResolvers;

    @Override
    public void init() throws ServletException {
        this.requestMapping = new MyRequestHandlerMapping();
        requestMapping.init();
        viewResolvers = Collections.singletonList(new JspViewResolver());
    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        log.info("[service] Invoke Dispatcher Servlet");
        try {
            Controller findControllerAndGetViewName = this.requestMapping.findHandler(new MyRequestCondition(MyRequestMethod.valueOf(request.getMethod()), request.getRequestURI()));
            //redirect: -> 제거 필요
            String viewName = findControllerAndGetViewName.handleRequest(request, response);
            // 결과 viewName: /member 이런 결과 값

            for (ViewResolver viewResolver : this.viewResolvers) {
                View findView = viewResolver.resolveView(viewName);
                findView.render(new HashMap<>(), request, response);
            }
        } catch (Exception e) {
            log.error("[service] Exception Occurred: {}", e.getMessage(), e);
        }
    }
}
