package org.zenix.testing.quoteparser.parsers

import org.junit.Test

import org.junit.Assert.*

class ParserUtilityTest {

    @Test
    fun trimQuotesIfExists() {
        val inputs = arrayOf("\" with   spacings \"", "\"singleWord\"", "oneQuoteMissing\"", "noQuotes")
        val expectedOutputs = arrayOf(" with   spacings ", "singleWord", "oneQuoteMissing\"", "noQuotes")

        for ((i, stringInput) in inputs.withIndex()) {
            assertEquals(ParserUtility.trimQuotesIfExists(stringInput), expectedOutputs[i])
        }
    }
}