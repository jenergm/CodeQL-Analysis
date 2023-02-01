/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE506_Embedded_Malicious_Code__screen_capture_08.java
Label Definition File: CWE506_Embedded_Malicious_Code.badonly.label.xml
Template File: point-flaw-badonly-08.tmpl.java
*/
/*
* @description
* CWE: 506 Embedded Malicious Code
* Sinks: screen_capture
*    BadSink : Perform a screen capture and save it to a file
*	 BadOnly (No GoodSink)
* Flow Variant: 08 Control flow: if(private_returns_t())
*
* */

package testcases.CWE506_Embedded_Malicious_Code;

import testcasesupport.*;

import java.awt.AWTException;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;

import javax.imageio.ImageIO;

public class CWE506_Embedded_Malicious_Code__screen_capture_08 extends AbstractTestCase
{

    /* The methods below always return the same value, so a tool
       should be able to figure out that every call to these
       methods will return true or return false. */
    private boolean private_returns_t()
    {
        return true;
    }

    private boolean private_returns_f()
    {
        return false;
    }

    public void bad() throws Throwable
    {
        if (private_returns_t())
        {
            /* adapted from http://www.java-tips.org/java-se-tips/java.awt/how-to-capture-screenshot.html */
            try
            {
                Robot robot = new Robot();
                /* FLAW: Capture the screen shot of the area of the screen defined by the rectangle */
                BufferedImage bi=robot.createScreenCapture(new Rectangle(100,100));
                ImageIO.write(bi, "jpg", new File("C:/screen.jpg"));
            }
            catch (AWTException e)
            {
                IO.logger.log(Level.WARNING, "Could not access screen for capture", e);
            }
            catch (IOException e)
            {
                IO.logger.log(Level.WARNING, "Could not access file system", e);
            }
        }
    }

    /* good1() changes private_returns_t() to private_returns_f() */
    private void good1() throws Throwable
    {
        if(private_returns_f())
        {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
            /* adapted from http://www.java-tips.org/java-se-tips/java.awt/how-to-capture-screenshot.html */
            try
            {
                Robot robot = new Robot();
                /* FLAW: Capture the screen shot of the area of the screen defined by the rectangle */
                BufferedImage bi=robot.createScreenCapture(new Rectangle(100,100));
                ImageIO.write(bi, "jpg", new File("C:/screen.jpg"));
            }
            catch (AWTException e)
            {
                IO.logger.log(Level.WARNING, "Could not access screen for capture", e);
            }
            catch (IOException e)
            {
                IO.logger.log(Level.WARNING, "Could not access file system", e);
            }
        }
    }

    /* good2() reverses the bodies in the if statement */
    private void good2() throws Throwable
    {
        if(private_returns_t())
        {
            /* INCIDENTAL: Empty Block */
        }
        else {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */

            /* adapted from http://www.java-tips.org/java-se-tips/java.awt/how-to-capture-screenshot.html */
            try
            {
                Robot robot = new Robot();
                /* FLAW: Capture the screen shot of the area of the screen defined by the rectangle */
                BufferedImage bi=robot.createScreenCapture(new Rectangle(100,100));
                ImageIO.write(bi, "jpg", new File("C:/screen.jpg"));
            }
            catch (AWTException e)
            {
                IO.logger.log(Level.WARNING, "Could not access screen for capture", e);
            }
            catch (IOException e)
            {
                IO.logger.log(Level.WARNING, "Could not access file system", e);
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
