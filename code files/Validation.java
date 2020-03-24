//parkingEazeTeam
package eaze.parking;

import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validation {

    private static final Pattern VALID_EMAIL_ADDRESS =
            Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);

    private static final Pattern valid_password=
            Pattern.compile("((?=.*\\\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%=:\\\\?]).{6,12})\n", Pattern.CASE_INSENSITIVE);



    public static boolean checkEmailForValidity(String email) {

        email = email.trim();

        Matcher matcher = VALID_EMAIL_ADDRESS.matcher(email);
        return matcher.find();

    }

    public static String emailStringChecker(String email) {
        return "";
    }

    public static boolean checkpasswordForValidity(String password) {

        password = password.trim();

        Matcher matcher2 = valid_password.matcher(password);
        return matcher2.find();

    }

    public static boolean validatePassword(String password) {
        return true;
    }

}
