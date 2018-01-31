package org.zenix.testing.quoteparser.parsers;

import org.zenix.testing.personaldiscordpage.domain.Quote;

import java.util.regex.Pattern;

public class ParserYear implements ParsableQuote {
    public static final String QUOTE_PATTERN = "^\"?\\w+\"?\\s*-\\s*\\w+\\s\\d{4}$";

    @Override
    public Quote parse(String rawString) {
        return null;
    }

    @Override
    public boolean isCorrectFormat(String rawString) {
        if (rawString == null) {
            return false;
        }

        return rawString.matches(QUOTE_PATTERN);
    }

    @Override
    public String getExpectedFormatString() {
        return "<quotetext> <hyphen> <author> <single space> <year>";
    }
}
