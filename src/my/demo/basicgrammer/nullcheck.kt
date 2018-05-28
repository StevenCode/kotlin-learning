package my.demo.basicgrammer

fun parseInt(str: String): Int? {
    return str.toIntOrNull()
}

fun printProduct(args1: String, args2: String) {
    val x = parseInt(args1)
    val y = parseInt(args2)

    if (x != null && y != null) {
        println(x * y)
    }
    else{
        println("either '$args1' or '$args2' is not a number")
    }
}

fun main(args: Array<String>) {
    printProduct("6", "7")
    printProduct("a", "7")
    printProduct("a", "b")

}