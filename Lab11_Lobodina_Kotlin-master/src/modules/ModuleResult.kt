package modules

import resources.OutpostResource

sealed class ModuleResult {
    data class Success (val message: String) : ModuleResult()
    data class ResourceProduced(
        val resource: String, val amount: Int
    ): ModuleResult()
    data class NotEnoughResources(
        val resourceName: String,
        val required: Int,
        val avaliable: Int
    ): ModuleResult()
    data class Error(val reason: String): ModuleResult()
}