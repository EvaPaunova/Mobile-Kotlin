package evapaunova.example.com.dominoskotlin.model

import java.io.Serializable

class User (val username: String, val password: String): Serializable {

    var age: Int = 0
    var isFemale: Boolean = false

    constructor(username: String, password: String, age: Int, isFemale: Boolean): this(username,password) {
        this.age = age
        this.isFemale = isFemale
    }
}
