package logic;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * это проверка сейчас нужна, чтобы понять: кому дать возможность комментирования, а кому – нет
 * сверять будем по сессии, полученной на странице авторизации.
 * То есть, если сессия там установлена, добавляем в список онлайна
 * наверное, лучше сверять не просто по сессии, а по sessionID
 *
 * 1-й String – sessionId
 * 2-й String – имя пользователя, оставляющего комментарий
 */
public class OnlineUsers {
    private static HashMap<String, String> onlineUsers = new HashMap<>();


    public static void addNewSession(HttpServletRequest req) {
        onlineUsers.put( req.getSession().getId(), req.getParameter("Login"));
        //затем это имя запихнем в hashmap, а потом уже будем брать из parseComment
        System.out.println("имя из запроса в ONLINE users = " + req.getParameter("Login"));
        System.out.println("сессия из запроса в ONLINE = " + req.getSession().getId());
    }

    public static HashMap<String, String> getOnlineList() {
        return onlineUsers;
    }

    public static String getOnline(HttpSession session) {
        return onlineUsers.get(session.getId());
    }
}
