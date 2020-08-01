package Utils;

import java.io.IOException;
import java.util.Properties;

public class PropertyLoader {
    private static final String GENERAL_PROP_FILE = "/config.properties";

    public static String loadProperty(String name) {
        Properties props = new Properties();
        try {
            props.load(PropertyLoader.class.getResourceAsStream(GENERAL_PROP_FILE));
        } catch (IOException e) {
            throw new IllegalArgumentException(e);
        }
        if (name != null) {
            return props.getProperty(name);
        }
        return "";
    }
}
