import Direction.SwimsLeft
import Direction.SwimsRight

class River(private val fish: List<Fish>) {
    fun survivors(): List<Fish> {
        if (fish.size < 2) {
            return fish
        }
        if (fish[0].direction == SwimsRight && fish[1].direction == SwimsLeft) {
            if (fish[0].strength == fish[1].strength) {
                return emptyList()
            }
            return listOf(fish.maxByOrNull { it.strength }!!)
        }
        return fish
    }
}
