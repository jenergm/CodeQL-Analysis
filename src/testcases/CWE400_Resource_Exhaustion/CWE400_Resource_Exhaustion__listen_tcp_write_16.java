/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE400_Resource_Exhaustion__listen_tcp_write_16.java
Label Definition File: CWE400_Resource_Exhaustion.label.xml
Template File: sources-sinks-16.tmpl.java
*/
/*
* @description
* CWE: 400 Resource Exhaustion
* BadSource: listen_tcp Read count using a listening tcp connection
* GoodSource: A hardcoded non-zero, non-min, non-max, even number
* Sinks: write
*    GoodSink: Write to a file count number of times, but first validate count
*    BadSink : Write to a file count number of times
* Flow Variant: 16 Control flow: while(true) and while(local_f)
*
* */

package testcases.CWE400_Resource_Exhaustion;

import testcasesupport.*;

import java.sql.*;
import javax.servlet.http.*;
import java.security.SecureRandom;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.net.Socket;
import java.net.ServerSocket;

import java.util.logging.Level;
import java.util.logging.Logger;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.BufferedWriter;
import java.io.IOException;

import java.util.logging.Level;
import java.util.logging.Logger;

public class CWE400_Resource_Exhaustion__listen_tcp_write_16 extends AbstractTestCase
{

    public void bad() throws Throwable
    {
        int count;
        boolean local_f = false; /* This local variable is used becuase the
		  Java compiler will generate an error on while(false) and similar
		  constructs that evaluate to false.  This is the simplest construct
		  that will always be false and still compile. */

        while(local_f)
        {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
            /* FIX: Use a hardcoded number that won't cause underflow, overflow, divide by zero, or loss-of-precision issues */
            count = 2;
            break;
        }

        while(true)
        {
            count = Integer.MIN_VALUE; /* Initialize count */
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
                    /* POTENTIAL FLAW: Read count using a listening tcp connection */
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
            break;
        }

        while(true)
        {
            File file = new File("badSink.txt");
            FileOutputStream fos = new FileOutputStream(file);
            OutputStreamWriter oswrite = new OutputStreamWriter(fos, "UTF-8");
            BufferedWriter buffwrite = new BufferedWriter(oswrite);
            int i;
            /* POTENTIAL FLAW: Do not validate count before using it as the for loop variant to write to a file */
            for (i = 0; i < count; i++)
            {
                try
                {
                    buffwrite.write("Hello");
                }
                catch (IOException ioe)
                {
                    IO.logger.log(Level.WARNING, "Error with stream writing", ioe);
                }
            }
            /* Close stream reading objects */
            try
            {
                if( buffwrite != null )
                {
                    buffwrite.close();
                }
            }
            catch( IOException ioe )
            {
                IO.logger.log(Level.WARNING, "Error closing BufferedWriter", ioe);
            }
            try
            {
                if( oswrite != null )
                {
                    oswrite.close();
                }
            }
            catch( IOException ioe )
            {
                IO.logger.log(Level.WARNING, "Error closing OutputStreamWriter", ioe);
            }
            try
            {
                if( fos != null )
                {
                    fos.close();
                }
            }
            catch( IOException ioe )
            {
                IO.logger.log(Level.WARNING, "Error closing FileOutputStream", ioe);
            }
            break;
        }

        while(local_f)
        {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
            /* FIX: Validate count before using it as the for loop variant to write to a file */
            if (count > 0 && count <= 20)
            {
                File file = new File("goodSink.txt");
                FileOutputStream fos = new FileOutputStream(file);
                OutputStreamWriter oswrite = new OutputStreamWriter(fos, "UTF-8");
                BufferedWriter buffwrite = new BufferedWriter(oswrite);
                int i;
                for (i = 0; i < count; i++)
                {
                    try
                    {
                        buffwrite.write("Hello");
                    }
                    catch (IOException ioe)
                    {
                        IO.logger.log(Level.WARNING, "Error with stream writing", ioe);
                    }
                }
                /* Close stream reading objects */
                try
                {
                    if( buffwrite != null )
                    {
                        buffwrite.close();
                    }
                }
                catch( IOException ioe )
                {
                    IO.logger.log(Level.WARNING, "Error closing BufferedWriter", ioe);
                }
                try
                {
                    if( oswrite != null )
                    {
                        oswrite.close();
                    }
                }
                catch( IOException ioe )
                {
                    IO.logger.log(Level.WARNING, "Error closing OutputStreamWriter", ioe);
                }
                try
                {
                    if( fos != null )
                    {
                        fos.close();
                    }
                }
                catch( IOException ioe )
                {
                    IO.logger.log(Level.WARNING, "Error closing FileOutputStream", ioe);
                }
            }
            break;
        }
    }

