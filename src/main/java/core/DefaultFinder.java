package core;

import netscape.javascript.JSObject;

import java.net.URL;

public class DefaultFinder implements Finder {

    @Override
    public ReportResult find(URL path) {
        return ReportResultBuilder.build()
    }
}
