/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE319_Cleartext_Tx_Sensitive_Info__listen_tcp_driverManager_81_goodG2B.java
Label Definition File: CWE319_Cleartext_Tx_Sensitive_Info.label.xml
Template File: sources-sinks-81_goodG2B.tmpl.java
*/
/*
 * @description
 * CWE: 319 Cleartext Transmission of Sensitive Information
 * BadSource: listen_tcp Read password using a listening tcp connection
 * GoodSource: Set password to a hardcoded value (one that was not sent over the network)
 * Sinks: driverManager
 *    GoodSink: Decrypt the password from the source before using it in database connection
 *    BadSink : Use password directly from source in database connection
 * Flow Variant: 81 Data flow: data passed in a parameter to an abstract method
 *
 * */

package testcases.CWE319_Cleartext_Tx_Sensitive_Info;

import testcasesupport.*;
import java.util.logging.Level;
import java.util.logging.Logger;

import java.io.*;
import java.sql.*;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.spec.SecretKeySpec;

import java.util.logging.Level;
import java.util.logging.Logger;

public class CWE319_Cleartext_Tx_Sensitive_Info__listen_tcp_driverManager_81_goodG2B extends CWE319_Cleartext_Tx_Sensitive_Info__listen_tcp_driverManager_81_base
{

    public void action(String password ) throws Throwable
    {

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
