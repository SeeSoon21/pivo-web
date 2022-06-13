package logic;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.StringWriter;
import java.sql.*;
import java.util.ArrayList;

/**
 * класс, посылающий запрос к базе данных комментариев commentary_beer_page
 */
public class CommentDataBase {
    private static final String URL = "jdbc:mysql://localhost:3306/mydbtest?useUnicode=true&useSSL=true&" +
            "useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
    private static final String ROOTLOGIN = "root";
    private static final String ROOTPASSWORD = "bebra_12";
    private static final String INSERT_NEW = "insert into commentary_beer_page value(?, ?, ?, ?, ?)";
    private static final String GET_ALL = "select * commentary_beer_page";

    public static void addNewComment(Comment comment) {
        try (Connection connection = DriverManager.getConnection(URL, ROOTLOGIN, ROOTPASSWORD)){
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_NEW);
            preparedStatement.setInt(1, comment.getId());
            preparedStatement.setString(2, comment.getCommentClass());
            preparedStatement.setString(3, comment.getUserName());
            preparedStatement.setDate(4, comment.getDate());
            preparedStatement.setNString(5, comment.getText());

            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static int getLastCommentID() {
        int lastID = 0;
        try (Connection connection = DriverManager.getConnection(URL, ROOTLOGIN, ROOTPASSWORD)) {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select id from commentary_beer_page");

            while(resultSet.next()) {
                lastID = resultSet.getInt("id");
                System.out.println("последний ID = " + lastID);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return lastID;
    }

    /**
     * Получаем все комментарии для какой-то конкретной странички
     * @param beerName – страница, для которой будем получать комменты
     * @return список комментариев со страницы
     */
    public static ArrayList<Comment> getCommentFromDBByBeer(String beerName) {
        ArrayList<Comment> commentList = new ArrayList<>();

        System.out.println("Зашли в бд");
        try (Connection connection = DriverManager.getConnection(URL, ROOTLOGIN, ROOTPASSWORD)) {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from commentary_beer_page");
            while(resultSet.next()) {

                if ((resultSet.getString("comment_class")).equals(beerName)) {
                    Comment tempComment = new Comment(); // переменная для хранения каждого следующего результата БД
                    tempComment.setId(resultSet.getInt("id"));
                    tempComment.setCommentClass(beerName);
                    tempComment.setUserName(resultSet.getString("user_name"));
                    tempComment.setDate(resultSet.getDate("date"));
                    tempComment.setText(resultSet.getString("text"));

                    commentList.add(tempComment);
                }

            }


        } catch(SQLException e) {
            e.printStackTrace();
        }

        return commentList;
    }


}
