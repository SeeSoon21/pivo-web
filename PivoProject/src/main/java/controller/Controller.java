package controller;


import command.ActionCommand;
import logic.ActionFactory;
import managers.MessageManager;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name="Controller", urlPatterns = {"/jsp/Controller", "/Controller"})
public class Controller extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req, resp);
    }

    public void processRequest(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ActionFactory client = new ActionFactory();
        ActionCommand command = client.defineCommand(req);
        String page = command.execute(req);
        System.out.println("page в контроллере: " +page);

        if (page != null) {
            req.getRequestDispatcher(page).forward(req, resp);
        } else {
            req.setAttribute("nullpage", MessageManager.getProperty("messages.nullpage"));
            //req.getRequestDispatcher(ConfigManager.getProperty("path.page.login"));
        }

        System.out.println("Текущая сессия:" + req.getSession(false).toString() + "\n");
        System.out.println("session id = " + req.getSession().getId());

        System.out.println("Локаль:" + req.getLocale().toString());
        
    }


}

