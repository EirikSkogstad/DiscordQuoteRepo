package org.zenix.testing.quoteparser.parsers;

import org.zenix.testing.personaldiscordpage.domain.Quote;

public interface ParsableQuote {
    /**
     * Tries to format a string into a Quote. Will throw an exception if quote was not parsable.
     * Use isCorrectFormat() method to check if Quote is parsable.
     * @param rawString raw quote to parse into an Quote
     * @return Quote that was parsed.
     */
    Quote parse(String rawString);

    /**
     * Checks a string to see if it is correct format to be parsed by class implementation.
     * @param rawString to check
     * @return is rawString parsable?
     */
    boolean isCorrectFormat(String rawString);

    /**
     * Returns the expected format of this implementation, as a string.
     * Should be in a format like this:
     * {@code <quotetext> <hyphen> <author> <single space> <year>}
     * @return
     */
    String getExpectedFormatString();
}
