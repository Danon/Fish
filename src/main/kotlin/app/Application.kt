package app

class Application {
    fun main() {
        // Fish declared from summary
        val integers = listOf(1, 5, -4, -2, 3, 3)
        val fishStrengths = app.ui.FishStrengths(integers)

        // Represent integer notation of fish strength and directions to entities
        val river: app.river.River = fishStrengths.river();

        // Get surviving fish
        val survivors = river.survivors();

        // Present surviving fish to the client of the interface (user)
        println("We're taking a look at numbers: (South) $integers (North)");
        println("There are ${survivors.size} fish that survived!");
        survivors.forEach { survivor ->
            println("Fish of strength ${survivor.strength} managed to escape ${survivor.direction}");
        };
    }
}
