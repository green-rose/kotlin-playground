package eu.karous

import java.io.File
import kotlin.system.measureTimeMillis

fun isPassSimilar(passwordToBeChecked:String):Boolean {

    val commonPasswords = readCommonPasswords()
    val timeInMillis = measureTimeMillis {
        commonPasswords.forEach {
            if(JaroStringDistance.distance(it,passwordToBeChecked)> JaroStringDistance.FINING) {
                return true
            }
        }
    }
    println("(The operation took $timeInMillis ms)") //(e.g. The operation took 193 ms)
    return false
}
fun readCommonPasswords(pathname: String = "passwords.txt") : List<String> {

    val commonPasswords = mutableListOf<String>()
    val timeInMillis = measureTimeMillis {
        File(pathname).reader().forEachLine {
            if (!it.startsWith("###")){
                val words = it.split(",")
                commonPasswords.addAll(words)
            }
        }
    }
    println("(The operation took $timeInMillis ms)") //(e.g. The operation took 85 ms)

    return commonPasswords

}
