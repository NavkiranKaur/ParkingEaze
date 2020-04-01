package eaze.parking;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


import static junit.framework.TestCase.assertTrue;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class UtilsTest {

    Validation emailValidation;

    @Before
    public void setUp() throws Exception {
        emailValidation = new Validation();
    }

    @Test
    public void verify_valid_email() {
        assertTrue(emailValidation.checkEmailForValidity("abc@abc.com"));

    }

    @Test
    public void verify_invalid_email() {
        assertFalse(emailValidation.checkEmailForValidity("yyzcom"));
    }

    @Test
    public void testIsEmailValid() {
        String testEmail = "abc@gmail.com";
        Assert.assertThat(String.format("Email Validity Test failed for %s ", testEmail), Validation.checkEmailForValidity(testEmail), is(true));

    }


    @Test
    public void testNotValidEmail() {
        String withoutNametestEmail = "@gmail.com  ";
        Assert.assertThat(String.format("Email Validity Test failed for %s ",  withoutNametestEmail), Validation.checkEmailForValidity( withoutNametestEmail), is(false));
    }

    @Test
    public void emailStringNullCheck() {
        Assert.assertThat(Validation.emailStringChecker(""), is(""));
    }

    @Test
    public void emailStringEmptyCheck() {
        Assert.assertThat(Validation.emailStringChecker(""), is(""));
    }

    @Test
    public void validatePassword_LengthLong() {
        // setup
        String password = "Abcdefg5#abcdefgabcd";
//WHEN LENGTH OF PASSWORD IS TOO LONG
        // execute
        boolean lengthPassword = Validation.checkpasswordForValidity(password);

        // assert
        assertFalse(lengthPassword);
    }

    @Test
    public void validatePassword_Missing_OneNumber() {
        // setup
        String password = "Abcdefg#";

        // execute
        boolean missingNum = Validation.checkpasswordForValidity(password);

        // assert
        assertFalse(missingNum);
    }

    @Test
    public void validatePassword_Missing_OneLowerCaseLetter() {
        // setup
        String password = "ABCDEFG5#";

        // execute
        boolean missing_lowercase = Validation.checkpasswordForValidity(password);

        // assert
        assertFalse(missing_lowercase);
    }

    @Test
    public void validatePassword_Missing_OneUpperCaseLetter() {
        // setup
        String password = "3344bb5#";

        // execute
        boolean missing_uppercase = Validation.checkpasswordForValidity(password);

        // assert
        assertFalse(missing_uppercase);
    }

    @Test
    public void validatePassword_Missing_SpecialCharacter() {
        // setup
        String password = "ABCDghi";

        // execute
        boolean missing_char_special = Validation.checkpasswordForValidity(password);

        // assert
        assertFalse(missing_char_special);
    }
    @Test
    public void validPassword_check() {
        // setup
        String password1 = "Abcdefg5#";

        // execute
        boolean valid = Validation. validatePassword(password1);

        // assert
        assertTrue(valid);
    }

}
