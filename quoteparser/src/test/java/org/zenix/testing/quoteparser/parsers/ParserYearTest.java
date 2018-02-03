package org.zenix.testing.quoteparser.parsers;

import org.junit.Before;
import org.junit.Test;
import org.zenix.testing.personaldiscordpage.domain.Quote;

import static org.junit.Assert.*;

public class ParserYearTest {

    private ParserYear parserYear;
    private String[] validQuotes;
    private String[] invalidQuotes;

    @Before
    public void setup() {
        validQuotes = new String[]{
                "han stjæler jo bare ÆÆÆÆÆÆÆÆÆÆÆÆÆÆÆÆÆHHHHHH\n -Eirik 2017",

        };
        invalidQuotes = new String[]{
                "\"Anders, jeg ser for meg morra di ute på alle fire og tygger på internettkabelen\" - Bergo 29.01.2018",
                "Not unbearable is what we strive for here at riot games :ok_hand::skin-tone-1:\" ~Riot Phreak 26/09/2017"
        };
        parserYear = new ParserYear();
    }

    @Test
    public void isCorrectFormat() {
        for (String validQuote : validQuotes) {
            assertTrue(parserYear.isCorrectFormat(validQuote));
        }
        for (String validQuote : invalidQuotes) {
            assertFalse(parserYear.isCorrectFormat(validQuote));
        }
    }

    @Test
    public void parse() {
        for (String validQuote : validQuotes) {
            try {
                Quote parsedQuote = parserYear.parse(validQuote);

                assertEquals("Eirik", parsedQuote.getAuthor());
                assertEquals("2017", parsedQuote.getDate());
                assertEquals("han stjæler jo bare ÆÆÆÆÆÆÆÆÆÆÆÆÆÆÆÆÆHHHHHH", parsedQuote.getText());
            } catch (QuoteParsingException e) {
                fail("Could not parse " + validQuote);
            }
        }
    }
}