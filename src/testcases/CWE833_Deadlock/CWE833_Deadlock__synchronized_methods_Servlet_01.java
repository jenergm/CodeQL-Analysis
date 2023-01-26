/*
 * @description Demonstrates a deadlock caused by synchronized methods in objects that call one another in a Servlet.  Servlets are inherently multithreaded, so we don't need to actually start threads in the bad() and goodX() functions.  Implementation based on http://download.oracle.com/javase/tutorial/essential/concurrency/deadlock.html.
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

public class CWE833_Deadlock__synchronized_methods_Servlet_01 extends AbstractTestCaseServlet {
	private static final long serialVersionUID = 1L;
	
  /* Bad - Call to a synchronized method on another object while holding lock on this object */
	
  /* Create bad static objects */
  static CWE833_Deadlock__synchronized_methods_Servlet_01 bad_a = new CWE833_Deadlock__synchronized_methods_Servlet_01();
  static CWE833_Deadlock__synchronized_methods_Servlet_01 bad_b = new CWE833_Deadlock__synchronized_methods_Servlet_01();
  
  public synchronized void bad_bow(CWE833_Deadlock__synchronized_methods_Servlet_01 bower) {
		IO.writeLine("bad_bow");
    try { 
      Thread.sleep(1000); /* sleep for a bit to allow a context switch or the other thread to "catch up" */
    } catch (InterruptedException e) {
      IO.logger.log(Level.WARNING, "Sleep Interrupted", e);
    }
		bower.bad_bowBack(this); /* FLAW: Call to a synchronized method on another object while holding lock on this object */
	}
  
	public synchronized void bad_bowBack(CWE833_Deadlock__synchronized_methods_Servlet_01 bower) {
		IO.writeLine("bad_bowBack");
	}
    
	public void bad(HttpServletRequest request, HttpServletResponse response) throws Throwable 
	{
    /* Branch so that not all requests call the same method.  If a valid request and an invalid
       one come in at the same time, a deadlock will result */
    if(request.isRequestedSessionIdValid()) {
      bad_a.bad_bow(bad_b);
    } else {
      bad_b.bad_bow(bad_a);
    }
	}

  /* Good1 - Call to synchronized method on another object is made after giving up "lock" on this object */
  
  /* Create good1 static objects */
  static CWE833_Deadlock__synchronized_methods_Servlet_01 good1_a = new CWE833_Deadlock__synchronized_methods_Servlet_01();
  static CWE833_Deadlock__synchronized_methods_Servlet_01 good1_b = new CWE833_Deadlock__synchronized_methods_Servlet_01();
  
	public void good1_bow(CWE833_Deadlock__synchronized_methods_Servlet_01 bower) {
  	synchronized(this) {
      IO.writeLine("good1_bow");
      try { 
        Thread.sleep(1000); /* sleep for a bit to allow a context switch or the other thread to "catch up" */
      } catch (InterruptedException e) {
        IO.logger.log(Level.WARNING, "Sleep Interrupted", e);
      }
    }
		bower.good1_bowBack(this); /* FIX: Call to synchronized method on another object is made after giving up "lock" on this object */
	}
  
	public synchronized void good1_bowBack(CWE833_Deadlock__synchronized_methods_Servlet_01 bower) {
		IO.writeLine("good1_bowBack");
	}
 
 	public void good1(HttpServletRequest request, HttpServletResponse response) throws Throwable 
	{
    /* Branch so that not all requests call the same method.  If a valid request and an invalid
       one come in at the same time, a deadlock will result */
    if(request.isRequestedSessionIdValid()) {
      good1_a.good1_bow(good1_b);
    } else {
      good1_b.good1_bow(good1_a);
    }
	}
  
  public void good(HttpServletRequest request, HttpServletResponse response) throws Throwable 
  {
    good1(request, response);
  } 
}
