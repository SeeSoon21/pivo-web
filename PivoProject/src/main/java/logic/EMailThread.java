package logic;

import managers.EMailSessionCreator;
import managers.SessionCreator;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

/**
 * Класс, предназначающийся для создания нового потока при отправке письма каждым пользователем
 * code – уникальный код, выдающийся каждому пользователю для подтверждения регистрации
 */
public class EMailThread extends Thread {
    private MimeMessage message;
    private String sendToEmail;
    private Properties properties;
    private final String mailSubject = "Регистрация на WebPivo!";
    private final String mailText = "Код подтверждения: ";
    private String code;

    public EMailThread(String sendToEmail, Properties properties, String code) {
        this.sendToEmail = sendToEmail;
        this.properties = properties;
        this.code = code;
    }

    private void init() {
        Session session = (new EMailSessionCreator(properties)).createSession();
        session.setDebug(true);

        message = new MimeMessage(session);
        try {
            message.setSubject(mailSubject);
            System.out.println("тема письма: " + mailSubject);
            String mailContent = mailText + ": " + code;
            message.setContent(mailContent, "text/html; charset=utf-8");
            message.setRecipient(Message.RecipientType.TO, new InternetAddress(sendToEmail));
        } catch (AddressException e) {
            System.err.print("Некорректный адрес:" + sendToEmail + " " + e);
            // in log file
        } catch (MessagingException e) {
            System.err.print("Ошибка формирования сообщения" + e);
        }
    }

    public void run() {
        init();
        try {
            Transport.send(message);
        } catch (MessagingException e) {
            System.err.print("Ошибка формирования сообщения" + e);
        }
    }
}
