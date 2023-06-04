package core;

import java.util.Properties;

public class TSProviderStrategy {
    public TSProviderStrategy(Properties properties) {
        this.updaterFinder = new UpdaterFinder(properties.get("pluginPath"));
    }

    public TSProvider getTSProvider(){

//        return new
    }
}
