/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE252_Unchecked_Return_Value__FileInputStream_19.java
Label Definition File: CWE252_Unchecked_Return_Value__FileInputStream.label.xml
Template File: point-flaw-19.tmpl.java
*/
/*
* @description
* CWE: 252 Unchecked Return Value
* Sinks:
*    GoodSink: Check the return value from FileInputStream.read() and handle possible errors
*    BadSink : Do not check the return value of FileInputStream.read()
* Flow Variant: 19 Control flow: Dead code after an if(true) return
*
* */

package testcases.CWE252_Unchecked_Return_Value;

import testcasesupport.*;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.FileNotFoundException;

import java.util.logging.Level;
import java.util.logging.Logger;

public class CWE252_Unchecked_Return_Value__FileInputStream_19 extends AbstractTestCase
{

    public void bad() throws Throwable
    {
        {

            FileInputStream fis = null;

            try {
                int bytesToRead = 1024;
                byte[] byteArray = new byte[bytesToRead];

                fis = new FileInputStream("c:\\file.txt");

                fis.read(byteArray);

                /* FLAW: Do not check the return value of read() */

                IO.writeLine(new String(byteArray, "UTF-8"));
            }
            catch(FileNotFoundException fnfe)
            {
                IO.logger.log(Level.WARNING, "FileNotFoundException opening file", fnfe);
            }
            catch(IOException ioe)
            {
                IO.logger.log(Level.WARNING, "IOException reading file", ioe);
            }
            finally {
                try {
                    if(fis != null)
                    {
                        fis.close();
                    }
                }
                catch(IOException ioe)
                {
                    IO.logger.log(Level.WARNING, "IOException closing FileInputStream", ioe);
                }
            }

        }
        if(true) return; /* INCIDENTAL: CWE 571 Expression is Always True.  We need the "if(true)" because the Java Language Spec requires that unreachable code generate a compiler error */
        /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
        {

            FileInputStream fis = null;

            try {
                int bytesToRead = 1024;
                byte[] byteArray = new byte[bytesToRead];

                fis = new FileInputStream("c:\\file.txt");

                int numberOfBytesRead = fis.read(byteArray);

                /* FIX: Check the return value of read() and handle possible errors */
                if (numberOfBytesRead == -1)
                {
                    IO.writeLine("The end of the file has been reached.");
                }
                else {
                    if (numberOfBytesRead < bytesToRead)
                    {
                        IO.writeLine("Could not read " + bytesToRead + " bytes.");
                    }
                    else {
                        IO.writeLine(new String(byteArray, "UTF-8"));
                    }
                }
            }
            catch(FileNotFoundException fnfe)
            {
                IO.logger.log(Level.WARNING, "FileNotFoundException opening file", fnfe);
            }
            catch(IOException ioe)
            {
                IO.logger.log(Level.WARNING, "IOException reading file", ioe);
            }
            finally {
                try {
                    if(fis != null)
                    {
                        fis.close();
                    }
                }
                catch(IOException ioe)
                {
                    IO.logger.log(Level.WARNING, "IOException closing FileInputStream", ioe);
                }
            }

        }
    }

    public void good() throws Throwable
    {
        good1();
    }

    /* good1() reverses the GoodSinkBody and the BadSinkBody so that the BadSinkBody never runs */
    private void good1() throws Throwable
    {
        {

            FileInputStream fis = null;

            try {
                int bytesToRead = 1024;
                byte[] byteArray = new byte[bytesToRead];

                fis = new FileInputStream("c:\\file.txt");

                int numberOfBytesRead = fis.read(byteArray);

                /* FIX: Check the return value of read() and handle possible errors */
                if (numberOfBytesRead == -1)
                {
                    IO.writeLine("The end of the file has been reached.");
                }
                else {
                    if (numberOfBytesRead < bytesToRead)
                    {
                        IO.writeLine("Could not read " + bytesToRead + " bytes.");
                    }
                    else {
                        IO.writeLine(new String(byteArray, "UTF-8"));
                    }
                }
            }
            catch(FileNotFoundException fnfe)
            {
                IO.logger.log(Level.WARNING, "FileNotFoundException opening file", fnfe);
            }
            catch(IOException ioe)
            {
                IO.logger.log(Level.WARNING, "IOException reading file", ioe);
            }
            finally {
                try {
                    if(fis != null)
                    {
                        fis.close();
                    }
                }
                catch(IOException ioe)
                {
                    IO.logger.log(Level.WARNING, "IOException closing FileInputStream", ioe);
                }
            }

        }
        if(true) return; /* INCIDENTAL: CWE 571 Expression is Always True.  We need the "if(true)" because the Java Language Spec requires that unreachable code generate a compiler error */
        /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
        {

            FileInputStream fis = null;

            try {
                int bytesToRead = 1024;
                byte[] byteArray = new byte[bytesToRead];

                fis = new FileInputStream("c:\\file.txt");

                fis.read(byteArray);

                /* FLAW: Do not check the return value of read() */

                IO.writeLine(new String(byteArray, "UTF-8"));
            }
            catch(FileNotFoundException fnfe)
            {
                IO.logger.log(Level.WARNING, "FileNotFoundException opening file", fnfe);
            }
            catch(IOException ioe)
            {
                IO.logger.log(Level.WARNING, "IOException reading file", ioe);
            }
            finally {
                try {
                    if(fis != null)
                    {
                        fis.close();
                    }
                }
                catch(IOException ioe)
                {
                    IO.logger.log(Level.WARNING, "IOException closing FileInputStream", ioe);
                }
            }

        }
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

