package eu.karous

import io.micronaut.test.extensions.junit5.annotation.MicronautTest
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test


@MicronautTest
class PasswordCheckerTest {

    @Test
    fun testPassCheckerWhenPasswordIsShort() {
        assertEquals(PasswordStrength.WEAK, passChecker("maloznaku"))
    }

    @Test
    fun testPassCheckerWhenPasswordIsVariableButShort() {
        assertEquals(PasswordStrength.WEAK, passChecker("Mal0!"))
    }

    @Test
    fun testPassCheckerWhenPasswordIsLongButSimple() {
        assertEquals(PasswordStrength.MEDIOCRE, passChecker("jenmaleznaky"))
    }

    @Test
    fun testPassCheckerWhenPasswordIsLongWithCapital() {
        assertEquals(PasswordStrength.MEDIOCRE, passChecker("znakuPresDeset"))
    }

    @Test
    fun testPassCheckerWhenPasswordIsLongerWithCapitalAndDigits() {
        assertEquals(PasswordStrength.STRONG, passChecker("AhojPriteli12"))
    }

    @Test
    fun testPassCheckerWhenPasswordIsLongEnoughButWithCapitalAndDigitsOnly() {
        assertEquals(PasswordStrength.STRONG, passChecker("Password15Znaku"))
    }

    @Test
    fun testPassCheckerWhenPasswordIsExtraLongAndWithAllCharVariations() {
        assertEquals(PasswordStrength.EXTRA_STRONG, passChecker("AhojPriteli12!Muj"))
    }

}
