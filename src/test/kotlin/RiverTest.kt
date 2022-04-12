import Direction.SwimsLeft
import Direction.SwimsRight
import kotlin.test.Test
import kotlin.test.assertEquals

internal class RiverTest {
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
    fun bothFishShouldLive_inTheSameDirection() {
        // given
        val fish = listOf(
            Fish(3, SwimsRight),
            Fish(4, SwimsRight)
        )
        // then
        val survivors = River(fish).survivors()
        // then
        assertEquals(fish, survivors)
    }

    @Test
    fun shouldOneFishBeTheHighKing() {
        val fish = Fish(0, SwimsLeft)
        assertEquals(listOf(fish), River(listOf(fish)).survivors())
    }

    @Test
    fun emptyRiverShouldYieldNoSurvivors() {
        assertEquals(emptyList(), River(emptyList()).survivors())
    }
}
