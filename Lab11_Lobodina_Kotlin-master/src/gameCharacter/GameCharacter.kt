package gameCharacter
class GameCharacter(private var name: String) {
    private var health = 100
    private var state: CharacterState = CharacterState.Idle
    fun changeState(newState: CharacterState) {
        state = newState
        println("$name: состояние изменено на $state")
    }
    fun attack(target: GameCharacter, damage: Int) {
        if (health > 0) {
            changeState(CharacterState.Attacking(damage))
            target.takeDamage(damage)
        } else {
            println("$name не может атаковать: персонаж мёртв")
        }
    }
    fun takeDamage(damage: Int) {
        if (health > 0) {
            health -= damage
            println("$name получает $damage урона. Здоровье: $health")
            if (health <= 0) {
                changeState(CharacterState.Dead("Потеряно всё здоровье"))
            }
        }
    }
    fun run() {
        if (health > 0) {
            changeState(CharacterState.Running)
        } else {
            println("$name не может бежать: персонаж мёртв")
        }
    }
    fun idle() {
        if (health > 0) {
            changeState(CharacterState.Idle)
        }
    }
    fun printStatus() {
        println("Персонаж: $name, Здоровье: $health, Состояние: $state")
    }
}