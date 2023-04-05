/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE601_Open_Redirect__Servlet_File_73b.java
Label Definition File: CWE601_Open_Redirect__Servlet.label.xml
Template File: sources-sink-73b.tmpl.java
*/
/*
 * @description
 * CWE: 601 Open Redirect
 * BadSource: File Read data from file (named c:\data.txt)
 * GoodSource: A hardcoded string
 * Sinks:
 *    BadSink : place redirect string directly into redirect api call
 * Flow Variant: 73 Data flow: data passed in a LinkedList from one method to another in different source files in the same package
 *
 * */

package testcases.CWE601_Open_Redirect;

import testcasesupport.*;
import java.util.LinkedList;

import javax.servlet.http.*;
import java.net.URI;
import java.net.URISyntaxException;

public class CWE601_Open_Redirect__Servlet_File_73b
{

    public void bad_sink(LinkedList<String> data_linkedlist , HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        String data = data_linkedlist.remove(2);

        if (data != null)
        {
            /* This prevents \r\n (and other chars) and should prevent incidentals such
             * as HTTP Response Splitting and HTTP Header Injection.
            */
            URI u;
            try
            {
                u = new URI(data);
            }
            catch (URISyntaxException e)
            {
                response.getWriter().write("Invalid redirect URL");
                return;
            }
            /* POTENTIAL FLAW: redirect is sent verbatim; escape the string to prevent ancillary issues like XSS, Response splitting etc */
            response.sendRedirect(data);
            return;
        }

    }

    /* goodG2B() - use goodsource and badsink */
    public void goodG2B_sink(LinkedList<String> data_linkedlist , HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        String data = data_linkedlist.remove(2);

        if (data != null)
        {
            /* This prevents \r\n (and other chars) and should prevent incidentals such
             * as HTTP Response Splitting and HTTP Header Injection.
            */
            URI u;
            try
            {
                u = new URI(data);
            }
            catch (URISyntaxException e)
            {
                response.getWriter().write("Invalid redirect URL");
                return;
            }
            /* POTENTIAL FLAW: redirect is sent verbatim; escape the string to prevent ancillary issues like XSS, Response splitting etc */
            response.sendRedirect(data);
            return;
        }

    }

}
