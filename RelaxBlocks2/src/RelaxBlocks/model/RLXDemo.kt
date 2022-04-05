package RelaxBlocks.model

fun main() {
    val player = Player("player1")
    val testTemplate = "%s currently has %d points."
    println(testTemplate.format(player.name, player.score))
    val templateTwo = "Cell %-10d X coordinate: %-8dY coordinate: %d\nCellType: %s"
    var testingTime = arrayListOf<Cell>()
    for (i in 0 until 10) {
        testingTime.add(i, Cell(0, i))
    }

    for (i in 0 until 10) {
        println(templateTwo.format(i,testingTime[i].x, testingTime[i].y, testingTime[i].cellType))
    }
    val cell = Cell(5, 5)  // Cell test, illegal CellValue
    val templateThree = "X coordinate: %-8dY coordinate: %d\nCellType: %s"
    println(templateThree.format(cell.x, cell.y, cell.cellType))
}