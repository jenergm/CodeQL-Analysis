/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE477_Obsolete_Functions__DataInputStream_readLine_03.java
Label Definition File: CWE477_Obsolete_Functions.label.xml
Template File: point-flaw-03.tmpl.java
*/
/*
* @description
* CWE: 477 Use of Obsolete Functions
* Sinks: DataInputStream_readLine
*    GoodSink: Use of preferred BufferedReader.readLine() method
*    BadSink : Use deprecated DataInputStream.readLine() method
* Flow Variant: 03 Control flow: if(5==5) and if(5!=5)
*
* */

package testcases.CWE477_Obsolete_Functions;

import testcasesupport.*;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.DataInputStream;

public class CWE477_Obsolete_Functions__DataInputStream_readLine_03 extends AbstractTestCase
{

    public void bad() throws Throwable
    {
        if (5==5)
        {
            /* Read a line of user input from console with deprecated DataInputStream.readLine() method */
            {
                /* FLAW: Read $Data$ from the console using DataInputStream.readLine() */
                DataInputStream dis = new DataInputStream(System.in);
                String s = dis.readLine();
                IO.writeLine(s); /* Use s */
                /* NOTE: Tools may report a flaw here because dis is not closed.  Unfortunately, closing that will close System.in, which will cause any future attempts to read from the console to fail and throw an exception */
            }
        }
        else {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */

            /* Read a line of user input from console with preferred BufferedReader.readLine() method */
            {
                InputStreamReader isr = new InputStreamReader(System.in, "UTF-8");
                BufferedReader buffread = new BufferedReader(isr);

                /* FIX: Read $Data$ from the console using preferred method BufferedReader.readLine() */
                String s = buffread.readLine();

                IO.writeLine(s); /* Use s */

                /* NOTE: Tools may report a flaw here because buffread and isr are not closed.  Unfortunately, closing those will close System.in, which will cause any future attempts to read from the console to fail and throw an exception */
            }

        }
    }

    /* good1() changes 5==5 to 5!=5 */
    private void good1() throws Throwable
    {
        if(5!=5)
        {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
            /* Read a line of user input from console with deprecated DataInputStream.readLine() method */
            {
                /* FLAW: Read $Data$ from the console using DataInputStream.readLine() */
                DataInputStream dis = new DataInputStream(System.in);
                String s = dis.readLine();
                IO.writeLine(s); /* Use s */
                /* NOTE: Tools may report a flaw here because dis is not closed.  Unfortunately, closing that will close System.in, which will cause any future attempts to read from the console to fail and throw an exception */
            }
        }
        else {

            /* Read a line of user input from console with preferred BufferedReader.readLine() method */
            {
                InputStreamReader isr = new InputStreamReader(System.in, "UTF-8");
                BufferedReader buffread = new BufferedReader(isr);

                /* FIX: Read $Data$ from the console using preferred method BufferedReader.readLine() */
                String s = buffread.readLine();

                IO.writeLine(s); /* Use s */

                /* NOTE: Tools may report a flaw here because buffread and isr are not closed.  Unfortunately, closing those will close System.in, which will cause any future attempts to read from the console to fail and throw an exception */
            }

        }
    }

    /* good2() reverses the bodies in the if statement */
    private void good2() throws Throwable
    {
        if(5==5)
        {
            /* Read a line of user input from console with preferred BufferedReader.readLine() method */
            {
                InputStreamReader isr = new InputStreamReader(System.in, "UTF-8");
                BufferedReader buffread = new BufferedReader(isr);
                /* FIX: Read $Data$ from the console using preferred method BufferedReader.readLine() */
                String s = buffread.readLine();
                IO.writeLine(s); /* Use s */
                /* NOTE: Tools may report a flaw here because buffread and isr are not closed.  Unfortunately, closing those will close System.in, which will cause any future attempts to read from the console to fail and throw an exception */
            }
        }
        else {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */

            /* Read a line of user input from console with deprecated DataInputStream.readLine() method */
            {
                /* FLAW: Read $Data$ from the console using DataInputStream.readLine() */
                DataInputStream dis = new DataInputStream(System.in);
                String s = dis.readLine();

                IO.writeLine(s); /* Use s */

                /* NOTE: Tools may report a flaw here because dis is not closed.  Unfortunately, closing that will close System.in, which will cause any future attempts to read from the console to fail and throw an exception */
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
