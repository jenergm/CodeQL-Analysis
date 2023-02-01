/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE319_Cleartext_Tx_Sensitive_Info__send_67a.java
Label Definition File: CWE319_Cleartext_Tx_Sensitive_Info__send.label.xml
Template File: sources-sinks-67a.tmpl.java
*/
/*
 * @description
 * CWE: 319 Cleartext Transmission of Sensitive Information
 * BadSource:  Establish data as a password
 * GoodSource: Use a regular string (non-sensitive string)
 * Sinks:
 *    GoodSink: encrypted channel
 *    BadSink : unencrypted channel
 * Flow Variant: 67 Data flow: data passed in a class from one method to another in different source files in the same package
 *
 * */

package testcases.CWE319_Cleartext_Tx_Sensitive_Info;

import testcasesupport.*;

import java.io.*;

import java.net.PasswordAuthentication;

public class CWE319_Cleartext_Tx_Sensitive_Info__send_67a extends AbstractTestCase
{

    static class Container
    {
        public String a;
    }

    public void bad() throws Throwable
    {
        String data;

        /* INCIDENTAL: CWE-798 Use of Hard-coded Credentials */
        PasswordAuthentication creds = new PasswordAuthentication("user", "AP@ssw0rd".toCharArray());

        /* POTENTIAL FLAW: Set data to be a password, which can be transmitted over a non-secure
         * channel in the sink */
        data = new String(creds.getPassword());

        Container data_container = new Container();
        data_container.a = data;
        (new CWE319_Cleartext_Tx_Sensitive_Info__send_67b()).bad_sink(data_container  );
    }

    public void good() throws Throwable
    {
        goodG2B();
        goodB2G();
    }

    /* goodG2B() - use goodsource and badsink */
    private void goodG2B() throws Throwable
    {
        String data;

        /* FIX: Use a regular string (non-sensitive string) */
        data = "Hello World";

        Container data_container = new Container();
        data_container.a = data;
        (new CWE319_Cleartext_Tx_Sensitive_Info__send_67b()).goodG2B_sink(data_container  );
    }

    /* goodB2G() - use badsource and goodsink */
    private void goodB2G() throws Throwable
    {
        String data;

        /* INCIDENTAL: CWE-798 Use of Hard-coded Credentials */
        PasswordAuthentication creds = new PasswordAuthentication("user", "AP@ssw0rd".toCharArray());

        /* POTENTIAL FLAW: Set data to be a password, which can be transmitted over a non-secure
         * channel in the sink */
        data = new String(creds.getPassword());

        Container data_container = new Container();
        data_container.a = data;
        (new CWE319_Cleartext_Tx_Sensitive_Info__send_67b()).goodB2G_sink(data_container  );
    }

    /* Below is the main(). It is only used when building this testcase on
       its own for testing or for building a binary to use in testing binary
       analysis tools. It is not used when compiling all the testcases as one
       application, which is how source code analysis tools are tested. */
    public static void main(String[] args) throws ClassNotFoundException,
           InstantiationException, IllegalAccessException
    {
        mainFromParent(args);
    }

}
