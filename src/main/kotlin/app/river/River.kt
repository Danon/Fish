package app.river

import app.river.Direction.North

class River(private val fishes: List<Fish>) {
    fun survivors(): List<Fish> {
        val survivors = mutableListOf<Fish>()
        val oppositeDirection = mutableListOf<Fish>();
        for (fish in fishes) {
            if (fish.direction == North) {
                oppositeDirection.add(fish);
                continue;
            }
            val survivorFish = eatOtherFishesOrDie(fish, oppositeDirection)
            survivorFish?.also { survivors.add(it); }
        }
        survivors.addAll(oppositeDirection);
        return survivors
    }

    private fun eatOtherFishesOrDie(fish: Fish, oppositeDirection: MutableList<Fish>): Fish? {
        var realFishStrength = fish.strength;
        var fishWasEaten = false;
        var fishAteEachOther = false;
        while (oppositeDirection.isNotEmpty()) {
            val other = oppositeDirection.last()
            if (other.strength > realFishStrength) {
                fishWasEaten = true;
                oppositeDirection.removeLast();
                oppositeDirection.add(Fish(other.strength + realFishStrength, other.direction))
                break;
            }
            if (other.strength == realFishStrength) {
                fishAteEachOther = true;
            } else {
                realFishStrength += other.strength;
            }
            oppositeDirection.removeLast();
        }
        return if (!fishWasEaten && !fishAteEachOther) {
            Fish(realFishStrength, fish.direction)
        } else {
            null
        }
    }
};
