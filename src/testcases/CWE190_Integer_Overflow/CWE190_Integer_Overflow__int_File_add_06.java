/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE190_Integer_Overflow__int_File_add_06.java
Label Definition File: CWE190_Integer_Overflow__int.label.xml
Template File: sources-sinks-06.tmpl.java
*/
/*
* @description
* CWE: 190 Integer Overflow
* BadSource: File Read data from file (named c:\data.txt)
* GoodSource: A hardcoded non-zero, non-min, non-max, even number
* Sinks: add
*    GoodSink: Ensure there will not be an overflow before adding 1 to data
*    BadSink : Add 1 to data, which can cause an overflow
* Flow Variant: 06 Control flow: if(private_final_five==5) and if(private_final_five!=5)
*
* */

package testcases.CWE190_Integer_Overflow;

import testcasesupport.*;

import java.sql.*;
import javax.servlet.http.*;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.FileInputStream;
import java.io.File;
import java.io.IOException;

import java.util.logging.Level;
import java.util.logging.Logger;

public class CWE190_Integer_Overflow__int_File_add_06 extends AbstractTestCase
{

    /* The variable below is declared "final", so a tool should be able
       to identify that reads of this will always give its initialized
       value. */
    private final int private_final_five = 5;

    public void bad() throws Throwable
    {
        int data;
        /* INCIDENTAL: CWE 571 Statement is Always True */
        if(private_final_five==5)
        {
            data = Integer.MIN_VALUE; /* Initialize data */
            {
                File f = new File("C:\\data.txt");
                FileInputStream fis = null;
                InputStreamReader isread = null;
                BufferedReader buffread = null;
                try
                {
                    /* read string from file into data */
                    fis = new FileInputStream(f);
                    isread = new InputStreamReader(fis, "UTF-8");
                    buffread = new BufferedReader(isread);
                    /* POTENTIAL FLAW: Read data from a file */
                    String s_data = buffread.readLine(); // This will be reading the first "line" of the file, which
                    // could be very long if there are little or no newlines in the file
                    if (s_data != null)  // avoid NPD incidental warnings
                    {
                        try
                        {
                            data = Integer.parseInt(s_data.trim());
                        }
                        catch(NumberFormatException nfe)
                        {
                            IO.logger.log(Level.WARNING, "Number format exception parsing data from string", nfe);
                        }
                    }
                }
                catch( IOException ioe )
                {
                    IO.logger.log(Level.WARNING, "Error with stream reading", ioe);
                }
                finally
                {
                    /* Close stream reading objects */
                    try {
                        if( buffread != null )
                        {
                            buffread.close();
                        }
                    }
                    catch( IOException ioe )
                    {
                        IO.logger.log(Level.WARNING, "Error closing BufferedReader", ioe);
                    }

                    try {
                        if( isread != null )
                        {
                            isread.close();
                        }
                    }
                    catch( IOException ioe )
                    {
                        IO.logger.log(Level.WARNING, "Error closing InputStreamReader", ioe);
                    }

                    try {
                        if( fis != null )
                        {
                            fis.close();
                        }
                    }
                    catch( IOException ioe )
                    {
                        IO.logger.log(Level.WARNING, "Error closing FileInputStream", ioe);
                    }
                }
            }
        }
        else {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */

            /* FIX: Use a hardcoded number that won't cause underflow, overflow, divide by zero, or loss-of-precision issues */
            data = 2;

        }
        /* INCIDENTAL: CWE 571 Statement is Always True */
        if(private_final_five==5)
        {
            /* POTENTIAL FLAW: if data == Integer.MAX_VALUE, this will overflow */
            int result = (int)(data + 1);
            IO.writeLine("result: " + result);
        }
        else {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */

            /* FIX: Add a check to prevent an overflow from occurring */
            if (data < Integer.MAX_VALUE)
            {
                int result = (int)(data + 1);
                IO.writeLine("result: " + result);
            }
            else {
                IO.writeLine("data value is too large to perform addition.");
            }

        }

    }

