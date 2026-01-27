package modules

import resources.ResourceManager

class ResearchLab : OutpostModule("Исследовательская лаборатория") {
    override fun performAction(manager: ResourceManager): ModuleResult{
        val minerals = manager.get("Minerals")
        if (minerals == null || minerals.amount < 30) {
            //println("Недостаточно минералов для исследования")
            return ModuleResult.NotEnoughResources(
                resourceName= "Minerals",
                required =30,
                avaliable = minerals?.amount ?:0
            )
        } else {
            minerals.amount -= 30
            //println("Лаборатория проводит исследование (минералы -30)")
            return ModuleResult.Success("Исследование завершено")
        }
    }
}