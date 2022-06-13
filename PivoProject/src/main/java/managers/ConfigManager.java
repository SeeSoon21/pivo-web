package managers;

import java.util.ResourceBundle;

public class ConfigManager {
    private final static ResourceBundle resourceBundle = ResourceBundle.getBundle("config");
    public static String getProperty(String key) { return resourceBundle.getString(key); }
}