    /* goodG2B1() - use goodsource and badsink by changing first private_final_five==5 to private_final_five!=5 */
    private void goodG2B1() throws Throwable
    {
        int data;
        /* INCIDENTAL: CWE 570 Statement is Always False */
        if(private_final_five!=5)
        {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
            data = Integer.MIN_VALUE; /* Initialize data */
            {
                File f = new File("C:\\data.txt");
                FileInputStream fis = null;
                InputStreamReader isread = null;
                BufferedReader buffread = null;
                try
                {
                    /* read string from file into data */
                    fis = new FileInputStream(f);
                    isread = new InputStreamReader(fis, "UTF-8");
                    buffread = new BufferedReader(isread);
                    /* POTENTIAL FLAW: Read data from a file */
                    String s_data = buffread.readLine(); // This will be reading the first "line" of the file, which
                    // could be very long if there are little or no newlines in the file
                    if (s_data != null)  // avoid NPD incidental warnings
                    {
                        try
                        {
                            data = Integer.parseInt(s_data.trim());
                        }
                        catch(NumberFormatException nfe)
                        {
                            IO.logger.log(Level.WARNING, "Number format exception parsing data from string", nfe);
                        }
                    }
                }
                catch( IOException ioe )
                {
                    IO.logger.log(Level.WARNING, "Error with stream reading", ioe);
                }
                finally
                {
                    /* Close stream reading objects */
                    try {
                        if( buffread != null )
                        {
                            buffread.close();
                        }
                    }
                    catch( IOException ioe )
                    {
                        IO.logger.log(Level.WARNING, "Error closing BufferedReader", ioe);
                    }

                    try {
                        if( isread != null )
                        {
                            isread.close();
                        }
                    }
                    catch( IOException ioe )
                    {
                        IO.logger.log(Level.WARNING, "Error closing InputStreamReader", ioe);
                    }

                    try {
                        if( fis != null )
                        {
                            fis.close();
                        }
                    }
                    catch( IOException ioe )
                    {
                        IO.logger.log(Level.WARNING, "Error closing FileInputStream", ioe);
                    }
                }
            }
        }
        else {

            /* FIX: Use a hardcoded number that won't cause underflow, overflow, divide by zero, or loss-of-precision issues */
            data = 2;

        }
        /* INCIDENTAL: CWE 571 Statement is Always True */
        if(private_final_five==5)
        {
            /* POTENTIAL FLAW: if data == Integer.MAX_VALUE, this will overflow */
            int result = (int)(data + 1);
            IO.writeLine("result: " + result);
        }
        else {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */

            /* FIX: Add a check to prevent an overflow from occurring */
            if (data < Integer.MAX_VALUE)
            {
                int result = (int)(data + 1);
                IO.writeLine("result: " + result);
            }
            else {
                IO.writeLine("data value is too large to perform addition.");
            }

        }
    }

