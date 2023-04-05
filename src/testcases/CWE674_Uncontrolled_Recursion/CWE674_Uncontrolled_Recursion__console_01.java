/*
 * @description uncontrolled recursion due to missing base or exit case
 *
 * */

package testcases.CWE674_Uncontrolled_Recursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;

import java.util.logging.Level;
import java.util.logging.Logger;

import testcasesupport.AbstractTestCase;
import testcasesupport.IO;

public class CWE674_Uncontrolled_Recursion__console_01 extends AbstractTestCase 
{

	private static long recursion_bad(long n)
	{
		/* FLAW: Missing base case */
		long ret = n + recursion_bad(n-1);
		return ret;
	}
	
	public void bad()
    {
        BufferedReader bufread2 = null;
        InputStreamReader inread2 = null;
		int num = 0;
        try
        {
            inread2 = new InputStreamReader(System.in, "UTF-8");
            bufread2 = new BufferedReader(inread2);

            System.out.print("Enter num:");
            
            try
            {
                num = Integer.parseInt(bufread2.readLine());
            }
            catch(IOException ioe)
            {
				IO.logger.log(Level.WARNING, "Error reading from console", ioe);
            }
			catch(NumberFormatException nfe)
			{
				IO.logger.log(Level.WARNING, "Error converting to int", nfe);
			}
			finally
			{
				/* default num of 1 */
                num = 1;
			}
        }
        catch(UnsupportedEncodingException uee)
        {
            IO.logger.log(Level.WARNING, "Encoding is not supported!", uee);
        }
        finally 
        {
            try 
            {
                if( bufread2 != null ) 
                {
                    bufread2.close();
                }
            }
            catch( IOException e )
            {
                IO.logger.log(Level.WARNING, "Error closing BufferedReader", e);
            }
            finally 
            {
                try 
                {
                    if( inread2 != null ) 
                    {   
                        inread2.close();
                    }
                }
                catch( IOException e )
                {
                    IO.logger.log(Level.WARNING, "Error closing InputStreamReader", e);
                }
            }
        }
            
        System.out.println(recursion_bad(num));
	}
	
	private static long recursion_good(long n)
	{
		/* FIX: add a case for termination */
		if (n < 0)
        {
            return 0;
        }
		
		long ret = n + recursion_good(n-1);
		return ret;
	}
	
	private void good1()
    {
        BufferedReader bufread2 = null;
        InputStreamReader inread2 = null;
		int num = 0;
        try
        {
            inread2 = new InputStreamReader(System.in, "UTF-8");
            bufread2 = new BufferedReader(inread2);

            System.out.print("Enter num:");
            
            try
            {
                num = Integer.parseInt(bufread2.readLine());
            }
            catch(IOException ioe)
            {
				IO.logger.log(Level.WARNING, "Error reading from console", ioe);
            }
			catch(NumberFormatException nfe)
			{
				IO.logger.log(Level.WARNING, "Error converting to int", nfe);
			}
			finally
			{
				/* default num of 1 */
                num = 1;
			}
        }
        catch(UnsupportedEncodingException uee)
        {
            IO.logger.log(Level.WARNING, "Encoding is not supported!", uee);
        }
        finally 
        {
            try 
            {
                if( bufread2 != null ) 
                {
                    bufread2.close();
                }
            }
            catch( IOException e )
            {
                IO.logger.log(Level.WARNING, "Error closing BufferedReader", e);
            }
            finally 
            {
                try 
                {
                    if( inread2 != null ) 
                    {   
                        inread2.close();
                    }
                }
                catch( IOException e )
                {
                    IO.logger.log(Level.WARNING, "Error closing InputStreamReader", e);
                }
            }
        }
            
		System.out.println(recursion_good(num));
	}
    
    public void good() throws IOException 
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
