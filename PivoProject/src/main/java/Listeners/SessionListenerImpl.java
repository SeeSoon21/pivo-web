package Listeners;

import com.fasterxml.jackson.databind.ObjectMapper;
import logic.Comment;
import logic.CommentDataBase;
import org.apache.hc.core5.http.HttpResponse;

import javax.servlet.ServletContext;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;
import java.util.ArrayList;

@WebListener
public class SessionListenerImpl implements HttpSessionAttributeListener {
    @Override
    public void attributeAdded(HttpSessionBindingEvent event) {
        System.out.println("Создан аттрибут(Listener)" + event.getName()
                + ", значение:" + event.getValue());

        String beerPage = (String) event.getSession().getAttribute("beerPage");

        ArrayList<Comment> commentList;
        ObjectMapper mapper = new ObjectMapper();


        if (beerPage!=null) {
            System.out.println("МЫ в SessionListener");
            //получаем лист комментов для каждой страницы
            commentList = CommentDataBase.getCommentFromDBByBeer(beerPage);
            System.out.println("значение скрытого поля до изменения:" + event.getSession().getAttribute("commentList"));
            event.getSession().setAttribute("commentList", commentList);
        }

    }

    @Override
    public void attributeRemoved(HttpSessionBindingEvent event) {

    }

    @Override
    public void attributeReplaced(HttpSessionBindingEvent event) {

    }
}
