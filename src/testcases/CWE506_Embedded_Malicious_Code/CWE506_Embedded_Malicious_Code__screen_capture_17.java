/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE506_Embedded_Malicious_Code__screen_capture_17.java
Label Definition File: CWE506_Embedded_Malicious_Code.badonly.label.xml
Template File: point-flaw-badonly-17.tmpl.java
*/
/*
* @description
* CWE: 506 Embedded Malicious Code
* Sinks: screen_capture
*    BadSink : Perform a screen capture and save it to a file
*	 BadOnly (No GoodSink)
* Flow Variant: 17 Control flow: for loop
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

public class CWE506_Embedded_Malicious_Code__screen_capture_17 extends AbstractTestCase
{

    public void bad() throws Throwable
    {
        for(int for_index_j = 0; for_index_j < 1; for_index_j++)
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

    /* good1() change the conditions on the while statements */
    private void good1() throws Throwable
    {
        for(int for_index_j = 0; for_index_j < 0; for_index_j++)
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

    public void good() throws Throwable
    {
        good1();
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
