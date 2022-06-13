package command;

import managers.ConfigManager;

import javax.servlet.http.HttpServletRequest;

/**
 * Класс, относящийся к семейству команд; им изначально инициализируется любой экземпляр ActionCommand.
 * Возвращает nullpage
 */
public class EmptyCommand implements ActionCommand{
    @Override
    public String execute(HttpServletRequest req) {
        return ConfigManager.getProperty("path.page.error");
    }
}
