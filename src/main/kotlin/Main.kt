import java.io.File
import java.lang.System.exit

fun main(args: Array<String>) {
    print("Enter color csv filename: ")
    var fileName = readLine()
    var file = File(fileName)

    if (!file.exists()) {
        println("Error opening file: $fileName")
        exit(1)
    } else {
        var count = file.readLines().size
        val colors = arrayOfNulls<Color>(count)
        var index = 0
        file.forEachLine {
            val values = it.split(',')
            var newColor = Color(values[1], values[2], values[3])
            newColor.name = values[0]
            colors[index] = newColor
            index++
        }
        var matchFound: Boolean = false
        for (i in colors.indices) {
            for (x in ((i + 1) until count)) {
                if(colors[i] == colors[x]){
                    println("===match found!===")
                    println("\t${colors[i]!!.name}: ${colors[i]}")
                    println("\t${colors[x]!!.name}: ${colors[x]}")
                    matchFound = true
                }
            }
        }
        if(!matchFound){
            println("NO MATCHES FOUND!")
        }
    }
}