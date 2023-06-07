package coreInicialization;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesLoader {
	
    private Properties props;

    public PropertiesLoader() {
        this.props = new Properties();
    }

    public void loadDefaultProperties(String file) throws IOException {
        props.load(new FileInputStream(file));
    }

    public String getDefaultPlugin() {
        return props.getProperty("defaultPlugin");
    }

    public String getDefaultPluginPath() {
        return props.getProperty("defaultPluginPath");
    }
}

