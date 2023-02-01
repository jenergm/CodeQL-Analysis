/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE506_Embedded_Malicious_Code__email_06.java
Label Definition File: CWE506_Embedded_Malicious_Code.badonly.label.xml
Template File: point-flaw-badonly-06.tmpl.java
*/
/*
* @description
* CWE: 506 Embedded Malicious Code
* Sinks: email
*    BadSink : Send an e-mail
*	 BadOnly (No GoodSink)
* Flow Variant: 06 Control flow: if(private_final_five==5)
*
* */

package testcases.CWE506_Embedded_Malicious_Code;

import testcasesupport.*;

import java.io.*;
import java.util.Properties;
import java.util.logging.Level;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class CWE506_Embedded_Malicious_Code__email_06 extends AbstractTestCase
{

    /* The variable below is declared "final", so a tool should be able
       to identify that reads of this will always give its initialized
       value. */
    private final int private_final_five = 5;

    public void bad() throws Throwable
    {
        if (private_final_five==5)
        {
            Properties props = new Properties();
            Session session = Session.getDefaultInstance(props, null);
            String msgBody = "...";
            try
            {
                Message msg = new MimeMessage(session); /* INCIDENTAL: CWE506 Encoded Payload */
                msg.setFrom(new InternetAddress("sender@example.com"));
                msg.addRecipient(Message.RecipientType.TO,
                new InternetAddress("recipient@example.com"));
                msg.setSubject("Shhh, I'm sending some bad stuff!");
                msg.setText(msgBody);
                /* FLAW: Send an e-mail */
                Transport.send(msg);
            }
            catch (AddressException e)
            {
                /* If you are trying to hide the presence of something bad in code
                 * (i.e. e-mail) then you normally would not indicate errors in
                 * the log, but we're trying to avoid numerous incidentals for
                 * an empty catch block */
                IO.logger.log(Level.WARNING, "Address is formatted incorrectly", e);
            }
            catch (MessagingException e)
            {
                /* If you are trying to hide the presence of something bad in code
                 * (i.e. e-mail) then you normally would not indicate errors in
                 * the log, but we're trying to avoid numerous incidentals for
                 * an empty catch block */
                IO.logger.log(Level.WARNING, "Error sending message", e);
            }
        }
    }

    /* good1() changes private_final_five==5 to private_final_five!=5 */
    private void good1() throws Throwable
    {
        if(private_final_five!=5)
        {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
            Properties props = new Properties();
            Session session = Session.getDefaultInstance(props, null);
            String msgBody = "...";
            try
            {
                Message msg = new MimeMessage(session); /* INCIDENTAL: CWE506 Encoded Payload */
                msg.setFrom(new InternetAddress("sender@example.com"));
                msg.addRecipient(Message.RecipientType.TO,
                new InternetAddress("recipient@example.com"));
                msg.setSubject("Shhh, I'm sending some bad stuff!");
                msg.setText(msgBody);
                /* FLAW: Send an e-mail */
                Transport.send(msg);
            }
            catch (AddressException e)
            {
                /* If you are trying to hide the presence of something bad in code
                 * (i.e. e-mail) then you normally would not indicate errors in
                 * the log, but we're trying to avoid numerous incidentals for
                 * an empty catch block */
                IO.logger.log(Level.WARNING, "Address is formatted incorrectly", e);
            }
            catch (MessagingException e)
            {
                /* If you are trying to hide the presence of something bad in code
                 * (i.e. e-mail) then you normally would not indicate errors in
                 * the log, but we're trying to avoid numerous incidentals for
                 * an empty catch block */
                IO.logger.log(Level.WARNING, "Error sending message", e);
            }
        }
    }

    /* good2() reverses the bodies in the if statement */
    private void good2() throws Throwable
    {
        if(private_final_five==5)
        {
            /* INCIDENTAL: Empty Block */
        }
        else {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */

            Properties props = new Properties();
            Session session = Session.getDefaultInstance(props, null);

            String msgBody = "...";

            try {
                Message msg = new MimeMessage(session); /* INCIDENTAL: CWE506 Encoded Payload */
                msg.setFrom(new InternetAddress("sender@example.com"));
                msg.addRecipient(Message.RecipientType.TO,
                new InternetAddress("recipient@example.com"));
                msg.setSubject("Shhh, I'm sending some bad stuff!");
                msg.setText(msgBody);
                /* FLAW: Send an e-mail */
                Transport.send(msg);

            }
            catch (AddressException e)
            {
                /* If you are trying to hide the presence of something bad in code
                 * (i.e. e-mail) then you normally would not indicate errors in
                 * the log, but we're trying to avoid numerous incidentals for
                 * an empty catch block */
                IO.logger.log(Level.WARNING, "Address is formatted incorrectly", e);
            }
            catch (MessagingException e)
            {
                /* If you are trying to hide the presence of something bad in code
                 * (i.e. e-mail) then you normally would not indicate errors in
                 * the log, but we're trying to avoid numerous incidentals for
                 * an empty catch block */
                IO.logger.log(Level.WARNING, "Error sending message", e);
            }

        }

    }

    public void good() throws Throwable
    {
        good1();
        good2();
    }

    /* Below is the main(). It is only used when building this testcase on
       its own for testing or for building a binary to use in testing binary
       analysis tools. It is not used when compiling all the testcases as one
       application, which is how source code analysis tools are tested. */
    public static void main(String[] args) throws ClassNotFoundException,
           InstantiationException, IllegalAccessException
    {
        mainFromParent(args);
    }
}
