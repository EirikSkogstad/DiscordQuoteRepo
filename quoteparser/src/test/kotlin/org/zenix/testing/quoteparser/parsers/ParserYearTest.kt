package org.zenix.testing.quoteparser.parsers

import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
import org.zenix.testing.quoteparser.models.Quote

class ParserYearTest {
    private val parserYear: ParserYear = ParserYear()
    private val validQuotes: Array<String> = arrayOf(
            "han stjæler jo bare    ÆÆÆÆÆÆÆÆÆÆÆÆÆÆÆÆÆHHHHHH\n - Eirik 2017",
            "\"Billy Motlem\" - Sloth 2018",
            "Er litt som at jeg fikk-lov til å smake til på NILU i dag \n-Jeffe 2017",
            "Foo-man is best  ever  - Foo-Man 2017",
            "Bar-man something quote  - Bar Man 2017")
    private val invalidQuotes: Array<String> = arrayOf(
            "\"Anders, jeg ser for meg morra di ute på alle fire og tygger på internettkabelen\" - Bergo 29.01.2018",
            "Not unbearable is what we strive for here at riot games :ok_hand::skin-tone-1:\" ~Riot Phreak 26/09/2017")

    private val expectedResults: Array<Quote> = arrayOf(
            Quote(author ="Eirik", text = "han stjæler jo bare    ÆÆÆÆÆÆÆÆÆÆÆÆÆÆÆÆÆHHHHHH", date = "2017"),
            Quote(author ="Sloth", text = "Billy Motlem", date = "2018"),
            Quote(author ="Jeffe", text = "Er litt som at jeg fikk-lov til å smake til på NILU i dag", date = "2017"),
            Quote(author ="Foo-Man", text = "Foo-man is best  ever", date = "2017"),
            Quote(author ="Bar Man", text = "Bar-man something quote", date = "2017")
    )

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
        for ((i, validQuote) in validQuotes.withIndex()) {
            try {
                val (author, text, date) = parserYear.parse(validQuote)
                val expectedQuote = expectedResults[i]

                assertEquals(expectedQuote.author, author)
                assertEquals(expectedQuote.text, text)
                assertEquals(expectedQuote.date, date)
            } catch (e: QuoteParsingException) {
                fail("Could not parse $validQuote")
            }
        }
    }
}