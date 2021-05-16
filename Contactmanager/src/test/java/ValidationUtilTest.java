import org.junit.Test;
import utils.ValidationUtils;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class ValidationUtilTest {
    @Test
    public void usernameValidationUtilityShouldWorkProperly() {
        assertTrue(ValidationUtils.validateUsername("test58"));
        assertTrue(ValidationUtils.validateUsername("testäö"));
        assertTrue(ValidationUtils.validateUsername("test12345678912"));
        assertFalse(ValidationUtils.validateUsername("t"));
        assertFalse(ValidationUtils.validateUsername("test."));
        assertFalse(ValidationUtils.validateUsername("test123456789123"));
    }

    @Test
    public void nameValidationUtilityShouldWorkProperly() {
        assertTrue(ValidationUtils.validateName("Test Tester"));
        assertTrue(ValidationUtils.validateName("Test Teteräö"));
        assertTrue(ValidationUtils.validateName("T T"));
        assertFalse(ValidationUtils.validateName("Test. Tester"));
        assertFalse(ValidationUtils.validateName("Test Tester."));
        assertFalse(ValidationUtils.validateName(" Tester"));
        assertFalse(ValidationUtils.validateName("Test"));
    }

    @Test
    public void emailValidationUtilityShouldWorkProperly() {
        assertTrue(ValidationUtils.validateEmail("test.tester@test.com"));
        assertTrue(ValidationUtils.validateEmail("test_tester@test.com"));
        assertFalse(ValidationUtils.validateEmail("test@tester@test.com"));
        assertFalse(ValidationUtils.validateEmail("test.tester@te.st.com"));
        assertFalse(ValidationUtils.validateEmail("test@test"));
        assertFalse(ValidationUtils.validateEmail("test.com"));
    }

    @Test
    public void phoneNumberValidationUtilityShouldWorkProperly() {
        assertTrue(ValidationUtils.validatePhoneNumber("+358401663587"));
        assertFalse(ValidationUtils.validatePhoneNumber("+35840"));
        assertFalse(ValidationUtils.validatePhoneNumber("358+401663587"));
    }
}
