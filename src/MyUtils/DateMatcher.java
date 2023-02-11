package MyUtils;

import java.util.regex.Pattern;

/**
 *
 * @author giahu
 */
public class DateMatcher {

    private static final Pattern DATE_PATTERN = Pattern.compile(
            "^(([1-9]|0[1-9]|1[0-9]|2[0-8])[-|/](2|02)[-|/]((19|2[0-9])[0-9]{2}))$"
            + "|^(([1-9]|0[1-9]|[12][0-9]|3[01])[-|/]([13578]|0[13578]|10|12)[-|/]((19|2[0-9])[0-9]{2}))"
            + "|^(([1-9]|0[1-9]|[12][0-9]|30)[-|/]([469]|0[469]|11)[-|/]((19|2[0-9])[0-9]{2}))$"
            + "|^(29[-|/](2|02)[-|/](2000|2400|2800|(19|2[0-9])(0[48]|[2468][048]|[13579][26])))$"
    );

    public boolean matches(String date) {
        return DATE_PATTERN.matcher(date).matches();
    }
}
