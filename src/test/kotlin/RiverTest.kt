import Direction.SwimsLeft
import Direction.SwimsRight
import kotlin.test.Test
import kotlin.test.assertEquals

internal class RiverTest {
    @Test
    fun biggerFishShouldNotWin_inOppositeDirection_butPastEachOther() {
        assertAllFishLive(listOf(Fish(4, SwimsLeft), Fish(3, SwimsRight)))
    }

    @Test
    fun biggerFishShouldWin_inOppositeDirection() {
        // given
        val fish = listOf(
            Fish(3, SwimsRight),
            Fish(4, SwimsLeft)
        )
        // then
        val survivors = River(fish).survivors()
        // then
        assertEquals(listOf(Fish(4, SwimsLeft)), survivors)
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
