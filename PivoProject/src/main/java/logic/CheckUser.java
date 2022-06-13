package logic;

/**
 * Класс, проверяющий, существует ли новый регистрируемый пользователь в БД или нет
 * сверка email и userName(его на потом)
 */

public class CheckUser {
    //получаем из БД почту и имя

    //если логина и email нет в базе данных, тогда будем отсылать true, иначе – false

    /**
     * @param email проверяем существование пользователя в БД по этому ключу
     * @return true – пользователя существует, false – нет
     */
    public static boolean checkEmail(String email) {
        boolean userIsExist = false;

        // != null – пользователь существует
        String dbEmail = DataBase.getEmail(email, "email");
        System.out.println("DBEMail, пришедший из базы данных:" + dbEmail);

        if (dbEmail != null) {
            userIsExist = true;
        }

        return userIsExist;
    }

//    public static boolean checkLogin(String login) {
//
//    }
}