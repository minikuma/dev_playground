package me.minikuma;

import org.apache.catalina.connector.Connector;
import org.apache.catalina.startup.Tomcat;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;

public class WebServerApp {

    private static final Logger log = LoggerFactory.getLogger(WebServerApp.class);

    public static void main(String[] args) throws Exception {
        String webappDir = "webapps/";
        Tomcat tomcat = new Tomcat();
        Connector connector = new Connector();
        connector.setPort(8080);
        tomcat.setConnector(connector);

        tomcat.addWebapp("/", new File(webappDir).getAbsolutePath());
        log.info("Starting Tomcat... app with basedir :: {}", new File(webappDir).getAbsolutePath());

        tomcat.start();
        tomcat.getServer().await();
    }
}
