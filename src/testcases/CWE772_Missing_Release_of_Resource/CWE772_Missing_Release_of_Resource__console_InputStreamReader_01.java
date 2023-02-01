/*
 * @description Missing Release of Resource After Effective Lifetime.  Performs some, but not all, necessary resource cleanup (InputStreamReader is not closed).
 * 
 * */

package testcases.CWE772_Missing_Release_of_Resource;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

import java.util.logging.Level;
import java.util.logging.Logger;

import testcasesupport.AbstractTestCase;
import testcasesupport.IO;

public class CWE772_Missing_Release_of_Resource__console_InputStreamReader_01
		extends AbstractTestCase 
{	
    public void bad()
	{
		BufferedReader buffread = null;
		InputStreamReader instrread = null;
		try
		{
			instrread = new InputStreamReader(System.in, "UTF-8");
			buffread = new BufferedReader(instrread);
	        String readString = buffread.readLine();
	        
	        IO.writeLine(readString);
		}
		catch(UnsupportedEncodingException uee)
        {
            IO.logger.log(Level.WARNING, "Encoding is not supported!", uee);
        }
		catch(IOException e)
		{
            IO.logger.log(Level.WARNING, "Error with stream reading", e);
		}
		
		/* FLAW: Streams are not closed */
	}
	
	private void good1() 
	{		
		BufferedReader buffread = null;
		InputStreamReader instrread = null;
		try
		{
			instrread = new InputStreamReader(System.in, "UTF-8");
			buffread = new BufferedReader(instrread);
	        String readString = buffread.readLine();
	        
	        IO.writeLine(readString);
		}
		catch(UnsupportedEncodingException uee)
        {
            IO.logger.log(Level.WARNING, "Encoding is not supported!", uee);
        }
		catch(IOException e)
		{
            IO.logger.log(Level.WARNING, "Error with stream reading", e);
		}
		/* FIX: Streams closed appropriately */
		finally
		{
            try
            {
                if (buffread != null)
                {
                    buffread.close();
                }
            }
            catch(IOException e )
            {
                IO.logger.log(Level.WARNING, "Error closing BufferedReader", e);
            }

			try 
			{
				if (instrread != null ) 
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
	
	public void good() throws IOException 
	{
        good1();
    }

	/* Below is the main(). It is only used when building this testcase on 
	   its own for testing or for building a binary to use in testing binary 
	   analysis tools. It is not used when compiling all the testcases as one 
	   application, which is how source code analysis tools are tested. */ 
	public static void main(String[] args) throws ClassNotFoundException,
			InstantiationException, IllegalAccessException {
		mainFromParent(args);
	}
}
