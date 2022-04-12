import Direction.SwimsRight

class River(private val fish: List<Fish>) {
    fun survivors(): List<Fish> {
        val survivors = mutableListOf<Fish>()

        if (fish.size < 2) {
            survivors.addAll(fish)
        } else {
            val temporaryStack = mutableListOf<Fish>();
            for (fish_ in fish) {
                if (fish_.direction == SwimsRight) { // fish goes right
                    temporaryStack.add(fish_);
                } else { // fish goes left
                    var fishIsLast = false;
                    var wereEqual = false;
                    while (temporaryStack.isNotEmpty()) {
                        val stackFish = temporaryStack.last()
                        if (stackFish.strength > fish_.strength) {
                            fishIsLast = true;
                            break;
                        }
                        if (stackFish.strength == fish_.strength) {
                            wereEqual = true;
                        }
                        temporaryStack.removeLast();
                    }
                    if (!fishIsLast && !wereEqual) {
                        survivors.add(fish_);
                    }
                }
            }
            survivors.addAll(temporaryStack);
        }
        return survivors
    }
}