    /* goodG2B2() - use goodsource and badsink by reversing statements in first if */
    private void goodG2B2() throws Throwable
    {
        int data;
        /* INCIDENTAL: CWE 571 Statement is Always True */
        if(private_final_five==5)
        {
            /* FIX: Use a hardcoded number that won't cause underflow, overflow, divide by zero, or loss-of-precision issues */
            data = 2;
        }
        else {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */

            data = Integer.MIN_VALUE; /* Initialize data */
            {
                File f = new File("C:\\data.txt");
                FileInputStream fis = null;
                InputStreamReader isread = null;
                BufferedReader buffread = null;

                try {
                    /* read string from file into data */
                    fis = new FileInputStream(f);
                    isread = new InputStreamReader(fis, "UTF-8");
                    buffread = new BufferedReader(isread);

                    /* POTENTIAL FLAW: Read data from a file */
                    String s_data = buffread.readLine(); // This will be reading the first "line" of the file, which
                    // could be very long if there are little or no newlines in the file
                    if (s_data != null)  // avoid NPD incidental warnings
                    {
                        try
                        {
                            data = Integer.parseInt(s_data.trim());
                        }
                        catch(NumberFormatException nfe)
                        {
                            IO.logger.log(Level.WARNING, "Number format exception parsing data from string", nfe);
                        }
                    }
                }
                catch( IOException ioe )
                {
                    IO.logger.log(Level.WARNING, "Error with stream reading", ioe);
                }
                finally {
                    /* Close stream reading objects */
                    try {
                        if( buffread != null )
                        {
                            buffread.close();
                        }
                    }
                    catch( IOException ioe )
                    {
                        IO.logger.log(Level.WARNING, "Error closing BufferedReader", ioe);
                    }

                    try {
                        if( isread != null )
                        {
                            isread.close();
                        }
                    }
                    catch( IOException ioe )
                    {
                        IO.logger.log(Level.WARNING, "Error closing InputStreamReader", ioe);
                    }

                    try {
                        if( fis != null )
                        {
                            fis.close();
                        }
                    }
                    catch( IOException ioe )
                    {
                        IO.logger.log(Level.WARNING, "Error closing FileInputStream", ioe);
                    }
                }
            }

        }
        /* INCIDENTAL: CWE 571 Statement is Always True */
        if(private_final_five==5)
        {
            /* POTENTIAL FLAW: if data == Integer.MAX_VALUE, this will overflow */
            int result = (int)(data + 1);
            IO.writeLine("result: " + result);
        }
        else {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */

            /* FIX: Add a check to prevent an overflow from occurring */
            if (data < Integer.MAX_VALUE)
            {
                int result = (int)(data + 1);
                IO.writeLine("result: " + result);
            }
            else {
                IO.writeLine("data value is too large to perform addition.");
            }

        }
    }

    /* goodB2G1() - use badsource and goodsink by changing second private_final_five==5 to private_final_five!=5 */
    private void goodB2G1() throws Throwable
    {
        int data;
        /* INCIDENTAL: CWE 571 Statement is Always True */
        if(private_final_five==5)
        {
            data = Integer.MIN_VALUE; /* Initialize data */
            {
                File f = new File("C:\\data.txt");
                FileInputStream fis = null;
                InputStreamReader isread = null;
                BufferedReader buffread = null;
                try
                {
                    /* read string from file into data */
                    fis = new FileInputStream(f);
                    isread = new InputStreamReader(fis, "UTF-8");
                    buffread = new BufferedReader(isread);
                    /* POTENTIAL FLAW: Read data from a file */
                    String s_data = buffread.readLine(); // This will be reading the first "line" of the file, which
                    // could be very long if there are little or no newlines in the file
                    if (s_data != null)  // avoid NPD incidental warnings
                    {
                        try
                        {
                            data = Integer.parseInt(s_data.trim());
                        }
                        catch(NumberFormatException nfe)
                        {
                            IO.logger.log(Level.WARNING, "Number format exception parsing data from string", nfe);
                        }
                    }
                }
                catch( IOException ioe )
                {
                    IO.logger.log(Level.WARNING, "Error with stream reading", ioe);
                }
                finally
                {
                    /* Close stream reading objects */
                    try {
                        if( buffread != null )
                        {
                            buffread.close();
                        }
                    }
                    catch( IOException ioe )
                    {
                        IO.logger.log(Level.WARNING, "Error closing BufferedReader", ioe);
                    }

                    try {
                        if( isread != null )
                        {
                            isread.close();
                        }
                    }
                    catch( IOException ioe )
                    {
                        IO.logger.log(Level.WARNING, "Error closing InputStreamReader", ioe);
                    }

                    try {
                        if( fis != null )
                        {
                            fis.close();
                        }
                    }
                    catch( IOException ioe )
                    {
                        IO.logger.log(Level.WARNING, "Error closing FileInputStream", ioe);
                    }
                }
            }
        }
        else {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */

            /* FIX: Use a hardcoded number that won't cause underflow, overflow, divide by zero, or loss-of-precision issues */
            data = 2;

        }
        /* INCIDENTAL: CWE 570 Statement is Always False */
        if(private_final_five!=5)
        {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
            /* POTENTIAL FLAW: if data == Integer.MAX_VALUE, this will overflow */
            int result = (int)(data + 1);
            IO.writeLine("result: " + result);
        }
        else {

            /* FIX: Add a check to prevent an overflow from occurring */
            if (data < Integer.MAX_VALUE)
            {
                int result = (int)(data + 1);
                IO.writeLine("result: " + result);
            }
            else {
                IO.writeLine("data value is too large to perform addition.");
            }

        }
    }

