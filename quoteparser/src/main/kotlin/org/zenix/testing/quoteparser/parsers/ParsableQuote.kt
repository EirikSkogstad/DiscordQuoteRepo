package org.zenix.testing.quoteparser.parsers

import org.zenix.testing.quoteparser.models.Quote

interface ParsableQuote {
    /**
     * Tries to format a string into a Quote. Will throw an exception if quote was not parsable.
     * Use isCorrectFormat() method to check if Quote is parsable.
     * @param rawString raw quote to parse into an Quote
     * @return Quote that was parsed.
     * @throws QuoteParsingException if quote could not be parsed.
     */
    @Throws(QuoteParsingException::class)
    fun parse(rawString: String): Quote

    /**
     * Checks a string to see if it is correct format to be parsed by class implementation.
     * @param rawString to check
     * @return is rawString parsable?
     */
    fun isCorrectFormat(rawString: String): Boolean

    /**
     * Returns the expected format of this implementation, as a string.
     * Should be in a format like this:
     * {@code <quotetext> <hyphen> <author> <single space> <year>}
     * @return
     */
    fun getExpectedFormat(): String

    /**
     * Returns an example of a valid quote
     */
    fun getExample(): String
}