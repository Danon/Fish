package app.river

import app.river.Direction.North
import app.river.Direction.South
import kotlin.test.Test
import kotlin.test.assertEquals

internal class AcceptanceTest {
    @Test
    fun shouldBiggerSharkEatSmallerShark() {
        // given
        val fish = listOf(
            Fish(1, South),
            Fish(5, South),
            Fish(4, North),
            Fish(2, North),
            Fish(3, South),
            Fish(3, South),
        )
        // then
        val expected = listOf(
            Fish(1, South),
            Fish(5, South),
            Fish(9, South),
            Fish(3, South),
        )
        assertEquals(expected, River(fish).survivors())
    }

    @Test
    fun shouldSumFish() {
        // given
        val fish = listOf(
            Fish(6, North),
            Fish(2, North),
            Fish(1, North),
            Fish(3, South)
        )
        // then
        assertEquals(emptyList(), River(fish).survivors())
    }
}
