package logic;

import java.sql.*;


/**
 * класс, отсылающий запрос к базе данных пользователей
 */
public class DataBase {
    private static final String URL = "jdbc:mysql://localhost:3306/mydbtest?useUnicode=true&useSSL=true&" +
            "useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
    private static final String ROOTLOGIN = "root";
    private static final String ROOTPASSWORD = "bebra_12";
    private static final String INSERT_NEW = "insert into users_database value(?, ?, ?, ?, ?, ?)";
    private static final String GET_ALL = "select * from users_database";

    /**
     *
     * @param user добавляется, если в базе данных нет с таким же email и login
     * @return true – добавление прошло успешно, false – ошибка
     */
    public static boolean add(User user) {

        try(Connection connection = DriverManager.getConnection(URL, ROOTLOGIN, ROOTPASSWORD)) {
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_NEW);
            preparedStatement.setInt(1, user.getId());
            preparedStatement.setString(2, user.getUsername());
            preparedStatement.setString(3, user.getEmail());
            preparedStatement.setString(4, user.getPassword());
            preparedStatement.setInt(5, user.getAge());
            preparedStatement.setString(6, user.getCountry());

            //отсылаем запрос к базе данных
            //тут нужно запросить последний айдишник, который был сохранен в БД
            preparedStatement.execute();

            return true;
        } catch(SQLException e) {
            e.printStackTrace();
            return false;
        }

    }

    /**
     *
     * @param keyEmail почта, полученная от пользователя
     * @param keyField поле, которое будем получать
     * @return если email совпал, возвращаем его
     */
    public static String getEmail(String keyEmail, String keyField) {
        String email = null;
        String query = "select " + keyField + " from users_database";
        try (Connection connection = DriverManager.getConnection(URL, ROOTLOGIN, ROOTPASSWORD)) {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            while(resultSet.next()) {
                String temp = resultSet.getString("email");
                if ((keyEmail.equals(temp))) {
                    email = temp;
                }
            }
            //email = resultSet.getString("email");
        } catch(SQLException e) {
            e.printStackTrace();
        }

        return email;
    }

    /**
     * @return номер последнего ID в БД
     */
    public static int getLastID() {
        int lastID = -1;
        try (Connection connection = DriverManager.getConnection(URL, ROOTLOGIN, ROOTPASSWORD)) {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select id from users_database");

            while(resultSet.next()) {
                lastID = resultSet.getInt("id");
                System.out.println("последний ID = " + lastID);
            }
        } catch( SQLException e) {
            e.printStackTrace();
        }

        return lastID;
    }

    /**
     * @return true – если пользователь найден в БД, иначе – false
     */
    public static boolean userIsExist(String userLogin, String userPassword) {
        boolean isExist = false;

        try(Connection connection = DriverManager.getConnection(URL, ROOTLOGIN, ROOTPASSWORD)) {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select username, password from users_database");

            while(resultSet.next()) {
                //если в БД нашлось совпадение по 2 полям
                if (userLogin.equals(resultSet.getString("username")) &
                        userPassword.equals(resultSet.getString("password"))) {
                    isExist = true;
                }
            }
        } catch(SQLException e) {
            e.printStackTrace();
        }

        return isExist;
    }


}