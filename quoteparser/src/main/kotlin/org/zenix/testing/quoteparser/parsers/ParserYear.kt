package org.zenix.testing.quoteparser.parsers

import org.zenix.testing.quoteparser.models.Quote


class ParserYear: ParsableQuote {
    // Note, currently doesnt work with Æ, Ø "non ascii" characters
    private val quotePattern = ("^.+\\n?\\s*-\\s*\\w+\\s\\d{4}$").toRegex()

    override fun parse(rawString: String): Quote {
        val split = rawString.split("-")
        if (isCorrectFormat(rawString) && split.size != 2) {
            throw QuoteParsingExceptionOld("String cannot be parsed! It's in a wrong format.   Expected format: " + getExpectedFormatString())
        }

        val quoteText = split[0].trim()
        val rest = split[1].trim()

        val textWithoutQuotes = ParserUtility.trimQuotesIfExists(quoteText)

        // Get the 4 last digits, the year. The the rest should be the author.
        val year = rest
                .substring(rest.length - 4, rest.length)
                .trim()
        val author = rest
                .substring(0, rest.length - 4)
                .trim()

        return Quote(author, textWithoutQuotes, year)
    }

    override fun isCorrectFormat(rawString: String): Boolean {
        return rawString.matches(quotePattern)
    }

    override fun getExpectedFormatString(): String {
        return "<quotetext> <hyphen> <author> <single space> <year>"
    }
}