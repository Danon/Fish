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
            val fishLives = eatOtherFishesOrDie(fish, oppositeDirection)
            if (fishLives) {
                survivors.add(fish);
            }
        }
        survivors.addAll(oppositeDirection);
        return survivors
    }

    private fun eatOtherFishesOrDie(fish: Fish, otherFishes: MutableList<Fish>): Boolean {
        var fishWasEaten = false;
        var fishAteEachOther = false;
        while (otherFishes.isNotEmpty()) {
            val other = otherFishes.last()
            if (other.strength > fish.strength) {
                fishWasEaten = true;
                break;
            }
            if (other.strength == fish.strength) {
                fishAteEachOther = true;
            }
            otherFishes.removeLast();
        }
        return !fishWasEaten && !fishAteEachOther
    }
}