package controller;

import managers.ConfigManager;
import managers.MessageManager;
import registration.SuccessRegistrationCommand;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * сервлет, определяющий действия после введенного пользователем кода подтверждения.
 */
@WebServlet(name="EMailCodeController", urlPatterns = {"/EMailCodeController", "/jsp/EMailCodeController"})
public class EMailCodeController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req, resp);
    }

    private void processRequest(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //получаем сгенерированный код
        String code = (String)(req.getSession().getAttribute("code"));
        System.out.println("got CODE:" + code);
        //получаем введенный код
        String userCode = req.getParameter("inputCode");
        System.out.println("usercode = " + userCode);


        if (userCode == null || userCode.isEmpty()) {
            System.out.println("Код от юзера нулёвый пришёл");
            req.setAttribute("errorConfirmCode", MessageManager.getProperty("messages.errorConfirmCode"));
            req.getRequestDispatcher(ConfigManager.getProperty("path.page.errorMail")).forward(req, resp);
        } //в случае успеха управление передается сервлету
        else if (userCode.equals(code)) {
            System.out.println("Код от юзера совпал с тем, что надо");
            req.getSession().setAttribute("emailConfirm", "successEmail");
            //можно перекинуть на страницу, обрабатываемую RegistrationController сервлетом
            req.getRequestDispatcher(ConfigManager.getProperty("path.page.redirectConfirmEmail")).forward(req, resp);

            //устанавливаем полученные параметры на уровне сессии
            System.out.println("Получение regMail в EMAILCODECONTROLLER = " + req.getParameter("regMail"));

        } else {
            //сообщение об ошибке в случае неправильно кода
            req.getSession().setAttribute("errorConfirmCode", MessageManager.getProperty("messages.errorConfirmCode"));
            req.getRequestDispatcher(ConfigManager.getProperty("path.page.errorMail")).forward(req, resp);
        }

    }

}
