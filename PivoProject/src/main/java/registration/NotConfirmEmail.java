package registration;

import controller.EMailController;
import managers.ConfigManager;
import managers.MessageManager;
import registration.NewUserActionCommand;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Класс, выдающий страницу неподтвержденного email, если пользователь ещё не дошёл до шага подтверждения
 * и вот тут мы уже должны сделать отправку на почту
 */
public class NotConfirmEmail implements NewUserActionCommand {
    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) {
        EMailController eMailController = new EMailController();
        try {
            System.out.println("Письмо пошло в контроллер");
            eMailController.send(req);
        } catch(IOException e) {
            System.err.print("ошибка отправки письма: " + e);
        }
        //req.setAttribute("errorConfirmCode", MessageManager.getProperty("messages.errorConfirmCode"));

        return ConfigManager.getProperty("path.page.emptyEmail");
    }
}
