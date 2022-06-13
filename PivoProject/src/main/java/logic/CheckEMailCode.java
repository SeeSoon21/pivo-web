package logic;

import managers.ConfigManager;
import managers.MessageManager;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Проверяет код, веденный пользователем с тем, что был отправлен ему на электронную почту
 */
public class CheckEMailCode {
    public static void checkCode(HttpServletRequest req, HttpServletResponse resp)  {
        System.out.println("Мы в checkCode()!!!!!!!!!!!!!!!");


        String userCode = req.getParameter("inputCode");
        System.out.println("usercode = " + userCode);
        String code = (String)(req.getSession().getAttribute("code"));
        System.out.println("got CODE:" + code);

        if (userCode.equals(code)) {
            req.getRequestDispatcher("/jsp/help_pages/redirectAfterConfirmEmail.jsp");
        } else {
            req.setAttribute("errorConfirmCode", MessageManager.getProperty("messages.errorConfirmCode"));
            req.getRequestDispatcher("/jsp/help_pages/redirectAfterConfirmEmail.jsp");
        }


    }
}
