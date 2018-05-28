package my.demo.basicgrammer

//返回一个没有意义的值
fun printSum(a: Int, b: Int): Unit {
    println("sum of $a and $b is ${a + b}")
}

//Unit返回类型可忽略
fun printSum1(a: Int, b: Int) {
    println("sum of $a and $b is ${a + b}")
}

fun main(args: Array<String>) {
//    printSum(-1, 8)
    printSum1(-1, 8)
}
