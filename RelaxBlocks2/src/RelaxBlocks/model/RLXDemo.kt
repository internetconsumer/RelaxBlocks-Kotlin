package RelaxBlocks.model

fun main() {
    val game = Game(15, 15)
    displayer(game)

    game.setCell(4, 4, 3)
    game.setCell(4, 2, 3)
    game.setCell(4, 5, 3)
    displayer(game)


}

// Displayer for console view of Game
fun displayer(game: Game) {
    val formatter0 = "%5s"
    print(formatter0.format(""))
    for (i in 0 until game.width) {
        print(formatter0.format(i))
    }
    println()
    var teller = 0
    for (inner in game.game) {
        print(formatter0.format(teller++))
        for (inside in inner) {
            print(formatter0.format(inside.cellType))
        }
        println()
    }
}