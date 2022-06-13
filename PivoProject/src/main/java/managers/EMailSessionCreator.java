package managers;

import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import java.util.Properties;

public class EMailSessionCreator {
    private String smtpHost;
    private String smtpPort;
    private String userName;
    private String userPassword;
    private Properties sessionProperties;

    public EMailSessionCreator(Properties configProperties) {
        smtpHost = configProperties.getProperty("mail.smtp.host");
        smtpPort = configProperties.getProperty("mail.smtp.port");
        userName = configProperties.getProperty("mail.user.name");
        userPassword = configProperties.getProperty("mail.user.password");

        sessionProperties = new Properties();
        sessionProperties.setProperty("mail.transport.protocol", "smtp");
        sessionProperties.setProperty("mail.host", smtpHost);

        sessionProperties.put("mail.smtp.auth", "true");
        sessionProperties.put("mail.smtp.port", smtpPort);
        sessionProperties.put("mail.smtp.socketFactory.port", smtpPort);
        sessionProperties.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        sessionProperties.put("mail.smtp.socketFactory.fallback", "false");
        sessionProperties.setProperty("mail.smtp.quitwait", "false");

        //переключение на новую версию протокола(без этого выдает ошибку)
        sessionProperties.put("mail.smtp.ssl.protocols", "TLSv1.2");

    }

    public Session createSession () {
        return Session.getDefaultInstance(sessionProperties,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(userName, userPassword);
                    }
                });
    }
}
