package app.ui

import app.river.Direction.North
import app.river.Direction.South
import app.river.Fish
import kotlin.test.Test
import kotlin.test.assertEquals

internal class FishStrengthsTest {
    @Test
    fun notation() {
        // given
        val fishStrengths = FishStrengths(listOf(4, -3))
        // when
        val river = fishStrengths.river();
        // then
        assertEquals(listOf(Fish(4, South), Fish(3, North)), river.survivors())
    }
}
