package controller;

import logic.MailThread;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Properties;
import java.util.ResourceBundle;

@WebServlet(name="MailController", urlPatterns={"/MailController", "/jsp/mail/MailController"})
public class MailController extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Properties properties = new Properties();
        ServletContext context = getServletContext();
        //ResourceBundle resourceBundle = ResourceBundle.getBundle("mail.properties");
        String filename = context.getInitParameter("mail");
        //получаем доступ к ресурсам, путь к которым задан в контекстном параметре
        properties.load(context.getResourceAsStream(filename));

        MailThread mailOperator =
                new MailThread(req.getParameter("to"),req.getParameter("subject"),
                        req.getParameter("mailMessageBody"), properties);
        // запуск процесса отправки письма в отдельном потоке
        mailOperator.start();
        // переход на страницу с предложением о создании нового письма
        req.getRequestDispatcher("/jsp/mail/send.jsp").forward(req, resp);


    }
}
