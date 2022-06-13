package command;

import managers.ConfigManager;
import logic.DataBase;
import managers.MessageManager;

import javax.servlet.http.HttpServletRequest;

/**
 * Класс, проверяющий логин и пароль на соответствие в БД и
 */
public class LoginCommand implements ActionCommand {
    @Override
    public String execute(HttpServletRequest req) {
        String page = null;

        String login = req.getParameter("Login");
        String password = req.getParameter("Password");
        if (DataBase.userIsExist(login, password)) {
            System.out.println("Логин введён верно!");
            req.setAttribute("user", login);
            //устанавливается для
            req.getSession().setAttribute("Login", login);
            page = ConfigManager.getProperty("path.page.main");
        } else {
            System.out.println("Логин или пароль введены неверно!");
            req.setAttribute("errorPassLoginMessage", MessageManager.getProperty("messages.loginerror"));
            page = ConfigManager.getProperty("path.page.login");
        }

        return page;
    }
}
