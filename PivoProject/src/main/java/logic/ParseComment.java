package logic;

import com.fasterxml.jackson.databind.ObjectMapper;
import managers.ConfigManager;
import managers.MessageManager;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.StringWriter;
import java.sql.Date;

/**
 * класс, извлекающий данные из оставленного комментария
 */
public class ParseComment {
    //независимо от того, какой комментарий написан, будем возвращаться на одну и ту же страницу с пивом
    public static void newCommentByUser(HttpServletRequest req) {
        String userComment = (String)req.getSession().getAttribute("commentaryField"); //body of commentary
        System.out.println("Полученный комментарий: " + userComment);
        //req.getSession().setAttribute("commentaryField", userComment);
        System.out.println("ParseComment success");
        HttpSession currentSession = req.getSession();

        if (userComment!= null && !userComment.isEmpty()) {
            Comment comment = new Comment();

            String userName = OnlineUsers.getOnline(currentSession); //получаем логин(имя пользователя)
            java.util.Date utilDate = new java.util.Date();
            Date date = new Date(utilDate.getTime()); // получаем дату отправки комментария
            //String commentText = req.getSession.getAttribute("commentaryField"); //получает тело комментария

            //проверяем, в онлайне ли текущий юзер(блок можно убрать и добавить замену js-ом)
            if (userName == null || userName.isEmpty()) {
                System.out.println("Пользовать не залогинен");
                req.setAttribute("commentOnlyAuthrzd", MessageManager.getProperty("messages.commentOnlyAuthrzd"));
            }
            else {
                comment.setId(CommentDataBase.getLastCommentID() + 1);
                comment.setCommentClass((String)req.getSession().getAttribute("beerPage")); //страница, с которой поступил запрос
                comment.setUserName(userName);
                comment.setDate(date);
                comment.setText(userComment);

                System.out.println("Добавляется новый комментарий с текстом" + comment);
                CommentDataBase.addNewComment(comment);
            }

        } else {
            System.out.println("Тело комментария пустое");
            req.setAttribute("commentIsEmpty", MessageManager.getProperty("messages.commentIsEmpty"));
        }

    }
}
