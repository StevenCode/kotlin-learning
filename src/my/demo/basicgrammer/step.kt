package my.demo.basicgrammer

fun main(args: Array<String>) {
    for (x in 1..10 step 2) {
        println(x)
    }

    for (x in 9 downTo 0 step 3) {
        println(x)
    }
}