    /* goodB2G2() - use badsource and goodsink by reversing statements in second if  */
    private void goodB2G2() throws Throwable
    {
        int data;
        /* INCIDENTAL: CWE 571 Statement is Always True */
        if(private_final_five==5)
        {
            data = Integer.MIN_VALUE; /* Initialize data */
            {
                File f = new File("C:\\data.txt");
                FileInputStream fis = null;
                InputStreamReader isread = null;
                BufferedReader buffread = null;
                try
                {
                    /* read string from file into data */
                    fis = new FileInputStream(f);
                    isread = new InputStreamReader(fis, "UTF-8");
                    buffread = new BufferedReader(isread);
                    /* POTENTIAL FLAW: Read data from a file */
                    String s_data = buffread.readLine(); // This will be reading the first "line" of the file, which
                    // could be very long if there are little or no newlines in the file
                    if (s_data != null)  // avoid NPD incidental warnings
                    {
                        try
                        {
                            data = Integer.parseInt(s_data.trim());
                        }
                        catch(NumberFormatException nfe)
                        {
                            IO.logger.log(Level.WARNING, "Number format exception parsing data from string", nfe);
                        }
                    }
                }
                catch( IOException ioe )
                {
                    IO.logger.log(Level.WARNING, "Error with stream reading", ioe);
                }
                finally
                {
                    /* Close stream reading objects */
                    try {
                        if( buffread != null )
                        {
                            buffread.close();
                        }
                    }
                    catch( IOException ioe )
                    {
                        IO.logger.log(Level.WARNING, "Error closing BufferedReader", ioe);
                    }

                    try {
                        if( isread != null )
                        {
                            isread.close();
                        }
                    }
                    catch( IOException ioe )
                    {
                        IO.logger.log(Level.WARNING, "Error closing InputStreamReader", ioe);
                    }

                    try {
                        if( fis != null )
                        {
                            fis.close();
                        }
                    }
                    catch( IOException ioe )
                    {
                        IO.logger.log(Level.WARNING, "Error closing FileInputStream", ioe);
                    }
                }
            }
        }
        else {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */

            /* FIX: Use a hardcoded number that won't cause underflow, overflow, divide by zero, or loss-of-precision issues */
            data = 2;

        }
        /* INCIDENTAL: CWE 571 Statement is Always True */
        if(private_final_five==5)
        {
            /* FIX: Add a check to prevent an overflow from occurring */
            if (data < Integer.MAX_VALUE)
            {
                int result = (int)(data + 1);
                IO.writeLine("result: " + result);
            }
            else
            {
                IO.writeLine("data value is too large to perform addition.");
            }
        }
        else {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */

            /* POTENTIAL FLAW: if data == Integer.MAX_VALUE, this will overflow */
            int result = (int)(data + 1);

            IO.writeLine("result: " + result);

        }
    }

    public void good() throws Throwable
    {
        goodG2B1();
        goodG2B2();
        goodB2G1();
        goodB2G2();
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
