package org.zenix.testing.quoteparser.parsers;

import org.junit.Test;

import static org.junit.Assert.*;

public class ParserYearTest {


    @Test
    public void isCorrectFormat() {
        String[] validQuotes = {
                "han stjæler jo bare ÆÆÆÆÆÆÆÆÆÆÆÆÆÆÆÆÆHHHHHH\n -Ernik 2017",

        };
        String[] invalidQuotes = {
                "\"Anders, jeg ser for meg morra di ute på alle fire og tygger på internettkabelen\" - Bergo 29.01.2018",
                "Not unbearable is what we strive for here at riot games :ok_hand::skin-tone-1:\" ~Riot Phreak 26/09/2017"
        };
        ParserYear parserYear = new ParserYear();

        for (String validQuote : validQuotes) {
            assertTrue(parserYear.isCorrectFormat(validQuote));
        }
        for (String validQuote : invalidQuotes) {
            assertFalse(parserYear.isCorrectFormat(validQuote));
        }
    }
}