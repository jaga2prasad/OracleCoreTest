package oracle.test;

import org.junit.Assert;
import org.junit.Test;

/**
 * Provides sufficient test coverage for oracle.test.PalindromeUtil class.
 */
public class PalindromeUtilTest {
	@Test
	public void testPalidrome(){
		Assert.assertTrue(PalindromeUtil.isPalindrome("Madam, I'm Adam."));
		Assert.assertTrue(PalindromeUtil.isPalindrome("liril"));
		Assert.assertFalse(PalindromeUtil.isPalindrome("123"));
		Assert.assertTrue(PalindromeUtil.isPalindrome(" "));
		Assert.assertTrue(PalindromeUtil.isPalindrome("j"));
		Assert.assertFalse(PalindromeUtil.isPalindrome("This is my house"));
		Assert.assertTrue(PalindromeUtil.isPalindrome("123321"));
		Assert.assertTrue(PalindromeUtil.isPalindrome("%121%"));
		Assert.assertTrue(PalindromeUtil.isPalindrome("%121#$"));
	}
	
	
}
