package filters;

import com.fasterxml.jackson.databind.ObjectMapper;
import logic.Comment;
import logic.CommentDataBase;
import org.apache.hc.client5.http.classic.HttpClient;
import org.apache.hc.client5.http.classic.methods.HttpPost;
import org.apache.hc.client5.http.impl.classic.HttpClientBuilder;
import org.apache.hc.core5.http.HttpResponse;
import org.apache.hc.core5.http.io.entity.StringEntity;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;

/**
 * Фильтр, созданный для подгрузки комментариев, после того, как
 * пользователь решил перейти на соответствующую страницу с пивом
 */
/*@WebFilter(urlPatterns = {"BeerPageController?*"},
    initParams = {@WebInitParam(name="", value="", description="")})*/
public class CommentFilter implements Filter {
    private String beerPage;
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        //
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        String currentURL = request.getRequestURI();
        System.out.println("currentURL: " + currentURL);
        //присваем только в том случае, если !null(ибо фильтр проходится по всем страницам и ставит последнее значение)
        if (request.getParameter("beerPage")!=null) {
            beerPage = request.getParameter("beerPage");
            request.getSession().setAttribute("beerPage", beerPage);
            System.out.println("loadllcomm");
            //request.getRequestDispatcher("LoadAllComments").forward(request, response);
            //return;
        }
        System.out.println("beer page(чисто с url): " + beerPage);

        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {

    }
}
