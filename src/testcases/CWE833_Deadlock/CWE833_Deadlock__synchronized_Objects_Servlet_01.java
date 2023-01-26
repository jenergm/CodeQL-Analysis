/*
 * @description Demonstrates a deadlock caused by synchronizing on objects in a different order in different functions in a Servlet that accesses shared variables.  Servlets are inherently multithreaded, so we don't need to actually start threads in the bad() and goodX() functions.
 * 
 * */
package testcases.CWE833_Deadlock;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.logging.Level;
import java.util.logging.Logger;

import testcasesupport.IO;
import testcasesupport.AbstractTestCaseServlet;

public class CWE833_Deadlock__synchronized_Objects_Servlet_01 extends AbstractTestCaseServlet {
	private static final long serialVersionUID = 1L;

  /* bad(): Synchronize on objects in different order in bad_add and bad_mult, causing a deadlock */
  static private int bada = 3;
  static private final Object bada_lock = new Object();

  static private int badb = 5;
  static private final Object badb_lock = new Object();
  
  static public void bad_add()
  {
    synchronized(bada_lock) {

      /* Would like to wait a bit here to allow for a context switch or for another thread to "catch up", but we can't call Thread.sleep() since that is not allowed in a Servlet (CWE-383: J2EE Bad Practices: Direct Use of Threads) */  

      synchronized(badb_lock) {
        bada = bada + badb;
      }
    }
  }
  
  static public void bad_mult()
  {
    synchronized(badb_lock) { /* FLAW: Synchronize on objects in the opposite order as in bad_add() */

      /* Would like to wait a bit here to allow for a context switch or for another thread to "catch up", but we can't call Thread.sleep() since that is not allowed in a Servlet (CWE-383: J2EE Bad Practices: Direct Use of Threads) */  

      synchronized(bada_lock) {
        bada = bada * badb;
      }
    }
  }
	
	public void bad(HttpServletRequest request, HttpServletResponse response) throws Throwable 
	{
    /* Branch so that not all requests call the same method.  If a valid request and an invalid
       one come in at the same time, a deadlock will result */
    if(request.isRequestedSessionIdValid()) {
      bad_add();
    } else {
      bad_mult();
    }
    
    /* write output */
    response.getWriter().write(bada);
	}

 
  /* good1() - Synchronize on objects in same order in good1_add() and good1_mult() */
  static private int good1a = 3;
  static private final Object good1a_lock = new Object();

  static private int good1b = 5;
  static private final Object good1b_lock = new Object();
  
  static public void good1_add()
  {
    synchronized(good1a_lock) {
    
      /* Would like to wait a bit here to allow for a context switch or for another thread to "catch up", but we can't call Thread.sleep() since that is not allowed in a Servlet (CWE-383: J2EE Bad Practices: Direct Use of Threads) */  

      synchronized(good1b_lock) {
        good1a = good1a + good1b;
      }
    }
  }
  
  static public void good1_mult()
  {
    synchronized(good1a_lock) { /* FIX: Synchronize on objects in the same order as in good1_add() */
    
      /* Would like to wait a bit here to allow for a context switch or for another thread to "catch up", but we can't call Thread.sleep() since that is not allowed in a Servlet (CWE-383: J2EE Bad Practices: Direct Use of Threads) */  
    
      synchronized(good1b_lock) {
        good1a = good1a * good1b;
      }
    }
  }
	
	public void good1(HttpServletRequest request, HttpServletResponse response) throws Throwable 
	{
    /* Branch so that not all requests call the same method. */
    if(request.isRequestedSessionIdValid()) {
      good1_add();
    } else {
      good1_mult();
    }
    
    /* write output */
    response.getWriter().write(good1a);
	}  
  
  public void good(HttpServletRequest request, HttpServletResponse response) throws Throwable 
  {
    good1(request, response);
  } 
}
