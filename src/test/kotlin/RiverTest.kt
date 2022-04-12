import Direction.SwimsLeft
import Direction.SwimsRight
import kotlin.test.Test
import kotlin.test.assertEquals

internal class RiverTest {
    @Test
    fun biggerFishShouldNotWin_inOppositeDirection_butPastEachOther_bigLeft() {
        assertAllFishLive(listOf(Fish(4, SwimsLeft), Fish(3, SwimsRight)))
        assertAllFishLive(listOf(Fish(5, SwimsLeft), Fish(6, SwimsRight)))
    }

    @Test
    fun biggerFishShouldNotWin_inOppositeDirection_butPastEachOther_bigRight() {
        assertAllFishLive(listOf(Fish(1, SwimsLeft), Fish(3, SwimsRight)))
        assertAllFishLive(listOf(Fish(10, SwimsLeft), Fish(16, SwimsRight)))
    }

    @Test
    fun biggerFishShouldWin_inOppositeDirection_firstBigFish() {
        // given
        val smallFish = Fish(3, SwimsRight)
        val bigFish = Fish(4, SwimsLeft)
        // then
        val survivors = River(listOf(smallFish, bigFish)).survivors()
        // then
        assertEquals(listOf(bigFish), survivors)
    }

    @Test
    fun biggerFishShouldWin_inOppositeDirection_secondBigFish() {
        // given
        val bigFish = Fish(9, SwimsRight)
        val smallFish = Fish(6, SwimsLeft)
        // then
        val survivors = River(listOf(bigFish, smallFish)).survivors()
        // then
        assertEquals(listOf(bigFish), survivors)
    }

    @Test
    fun bothFishShouldLive_inTheSameDirection_Right() {
        assertAllFishLive(
            listOf(
                Fish(3, SwimsRight),
                Fish(4, SwimsRight)
            )
        )
    }

    @Test
    fun bothFishShouldLive_inTheSameDirection_Left() {
        assertAllFishLive(
            listOf(
                Fish(3, SwimsLeft),
                Fish(4, SwimsLeft)
            )
        )
    }

    @Test
    fun shouldOneFishBeTheHighKing() {
        assertAllFishLive(listOf(Fish(0, SwimsLeft)))
        assertAllFishLive(listOf(Fish(0, SwimsRight)))
    }

    @Test
    fun emptyRiverShouldYieldNoSurvivors() {
        assertEquals(emptyList(), River(emptyList()).survivors())
    }

    private fun assertAllFishLive(fish: List<Fish>) {
        assertEquals(fish, River(fish).survivors())
    }
}
