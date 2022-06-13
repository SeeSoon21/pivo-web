package logic;

import java.sql.Date;

/**
 * Структура комментария, оставленного пользователем
 * text – тело комментария
 * date – дата-время отправки
 * user-name – имя пользователя
 */
public class Comment {
    private int id;
    private String commentClass;
    private String text;
    private Date date;
    private String userName;

    public Comment() {
    }

    public Comment(String text, Date date, String userName) {
        this.text = text;
        this.date = date;
        this.userName = userName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCommentClass() {
        return commentClass;
    }

    public void setCommentClass(String commentClass) {
        this.commentClass = commentClass;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "id=" + id +
                ", commentClass='" + commentClass + '\'' +
                ", text='" + text + '\'' +
                ", date=" + date +
                ", userName='" + userName + '\'' +
                '}';
    }
}
