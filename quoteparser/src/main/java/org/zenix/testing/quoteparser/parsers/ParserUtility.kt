package org.zenix.testing.quoteparser.parsers

import java.util.HashMap
import java.util.HashSet

class ParserUtility {
    companion object {
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
