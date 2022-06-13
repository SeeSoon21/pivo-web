package registration;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface NewUserActionCommand {
    public String execute(HttpServletRequest req, HttpServletResponse resp);
}
