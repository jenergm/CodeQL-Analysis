/*
 * @description An object contains sensitive data and is implicitly serializable
 *  
 * This class contains the "good" version, which prohibits serialization by
 * overriding the function writeObject.  
 * There is no need to implement the bad() and good() methods in this test case.
 * 
 * */

package testcases.CWE499_Sensitive_Data_Serializable;

import java.sql.*;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import testcasesupport.*;

/* We would never expect to see a real class like this, but our implementation tries to ensure the fact
 * that one of the fields is sensitive */
public class CWE499_Sensitive_Data_Serializable__serializable_01_good1 extends AbstractTestCaseClassIssueGood
{
	/* Sensitive field */
	private String pw_hash;
	
	protected void setPassword(String pw)
	{
		pw_hash = pw;
	}
	
	protected String getPassword()
	{
		return pw_hash;
	}

    protected void withdraw(float amount) throws SQLException 
    {
		if (pw_hash != null)
		{
			Connection conn = DriverManager.getConnection("192.168.39.10", "sa", pw_hash);
		
			/* etc */
		
			/* close connection */
			if (conn != null)
			{
				try
				{	
					conn.close();
				} 
				catch( Exception e )
				{
					IO.logger.log(Level.WARNING, "Error closing Connection", e);
				}
			}
		} 
		else 
		{
			IO.logger.log(Level.WARNING, "Invalid password.");
		}
    }

    /* FIX: Override writeObject() and readObject() methods to deny serialization attempts */
    private final void writeObject(ObjectOutputStream out) throws IOException 
    {
        throw new NotSerializableException();
    }
	
	private final void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException 
    {
        throw new NotSerializableException();
    }

    private void good1() { }
    
    public void good() 
    {
        good1();
    }

		
	/* Below is the main(). It is only used when building this testcase on 
	   its own for testing or for building a binary to use in testing binary 
	   analysis tools. It is not used when compiling all the testcases as one 
	   application, which is how source code analysis tools are tested. */ 
	public static void main(String[] args) 
		throws ClassNotFoundException, InstantiationException, IllegalAccessException 
	{
		mainFromParent(args);
	}

}
