/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE319_Cleartext_Tx_Sensitive_Info__listen_tcp_driverManager_61a.java
Label Definition File: CWE319_Cleartext_Tx_Sensitive_Info.label.xml
Template File: sources-sinks-61a.tmpl.java
*/
/*
 * @description
 * CWE: 319 Cleartext Transmission of Sensitive Information
 * BadSource: listen_tcp Read password using a listening tcp connection
 * GoodSource: Set password to a hardcoded value (one that was not sent over the network)
 * Sinks: driverManager
 *    GoodSink: Decrypt the password from the source before using it in database connection
 *    BadSink : Use password directly from source in database connection
 * Flow Variant: 61 Data flow: data returned from one method to another in different classes in the same package
 *
 * */

package testcases.CWE319_Cleartext_Tx_Sensitive_Info;

import testcasesupport.*;

import java.io.*;
import java.sql.*;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.spec.SecretKeySpec;

import java.util.logging.Level;
import java.util.logging.Logger;

public class CWE319_Cleartext_Tx_Sensitive_Info__listen_tcp_driverManager_61a extends AbstractTestCase
{

    public void bad() throws Throwable
    {
        String password = (new CWE319_Cleartext_Tx_Sensitive_Info__listen_tcp_driverManager_61b()).bad_source();

        Connection conn2 = null;
        PreparedStatement st = null;
        ResultSet rs2 = null;
        try
        {
            /* POTENTIAL FLAW: use password directly in getConnection() */
            conn2 = DriverManager.getConnection("data-url", "root", password);
            st = conn2.prepareStatement("select * from test_table");
            rs2 = st.executeQuery();
        }
        catch(SQLException e)
        {
            IO.logger.log(Level.WARNING, "Error with database connection", e);
        }
        finally
        {
            try
            {
                if( rs2 != null )
                {
                    rs2.close();
                }
            }
            catch( SQLException e )
            {
                IO.logger.log(Level.WARNING, "Error closing ResultSet", e);
            }

            try
            {
                if( st != null )
                {
                    st.close();
                }
            }
            catch( SQLException e )
            {
                IO.logger.log(Level.WARNING, "Error closing PreparedStatement", e);
            }

            try
            {
                if( conn2 != null )
                {
                    conn2.close();
                }
            }
            catch( SQLException e )
            {
                IO.logger.log(Level.WARNING, "Error closing Connection", e);
            }
        }

    }

    public void good() throws Throwable
    {
        goodG2B();
        goodB2G();
    }

    /* goodG2B() - use goodsource and badsink */
    private void goodG2B() throws Throwable
    {
        String password = (new CWE319_Cleartext_Tx_Sensitive_Info__listen_tcp_driverManager_61b()).goodG2B_source();

        Connection conn2 = null;
        PreparedStatement st = null;
        ResultSet rs2 = null;
        try
        {
            /* POTENTIAL FLAW: use password directly in getConnection() */
            conn2 = DriverManager.getConnection("data-url", "root", password);
            st = conn2.prepareStatement("select * from test_table");
            rs2 = st.executeQuery();
        }
        catch(SQLException e)
        {
            IO.logger.log(Level.WARNING, "Error with database connection", e);
        }
        finally
        {
            try
            {
                if( rs2 != null )
                {
                    rs2.close();
                }
            }
            catch( SQLException e )
            {
                IO.logger.log(Level.WARNING, "Error closing ResultSet", e);
            }

            try
            {
                if( st != null )
                {
                    st.close();
                }
            }
            catch( SQLException e )
            {
                IO.logger.log(Level.WARNING, "Error closing PreparedStatement", e);
            }

            try
            {
                if( conn2 != null )
                {
                    conn2.close();
                }
            }
            catch( SQLException e )
            {
                IO.logger.log(Level.WARNING, "Error closing Connection", e);
            }
        }

    }

    /* goodB2G() - use badsource and goodsink */
    private void goodB2G() throws Throwable
    {
        String password = (new CWE319_Cleartext_Tx_Sensitive_Info__listen_tcp_driverManager_61b()).goodB2G_source();

        if (password != null)
        {
            /* FIX: Decrypt password before using in KerberosKey() */
            {
                Cipher aes = Cipher.getInstance("AES");
                KeyGenerator kg = KeyGenerator.getInstance("AES");
                kg.init(128);
                /* INCIDENTAL: CWE-321: Use of Hard-coded Cryptographic Key */
                SecretKeySpec keySpec = new SecretKeySpec("ABCDEFGHABCDEFGH".getBytes("UTF-8"), "AES");
                aes.init(Cipher.DECRYPT_MODE, keySpec);
                password = new String(aes.doFinal(password.getBytes("UTF-8")), "UTF-8");
            }
            Connection conn2 = null;
            PreparedStatement st = null;
            ResultSet rs2 = null;
            try
            {
                /* POTENTIAL FLAW: use password directly in getConnection() */
                conn2 = DriverManager.getConnection("data-url", "root", password);
                st = conn2.prepareStatement("select * from test_table");
                rs2 = st.executeQuery();
            }
            catch(SQLException e)
            {
                IO.logger.log(Level.WARNING, "Error with database connection", e);
            }
            finally
            {
                try
                {
                    if( rs2 != null )
                    {
                        rs2.close();
                    }
                }
                catch( SQLException e )
                {
                    IO.logger.log(Level.WARNING, "Error closing ResultSet", e);
                }

                try
                {
                    if( st != null )
                    {
                        st.close();
                    }
                }
                catch( SQLException e )
                {
                    IO.logger.log(Level.WARNING, "Error closing PreparedStatement", e);
                }

                try
                {
                    if( conn2 != null )
                    {
                        conn2.close();
                    }
                }
                catch( SQLException e )
                {
                    IO.logger.log(Level.WARNING, "Error closing Connection", e);
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
