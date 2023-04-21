package core;

import java.net.MalformedURLException;
import java.net.URL;

public class Main {

    public static void main (String[] args) throws MalformedURLException {
        PvCore core = new PvCore();
        URL url = new URL(null,"https://");
        core.init("default",url, 5000);

        core.run();

    }
}

