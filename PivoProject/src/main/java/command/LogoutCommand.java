package command;

import managers.ConfigManager;

import javax.servlet.http.HttpServletRequest;

/**
 * класс, возвращающий страницу выхода, при соответственном действии
 */
public class LogoutCommand implements ActionCommand{
    @Override
    public String execute(HttpServletRequest req) {
        return ConfigManager.getProperty("path.page.index");
    }
}
