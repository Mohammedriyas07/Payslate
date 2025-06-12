package Helper;

import org.testng.Assert;

public class Assertion {
    private static Assertion assertion;
    private Assertion()
    {

    }
    public static Assertion getInstance()
    {
        if (assertion==null)
        {
            assertion=new Assertion();
            return assertion;
        }
        else
        {
            return assertion;
        }
    }
    public void verifyText(String actual,String expected)
    {
        if(actual.isEmpty() || expected.isEmpty())
        {
            throw new RuntimeException("Assertion failed");
        }
        else {
            Assert.assertEquals(actual,expected);
        }
    }
}
