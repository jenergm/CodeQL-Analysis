/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE760_Predictable_Salt_One_Way_Hash__URLConnection_81_base.java
Label Definition File: CWE760_Predictable_Salt_One_Way_Hash.label.xml
Template File: sources-sinks-81_base.tmpl.java
*/
/*
 * @description
 * CWE: 760 Use of one-way hash with a predictable salt
 * BadSource: URLConnection Read data from a web server with URLConnection
 * GoodSource: A hardcoded string
 * Sinks:
 *    GoodSink: use a sufficiently random salt
 *    BadSink : SHA512 with a predictable salt
 * Flow Variant: 81 Data flow: data passed in a parameter to an abstract method
 *
 * */

package testcases.CWE760_Predictable_Salt_One_Way_Hash;

import testcasesupport.*;

import java.security.GeneralSecurityException;
import java.security.MessageDigest;
import java.security.SecureRandom;

import javax.servlet.http.*;

public abstract class CWE760_Predictable_Salt_One_Way_Hash__URLConnection_81_base
{

    public abstract void action(String data ) throws Throwable;

}
