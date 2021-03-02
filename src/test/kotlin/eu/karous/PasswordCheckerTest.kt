package eu.karous

import io.micronaut.test.extensions.junit5.annotation.MicronautTest
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test


@MicronautTest
class PasswordCheckerTest {

    @Test
    fun testPassCheckerWhenPasswordIsShort() {
        assertEquals(PasswordStrength.WEAK, passChecker("ahoj"))
    }

    @Test
    fun testPassCheckerWhenPasswordIsShortButVariable() {
        assertEquals(PasswordStrength.WEAK, passChecker("Ah0!"))
    }

    @Test
    fun testPassCheckerWhenPasswordIsLongButWeak() {
        assertEquals(PasswordStrength.WEAK, passChecker("ahojpriteli"))
    }

    @Test
    fun testPassCheckerWhenPasswordIsLongWithCapital() {
        assertEquals(PasswordStrength.MEDIOCRE, passChecker("AhojPriteli"))
    }

    @Test
    fun testPassCheckerWhenPasswordIsLongWithCapitalAndDigits() {
        assertEquals(PasswordStrength.STRONG, passChecker("AhojPriteli12"))
    }

    @Test
    fun testPassCheckerWhenPasswordIsExtraStrong() {
        assertEquals(PasswordStrength.EXTRA_STRONG, passChecker("AhojPriteli12!"))
    }

}
