import Direction.SwimsLeft
import Direction.SwimsRight
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

    @Test
    fun sharkShouldEatAllFish_Right() {
        // given
        val shark = Fish(4, SwimsRight)
        val nemo = Fish(2, SwimsLeft)
        val dory = Fish(3, SwimsLeft)
        // then
        assertEquals(listOf(shark), River(listOf(shark, nemo, dory)).survivors())
    }

    @Test
    fun sharkShouldEatAllFish_Left() {
        // given
        val nemo = Fish(2, SwimsRight)
        val dory = Fish(3, SwimsRight)
        val shark = Fish(4, SwimsLeft)
        // then
        assertEquals(listOf(shark), River(listOf(nemo, dory, shark)).survivors())
    }

    @Test
    fun shouldEatingFishBeEaten() {
        // given
        val nemo = Fish(0, SwimsLeft)
        val shark1 = Fish(4, SwimsRight)
        val dory = Fish(3, SwimsLeft)
        val shark2 = Fish(5, SwimsLeft)
        val merlin = Fish(2, SwimsLeft)
        val fish = listOf(nemo, shark1, dory, shark2, merlin)
        // then
        assertEquals(listOf(nemo, shark2, merlin), River(fish).survivors())
    }

    private fun assertAllFishLive(fish: List<Fish>) {
        assertEquals(fish, River(fish).survivors())
    }
}
