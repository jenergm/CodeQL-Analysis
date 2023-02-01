/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE760_Predictable_Salt_One_Way_Hash__connect_tcp_21.java
Label Definition File: CWE760_Predictable_Salt_One_Way_Hash.label.xml
Template File: sources-sinks-21.tmpl.java
*/
/*
 * @description
 * CWE: 760 Use of one-way hash with a predictable salt
 * BadSource: connect_tcp Read data using an outbound tcp connection
 * GoodSource: A hardcoded string
 * Sinks:
 *    GoodSink: use a sufficiently random salt
 *    BadSink : SHA512 with a predictable salt
 * Flow Variant: 21 Control flow: Flow controlled by value of a private variable. All functions contained in one file.
 *
 * */

package testcases.CWE760_Predictable_Salt_One_Way_Hash;

import testcasesupport.*;

import java.security.GeneralSecurityException;
import java.security.MessageDigest;
import java.security.SecureRandom;

import javax.servlet.http.*;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.net.Socket;

import java.util.logging.Level;
import java.util.logging.Logger;

public class CWE760_Predictable_Salt_One_Way_Hash__connect_tcp_21 extends AbstractTestCase
{

    /* The variable below is used to drive control flow in the sink function */
    private boolean bad_private = false;

    public void bad() throws Throwable
    {
        String data;

        data = ""; /* Initialize data */

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

                /* POTENTIAL FLAW: Read data using an outbound tcp connection */
                data = buffread.readLine();
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

        bad_private = true;
        bad_sink(data );
    }

    private void bad_sink(String data ) throws Throwable
    {
        if(bad_private)
        {
            if (data != null)
            {
                MessageDigest hash = MessageDigest.getInstance("SHA-512");
                hash.update(data.getBytes("UTF-8"));  /* POTENTIAL FLAW: SHA512 with a predictable salt */
                byte[] hashv = hash.digest("hash me".getBytes("UTF-8"));
                IO.writeLine(IO.toHex(hashv));
            }
        }
        else {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */

            SecureRandom r = new SecureRandom();

            MessageDigest hash = MessageDigest.getInstance("SHA-512");
            hash.update(r.getSeed(32));  /* FIX: Use a sufficiently random salt */
            byte[] hashv = hash.digest("hash me".getBytes("UTF-8"));

            IO.writeLine(IO.toHex(hashv));

        }
    }

    /* The variables below are used to drive control flow in the sink functions. */
    private boolean goodB2G1_private = false;
    private boolean goodB2G2_private = false;
    private boolean goodG2B_private = false;

    public void good() throws Throwable
    {
        goodB2G1();
        goodB2G2();
        goodG2B();
    }

    /* goodB2G1() - use BadSource and GoodSink by setting the variable to false instead of true */
    private void goodB2G1() throws Throwable
    {
        String data;

        data = ""; /* Initialize data */

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

                /* POTENTIAL FLAW: Read data using an outbound tcp connection */
                data = buffread.readLine();
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

        goodB2G1_private = false;
        goodB2G1_sink(data );
    }

    private void goodB2G1_sink(String data ) throws Throwable
    {
        if(goodB2G1_private)
        {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
            if (data != null)
            {
                MessageDigest hash = MessageDigest.getInstance("SHA-512");
                hash.update(data.getBytes("UTF-8"));  /* POTENTIAL FLAW: SHA512 with a predictable salt */
                byte[] hashv = hash.digest("hash me".getBytes("UTF-8"));
                IO.writeLine(IO.toHex(hashv));
            }
        }
        else {

            SecureRandom r = new SecureRandom();

            MessageDigest hash = MessageDigest.getInstance("SHA-512");
            hash.update(r.getSeed(32));  /* FIX: Use a sufficiently random salt */
            byte[] hashv = hash.digest("hash me".getBytes("UTF-8"));

            IO.writeLine(IO.toHex(hashv));

        }
    }

    /* goodB2G2() - use BadSource and GoodSink by reversing the blocks in the if in the sink function */
    private void goodB2G2() throws Throwable
    {
        String data;

        data = ""; /* Initialize data */

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

                /* POTENTIAL FLAW: Read data using an outbound tcp connection */
                data = buffread.readLine();
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

        goodB2G2_private = true;
        goodB2G2_sink(data );
    }

    private void goodB2G2_sink(String data ) throws Throwable
    {
        if(goodB2G2_private)
        {
            SecureRandom r = new SecureRandom();
            MessageDigest hash = MessageDigest.getInstance("SHA-512");
            hash.update(r.getSeed(32));  /* FIX: Use a sufficiently random salt */
            byte[] hashv = hash.digest("hash me".getBytes("UTF-8"));
            IO.writeLine(IO.toHex(hashv));
        }
        else {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */

            if (data != null)
            {
                MessageDigest hash = MessageDigest.getInstance("SHA-512");
                hash.update(data.getBytes("UTF-8"));  /* POTENTIAL FLAW: SHA512 with a predictable salt */
                byte[] hashv = hash.digest("hash me".getBytes("UTF-8"));
                IO.writeLine(IO.toHex(hashv));
            }

        }
    }

    /* goodG2B() - use GoodSource and BadSink */
    private void goodG2B() throws Throwable
    {
        String data;

        /* FIX: Use a hardcoded string */
        data = "foo";

        goodG2B_private = true;
        goodG2B_sink(data );
    }

    private void goodG2B_sink(String data ) throws Throwable
    {
        if(goodG2B_private)
        {
            if (data != null)
            {
                MessageDigest hash = MessageDigest.getInstance("SHA-512");
                hash.update(data.getBytes("UTF-8"));  /* POTENTIAL FLAW: SHA512 with a predictable salt */
                byte[] hashv = hash.digest("hash me".getBytes("UTF-8"));
                IO.writeLine(IO.toHex(hashv));
            }
        }
        else {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */

            SecureRandom r = new SecureRandom();

            MessageDigest hash = MessageDigest.getInstance("SHA-512");
            hash.update(r.getSeed(32));  /* FIX: Use a sufficiently random salt */
            byte[] hashv = hash.digest("hash me".getBytes("UTF-8"));

            IO.writeLine(IO.toHex(hashv));

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
