package example

sealed class NetworkResult{
    data class Success(val data: String): NetworkResult()
    data class Error(val message: String, val code: Int):NetworkResult()
    object Loading: NetworkResult()
}
fun handleResult(result: NetworkResult){
    when(result){
        is NetworkResult.Success -> {
            println("Успех ${result.data}")
    }
        is NetworkResult.Error ->{
            println("Ошибка ${result.code}: ${result.message}")

        }
        NetworkResult.Loading ->{
            println("Загрузка...")
        }
    }
}
object GameSession{
    init {
        println("Игровая сессия создана")
    }
    var isActive: Boolean = false
    fun start(){
        isActive= true
        println("Игра началась")
    }
    fun end(){
        isActive = false
        println("Игра завершена")
    }
}

object Logger {
    var count =0
    fun log (message: String){
        count++
        println("[$count] $message")
    }
}
object  AppSettings{
    val version= "1.0.0"
    var isDarkMode = true
    fun toggleTheme(){
        isDarkMode= !isDarkMode
    }
    fun checkTheme(){
        if (AppSettings.isDarkMode){
            println("Темная тема включена")
        }
    }
}
object  Colors{
    const val RED= "#FF0000"
    const val GREEN = "#00FF00"
    const val BLUE = "0000FF"
}
class MyCar(val model: String) {
    fun drive() = println("$model едет")
}
object TrafficController{
    var carCount=0
    fun carPassed(){
        carCount++
    }
}
sealed class OrderStatus{
    object Created : OrderStatus()
    object Paid: OrderStatus()
    object Shipped: OrderStatus()
    data class Cancelled(val reason: String): OrderStatus()
}
fun handleOrder(status: OrderStatus){
    when(status){
        OrderStatus.Created-> println("Заказ создан")
        OrderStatus.Paid -> println("Заказ оплачен")
        OrderStatus.Shipped -> println("Заказ отправлен")
        is OrderStatus.Cancelled-> println("Отменён: ${status.reason}")
    }
}
fun main(){
    val success = NetworkResult.Success("Данные получены")
    val error = NetworkResult.Error("Сервер не отвечает",500)
    val loading = NetworkResult.Loading
    handleResult(success)
    handleResult(error)
    handleResult(loading)
    println("Программв запущена")
    println("Проверяем состояние, но не трогаем GameSession")
    println("Теперь запускем игру")
    GameSession.start()
    println("Проверяем состояние ещё раз")
    println("Активна ли сессия: ${GameSession.isActive}")
    Logger.log("Первое сообщение")
    Logger.log("Второе сообщение")
    val logger1= Logger
    val logger2= Logger
    println(logger1==logger2)
    println(Colors.RED)
    println(Colors.GREEN)
    println(Colors.BLUE)
    val handler = object {
        val name = "Обработчик"
        fun handle() {
            println("Обрабатываю...")
        }
    }
    println(handler.name)
    handler.handle()
    MyCar("Toyota")
    MyCar("BMW")
    TrafficController.carPassed()
    handleOrder(OrderStatus.Created)
    handleOrder(OrderStatus.Paid)
    handleOrder(OrderStatus.Shipped)
    handleOrder(OrderStatus.Cancelled("Нет товара на складе"))

}