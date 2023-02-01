/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE259_Hard_Coded_Password__passwordAuth_73b.java
Label Definition File: CWE259_Hard_Coded_Password.label.xml
Template File: sources-sink-73b.tmpl.java
*/
/*
 * @description
 * CWE: 259 Hard Coded Password
 * BadSource: hardcodedPassword Set data to a hardcoded string
 * GoodSource: Read data from the console using readLine()
 * Sinks: passwordAuth
 *    BadSink : data used as password in PasswordAuthentication()
 * Flow Variant: 73 Data flow: data passed in a LinkedList from one method to another in different source files in the same package
 *
 * */

package testcases.CWE259_Hard_Coded_Password;

import testcasesupport.*;
import java.util.LinkedList;

import java.sql.*;
import javax.servlet.http.*;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.io.*;

import java.net.PasswordAuthentication;

public class CWE259_Hard_Coded_Password__passwordAuth_73b
{

    public void bad_sink(LinkedList<String> data_linkedlist ) throws Throwable
    {
        String data = data_linkedlist.remove(2);

        if (data != null)
        {
            /* POTENTIAL FLAW: data used as password in PasswordAuthentication() */
            PasswordAuthentication pa = new PasswordAuthentication("user", data.toCharArray());
            IO.writeLine(pa.toString());
        }

    }

    /* goodG2B() - use goodsource and badsink */
    public void goodG2B_sink(LinkedList<String> data_linkedlist ) throws Throwable
    {
        String data = data_linkedlist.remove(2);

        if (data != null)
        {
            /* POTENTIAL FLAW: data used as password in PasswordAuthentication() */
            PasswordAuthentication pa = new PasswordAuthentication("user", data.toCharArray());
            IO.writeLine(pa.toString());
        }

    }

}
