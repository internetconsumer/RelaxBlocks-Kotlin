package RelaxBlocks.model

import kotlin.random.Random

class Game(val height: Int, val width: Int) {


    init {
        if (height < 0 || width < 0) {
            throw IllegalArgumentException("ERROR. Game height or width invalid")
        }
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