import kotlin.test.Test
import kotlin.test.assertEquals

internal class RiverTest {
    @Test
    fun emptyRiverShouldYieldNoSurvivors() {
        assertEquals(emptyList(), River().survivors())
    }
}
