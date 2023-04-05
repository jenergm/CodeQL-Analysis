/*
 * @description Demonstrates lack of any synchronization or locks in a Servlet that updates a shared variable.  Servlets are inherently multithreaded, so we don't need to actually start threads in the bad() and goodX() functions.
 * 
 * */

package testcases.CWE609_Double_Checked_Locking;

import java.util.concurrent.locks.ReentrantLock;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.logging.Level;
import java.util.logging.Logger;

import testcasesupport.IO;
import testcasesupport.AbstractTestCaseServlet;

public class CWE609_Double_Checked_Locking__Servlet_01 extends AbstractTestCaseServlet {
	private static final long serialVersionUID = 1L;

  /* Bad() - Use of Double Checked Locking */
	private static String bad_string = null;
	
	/* FLAW: Insufficient "Double-Checked Locking" in this method - in certain circumstances, this can lead to bad_string being initialized twice.  See http://www.cs.umd.edu/~pugh/java/memoryModel/DoubleCheckedLocking.html for details. */
	public static String bad_getString() { 
		if (bad_string == null)
		{
			synchronized(CWE609_Double_Checked_Locking__Servlet_01.class)
			{
				if (bad_string == null)
				{
					bad_string = "bad_string";
				}
			}
		}
		return bad_string;
  }
  
  public void bad(HttpServletRequest request, HttpServletResponse response) throws Throwable 
	{
    response.getWriter().write(bad_getString());
	}
  
  
  /* Good1() - Add volatile keyword for Double Checked Locking 
volatile valid fix for Java 5 and later */
  private volatile static String good1_string = null;  /* FIX: Added "volatile" here */
	
	public static String good1_getString() { 
		if (good1_string == null)
		{
			synchronized(CWE609_Double_Checked_Locking__Servlet_01.class)
			{
				if (good1_string == null)
				{
					good1_string = "good1_string";
				}
			}
		}
		return good1_string;
  }
  
  public void good1(HttpServletRequest request, HttpServletResponse response) throws Throwable 
	{
    response.getWriter().write(good1_getString());
	}
  
  
  /* Good2() - Use method level synchronization instead of Double Checked Locking */
  private static String good2_string = null;  
	
	public synchronized static String good2_getString() { /* FIX: method is synchronized */
		if (good2_string == null)
		{
			good2_string = "good2_string";
		}
		return good2_string;
	}
  
  public void good2(HttpServletRequest request, HttpServletResponse response) throws Throwable 
	{
		response.getWriter().write(good2_getString());
	}
  
  
  /* Good3() - Use block synchronization on class instead of Double Checked Locking */
	private static String good3_string = null; 

	public static String good3_getString() { 
    synchronized(CWE609_Double_Checked_Locking__Thread_01.class) { /* FIX: Entire block is synchronized on class (not "double checked") */
      if (good3_string == null)
      {
        good3_string = "good3_string";
      }
      return good3_string;
    }
	}
  
  public void good3(HttpServletRequest request, HttpServletResponse response) throws Throwable 
	{
		response.getWriter().write(good3_getString());
	}
  
 
  /* Good4() - Use lock object instead of Double Checked Locking */
	private static String good4_string = null; 
	static private final Object good4_string_lock = new Object();

	public static String good4_getString() { 
    synchronized(good4_string_lock) { /* FIX: block is synchronized on good4_string_lock */
      if (good4_string == null)
      {
        good4_string = "good4_string";
      }
      return good4_string;
    }
	}
  
  public void good4(HttpServletRequest request, HttpServletResponse response) throws Throwable 
	{
    response.getWriter().write(good4_getString());
	}
 
  
  /* good5() - Use ReentrantLock instead of Double Checked Locking */
	private static String good5_string = null; 
  static private final ReentrantLock good5relock = new ReentrantLock();

	public static String good5_getString() { 
    good5relock.lock(); /* FIX: Block is "protected" with a ReentrantLock */
    /* good practice is to unlock() in a finally block, see http://download.oracle.com/javase/6/docs/api/java/util/concurrent/locks/ReentrantLock.html */
    try { 
      if (good5_string == null)
      {
        good5_string = "good5_string";
      }
      return good5_string;
    } finally {
      good5relock.unlock();
    }
	}
  
  public void good5(HttpServletRequest request, HttpServletResponse response) throws Throwable 
	{
    response.getWriter().write(good5_getString());
	}
  
  
  public void good(HttpServletRequest request, HttpServletResponse response) throws Throwable 
  {
    good1(request, response);
    good2(request, response);
    good3(request, response);
    good4(request, response);
    good5(request, response);
  } 
}
