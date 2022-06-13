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
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

@WebServlet(name = "BeerPageController", urlPatterns = {"/jsp/BeerPageController", "/BeerPageController", "jsp/beer/BeerPageController"})
public class BeerPageController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req, resp);
    }

    public void processRequest(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String beerPage = req.getParameter("beerPage");
        req.getSession().setAttribute("beerPage", beerPage);
        System.out.println("BeerPageController:" + beerPage);

        ArrayList<Comment> commentList;


        /*if (req.getParameter("commentaryField")!=null) {

            ParseComment.newCommentByUser(req);
        } else {
            System.out.println("Комментарий не был создан");
        }*/
        if (beerPage!=null) {
            System.out.println("мы в пив-контроллере");
            //получаем лист комментов для каждой страницы
            commentList = CommentDataBase.getCommentFromDBByBeer(beerPage);
            //req.getSession().setAttribute("commentList", commentList);
            //req.setAttribute("commentList", commentList);
            System.out.println("commentList в BeerPageController: " + req.getSession().getAttribute("commentList"));
            //System.out.println("Значение скрытого поля после: " + req.getSession().getAttribute("commentList"));



            /*String json = new Gson().toJson(commentList);
            System.out.println("json, который получился в пив-контроллере" + json);
            resp.setContentType("application/json");
            resp.setCharacterEncoding("UTF-8");
            resp.getWriter().write(json);*/
            //загружаем весь лист комментов в поток

            //req.getRequestDispatcher("/jsp/beer/" + beerPage + ".jsp").forward(req, resp);
            resp.sendRedirect("/pivoWeb/jsp/beer/" + beerPage + ".jsp");
        }


    }
}
