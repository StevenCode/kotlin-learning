package my.demo.basicgrammer


fun main(args: Array<String>) {
    print("sum of 3 and 5 is ")
    println(sum(3, 5))

}

fun sum(a: Int, b: Int): Int {
    return a + b
}