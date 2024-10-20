package practice.controller.httpserver;

import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * @author shguddnr2@coremethod.co.kr
 * @version 1.0
 * @since 24. 10. 21.
 */
public class Main {

    public static void main(String[] args) throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException, IOException {
        initConfiguration();
        WebServer webServer = new WebServer();
        webServer.startServer();
    }

    private static void initConfiguration() throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Constructor<ServerConfiguration> constructor = ServerConfiguration.class.getDeclaredConstructor(int.class, String.class);
        constructor.setAccessible(true);
        constructor.newInstance(8080, "hello");
    }

}
