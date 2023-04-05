/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE760_Predictable_Salt_One_Way_Hash__database_74b.java
Label Definition File: CWE760_Predictable_Salt_One_Way_Hash.label.xml
Template File: sources-sinks-74b.tmpl.java
*/
/*
 * @description
 * CWE: 760 Use of one-way hash with a predictable salt
 * BadSource: database Read data from a database
 * GoodSource: A hardcoded string
 * Sinks:
 *    GoodSink: use a sufficiently random salt
 *    BadSink : SHA512 with a predictable salt
 * Flow Variant: 74 Data flow: data passed in a HashMap from one method to another in different source files in the same package
 *
 * */

package testcases.CWE760_Predictable_Salt_One_Way_Hash;

import testcasesupport.*;
import java.util.HashMap;

import java.security.GeneralSecurityException;
import java.security.MessageDigest;
import java.security.SecureRandom;

import javax.servlet.http.*;

public class CWE760_Predictable_Salt_One_Way_Hash__database_74b
{

    public void bad_sink(HashMap<Integer,String> data_hashmap ) throws Throwable
    {
        String data = data_hashmap.get(2);

        if (data != null)
        {
            MessageDigest hash = MessageDigest.getInstance("SHA-512");
            hash.update(data.getBytes("UTF-8"));  /* POTENTIAL FLAW: SHA512 with a predictable salt */
            byte[] hashv = hash.digest("hash me".getBytes("UTF-8"));
            IO.writeLine(IO.toHex(hashv));
        }

    }

    /* goodG2B() - use GoodSource and BadSink */
    public void goodG2B_sink(HashMap<Integer,String> data_hashmap ) throws Throwable
    {
        String data = data_hashmap.get(2);

        if (data != null)
        {
            MessageDigest hash = MessageDigest.getInstance("SHA-512");
            hash.update(data.getBytes("UTF-8"));  /* POTENTIAL FLAW: SHA512 with a predictable salt */
            byte[] hashv = hash.digest("hash me".getBytes("UTF-8"));
            IO.writeLine(IO.toHex(hashv));
        }

    }

    /* goodB2G() - use BadSource and GoodSink */
    public void goodB2G_sink(HashMap<Integer,String> data_hashmap ) throws Throwable
    {
        String data = data_hashmap.get(2);

        SecureRandom r = new SecureRandom();

        MessageDigest hash = MessageDigest.getInstance("SHA-512");
        hash.update(r.getSeed(32));  /* FIX: Use a sufficiently random salt */
        byte[] hashv = hash.digest("hash me".getBytes("UTF-8"));

        IO.writeLine(IO.toHex(hashv));

    }
}
