/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE400_Resource_Exhaustion__connect_tcp_for_loop_72a.java
Label Definition File: CWE400_Resource_Exhaustion.label.xml
Template File: sources-sinks-72a.tmpl.java
*/
/*
 * @description
 * CWE: 400 Resource Exhaustion
 * BadSource: connect_tcp Read count using an outbound tcp connection
 * GoodSource: A hardcoded non-zero, non-min, non-max, even number
 * Sinks: for_loop
 *    GoodSink: Validate count before using it as the loop variant in a for loop
 *    BadSink : Use count as the loop variant in a for loop
 * Flow Variant: 72 Data flow: data passed in a Vector from one method to another in different source files in the same package
 *
 * */

package testcases.CWE400_Resource_Exhaustion;

import testcasesupport.*;
import java.util.Vector;

import java.sql.*;
import javax.servlet.http.*;
import java.security.SecureRandom;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.net.Socket;

import java.util.logging.Level;
import java.util.logging.Logger;

public class CWE400_Resource_Exhaustion__connect_tcp_for_loop_72a extends AbstractTestCase
{

    public void bad() throws Throwable
    {
        int count;

        count = Integer.MIN_VALUE; /* Initialize count */

        /* Read data using an outbound tcp connection */
        {
            Socket sock = null;
            BufferedReader buffread = null;
            InputStreamReader instrread = null;
            try {
                /* Read data using an outbound tcp connection */
                sock = new Socket("host.example.org", 39544);

                /* read input from socket */

                instrread = new InputStreamReader(sock.getInputStream(), "UTF-8");
                buffread = new BufferedReader(instrread);

                /* POTENTIAL FLAW: Read count using an outbound tcp connection */
                String s_count = buffread.readLine();
                if (s_count != null)  // avoid NPD incidental warnings
                {
                    try
                    {
                        count = Integer.parseInt(s_count.trim());
                    }
                    catch(NumberFormatException nfe)
                    {
                        IO.logger.log(Level.WARNING, "Number format exception parsing count from string", nfe);
                    }
                }

            }
            catch( IOException ioe )
            {
                IO.logger.log(Level.WARNING, "Error with stream reading", ioe);
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

                /* clean up socket objects */
                try {
                    if( sock != null )
                    {
                        sock.close();
                    }
                }
                catch( IOException e )
                {
                    IO.logger.log(Level.WARNING, "Error closing Socket", e);
                }
            }
        }

        Vector<Integer> count_vector = new Vector<Integer>(5);
        count_vector.add(0, count);
        count_vector.add(1, count);
        count_vector.add(2, count);
        (new CWE400_Resource_Exhaustion__connect_tcp_for_loop_72b()).bad_sink(count_vector  );
    }

    public void good() throws Throwable
    {
        goodG2B();
        goodB2G();
    }

    /* goodG2B() - use GoodSource and BadSink */
    private void goodG2B() throws Throwable
    {
        int count;

        /* FIX: Use a hardcoded number that won't cause underflow, overflow, divide by zero, or loss-of-precision issues */
        count = 2;

        Vector<Integer> count_vector = new Vector<Integer>(5);
        count_vector.add(0, count);
        count_vector.add(1, count);
        count_vector.add(2, count);
        (new CWE400_Resource_Exhaustion__connect_tcp_for_loop_72b()).goodG2B_sink(count_vector  );
    }

    /* goodB2G() - use BadSource and GoodSink */
    private void goodB2G() throws Throwable
    {
        int count;

        count = Integer.MIN_VALUE; /* Initialize count */

        /* Read data using an outbound tcp connection */
        {
            Socket sock = null;
            BufferedReader buffread = null;
            InputStreamReader instrread = null;
            try {
                /* Read data using an outbound tcp connection */
                sock = new Socket("host.example.org", 39544);

                /* read input from socket */

                instrread = new InputStreamReader(sock.getInputStream(), "UTF-8");
                buffread = new BufferedReader(instrread);

                /* POTENTIAL FLAW: Read count using an outbound tcp connection */
                String s_count = buffread.readLine();
                if (s_count != null)  // avoid NPD incidental warnings
                {
                    try
                    {
                        count = Integer.parseInt(s_count.trim());
                    }
                    catch(NumberFormatException nfe)
                    {
                        IO.logger.log(Level.WARNING, "Number format exception parsing count from string", nfe);
                    }
                }

            }
            catch( IOException ioe )
            {
                IO.logger.log(Level.WARNING, "Error with stream reading", ioe);
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

                /* clean up socket objects */
                try {
                    if( sock != null )
                    {
                        sock.close();
                    }
                }
                catch( IOException e )
                {
                    IO.logger.log(Level.WARNING, "Error closing Socket", e);
                }
            }
        }

        Vector<Integer> count_vector = new Vector<Integer>(5);
        count_vector.add(0, count);
        count_vector.add(1, count);
        count_vector.add(2, count);
        (new CWE400_Resource_Exhaustion__connect_tcp_for_loop_72b()).goodB2G_sink(count_vector  );
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
