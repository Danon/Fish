package app.ui

import app.river.Direction.North
import app.river.Direction.South
import app.river.Fish
import app.river.River

class FishStrengths(private val strengths: List<Int>) {
    fun river() = River(strengths.map(::fishOfStrengthAndDirection));

    private fun fishOfStrengthAndDirection(directedStrength: Int) =
        if (directedStrength < 0) Fish(-directedStrength, North) else Fish(directedStrength, South);
}
