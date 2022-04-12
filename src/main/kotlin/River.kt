import Direction.SwimsRight

class River(private val fishes: List<Fish>) {
    fun survivors(): List<Fish> {
        val survivors = mutableListOf<Fish>()

        val temporaryStack = mutableListOf<Fish>();
        for (fish in fishes) {
            if (fish.direction == SwimsRight) { // fish goes right
                temporaryStack.add(fish);
                continue;
            }
            var fishWasEaten = false;
            var fishAteEachOther = false;
            while (temporaryStack.isNotEmpty()) {
                val stackFish = temporaryStack.last()
                if (stackFish.strength > fish.strength) {
                    fishWasEaten = true;
                    break;
                }
                if (stackFish.strength == fish.strength) {
                    fishAteEachOther = true;
                }
                temporaryStack.removeLast();
            }
            if (!fishWasEaten && !fishAteEachOther) {
                survivors.add(fish);
            }
        }
        survivors.addAll(temporaryStack);

        return survivors
    }
}
