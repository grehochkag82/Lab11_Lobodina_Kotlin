package example

interface Movable{
    var speed: Int
    val model: String
    val number: String
    fun move()
    fun stop() {
        println("Останавливаемся...")
    }
}
class Car(
    override val model: String,
    override val number: String
) : Movable {
    override var speed = 60
    override fun move() {
        println("Едем на машине сл скоростью $speed км/ч")
    }
}

class Aircraft(
    override val model: String,
    override val number: String
) : Movable {
    override var speed = 600
    override fun move() {
        println("Летим на самолете со скоростью $speed км/ч")
    }
    override fun stop() = println("Приземляемся...")
}

fun travel(obj: Movable) = obj.move()

interface Worker{
    fun work()
}
interface Student{
    fun study()
}

class WorkingStudent(val name: String): Worker, Student {
    override fun work() = println("$name работает")
    override fun study() = println("$name учится")
}

fun main() {
    val car = Car("LADA", "134LAD")
    val aircraft = Aircraft("Boeing", "737")
//    travel(car)
//    travel(aircraft)
//    val veronika= WorkingStudent("Veronika")
//    veronika.work()
//    veronika.study()
//    car.move()
//    car.stop()
//    aircraft.move()
//    aircraft.stop()
    val player = MediaPlayer()
    player.play()
}

interface VideoPlayable {
    fun play() = println("Play video")
}

interface AudioPlayable {
    fun play() = println("Play audio")
}

class MediaPlayer: VideoPlayable, AudioPlayable {
    override fun play() {
        println("Start playing")
        super<VideoPlayable>.play()
        super<AudioPlayable>.play()
    }
}