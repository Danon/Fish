import Direction.SwimsLeft
import Direction.SwimsRight

class River(private val fish: List<Fish>) {
    fun survivors(): List<Fish> {
        val survivors = mutableListOf<Fish>()

        if (fish.size < 2) {
            survivors.addAll(fish)
        } else {
            if (fish[0].direction == SwimsRight && fish[1].direction == SwimsLeft) {
                if (fish[0].strength != fish[1].strength) {
                    survivors.add(fish.maxByOrNull { it.strength }!!)
                }
            } else {
                survivors.addAll(fish)
            }
        }

        return survivors
    }
}
