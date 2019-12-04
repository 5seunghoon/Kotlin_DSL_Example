data class Person(var age: Int = 0, var name: String = "java") {
}

object V1 {
    fun makePerson(
        makePersonAction: (Person) -> Unit
    ): Person {
        val person = Person()
        makePersonAction(person)
        return person
    }
}

object V2 {
    fun makePerson(
        makePersonAction: Person.() -> Unit
    ): Person {
        val person = Person()
        person.makePersonAction()
        return person
    }
}

fun main() {
    println(V1.makePerson {
        it.age = 10
        it.name = "kotlin"
    })

    println(V2.makePerson {
        //확장함수처럼 this가 넘어가기 때문에 it을 붙이지 않아도 된다
        age = 10
        name = "kotlin"
    })
}