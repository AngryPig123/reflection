package practice.controller.httpserver;

import com.sun.net.httpserver.HttpServer;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;

/**
 * @author shguddnr2@coremethod.co.kr
 * @version 1.0
 * @since 24. 10. 21.
 */
@Slf4j
public class WebServer {

    public void startServer() throws IOException {

        HttpServer httpServer = HttpServer.create(ServerConfiguration.getInstance().getInetSocketAddress(), 0);
        httpServer.createContext("/greeting").setHandler(exchange -> {
            String responseMessage = ServerConfiguration.getInstance().getGreetingMessage();
            exchange.sendResponseHeaders(200, responseMessage.length());
            OutputStream responseBody = exchange.getResponseBody();
            responseBody.write(responseMessage.getBytes(StandardCharsets.UTF_8));
            responseBody.flush();
            responseBody.close();
        });

        log.info("Starting server on address {} : {}",
                ServerConfiguration.getInstance().getInetSocketAddress().getHostName(),
                ServerConfiguration.getInstance().getInetSocketAddress().getPort()
        );

        httpServer.start();

    }

}
