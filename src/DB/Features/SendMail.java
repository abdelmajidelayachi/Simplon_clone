package DB.Features;

import DB.Models.LearnerCrud;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.ArrayList;
import java.util.Properties;

public class SendMail {

    public static boolean sendEmail(int promoId,String subject,String name,String context,String body,String sDate,String eDate ){
        final String user="majidev85@gmail.com";
        final String password="ojnatthyjimbwxoj";

        // get the session object
        String host = "smtp.gmail.com";

        Properties properties = System.getProperties();
        properties.put("mail.smtp.auth", true);
        properties.put("mail.smtp.host",host);
        properties.put("mail.smtp.port",587);
        properties.put("mail.smtp.ssl.trust", "smtp.gmail.com");
        properties.put("mail.smtp.ssl.protocols", "TLSv1.2");
        properties.put("mail.smtp.starttls.enable", "true");

        Session session = Session.getDefaultInstance(properties,
                new Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(user,password);
                    }
                });

        // compose of the mail
        // try catch to handle errors
        try {
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(user));
            ArrayList<String[]> learners = LearnerCrud.getAllLearnerInPromo(promoId);
            for (String[] learner: learners) {
                message.addRecipient(Message.RecipientType.TO, new InternetAddress(learner[3]));
            }
            message.setSubject(subject);
            message.setText("Bonjour \n\nName : "+name+"\n\nContext : "+context + "\n\nDetails :" + body+"\n\nStart Date : "+sDate + "\n\nDeadline : "+eDate+"\n\nBest Regards 🙂.");

            // try to send mail
            Transport.send(message);
            System.out.println("brief sent to learner successfully 👏👏👏");
        }catch (MessagingException e){
            System.out.println("something went wrong "+ e.getMessage());
            return false;
        }
        return true;

    }
}
