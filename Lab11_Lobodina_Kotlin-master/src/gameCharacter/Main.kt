package gameCharacter
fun main() {
    val hero = GameCharacter("Герой")
    val enemy = GameCharacter("Враг")
    hero.printStatus()
    enemy.printStatus()
    println("\nБой начинается")
    hero.attack(enemy, 30)
    enemy.attack(hero, 20)
    hero.run()
    enemy.idle()
    hero.attack(enemy, 50)
    enemy.attack(hero, 100)
    hero.printStatus()
    enemy.printStatus()
    hero.run()
    hero.attack(enemy, 10)
}