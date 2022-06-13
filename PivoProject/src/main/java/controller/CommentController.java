package controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import logic.Comment;
import logic.CommentDataBase;
import logic.CommentToJson;
import logic.ParseComment;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * Класс, контроллирующий действия, связанные с отправкой комментария
 * пока что тут всё связано с проверкой сессии
 */
//видимо, может быть такое, что юзер перейдет на страницу прямо к пиву, но сессия не будет создана, хотя он зарегистрирован
@WebServlet(name="CommentController", urlPatterns = {"/jsp/beer/CommentController", "/CommentController"})
public class CommentController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req, resp);
    }

    /**
     * @see filters.CommentFilter – тут подгружаются комментарии для каждой страницы
     *
     */
    private void processRequest(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //нужно проверить регистрацию и если её нет, отправить на страницу регистрации

        //нужно сразу установить подгрузку комментов с БД на страницу
        //ArrayList<Comment> commentList = new ArrayList<>();
        //String beerPage = (String) req.getSession().getAttribute("beerPage"); //страница, с которой поступил запрос
        //System.out.println("Страница, с которой поступил запрос: " + beerPage);

        //читаем тело комментария из потока
        // 1. get received JSON data from request
        String Login = (String)req.getSession().getAttribute("Login");
        System.out.println("LOGIN: " + Login);
        //очищаем выходной поток, чтобы лишняя инфа не засоряла json
        //System.out.flush();
        BufferedReader br =
                new BufferedReader(new InputStreamReader(req.getInputStream()));

        String json = "";
        //тут мы получаем введенный комментарий(прямо с полей jsp страницы)
        if(br != null){
            json = br.readLine();
        }

        System.out.println("getted json: " + json);

        // 2. initiate jackson mapper
        ObjectMapper mapper = new ObjectMapper();

        // 3. Конвертируем полученный с формы(js) json в объект
        CommentToJson comment = mapper.readValue(json, CommentToJson.class);
        System.out.println("новоиспеченный cumment = " + comment.toString());
        // 4. Set response type to JSON
        resp.setContentType("application/json");

        // 5. отправляем всё в форму(js), чтобы испечь коммент на странице
        mapper.writeValue(resp.getOutputStream(), comment);
        req.getSession().setAttribute("commentaryField", comment.getField());
        ParseComment.newCommentByUser(req);

        // 6. отсылаем весь наш массив в json, но это мне не пригодится. А вот при подгрузке даже очень
        //mapper.writeValue(response.getOutputStream(), articles);*/
        /*//req.getSession().setAttribute("commentaryField", json);


        CommentToJson commentToJson = new CommentToJson((String)req.getSession().getAttribute("Login"), json);
        System.out.println("CommentToJSON: " + commentToJson);

        //отправляем 'обработанный'(будто его кто-то обрабатывал, ага) json обратно в js-скрипт
        String completeComment = new Gson().toJson(commentToJson);
        System.out.println("completeComment");

        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");
        resp.getWriter().write(completeComment);
        //если список выводимого листа комментов не пуст, значит
        ParseComment.newCommentByUser(req);*/


    }
}
