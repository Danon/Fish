package app.river

import app.river.Direction.North
import app.river.Direction.South
import kotlin.test.Test
import kotlin.test.assertEquals

internal class RiverForTwoFishTest {
    @Test
    fun birdEatsTwoDeadFish() {
        assertEquals(emptyList(), River(listOf(Fish(0, North), Fish(0, South))).survivors())
        assertEquals(emptyList(), River(listOf(Fish(3, North), Fish(3, South))).survivors())
    }

    @Test
    fun biggerFishShouldNotWin_inOppositeDirection_butPastEachOther_bigLeft() {
        assertAllFishLive(listOf(Fish(4, South), Fish(3, North)))
        assertAllFishLive(listOf(Fish(5, South), Fish(6, North)))
    }

    @Test
    fun biggerFishShouldNotWin_inOppositeDirection_butPastEachOther_bigRight() {
        assertAllFishLive(listOf(Fish(1, South), Fish(3, North)))
        assertAllFishLive(listOf(Fish(10, South), Fish(16, North)))
    }

    @Test
    fun biggerFishShouldWin_inOppositeDirection_firstBigFish() {
        // given
        val smallFish = Fish(3, North)
        val bigFish = Fish(4, South)
        // then
        val survivors = River(listOf(smallFish, bigFish)).survivors()
        // then
        assertEquals(listOf(bigFish), survivors)
    }

    @Test
    fun biggerFishShouldWin_inOppositeDirection_secondBigFish() {
        // given
        val bigFish = Fish(9, North)
        val smallFish = Fish(6, South)
        // then
        val survivors = River(listOf(bigFish, smallFish)).survivors()
        // then
        assertEquals(listOf(bigFish), survivors)
    }

    @Test
    fun bothFishShouldLive_inTheSameDirection_Right() {
        assertAllFishLive(
            listOf(
                Fish(3, North),
                Fish(4, North)
            )
        )
    }

    @Test
    fun bothFishShouldLive_inTheSameDirection_Left() {
        assertAllFishLive(
            listOf(
                Fish(3, South),
                Fish(4, South)
            )
        )
    }

    @Test
    fun shouldOneFishBeTheHighKing() {
        assertAllFishLive(listOf(Fish(0, South)))
        assertAllFishLive(listOf(Fish(0, North)))
    }

    @Test
    fun emptyRiverShouldYieldNoSurvivors() {
        assertEquals(emptyList(), River(emptyList()).survivors())
    }

    private fun assertAllFishLive(fish: List<Fish>) {
        assertEquals(fish, River(fish).survivors())
    }
}
