package logic;

import command.ActionCommand;
import command.EmptyCommand;
import command.LoginCommand;
import command.LogoutCommand;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class ActionFactory {
    public ActionCommand defineCommand(HttpServletRequest req) {
        //Скрытое поле – это только полдела. У нас передаётся
        //кроме того сам логин и пароль.
        //Скрытое поле является маячком
        String action = req.getParameter("command");
        //отсюда всё должно перекидываться в контроллер
        ActionCommand current = new EmptyCommand();

        if (action == null || action.isEmpty()) {
            return current;
        }

        if (action.equals("Login")) {
            current = new LoginCommand();
            System.out.println("сессия в ActionFactory = " + req.getSession());
            OnlineUsers.addNewSession(req); //добавляем юзера в список олнайна

        } else if (action.equals("Logout")){
            //после этого сессия уже недоступна. Она будет создана после перехода в index.jsp(точнее, в login.jsp)
            req.getSession().invalidate(); //прекращаем сессию

            current = new LogoutCommand();
        }

        return current;

    }
}
