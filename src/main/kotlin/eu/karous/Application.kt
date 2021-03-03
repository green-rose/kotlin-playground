package eu.karous

import kotlin.system.measureTimeMillis

enum class PasswordStrength(val description: String, val relativeWeakness: Float) {
   WEAK("weak", 0f),
   MEDIOCRE("mediocre", 0.5f),
   STRONG("strong", 0.7f),
   EXTRA_STRONG("extra strong", 0.9f)
}

fun containsSmallLetters(pass: String): Boolean {
   return pass.any { it in 'a'..'z' }
}
fun containsCapitalLetters(pass: String): Boolean {
   return pass.any { it in 'A'..'Z' }
}
fun containsDigits(pass: String): Boolean {
   return pass.any { it in '0'..'9' }
}
fun containsSpecialCharacters(pass: String): Boolean {
   return pass.filter { it in 'A'..'Z' || it in 'a'..'z'||  it in '0'..'9' }.length != pass.length
}

fun passRelativeStrengthChecker(passwordToBeChecked: String): Float {

   if (passwordToBeChecked.length < 8) return 0f

   var strength: Int = if (passwordToBeChecked.length <= 10) 2 else if (passwordToBeChecked.length <= 14) 4 else 6

   if (containsSmallLetters(passwordToBeChecked)) strength += 2
   if (containsCapitalLetters(passwordToBeChecked)) strength += 2
   if (containsDigits(passwordToBeChecked)) strength += 2
   if (containsSpecialCharacters(passwordToBeChecked)) strength += 2

   return strength.toFloat() / 14
}

fun main() {
}

fun passChecker(passwordToBeChecked:String):PasswordStrength {

   val relativeStrength = passRelativeStrengthChecker(passwordToBeChecked)

   if (relativeStrength>=PasswordStrength.EXTRA_STRONG.relativeWeakness) return PasswordStrength.EXTRA_STRONG
   if (relativeStrength>=PasswordStrength.STRONG.relativeWeakness) return PasswordStrength.STRONG
   if (relativeStrength>=PasswordStrength.MEDIOCRE.relativeWeakness) return PasswordStrength.MEDIOCRE

   return PasswordStrength.WEAK
}


