package registration;


import logic.CheckEMailCode;
import logic.CheckUser;
import logic.DataBase;
import logic.User;
import managers.ConfigManager;
import managers.MessageManager;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Класс, наследуемый от NewUserActionCommand, определяющий fun execute(req)
 * Для проверки занят логин и email связывается с БД(ч/з класс checkUser)
 * Может вернуть обратно на страницу регистрации(с соответствующим сообщением: если ключ неверный, допустим)
 * В случае успеха redirect на success.jsp с именем зарегистрированного пользователя
 */
public class SuccessRegistrationCommand implements NewUserActionCommand{
    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) {
        User user = new User(); // будет хранить данные о конкретном пользователе
        String page = null; //будем возвращать страницу в случае успеха/ошибки
        System.out.println("поля, полученные в jsp");

        //устанавливаем полученные данные на уровне сессии
        user.setEmail((String)req.getSession().getAttribute("regMail"));
        user.setUsername((String)req.getSession().getAttribute("regLogin"));
        user.setPassword((String)req.getSession().getAttribute("regPassword"));
        user.setCountry((String)req.getSession().getAttribute("regCountry"));
        user.setAge(Integer.parseInt((String)req.getSession().getAttribute("regAge")));

        System.out.println("regMail = " + user.getEmail());
        System.out.println("regLogin = " + user.getUsername());
        System.out.println("regPassword = " + user.getPassword());
        System.out.println("regCountry = " + user.getCountry());
        System.out.println("regAge = " + user.getAge());


        //получаем последний существующий в БД id, а новый устанавливаем на 1 больше
        user.setId(DataBase.getLastID() + 1);

        // if из checkEmail приходит false – значит пользователя не базе данных и мы заносим его туда
        // if в checkEMailCode код подтверждения совпал – возвращается true
        if (!CheckUser.checkEmail(user.getEmail())) {
            System.out.println("добавлен ли user: " + DataBase.add(user)); // добавляем юзера в базу данных
            req.setAttribute("regLogin", user.getUsername());
            //записываем результат в базу данных
            //но перед этим проверяем ключ через статический метод класс CheckEMailCode
            page = ConfigManager.getProperty("path.page.successRegistration");

        } else {
            req.setAttribute("userIsExist", MessageManager.getProperty("messages.userIsExist"));
            page = ConfigManager.getProperty("path.page.registration");
        }

        return page; // т.е. если возвращается null-page, пользователь уже есть в системе
    }

    //больше похоже на костыль, но я пока больше не понимаю, как указать бОльшую область видимости для введенных полей

}