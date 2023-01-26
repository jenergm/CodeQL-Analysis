/*
 * @description Demonstrates use of lock() more times than unlock() in a Servlet that updates a shared variable.  Servlets are inherently multithreaded, so we don't need to actually start threads in the bad() and goodX() functions.
 * 
 * */
package testcases.CWE764_Multiple_Locks;

import java.util.concurrent.locks.ReentrantLock;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.logging.Level;
import java.util.logging.Logger;

import testcasesupport.IO;
import testcasesupport.AbstractTestCaseServlet;

public class CWE764_Multiple_Locks__ReentrantLock_Servlet_01 extends AbstractTestCaseServlet {
	private static final long serialVersionUID = 1L;

  /* bad(): Use lock() twice and unlock() once */
  static private int badint = 1;
  static private final ReentrantLock badrelock = new ReentrantLock();
    
  static public void bad_double() 
  {
    badrelock.lock(); 
    badrelock.lock(); /* FLAW: Code uses lock() twice (and unlock() once), so no other threads will ever be able to get lock */
    
    /* good practice is to unlock() in a finally block, see http://download.oracle.com/javase/6/docs/api/java/util/concurrent/locks/ReentrantLock.html */
    try{ 
      badint = badint * 2;
    } finally {
      badrelock.unlock(); /* Only one unlock(), so the lock will still be held when the thread ends, meaning no other threads can get the lock */
    }
  }
	
	public void bad(HttpServletRequest request, HttpServletResponse response) throws Throwable 
	{
		bad_double();
    response.getWriter().write(badint);
	}

 
  /* good1(): Use a ReentrantLock properly (use lock() once and unlock() once) */
  static private int good1int = 1;
  static private final ReentrantLock good1relock = new ReentrantLock();

  static public void good1_double() 
  {
    good1relock.lock(); /* FIX: Only use lock() once */
    
    /* good practice is to unlock() in a finally block, see http://download.oracle.com/javase/6/docs/api/java/util/concurrent/locks/ReentrantLock.html */
    try{ 
      good1int = good1int * 2;
    } finally {
      good1relock.unlock();
    }
  }
  
  private void good1(HttpServletRequest request, HttpServletResponse response) throws Throwable
  {        
  	good1_double();
    response.getWriter().write(good1int);
  }  
  
  
  public void good(HttpServletRequest request, HttpServletResponse response) throws Throwable 
  {
    good1(request, response);
  } 
}
