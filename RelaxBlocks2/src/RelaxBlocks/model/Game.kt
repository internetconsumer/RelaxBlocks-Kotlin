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

    fun setCell(y: Int, x: Int, cellValue: Int) {
        if (y < 0 || y > height) {
            throw IndexOutOfBoundsException("y coordinate is out of index range")
        }
        if (x < 0 || x > width) {
            throw IndexOutOfBoundsException("x coordinate is out of index range")
        }
        if (cellValue < 0 || cellValue > 3) {
            throw IllegalArgumentException("ERROR. CellValue Illegal")
        }
        game[y][x].cellValue = cellValue
        game[y][x].setCellType(cellValue)
        val formatterSetCell = "Cell x%d y%d value set to %s\n"
        print(formatterSetCell.format(x, y, game[y][x].cellType))
    }

}


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

class Player(val name: String) {
    var score = 0
    var highScore = 0

}

class Input(var x: Int, var y: Int) {}