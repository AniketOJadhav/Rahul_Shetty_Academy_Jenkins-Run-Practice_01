package Com_Utility;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.EmailAttachment;
import org.apache.commons.mail.MultiPartEmail;
import java.net.ConnectException;
import java.net.UnknownHostException;

public class Demo_Mail {

    public static void sendReportEmail(String reportPath) throws Exception {

        try {
            System.out.println("======= Sending Email with Extent Report Attachment =======");

            // Create the attachment
            EmailAttachment attachment = new EmailAttachment();
            attachment.setPath(reportPath);
            attachment.setDisposition(EmailAttachment.ATTACHMENT);
            attachment.setDescription("Automation Test Extent Report");
            attachment.setName("Extent_Test_Report.html");

            // Create the email message
               MultiPartEmail email = new MultiPartEmail();
//            email.setHostName("smtp.gmail.com");  // Gmail's SMTP server
//            email.setSmtpPort(587);  // Use port 587 for STARTTLS (or 465 for SSL)
//
//            // Use your Gmail email & App Password
//            email.setAuthenticator(new DefaultAuthenticator("jadhavaniket575@gmail.com", "Aniket@344@"));

//            // Fix STARTTLS issue by forcing it explicitly
//            email.setStartTLSEnabled(true);  
//            email.setStartTLSRequired(true);  
//            email.setSSLOnConnect(false);  
            email.setHostName("smtp.gmail.com");
            email.setSmtpPort(587);
            email.setAuthenticator(new DefaultAuthenticator("jadhavaniket575@gmail.com", ""));
            email.setStartTLSEnabled(true);
            email.setStartTLSRequired(true);
            email.setSSLOnConnect(false);

            
            email.setSmtpPort(465);  // Use port 465 for SSL
            email.setSSLOnConnect(true);  // Enable SSL
            email.setStartTLSEnabled(false);  // Disable STARTTLS


            email.setFrom("jadhavaniket575@gmail.com");
            email.setSubject("Automation Test Execution Report");
            email.setMsg("Please find the attached Automation Test Execution Report.");
            email.addTo("jadhavaniket1572@gmail.com");

            // Attach the report with Extent html
            email.attach(attachment);

            // Send the email
            email.send();

            System.out.println("Email sent successfully with the report attached!");

        } catch (Exception e) {
            String errorMessage = e.getMessage().toLowerCase();

            // Handle authentication errors
            if (errorMessage.contains("authentication failed") || errorMessage.contains("incorrect password")) {
                System.out.println("Authentication failed: The email/password combination is incorrect.");
            } else {
                // General exception message
                System.out.println("Failed to send email: " + e.getMessage());
            }
            e.printStackTrace();
        }
    }
}
