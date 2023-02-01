/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE760_Predictable_Salt_One_Way_Hash__database_05.java
Label Definition File: CWE760_Predictable_Salt_One_Way_Hash.label.xml
Template File: sources-sinks-05.tmpl.java
*/
/*
* @description
* CWE: 760 Use of one-way hash with a predictable salt
* BadSource: database Read data from a database
* GoodSource: A hardcoded string
* Sinks:
*    GoodSink: use a sufficiently random salt
*    BadSink : SHA512 with a predictable salt
* Flow Variant: 05 Control flow: if(private_t) and if(private_f)
*
* */

package testcases.CWE760_Predictable_Salt_One_Way_Hash;

import testcasesupport.*;

import java.security.GeneralSecurityException;
import java.security.MessageDigest;
import java.security.SecureRandom;

import javax.servlet.http.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

import java.util.logging.Level;
import java.util.logging.Logger;

public class CWE760_Predictable_Salt_One_Way_Hash__database_05 extends AbstractTestCase
{

    /* The two variables below are not defined as "final", but are never
       assigned any other value, so a tool should be able to identify that
       reads of these will always return their initialized values. */
    private boolean private_t = true;
    private boolean private_f = false;

    public void bad() throws Throwable
    {
        String data;
        /* INCIDENTAL: CWE 571 Statement is Always True */
        if(private_t)
        {
            data = ""; /* Initialize data */
            /* Read data from a database */
            {
                Connection conn = null;
                PreparedStatement statement = null;
                ResultSet rs = null;
                try
                {
                    /* setup the connection */
                    conn = IO.getDBConnection();
                    /* prepare and execute a (hardcoded) query */
                    statement = conn.prepareStatement("select name from users where id=0");
                    rs = statement.executeQuery();
                    /* POTENTIAL FLAW: Read data from a database query resultset */
                    data = rs.getString(1);
                }
                catch( SQLException se )
                {
                    IO.logger.log(Level.WARNING, "Error with SQL statement", se);
                }
                finally
                {
                    /* Close database objects */
                    try {
                        if( rs != null )
                        {
                            rs.close();
                        }
                    }
                    catch( SQLException se )
                    {
                        IO.logger.log(Level.WARNING, "Error closing ResultSet", se);
                    }

                    try {
                        if( statement != null )
                        {
                            statement.close();
                        }
                    }
                    catch( SQLException se )
                    {
                        IO.logger.log(Level.WARNING, "Error closing Statement", se);
                    }

                    try {
                        if( conn != null )
                        {
                            conn.close();
                        }
                    }
                    catch( SQLException se)
                    {
                        IO.logger.log(Level.WARNING, "Error closing Connection", se);
                    }
                }
            }
        }
        else {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */

            /* FIX: Use a hardcoded string */
            data = "foo";

        }
        /* INCIDENTAL: CWE 571 Statement is Always True */
        if(private_t)
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

    /* goodG2B1() - use goodsource and badsink by changing first private_t to private_f */
    private void goodG2B1() throws Throwable
    {
        String data;
        /* INCIDENTAL: CWE 570 Statement is Always False */
        if(private_f)
        {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
            data = ""; /* Initialize data */
            /* Read data from a database */
            {
                Connection conn = null;
                PreparedStatement statement = null;
                ResultSet rs = null;
                try
                {
                    /* setup the connection */
                    conn = IO.getDBConnection();
                    /* prepare and execute a (hardcoded) query */
                    statement = conn.prepareStatement("select name from users where id=0");
                    rs = statement.executeQuery();
                    /* POTENTIAL FLAW: Read data from a database query resultset */
                    data = rs.getString(1);
                }
                catch( SQLException se )
                {
                    IO.logger.log(Level.WARNING, "Error with SQL statement", se);
                }
                finally
                {
                    /* Close database objects */
                    try {
                        if( rs != null )
                        {
                            rs.close();
                        }
                    }
                    catch( SQLException se )
                    {
                        IO.logger.log(Level.WARNING, "Error closing ResultSet", se);
                    }

                    try {
                        if( statement != null )
                        {
                            statement.close();
                        }
                    }
                    catch( SQLException se )
                    {
                        IO.logger.log(Level.WARNING, "Error closing Statement", se);
                    }

                    try {
                        if( conn != null )
                        {
                            conn.close();
                        }
                    }
                    catch( SQLException se)
                    {
                        IO.logger.log(Level.WARNING, "Error closing Connection", se);
                    }
                }
            }
        }
        else {

            /* FIX: Use a hardcoded string */
            data = "foo";

        }
        /* INCIDENTAL: CWE 571 Statement is Always True */
        if(private_t)
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

    /* goodG2B2() - use goodsource and badsink by reversing statements in first if */
    private void goodG2B2() throws Throwable
    {
        String data;
        /* INCIDENTAL: CWE 571 Statement is Always True */
        if(private_t)
        {
            /* FIX: Use a hardcoded string */
            data = "foo";
        }
        else {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */

            data = ""; /* Initialize data */

            /* Read data from a database */
            {
                Connection conn = null;
                PreparedStatement statement = null;
                ResultSet rs = null;
                try {
                    /* setup the connection */
                    conn = IO.getDBConnection();

                    /* prepare and execute a (hardcoded) query */
                    statement = conn.prepareStatement("select name from users where id=0");
                    rs = statement.executeQuery();

                    /* POTENTIAL FLAW: Read data from a database query resultset */
                    data = rs.getString(1);
                }
                catch( SQLException se )
                {
                    IO.logger.log(Level.WARNING, "Error with SQL statement", se);
                }
                finally {
                    /* Close database objects */
                    try {
                        if( rs != null )
                        {
                            rs.close();
                        }
                    }
                    catch( SQLException se )
                    {
                        IO.logger.log(Level.WARNING, "Error closing ResultSet", se);
                    }

                    try {
                        if( statement != null )
                        {
                            statement.close();
                        }
                    }
                    catch( SQLException se )
                    {
                        IO.logger.log(Level.WARNING, "Error closing Statement", se);
                    }

                    try {
                        if( conn != null )
                        {
                            conn.close();
                        }
                    }
                    catch( SQLException se)
                    {
                        IO.logger.log(Level.WARNING, "Error closing Connection", se);
                    }
                }
            }

        }
        /* INCIDENTAL: CWE 571 Statement is Always True */
        if(private_t)
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

    /* goodB2G1() - use badsource and goodsink by changing second private_t to private_f */
    private void goodB2G1() throws Throwable
    {
        String data;
        /* INCIDENTAL: CWE 571 Statement is Always True */
        if(private_t)
        {
            data = ""; /* Initialize data */
            /* Read data from a database */
            {
                Connection conn = null;
                PreparedStatement statement = null;
                ResultSet rs = null;
                try
                {
                    /* setup the connection */
                    conn = IO.getDBConnection();
                    /* prepare and execute a (hardcoded) query */
                    statement = conn.prepareStatement("select name from users where id=0");
                    rs = statement.executeQuery();
                    /* POTENTIAL FLAW: Read data from a database query resultset */
                    data = rs.getString(1);
                }
                catch( SQLException se )
                {
                    IO.logger.log(Level.WARNING, "Error with SQL statement", se);
                }
                finally
                {
                    /* Close database objects */
                    try {
                        if( rs != null )
                        {
                            rs.close();
                        }
                    }
                    catch( SQLException se )
                    {
                        IO.logger.log(Level.WARNING, "Error closing ResultSet", se);
                    }

                    try {
                        if( statement != null )
                        {
                            statement.close();
                        }
                    }
                    catch( SQLException se )
                    {
                        IO.logger.log(Level.WARNING, "Error closing Statement", se);
                    }

                    try {
                        if( conn != null )
                        {
                            conn.close();
                        }
                    }
                    catch( SQLException se)
                    {
                        IO.logger.log(Level.WARNING, "Error closing Connection", se);
                    }
                }
            }
        }
        else {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */

            /* FIX: Use a hardcoded string */
            data = "foo";

        }
        /* INCIDENTAL: CWE 570 Statement is Always False */
        if(private_f)
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

    /* goodB2G2() - use badsource and goodsink by reversing statements in second if  */
    private void goodB2G2() throws Throwable
    {
        String data;
        /* INCIDENTAL: CWE 571 Statement is Always True */
        if(private_t)
        {
            data = ""; /* Initialize data */
            /* Read data from a database */
            {
                Connection conn = null;
                PreparedStatement statement = null;
                ResultSet rs = null;
                try
                {
                    /* setup the connection */
                    conn = IO.getDBConnection();
                    /* prepare and execute a (hardcoded) query */
                    statement = conn.prepareStatement("select name from users where id=0");
                    rs = statement.executeQuery();
                    /* POTENTIAL FLAW: Read data from a database query resultset */
                    data = rs.getString(1);
                }
                catch( SQLException se )
                {
                    IO.logger.log(Level.WARNING, "Error with SQL statement", se);
                }
                finally
                {
                    /* Close database objects */
                    try {
                        if( rs != null )
                        {
                            rs.close();
                        }
                    }
                    catch( SQLException se )
                    {
                        IO.logger.log(Level.WARNING, "Error closing ResultSet", se);
                    }

                    try {
                        if( statement != null )
                        {
                            statement.close();
                        }
                    }
                    catch( SQLException se )
                    {
                        IO.logger.log(Level.WARNING, "Error closing Statement", se);
                    }

                    try {
                        if( conn != null )
                        {
                            conn.close();
                        }
                    }
                    catch( SQLException se)
                    {
                        IO.logger.log(Level.WARNING, "Error closing Connection", se);
                    }
                }
            }
        }
        else {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */

            /* FIX: Use a hardcoded string */
            data = "foo";

        }
        /* INCIDENTAL: CWE 571 Statement is Always True */
        if(private_t)
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
