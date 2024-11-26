package mx.ipn.cic.firstloginpractice.models

import java.io.Serializable

class User(
    var name: String,
    var pass: String
) : Serializable {

    override fun toString(): String {
        return "User(name='$name', pass='$pass')"
    }

}