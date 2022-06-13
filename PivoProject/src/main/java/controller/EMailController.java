package controller;

import logic.EMailThread;
import logic.RandomSymbols;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Properties;

/**
 * управляет запуском процессов, после того как было получено письмо
 */
public class EMailController {
    public void send(HttpServletRequest req) throws IOException {
        String email = req.getParameter("regMail");
        System.out.println("email отправителя в EMailController: " + req.getParameter("regMail"));

        String code = RandomSymbols.randomString(5);
        System.out.println("CODE: " + code);
        req.getSession().setAttribute("code", code);

        if (email==null || email.isEmpty()) {
            System.out.println("Введенный адрес элпочты == пуст");
        }
        else {
            Properties properties = new Properties();
            ServletContext context = req.getServletContext();
            String filename = context.getInitParameter("mail");

            properties.load(context.getResourceAsStream(filename));

            EMailThread mailOperator = new EMailThread(email, properties, code);
            //создание нового потока
            mailOperator.start();
        }
    }
}
