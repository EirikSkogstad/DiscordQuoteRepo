package org.zenix.testing.quoteparser.parsers;


import org.zenix.testing.quoteparser.models.Quote;

public class ParserYear implements ParsableQuote {
    // Note, currently doesnt work with Æ, Ø "non ascii" characters
    public static final String QUOTE_PATTERN = "^.+\\n?\\s*-\\s*\\w+\\s\\d{4}$";

    @Override
    public Quote parse(String rawString) {
        if (rawString == null) {
            throw new NullPointerException();
        }
        String[] split = rawString.split("-");
        if (isCorrectFormat(rawString) && split.length != 2) {
            throw new QuoteParsingException("String cannot be parsed! It's in a wrong format.   Expected format: " + getExpectedFormatString());
        }

        String quoteText = split[0].trim();
        String rest = split[1].trim();

        String textWithoutQuotes = ParserUtility.trimQuotesIfExists(quoteText);

        // Get the 4 last digits, the year. The the rest should be the author.
        String year = rest
                .substring(rest.length() - 4, rest.length())
                .trim();
        String author = rest
                .substring(0, rest.length() - 4)
                .trim();

        return new Quote(author, textWithoutQuotes, year);
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
