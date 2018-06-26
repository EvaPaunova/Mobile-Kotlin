package evapaunova.example.com.dominoskotlin.model

import java.io.Serializable

class User (var firstName: String, var lastName: String, var email: String, var password: String): Serializable {

    var age: Int = 0
    var isFemale: Boolean = false

    constructor(firstName: String, lastName: String, email: String, password: String, age: Int, isFemale: Boolean): this(firstName,lastName,email,password) {
        this.age = age
        this.isFemale = isFemale
    }
}
