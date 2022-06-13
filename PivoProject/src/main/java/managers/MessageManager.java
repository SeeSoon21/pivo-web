package managers;

import java.util.ResourceBundle;

public class MessageManager {
    private final static ResourceBundle resourceBundle = ResourceBundle.getBundle("messages");
    public static String getProperty(String key) {return resourceBundle.getString(key); }
}
