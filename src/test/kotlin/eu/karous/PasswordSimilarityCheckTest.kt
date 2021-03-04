package eu.karous

import io.micronaut.test.extensions.junit5.annotation.MicronautTest
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test


@MicronautTest
class PasswordSimilarityCheckTest {

    @Test
    fun testIfInVocabulary() {
        assertTrue(isPassSimilar("1qaz2wsx3edc"))
    }

    @Test
    fun testIfSimilarWithVocabulary() {
        assertTrue(isPassSimilar("Rainbowl")) //rainbow
    }

    @Test
    fun testIfLesserSimilarWithVocabulary() {
        assertTrue(isPassSimilar("Rainb0wl")) //rainbow
    }

    @Test
    fun testIfLessSimilarWithVocabulary() {
        assertFalse(isPassSimilar("Re!nb0wl")) //rainbow
    }

    @Test
    fun testIfDifferentWithVocabulary() {
        assertFalse(isPassSimilar("Revnice25230"))
    }

    @Test
    fun testIfNumberDifferentFromVocabulary() {
        assertTrue(isPassSimilar("1245876524")) //123456852 !!! Dvě čísla jsou si vždy dost podobná...
    }
}
