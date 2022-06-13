package managers;

import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import java.util.Properties;

public class SessionCreator {
    private String smtpHost;
    private String smtpPort;
    private String userName;
    private String userPassword;
    private Properties sessionProperties;

    public SessionCreator(Properties configProperties) {
        //загружаем из файла свойств
        smtpHost = configProperties.getProperty("mail.smtp.host");
        smtpPort = configProperties.getProperty("mail.smtp.port");
        userName = configProperties.getProperty("mail.user.name");
        userPassword = configProperties.getProperty("mail.user.password");

        //загрузка параметров почтовой сессии свойства почтовой сессии
        sessionProperties = new Properties();
        sessionProperties.setProperty("mail.transport.protocol", "smtp");
        sessionProperties.setProperty("mail.host", smtpHost);

        //загружаем параметры, нужные для нашей аутентификации, а также свойства
        sessionProperties.put("mail.smtp.auth", "true");
        sessionProperties.put("mail.smtp.port", smtpPort);
        //socketFactory – экземпляр класса, а не имя и мы должны использовать put метод
        sessionProperties.put("mail.smtp.socketFactory.port", smtpPort);
        //если чёта пошло не так, будет создан класс
        sessionProperties.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        //если произойдет сбой, будет создан новый сокет
        sessionProperties.put("mail.smtp.socketFactory.fallback", "false");
        //закрывает подключение(если указан false)
        sessionProperties.setProperty("mail.smtp.quitwait", "false");

        //переключение на новую версию протокола(без этого выдает ошибку)
        sessionProperties.put("mail.smtp.ssl.protocols", "TLSv1.2");
    }

    public Session createSession() {
        return Session.getDefaultInstance(sessionProperties,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(userName, userPassword);
                    }
                });
    }
}
