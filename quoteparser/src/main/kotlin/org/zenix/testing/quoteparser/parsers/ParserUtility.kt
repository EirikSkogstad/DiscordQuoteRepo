package org.zenix.testing.quoteparser.parsers

import java.util.HashMap
import java.util.HashSet

class ParserUtility {
    companion object {

        /**
         * Remove first and last Characters, if they are both generic characters used for quotes.
         * Like ', " and `
         */
        @JvmStatic
        fun trimQuotesIfExists(quote: String): String {
            val quoteCharacters = setOf("'", "\"", "`")

            if (quoteCharacters.contains(quote.first().toString()) && quoteCharacters.contains((quote.last().toString()))) {
                return quote.substring(1, quote.length - 1)
            }
            return quote
        }
    }
}
