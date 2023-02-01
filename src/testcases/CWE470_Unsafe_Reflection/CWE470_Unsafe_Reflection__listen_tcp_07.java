/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE470_Unsafe_Reflection__listen_tcp_07.java
Label Definition File: CWE470_Unsafe_Reflection.label.xml
Template File: sources-sink-07.tmpl.java
*/
/*
* @description
* CWE: 470 Use of Externally-Controlled Input to Select Classes or Code ('Unsafe Reflection')
* BadSource: listen_tcp Read data using a listening tcp connection
* GoodSource: Set data to a hardcoded class name
* BadSink:  Instantiate class named in data
* Flow Variant: 07 Control flow: if(private_five==5) and if(private_five!=5)
*
* */

package testcases.CWE470_Unsafe_Reflection;

import testcasesupport.*;

import javax.servlet.http.*;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.net.Socket;
import java.net.ServerSocket;

import java.util.logging.Level;
import java.util.logging.Logger;

public class CWE470_Unsafe_Reflection__listen_tcp_07 extends AbstractTestCase
{

    /* The variable below is not declared "final", but is never assigned
       any other value so a tool should be able to identify that reads of
       this will always give its initialized value. */
    private int private_five = 5;

    /* uses badsource and badsink */
    public void bad() throws Throwable
    {
        String data;
        if(private_five == 5)
        {
            data = ""; /* Initialize data */
            /* Read data using a listening tcp connection */
            {
                ServerSocket listener = null;
                Socket sock = null;
                BufferedReader buffread = null;
                InputStreamReader instrread = null;
                try
                {
                    /* read input from socket */
                    listener = new ServerSocket(39543);
                    sock = listener.accept();
                    instrread = new InputStreamReader(sock.getInputStream(), "UTF-8");
                    buffread = new BufferedReader(instrread);
                    /* POTENTIAL FLAW: Read data using a listening tcp connection */
                    data = buffread.readLine();
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
                        if( instrread != null )
                        {
                            instrread.close();
                        }
                    }
                    catch( IOException ioe )
                    {
                        IO.logger.log(Level.WARNING, "Error closing InputStreamReader", ioe);
                    }

                    /* Close socket objects */
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

                    try {
                        if( listener != null )
                        {
                            listener.close();
                        }
                    }
                    catch( IOException e )
                    {
                        IO.logger.log(Level.WARNING, "Error closing ServerSocket", e);
                    }
                }
            }
        }
        else {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */

            /* FIX: Use a hardcoded class name */
            data = "Testing.test";

        }

        /* POTENTIAL FLAW: Instantiate object of class named in data (which may be from external input) */
        Class<?> c = Class.forName(data);
        Object instance = c.newInstance();

        IO.writeLine(instance.toString()); /* Use instance in some way */

    }

    /* goodG2B1() - use goodsource and badsink by changing private_five==5 to private_five!=5 */
    private void goodG2B1() throws Throwable
    {
        String data;
        if(private_five != 5)
        {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
            data = ""; /* Initialize data */
            /* Read data using a listening tcp connection */
            {
                ServerSocket listener = null;
                Socket sock = null;
                BufferedReader buffread = null;
                InputStreamReader instrread = null;
                try
                {
                    /* read input from socket */
                    listener = new ServerSocket(39543);
                    sock = listener.accept();
                    instrread = new InputStreamReader(sock.getInputStream(), "UTF-8");
                    buffread = new BufferedReader(instrread);
                    /* POTENTIAL FLAW: Read data using a listening tcp connection */
                    data = buffread.readLine();
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
                        if( instrread != null )
                        {
                            instrread.close();
                        }
                    }
                    catch( IOException ioe )
                    {
                        IO.logger.log(Level.WARNING, "Error closing InputStreamReader", ioe);
                    }

                    /* Close socket objects */
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

                    try {
                        if( listener != null )
                        {
                            listener.close();
                        }
                    }
                    catch( IOException e )
                    {
                        IO.logger.log(Level.WARNING, "Error closing ServerSocket", e);
                    }
                }
            }
        }
        else {

            /* FIX: Use a hardcoded class name */
            data = "Testing.test";

        }

        /* POTENTIAL FLAW: Instantiate object of class named in data (which may be from external input) */
        Class<?> c = Class.forName(data);
        Object instance = c.newInstance();

        IO.writeLine(instance.toString()); /* Use instance in some way */

    }

    /* goodG2B2() - use goodsource and badsink by reversing statements in if */
    private void goodG2B2() throws Throwable
    {
        String data;
        if(private_five == 5)
        {
            /* FIX: Use a hardcoded class name */
            data = "Testing.test";
        }
        else {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */

            data = ""; /* Initialize data */

            /* Read data using a listening tcp connection */
            {
                ServerSocket listener = null;
                Socket sock = null;
                BufferedReader buffread = null;
                InputStreamReader instrread = null;

                try {
                    /* read input from socket */
                    listener = new ServerSocket(39543);
                    sock = listener.accept();

                    instrread = new InputStreamReader(sock.getInputStream(), "UTF-8");
                    buffread = new BufferedReader(instrread);

                    /* POTENTIAL FLAW: Read data using a listening tcp connection */
                    data = buffread.readLine();
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
                        if( instrread != null )
                        {
                            instrread.close();
                        }
                    }
                    catch( IOException ioe )
                    {
                        IO.logger.log(Level.WARNING, "Error closing InputStreamReader", ioe);
                    }

                    /* Close socket objects */
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

                    try {
                        if( listener != null )
                        {
                            listener.close();
                        }
                    }
                    catch( IOException e )
                    {
                        IO.logger.log(Level.WARNING, "Error closing ServerSocket", e);
                    }
                }
            }

        }

        /* POTENTIAL FLAW: Instantiate object of class named in data (which may be from external input) */
        Class<?> c = Class.forName(data);
        Object instance = c.newInstance();

        IO.writeLine(instance.toString()); /* Use instance in some way */

    }

    public void good() throws Throwable
    {
        goodG2B1();
        goodG2B2();
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
