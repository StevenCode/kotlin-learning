package my.demo.basicgrammer

fun main(args: Array<String>) {
    var a = 1
    //使用变量名作为模板
    val s1 = "a is $a"

    a = 2
    //使用表达式作为模板
    val s2 = "${s1.replace("is", "was")}, but now is $a"
    println(s2)
}