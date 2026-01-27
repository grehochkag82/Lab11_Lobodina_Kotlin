## Galaxy Outpost Manager
___
Учебный проект на Kotlin, демонстрирующий основы объектно-ориентированного программирования и
архитектурные приёмы языка.
___
### Sealed-классы
___
**Sealed-классы** используются для представления ограниченного набора состояний или результатов, которые
известны на этапе компиляции.
Они позволяют:
- гарантировать обработку всех возможных вариантов;
- безопасно использовать конструкцию when без else;
- удобно описывать состояния, события и результаты действий.
### Пример: результат работы модуля
```sealed-class ModuleResult {
data class Success(val message: String) : ModuleResult()
data class ResourceProduced(val resourceName: String, val amount: Int) : ModuleResult()
data class NotEnoughResources(
val resourceName: String,
val required: Int,
val available: Int
) : ModuleResult()
data class Error(val reason: String) : ModuleResult()
}
````
### **Object в Kotlin**
**object** — это специальная конструкция Kotlin, которая создаёт единственный экземпляр класса (Singleton).
Особенности:
- создаётся при первом обращении;
- существует в одном экземпляре;
- не имеет конструктора.
### Пример: глобальный логгер
``` object Logger {
private var counter = 0
fun log(message: String) {
counter++
println("[$counter] $message")
}
}
```
**Использование:**
``` 
Logger.log("Инициализация системы")
Logger.log("Модуль запущен")
```
**object** удобно использовать для:
- логгеров;
- конфигураций;
- состояний без данных в sealed-классах;
- утилитарных классов