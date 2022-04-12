import kotlin.test.Test
import kotlin.test.assertEquals

internal class RiverTest {
    @Test
    fun biggerFishShouldWin() {
        val river = River(listOf(Fish(3), Fish(4)))
        assertEquals(listOf(Fish(4)), river.survivors())
    }

    @Test
    fun emptyRiverShouldYieldNoSurvivors() {
        assertEquals(emptyList(), River(emptyList()).survivors())
    }
}
