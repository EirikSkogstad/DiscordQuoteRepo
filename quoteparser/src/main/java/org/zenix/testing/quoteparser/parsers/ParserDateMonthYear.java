package org.zenix.testing.quoteparser.parsers;

import org.zenix.testing.personaldiscordpage.domain.Quote;

public class ParserDateMonthYear implements ParsableQuote {
    @Override
    public Quote parse(String rawString) {
        return null;
    }

    @Override
    public boolean isCorrectFormat(String rawString) {
        return false;
    }

    @Override
    public String getExpectedFormatString() {
        return "<quotetext> <hyphen> <author> <single space> <day.month.year>";
    }
}
