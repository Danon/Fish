class River(private val fish: List<Fish>) {
    fun survivors(): List<Fish> {
        if (fish.size < 2) {
            return fish
        }
        if (fish[0].direction == fish[1].direction) {
            return fish
        }
        return listOf(fish.maxByOrNull { fish -> fish.strength }!!)
    }
}
