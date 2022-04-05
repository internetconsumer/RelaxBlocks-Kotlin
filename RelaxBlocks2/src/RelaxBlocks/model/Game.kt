package RelaxBlocks.model

import kotlin.random.Random


// Game class, contains game matrix in which all Cells are located
// Essential to core of the Game
class Game(val height: Int, val width: Int) {
    var game = arrayListOf<ArrayList<Cell>>()

    //    game is an arraylist of an ArrayList of Cell
    init {
        if (height < 0 || width < 0) {
            throw IllegalArgumentException("ERROR. Game height or width invalid")
        }
        // Fill game per row with listrow, which is ArrayList of Cell
        for (i in 0 until height) {
            val listRow = ArrayList<Cell>()
            for (j in 0 until width) {
                listRow.add(Cell(i, j))
            }
            game.add(listRow)
        }
    }

}

// Cells used for Game, contain X and Y coordinate, given in constructor
// Given random value between 0 and 2 at start
class Cell(val y: Int, val x: Int) {
    var cellValue = Random.nextInt(3)
    var cellType: Char? = null

    init {
        if (cellValue > 3 || cellValue < 0) {
            throw IllegalArgumentException("ERROR. CellValue Illegal")
        }
        setCellType(cellValue)
    }

    //    Give cell value depending on filled(0 until 2) or empty(3)
    fun setCellType(cellValue: Int) {
        when (cellValue) {
            0 -> cellType = '0'
            1 -> cellType = '+'
            2 -> cellType = 'X'
            3 -> cellType = '▮'
            else -> {
                throw IllegalArgumentException("IllegalArgument")
            }
        }
    }
}

// Player class, contains name, current score and final/highScore
class Player(val name: String) {
    var score = 0
    var highScore = 0
}

class Input(var x: Int, var y: Int) {}