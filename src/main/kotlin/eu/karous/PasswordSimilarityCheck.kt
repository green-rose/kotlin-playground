package eu.karous

import java.io.File
//import kotlin.system.measureTimeMillis

fun isPassSimilar(passwordToBeChecked:String):Boolean {

    val commonPasswords = readCommonPasswords()
    //val timeInMillis = measureTimeMillis {
        commonPasswords.forEach {
            if(JaroStringDistance.distance(it,passwordToBeChecked)> JaroStringDistance.FINING) {
                println(it)
                return true
            }
        }
    //}
    //println("(The operation took $timeInMillis ms)") //(e.g. The operation took 193 ms)
    return false
}


fun readCommonPasswords(pathname: String = "passwords.txt") : List<String> {

    val commonPasswords = mutableListOf<String>()
        File(pathname).reader().forEachLine {
            if (!it.startsWith("###")){
                val words = it.split(",") //for csv format only
                commonPasswords.addAll(words)
            }
        }

    return commonPasswords

}
