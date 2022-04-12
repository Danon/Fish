class River(private val fish: List<Fish>) {
    fun survivors(): List<Fish> {
        if (fish.isEmpty()) {
            return emptyList()
        }
        return listOf(fish.maxByOrNull { fish -> fish.strength }!!)
    }
}
