package controller;

import com.google.gson.Gson;
import logic.Comment;
import logic.CommentDataBase;
import managers.MessageManager;
import registration.NewUserActionCommand;
import registration.NotConfirmEmail;
import registration.SuccessRegistrationCommand;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;

@WebServlet(name="/RegistrationController", urlPatterns = "/jsp/RegistrationController")
public class RegistrationController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req, resp);
    }

    //вот тут и будем определять value команды emailConfirm
    private void processRequest(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        /*Видимо всё равно придётся ставить 1 котроллер, потому что при переходе через redirect у нас все параметры,
        * введенные пользователем, обнуляются. Нужно обдумать.*/

        NewUserActionCommand action; //для определения действия(email подтвержден или нет)
        String redirectPage; //страница, на которую редирект

        //если у пользователя(в текущей сессии) ещё не введен
        System.out.println("emailConfirm в PROCESSREQUEST: " + req.getSession().getAttribute("emailConfirm"));
        System.out.println("emailConfirm только через аттрибут:" + req.getSession().getAttribute("emailConfirm"));

        //если email подтвержден кодом
        if (req.getSession().getAttribute("emailConfirm").equals("successEmail")){
            System.out.println("Зашли в успешный блок RegController");
            action = new SuccessRegistrationCommand();
            redirectPage = action.execute(req, resp);
        } //если не был введен верный код подтверждения
        else {
            action = new NotConfirmEmail();
            redirectPage = action.execute(req, resp); //страница редиректа(результат действия)
            System.out.println("regMail в RegistrationController" + req.getParameter("regMail"));

            //устанавливаем полученные данные на уровне сессии
            //А потом(если вдруг неверно введён код можно session.invalidate(?))
            req.getSession().setAttribute("regMail", req.getParameter("regMail"));
            req.getSession().setAttribute("regLogin", req.getParameter("regLogin"));
            req.getSession().setAttribute("regPassword", req.getParameter("regPassword"));
            req.getSession().setAttribute("regCountry", req.getParameter("regCountry"));
            req.getSession().setAttribute("regAge", req.getParameter("regAge"));
        }

        /*String beerPage = (String) req.getSession().getAttribute("beerPage");
        ArrayList<Comment> commentList;
        //ObjectMapper mapper = new ObjectMapper();
        System.out.println("Мы в LoadComments");
        if (beerPage!=null) {
            //получаем лист комментов для каждой страницы
            commentList = CommentDataBase.getCommentFromDBByBeer(beerPage);
            System.out.println("значение скрытого поля до изменения:" + req.getSession().getAttribute("commentList"));
            req.getSession().setAttribute("commentList", commentList);
            System.out.println("Значение скрытого поля после: " + req.getSession().getAttribute("commentList"));

            String json = new Gson().toJson(commentList);
            resp.setContentType("application/json");
            resp.setCharacterEncoding("UTF-8");
            resp.getWriter().write(json);
            //загружаем весь лист комментов в поток

            //mapper.writeValue(resp.getOutputStream(), commentList);
        }*/

        System.out.println("redirectPage = " + redirectPage);
        req.getRequestDispatcher(redirectPage).forward(req, resp);

    }
}
