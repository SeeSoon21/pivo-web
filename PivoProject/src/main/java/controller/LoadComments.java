package controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import logic.Comment;
import logic.CommentDataBase;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

/**
 * сервлет, созданный для связи с js(конкретно, с ajax) для подгрузки комментариев сразу после того, как пользователь
 * нажмет на одну из ссылок на пиво
 */
@WebServlet(name="LoadComments", urlPatterns = {"/LoadComments", "/jsp/LoadComments", "/jsp/beer/LoadComments"})
public class LoadComments extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req, resp);
    }

    public void processRequest(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String beerPage = (String) req.getSession().getAttribute("beerPage");

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
        }
        req.getRequestDispatcher("/" + beerPage + ".jsp").forward(req, resp);

    }
}
