/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE190_Integer_Overflow__byte_console_readLine_add_73a.java
Label Definition File: CWE190_Integer_Overflow.label.xml
Template File: sources-sinks-73a.tmpl.java
*/
/*
 * @description
 * CWE: 190 Integer Overflow
 * BadSource: console_readLine Read data from the console using readLine
 * GoodSource: A hardcoded non-zero, non-min, non-max, even number
 * Sinks: add
 *    GoodSink: Ensure there will not be an overflow before adding 1 to data
 *    BadSink : Add 1 to data, which can cause an overflow
 * Flow Variant: 73 Data flow: data passed in a LinkedList from one method to another in different source files in the same package
 *
 * */

package testcases.CWE190_Integer_Overflow;

import testcasesupport.*;
import java.util.LinkedList;

import java.sql.*;
import javax.servlet.http.*;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

import java.util.logging.Level;
import java.util.logging.Logger;

public class CWE190_Integer_Overflow__byte_console_readLine_add_73a extends AbstractTestCase
{

    public void bad() throws Throwable
    {
        byte data;

        /* init data */
        data = -1;

        /* POTENTIAL FLAW: Read data from console with readLine*/
        BufferedReader buffread = null;
        InputStreamReader instrread = null;
        try {
            instrread = new InputStreamReader(System.in, "UTF-8");
            buffread = new BufferedReader(instrread);
            String s_data = buffread.readLine();
            if (s_data != null)
            {
                data = Byte.parseByte(s_data.trim());
            }
        }
        catch( IOException ioe )
        {
            IO.logger.log(Level.WARNING, "Error with stream reading", ioe);
        }
        catch( NumberFormatException nfe )
        {
            IO.logger.log(Level.WARNING, "Error with number parsing", nfe);
        }
        finally {
            /* clean up stream reading objects */
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
            finally {
                try {
                    if( instrread != null )
                    {
                        instrread.close();
                    }
                }
                catch( IOException ioe )
                {
                    IO.logger.log(Level.WARNING, "Error closing InputStreamReader", ioe);
                }
            }
        }

        LinkedList<Byte> data_linkedlist = new LinkedList<Byte>();
        data_linkedlist.add(0, data);
        data_linkedlist.add(1, data);
        data_linkedlist.add(2, data);
        (new CWE190_Integer_Overflow__byte_console_readLine_add_73b()).bad_sink(data_linkedlist  );
    }

    public void good() throws Throwable
    {
        goodG2B();
        goodB2G();
    }

    /* goodG2B() - use GoodSource and BadSink */
    private void goodG2B() throws Throwable
    {
        byte data;

        /* FIX: Use a hardcoded number that won't cause underflow, overflow, divide by zero, or loss-of-precision issues */
        data = 2;

        LinkedList<Byte> data_linkedlist = new LinkedList<Byte>();
        data_linkedlist.add(0, data);
        data_linkedlist.add(1, data);
        data_linkedlist.add(2, data);
        (new CWE190_Integer_Overflow__byte_console_readLine_add_73b()).goodG2B_sink(data_linkedlist  );
    }

    /* goodB2G() - use BadSource and GoodSink */
    private void goodB2G() throws Throwable
    {
        byte data;

        /* init data */
        data = -1;

        /* POTENTIAL FLAW: Read data from console with readLine*/
        BufferedReader buffread = null;
        InputStreamReader instrread = null;
        try {
            instrread = new InputStreamReader(System.in, "UTF-8");
            buffread = new BufferedReader(instrread);
            String s_data = buffread.readLine();
            if (s_data != null)
            {
                data = Byte.parseByte(s_data.trim());
            }
        }
        catch( IOException ioe )
        {
            IO.logger.log(Level.WARNING, "Error with stream reading", ioe);
        }
        catch( NumberFormatException nfe )
        {
            IO.logger.log(Level.WARNING, "Error with number parsing", nfe);
        }
        finally {
            /* clean up stream reading objects */
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
            finally {
                try {
                    if( instrread != null )
                    {
                        instrread.close();
                    }
                }
                catch( IOException ioe )
                {
                    IO.logger.log(Level.WARNING, "Error closing InputStreamReader", ioe);
                }
            }
        }

        LinkedList<Byte> data_linkedlist = new LinkedList<Byte>();
        data_linkedlist.add(0, data);
        data_linkedlist.add(1, data);
        data_linkedlist.add(2, data);
        (new CWE190_Integer_Overflow__byte_console_readLine_add_73b()).goodB2G_sink(data_linkedlist  );
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
