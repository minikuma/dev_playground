package me.minikuma.mvc;

import me.minikuma.mvc.controller.Controller;
import me.minikuma.mvc.controller.MyRequestCondition;
import me.minikuma.mvc.controller.MyRequestMethod;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/")
public class DispatcherServlet extends HttpServlet {
    private static final Logger log = LoggerFactory.getLogger(DispatcherServlet.class);
    private MyRequestMapping requestMapping;

    @Override
    public void init() throws ServletException {
        this.requestMapping = new MyRequestMapping();
        requestMapping.init();
    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        log.info("[service] Invoke Dispatcher Servlet");

        Controller findController = this.requestMapping.findHandler(new MyRequestCondition(MyRequestMethod.valueOf(request.getMethod()), request.getRequestURI()));
        log.info("[service] find controller : {}", findController);

        try {
            String viewName = findController.handleRequest(request, response);
            RequestDispatcher requestDispatcher = request.getRequestDispatcher(viewName);
            requestDispatcher.forward(request, response);
        } catch (Exception e) {
            log.error("[service] Exception Occurred: {}", e.getMessage(), e);
        }
    }
}
