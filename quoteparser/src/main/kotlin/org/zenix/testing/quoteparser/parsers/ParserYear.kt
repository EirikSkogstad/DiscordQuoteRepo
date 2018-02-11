package org.zenix.testing.quoteparser.parsers

import org.zenix.testing.quoteparser.models.Quote


class ParserYear : ParsableQuote {
    private val quotePattern = ("^.+\\n?\\s*-\\s*\\w+\\s\\d{4}$").toRegex()

    override fun parse(rawString: String): Quote {
        val trimmedString = rawString.filter { c -> c != '\n' }
        val length = trimmedString.length
        val lastHyphenIndex = trimmedString.indexOfLast { c -> c == '-' }


        val year = trimmedString.substring(length - 4, length)
                .trim()
        val author = trimmedString.substring(lastHyphenIndex, length - 4)
                .filter { c -> c != '-'}
                .trim()
        val text = trimmedString.substring(0, lastHyphenIndex)
                .filter { c -> c != '"' }
                .trim()

        return Quote(author, text, year)
    }

    override fun isCorrectFormat(rawString: String): Boolean {
        return rawString.matches(quotePattern)
    }

    override fun getExpectedFormatString(): String {
        return "<quotetext> <hyphen> <author> <single space> <year>"
    }
}