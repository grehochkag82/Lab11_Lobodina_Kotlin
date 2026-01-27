import example.handleResult
import modules.EnergyGenerator
import modules.ResearchLab
import resources.OutpostResource
import resources.ResourceManager


import example.InstantMessager
import example.PhotoCamera
import example.SmartPhone
import modules.ModuleResult
import payment.CardType
import payment.Payment
import payment.PaymentProcessor
import example.counter

fun main() {
    val processor = PaymentProcessor()
    val payments = listOf(
        Payment("4_111_111_111_111_111", 1000, CardType.VISA),
        Payment("5_111_111_111_111_111", 1000, CardType.MASTERCARD),
        Payment("2_222_222_222_222_222", 2000, CardType.MIR),
        Payment("1234567812345678", 500, CardType.UNKNOWN),
        Payment("123", 300, CardType.VISA)
    )
    println("Обработка платежей")
    payments.forEach { payment ->
        println("\nПлатеж ${payment.type}: ${payment.card.take(4)} . . . , ${payment.sum}руб")
        val result = processor.pay(payment)
        processor.show(result)
    }
    println("\n Работа с enum")
    val cardType = CardType.VISA
    println(" $cardType")
    println("${cardType.ordinal}")
    println(" ${CardType.values().joinToString()}")

    val payment1 = Payment("4111111111111111", 1000, CardType.VISA)
    val payment2 = payment1.copy(type = CardType.MASTERCARD, sum = 2000)

    println("\n Сравнение data-class")
    println("Платёж 1: $payment1")
    println("Платёж 2: $payment2")
    println("Одинаковые? ${payment1 == payment2}")

    fun handleModuleResult(result: ModuleResult) {
        when (result) {
            is ModuleResult.Success ->
                println("${result.message}")
            is ModuleResult.ResourceProduced ->
                println("Произведено: ${result.resource}+${result.amount}")
            is ModuleResult.NotEnoughResources ->
                println(
                    "Недостаточно ресурса ${result.resourceName}. " +
                            "Нужно:${result.required}, есть:${result.avaliable}"
                )
                is ModuleResult.Error ->
                    println("ОШИБКА${result.reason}")
        }
    }


//    val manager = resources.ResourceManager()
//    val minerals = OutpostResource(1, "Minerals", 300)
//    val gas = OutpostResource(2, "Gas", 100)
//    manager.add(minerals)
//    manager.add(gas)
//    manager.printAll()
//    val bonus = minerals.copy(amount = minerals.amount + 50)
//    println("Копия минералов с бонусом: $bonus")
    val manager = ResourceManager()
    manager.add(OutpostResource(1, "Minerals", 120))
    manager.add(OutpostResource(2, "Gas", 40))
    val generator = EnergyGenerator()
    val lab = ResearchLab()
    generator.performAction(manager)
    lab.performAction(manager)
    println()
    manager.printAll()
    val generatorResult = generator.performAction(manager)
    val labResult = lab.performAction(manager)
    handleModuleResult(generatorResult)
    handleModuleResult(labResult)
    println()
    manager.printAll()
    val max = InstantMessager("MAX")
    val photoCamera = PhotoCamera()
    val yotaPhone = SmartPhone("YotaPhone", max)
    yotaPhone.sendTextMessage()
    yotaPhone.sendVideoMessage()
    counter = 1
    counter = 5
}
