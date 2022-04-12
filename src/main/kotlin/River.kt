class River(private val fish: List<Fish>) {
    fun survivors(): List<Fish> {
        if (fish.size < 2) {
            return fish
        }
        if (fish[0].direction == fish[1].direction) {
            return fish
        }
        if (fish[0].strength > fish[1].strength) {
            return listOf(fish[0], fish[1])
        }
        return listOf(fish[1])
    }
}