    /* goodG2B() - use goodsource and badsink by changing the conditions on the first and second while statements */
    private void goodG2B() throws Throwable
    {
        int count;
        boolean local_f = false;

        while(true)
        {
            /* FIX: Use a hardcoded number that won't cause underflow, overflow, divide by zero, or loss-of-precision issues */
            count = 2;
            break;
        }

        while(local_f)
        {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
            count = Integer.MIN_VALUE; /* Initialize count */
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
                    /* POTENTIAL FLAW: Read count using a listening tcp connection */
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
            break;
        }

        while(true)
        {
            File file = new File("badSink.txt");
            FileOutputStream fos = new FileOutputStream(file);
            OutputStreamWriter oswrite = new OutputStreamWriter(fos, "UTF-8");
            BufferedWriter buffwrite = new BufferedWriter(oswrite);
            int i;
            /* POTENTIAL FLAW: Do not validate count before using it as the for loop variant to write to a file */
            for (i = 0; i < count; i++)
            {
                try
                {
                    buffwrite.write("Hello");
                }
                catch (IOException ioe)
                {
                    IO.logger.log(Level.WARNING, "Error with stream writing", ioe);
                }
            }
            /* Close stream reading objects */
            try
            {
                if( buffwrite != null )
                {
                    buffwrite.close();
                }
            }
            catch( IOException ioe )
            {
                IO.logger.log(Level.WARNING, "Error closing BufferedWriter", ioe);
            }
            try
            {
                if( oswrite != null )
                {
                    oswrite.close();
                }
            }
            catch( IOException ioe )
            {
                IO.logger.log(Level.WARNING, "Error closing OutputStreamWriter", ioe);
            }
            try
            {
                if( fos != null )
                {
                    fos.close();
                }
            }
            catch( IOException ioe )
            {
                IO.logger.log(Level.WARNING, "Error closing FileOutputStream", ioe);
            }
            break;
        }

        while(local_f)
        {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
            /* FIX: Validate count before using it as the for loop variant to write to a file */
            if (count > 0 && count <= 20)
            {
                File file = new File("goodSink.txt");
                FileOutputStream fos = new FileOutputStream(file);
                OutputStreamWriter oswrite = new OutputStreamWriter(fos, "UTF-8");
                BufferedWriter buffwrite = new BufferedWriter(oswrite);
                int i;
                for (i = 0; i < count; i++)
                {
                    try
                    {
                        buffwrite.write("Hello");
                    }
                    catch (IOException ioe)
                    {
                        IO.logger.log(Level.WARNING, "Error with stream writing", ioe);
                    }
                }
                /* Close stream reading objects */
                try
                {
                    if( buffwrite != null )
                    {
                        buffwrite.close();
                    }
                }
                catch( IOException ioe )
                {
                    IO.logger.log(Level.WARNING, "Error closing BufferedWriter", ioe);
                }
                try
                {
                    if( oswrite != null )
                    {
                        oswrite.close();
                    }
                }
                catch( IOException ioe )
                {
                    IO.logger.log(Level.WARNING, "Error closing OutputStreamWriter", ioe);
                }
                try
                {
                    if( fos != null )
                    {
                        fos.close();
                    }
                }
                catch( IOException ioe )
                {
                    IO.logger.log(Level.WARNING, "Error closing FileOutputStream", ioe);
                }
            }
            break;
        }

    }

    /* goodB2G() - use badsource and goodsink by changing the conditions on the third and fourth while statements */
    private void goodB2G() throws Throwable
    {
        int count;
        boolean local_f = false;

        while(local_f)
        {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
            /* FIX: Use a hardcoded number that won't cause underflow, overflow, divide by zero, or loss-of-precision issues */
            count = 2;
            break;
        }

        while(true)
        {
            count = Integer.MIN_VALUE; /* Initialize count */
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
                    /* POTENTIAL FLAW: Read count using a listening tcp connection */
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
            break;
        }

        while(local_f)
        {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
            File file = new File("badSink.txt");
            FileOutputStream fos = new FileOutputStream(file);
            OutputStreamWriter oswrite = new OutputStreamWriter(fos, "UTF-8");
            BufferedWriter buffwrite = new BufferedWriter(oswrite);
            int i;
            /* POTENTIAL FLAW: Do not validate count before using it as the for loop variant to write to a file */
            for (i = 0; i < count; i++)
            {
                try
                {
                    buffwrite.write("Hello");
                }
                catch (IOException ioe)
                {
                    IO.logger.log(Level.WARNING, "Error with stream writing", ioe);
                }
            }
            /* Close stream reading objects */
            try
            {
                if( buffwrite != null )
                {
                    buffwrite.close();
                }
            }
            catch( IOException ioe )
            {
                IO.logger.log(Level.WARNING, "Error closing BufferedWriter", ioe);
            }
            try
            {
                if( oswrite != null )
                {
                    oswrite.close();
                }
            }
            catch( IOException ioe )
            {
                IO.logger.log(Level.WARNING, "Error closing OutputStreamWriter", ioe);
            }
            try
            {
                if( fos != null )
                {
                    fos.close();
                }
            }
            catch( IOException ioe )
            {
                IO.logger.log(Level.WARNING, "Error closing FileOutputStream", ioe);
            }
            break;
        }

        while(true)
        {
            /* FIX: Validate count before using it as the for loop variant to write to a file */
            if (count > 0 && count <= 20)
            {
                File file = new File("goodSink.txt");
                FileOutputStream fos = new FileOutputStream(file);
                OutputStreamWriter oswrite = new OutputStreamWriter(fos, "UTF-8");
                BufferedWriter buffwrite = new BufferedWriter(oswrite);
                int i;
                for (i = 0; i < count; i++)
                {
                    try
                    {
                        buffwrite.write("Hello");
                    }
                    catch (IOException ioe)
                    {
                        IO.logger.log(Level.WARNING, "Error with stream writing", ioe);
                    }
                }
                /* Close stream reading objects */
                try
                {
                    if( buffwrite != null )
                    {
                        buffwrite.close();
                    }
                }
                catch( IOException ioe )
                {
                    IO.logger.log(Level.WARNING, "Error closing BufferedWriter", ioe);
                }
                try
                {
                    if( oswrite != null )
                    {
                        oswrite.close();
                    }
                }
                catch( IOException ioe )
                {
                    IO.logger.log(Level.WARNING, "Error closing OutputStreamWriter", ioe);
                }
                try
                {
                    if( fos != null )
                    {
                        fos.close();
                    }
                }
                catch( IOException ioe )
                {
                    IO.logger.log(Level.WARNING, "Error closing FileOutputStream", ioe);
                }
            }
            break;
        }
    }

    public void good() throws Throwable
    {
        goodG2B();
        goodB2G();
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
