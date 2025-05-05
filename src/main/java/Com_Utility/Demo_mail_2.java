package Com_Utility;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.EmailAttachment;
import org.apache.commons.mail.MultiPartEmail;

public class Demo_mail_2 {

    public static void main(String args[]) throws Exception {
        Send_Email_Method();
    }

    public static void Send_Email_Method() throws Exception {
        System.out.println("=================== TEST Started ==============");

        // Path to your Extent Report
        String reportPath = "/Rahul_Shetty_Academy_Jenkins_Run_Project/test-output/Extent_Reports/TestReport.html";

        //  Create the attachment
        EmailAttachment attachment = new EmailAttachment();
        attachment.setPath(reportPath);
        attachment.setDisposition(EmailAttachment.ATTACHMENT);
        attachment.setDescription("Automation Test Extent Report");
        attachment.setName("Extent_Test_Report.html");

        // Create the email message 
        MultiPartEmail email = new MultiPartEmail();
        email.setHostName("smtp.office365.com");      // Office 365 SMTP Server
        email.setSmtpPort(587);                       // TLS Port
        email.setAuthenticator(new DefaultAuthenticator("", ""));
        email.setStartTLSEnabled(true);             // Enable STARTTLS
        email.setSSLOnConnect(false);               // Office365 compatibility

        email.setFrom(""); // Sender
        email.setSubject("Automation Test Execution Report");
        email.setMsg("Hello Team,"
        		+ "\n\nPlease find the attached Automation Test Execution Extent Report.\n\nRegards,\nAniket Jadhav");
        email.addTo("jadhavaniket1572@gmail.com"); // Receiver

//        // Attach the Extent Report
     email.attach(attachment);

        // Send the email 
        email.send();

        System.out.println("============== Email sent successfully with Extent Report attached! ===============");
    }
}
