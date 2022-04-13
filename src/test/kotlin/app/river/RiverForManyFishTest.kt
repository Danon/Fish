package app.river

import app.river.Direction.North
import app.river.Direction.South
import kotlin.test.Test
import kotlin.test.assertEquals

internal class RiverForManyFishTest {
    @Test
    fun shouldAllFriendsFishLive() {
        // given
        val nemo = Fish(4, South)
        val dory = Fish(3, South)
        val marlin = Fish(2, South)
        // then
        assertAllFishLive(listOf(nemo, dory, marlin))
    }

    @Test
    fun sharkShouldEatAllFish_Right() {
        // given
        val shark = Fish(4, North)
        val nemo = Fish(2, South)
        val dory = Fish(3, South)
        // then
        assertEquals(listOf(Fish(9, North)), River(listOf(shark, nemo, dory)).survivors())
    }

    @Test
    fun sharkShouldEatAllFish_Left() {
        // given
        val nemo = Fish(2, North)
        val dory = Fish(3, North)
        val shark = Fish(4, South)
        // then
        assertEquals(listOf(Fish(9, South)), River(listOf(nemo, dory, shark)).survivors())
    }

    @Test
    fun shouldEatingFishBeEaten() {
        // given
        val nemo = Fish(0, South)
        val shark1 = Fish(4, North)
        val dory = Fish(3, South)
        val shark2 = Fish(10, South)
        val merlin = Fish(2, South)
        val fish = listOf(nemo, shark1, dory, shark2, merlin)
        // then
        assertEquals(listOf(nemo, Fish(17, South), merlin), River(fish).survivors())
    }

    private fun assertAllFishLive(fish: List<Fish>) {
        assertEquals(fish, River(fish).survivors())
    }
}
