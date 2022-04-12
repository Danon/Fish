import Direction.SwimsLeft
import kotlin.test.Test
import kotlin.test.assertEquals

internal class RiverForThreeFishTest {
    @Test
    fun shouldAllFriendsFishLive() {
        // given
        val nemo = Fish(4, SwimsLeft)
        val dory = Fish(3, SwimsLeft)
        val marlin = Fish(2, SwimsLeft)
        // then
        assertAllFishLive(listOf(nemo, dory, marlin))
    }

    private fun assertAllFishLive(fish: List<Fish>) {
        assertEquals(fish, River(fish).survivors())
    }
}
