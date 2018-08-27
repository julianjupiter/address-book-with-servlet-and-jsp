package io.github.julianjupiter.addressbook.server;

import java.io.File;
import java.io.IOException;
import java.util.Optional;
import org.apache.catalina.LifecycleException;
import org.apache.catalina.startup.Tomcat;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class TomcatServer {

    private static final Logger LOGGER = LogManager.getLogger(TomcatServer.class);
    
    private static final String APP_NAME = "Address Book Application";
    private static final Optional<String> PORT = Optional.ofNullable(System.getenv("PORT"));
    private static final Optional<String> HOSTNAME = Optional.ofNullable(System.getenv("HOSTNAME"));
    private static final String DEFAULT_HOST = "localhost";
    private static final String DEFAULT_PORT = "8080";
    private static final String CONTEXT_PATH = "/";
    private static final String DOC_BASE = "src/main/webapp/";

    private TomcatServer() {

    }

    public static void run(String[] args) throws IOException {
        int port = port(args);
        Tomcat tomcat = tomcat(port);

        try {
            LOGGER.info("{} started with context path {}.", APP_NAME, CONTEXT_PATH);
            LOGGER.info("Hit Ctrl + D or C to stop it...");
            tomcat.start();
        } catch (LifecycleException exception) {
            LOGGER.error("{}", exception.getMessage());
            LOGGER.error("Exit...");
            System.exit(1);
        }

        tomcat.getServer().await();
    }

    private static int port(String[] args) {
        if (args.length > 0) {
            String port = args[0];
            try {
                return Integer.valueOf(port);
            } catch (NumberFormatException exception) {
                LOGGER.error("Invalid port number {}", port, exception);
                LOGGER.error("Default port number {} will be used.", DEFAULT_PORT);
            }
        }

        return Integer.valueOf(PORT.orElse(DEFAULT_PORT));
    }

    private static Tomcat tomcat(int port) {
        Tomcat tomcat = new Tomcat();
        tomcat.setHostname(HOSTNAME.orElse(DEFAULT_HOST));
        tomcat.setPort(port);
        tomcat.addWebapp(CONTEXT_PATH, new File(DOC_BASE).getAbsolutePath());
        tomcat.getConnector();

        return tomcat;
    }
}
