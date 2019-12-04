object V1 {
    fun buildString(
        buildAction: (StringBuilder) -> Unit
    ): String {
        val sb = StringBuilder()
        buildAction(sb)
        return sb.toString()
    }
}

object V2 {
    fun buildString(
        buildAction: StringBuilder.() -> Unit
    ): String {
        val sb = StringBuilder()
        buildAction(sb)
        return sb.toString()
    }
}

fun main() {
    println(V1.buildString {
        it.append("HELLO")
        it.append("DSL")
    })

    println(V2.buildString {
        append("V2")
        append("DSL")
    })
}