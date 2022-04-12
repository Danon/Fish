import Direction.South
import Direction.North
import kotlin.test.Test
import kotlin.test.assertEquals

internal class AcceptanceTest {
    @Test
    fun acceptance() {
        // Example when providing size and direction as integers (positive to the South, negative numbers swim to the North).
        // Position in array maps to position in the river from South to North):
        // Fishes: 1,5,-4,-2,3,3
        // Output with explanation: 1,5 reaches South, as they will not meet any other fishes. -4 will reach North end,
        // after conflicts with two size 3 fishes swimming to the South.

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
            Fish(4, North)
        )
        assertEquals(expected, River(fish).survivors())
    }
}
