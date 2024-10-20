package practice.controller.httpserver;

import java.net.InetSocketAddress;

/**
 * @author shguddnr2@coremethod.co.kr
 * @version 1.0
 * @since 24. 10. 21.
 */
public class ServerConfiguration {

    private static ServerConfiguration serverConfigurationInstance;
    private final InetSocketAddress inetSocketAddress;
    private final String greetingMessage;

    public static ServerConfiguration getInstance() {
        return serverConfigurationInstance;
    }

    private ServerConfiguration(int port, String greetingMessage) {
        this.greetingMessage = greetingMessage;
        this.inetSocketAddress = new InetSocketAddress("localhost", port);
        if (serverConfigurationInstance == null) {
            serverConfigurationInstance = this;
        }
    }

    public InetSocketAddress getInetSocketAddress() {
        return inetSocketAddress;
    }

    public String getGreetingMessage() {
        return greetingMessage;
    }

}
