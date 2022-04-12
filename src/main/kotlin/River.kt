import Direction.SwimsRight

class River(private val fishes: List<Fish>) {
    fun survivors(): List<Fish> {
        val survivors = mutableListOf<Fish>()

        val oppositeDirection = mutableListOf<Fish>();
        for (fish in fishes) {
            if (fish.direction == SwimsRight) {
                oppositeDirection.add(fish);
                continue;
            }
            var fishWasEaten = false;
            var fishAteEachOther = false;
            while (oppositeDirection.isNotEmpty()) {
                val nextFish = oppositeDirection.last()
                if (nextFish.strength > fish.strength) {
                    fishWasEaten = true;
                    break;
                }
                if (nextFish.strength == fish.strength) {
                    fishAteEachOther = true;
                }
                oppositeDirection.removeLast();
            }
            if (!fishWasEaten && !fishAteEachOther) {
                survivors.add(fish);
            }
        }
        survivors.addAll(oppositeDirection);

        return survivors
    }
}
