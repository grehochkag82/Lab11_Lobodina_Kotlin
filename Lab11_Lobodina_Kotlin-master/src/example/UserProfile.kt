package example

import kotlin.properties.Delegates

class UserProfile(initialName: String,initialEmail: String){
    var name: String by Delegates.observable(initialName){
        _, old, new ->
        println("Имя изменено: `$old`->`$new`")
    }
    var email: String by Delegates.observable(initialEmail){
        _, old, new ->
        println("Email обновлен: `$old` ->`$new`")
    }
    val avatar: String by lazy{
        println("Загружаем аватар для $name . . . ")
        "avatar_of_$name.png"
    }
}