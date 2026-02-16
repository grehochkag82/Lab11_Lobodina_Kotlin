package example
import kotlin.properties.Delegates
interface Base {
    fun someFun()
}
class BaseImpl() : Base {
    override fun someFun() {}
}
class Derived(someBase:Base): Base by someBase

interface Messenger{
    fun sendTextMessage()
    fun sendVideoMessage()
}
class InstantMessager(val programName: String): Messenger{
    override fun sendTextMessage() = println("Send text message")
    override fun sendVideoMessage() = println("Send video message")
}
interface  PhotoDevices {
    fun takePhoto()
}
class PhotoCamera: PhotoDevices{
    override fun takePhoto() = println("Take a photo")
}
class SmartPhone(val name: String, m: Messenger): Messenger by m {
    override fun sendTextMessage()= println("Send SMS")
}
var counter: Int by Delegates.observable(0) { _, old,new ->
    println("Счётчик изменился: $old -> $new")
}
class User{
    var name: String by Delegates.observable("no name"){ _, old, new ->
        println(" Имя изменено: `$old`->`new`")
    }
}