package logic;

public class CommentToJson {
    private String login;
    private String field;
    public CommentToJson(String login, String field) {
        login = this.login;
        field = this.field;
    }

    public CommentToJson() {
        login = null;
        field = null;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    @Override
    public String toString() {
        return "CommentToJson{" +
                "login='" + login + '\'' +
                ", text='" + field + '\'' +
                '}';
    }
}
