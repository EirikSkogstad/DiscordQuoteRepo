package org.zenix.testing.quoteparser.parsers

import org.junit.Assert.*
import org.junit.Before
import org.junit.Test

class ParserYearTest {
    private val parserYear: ParserYear = ParserYear()
    private val validQuotes: Array<String> = arrayOf("han stjæler jo bare ÆÆÆÆÆÆÆÆÆÆÆÆÆÆÆÆÆHHHHHH\n -Eirik 2017")
    private val invalidQuotes: Array<String> = arrayOf("\"Anders, jeg ser for meg morra di ute på alle fire og tygger på internettkabelen\" - Bergo 29.01.2018", "Not unbearable is what we strive for here at riot games :ok_hand::skin-tone-1:\" ~Riot Phreak 26/09/2017")

    @Test
    fun isCorrectFormat() {
        for (validQuote in validQuotes) {
            assertTrue(parserYear.isCorrectFormat(validQuote))
        }
        for (validQuote in invalidQuotes) {
            assertFalse(parserYear.isCorrectFormat(validQuote))
        }
    }

    @Test
    fun parse() {
        for (validQuote in validQuotes) {
            try {
                val (author, text, date) = parserYear.parse(validQuote)

                assertEquals("Eirik", author)
                assertEquals("2017", date)
                assertEquals("han stjæler jo bare ÆÆÆÆÆÆÆÆÆÆÆÆÆÆÆÆÆHHHHHH", text)
            } catch (e: QuoteParsingException) {
                fail("Could not parse " + validQuote)
            }
        }
    }
}