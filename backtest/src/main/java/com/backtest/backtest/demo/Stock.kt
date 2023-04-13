import java.io.File
import java.time.LocalDate
import java.time.ZoneOffset
import java.time.format.DateTimeFormatter

class Stock(path: String) {
    var symbol: String = ""
    var name: String = ""
    var timePeriod: String = ""
    var splitAdjust: String = ""
    var date: List<LocalDate> = listOf()
    var open: List<Double> = listOf()
    var close: List<Double> = listOf()
    var high: List<Double> = listOf()
    var low: List<Double> = listOf()
    var volume: List<Double> = listOf()
    var turnVolume: List<Double> = listOf()
    var timestamp: List<Long> = listOf()
    var dateToClose: Map<LocalDate, Double> = mapOf()

    init {
        val lines = File(path).readLines(Charsets.ISO_8859_1)
        val title = lines[0].trim().split("\\s+".toRegex())

        symbol = title[0]
        name = title.subList(1, title.size - 2).joinToString(" ")
        timePeriod = title[title.size - 2]
        splitAdjust = title[title.size - 1]

        for (line in lines.drop(2)) {
            val data = line.trim().split("\\s+".toRegex())

            if (data.size < 7) {
                break
            }

            val date = LocalDate.parse(data[0], DateTimeFormatter.ofPattern("yyyy/MM/dd"))
            this.date += date
            this.timestamp += date.atStartOfDay().toEpochSecond(ZoneOffset.UTC)
            this.open += data[1].toDouble()
            this.high += data[2].toDouble()
            this.low += data[3].toDouble()
            this.close += data[4].toDouble()
            this.volume += data[5].toDouble()
            this.turnVolume += data[6].toDouble()
        }

        dateToClose = date.zip(close).toMap()
    }
}

fun getAllStocks(path: String): Map<String, Stock> {
    val files = File(path).listFiles() ?: emptyArray()
    val stocks = mutableMapOf<String, Stock>()

    for (file in files.slice(0..5)) {
        val stock = Stock(file.path)
        stocks[stock.symbol] = stock
        println(stock.close)
    }

    return stocks
}

fun main() {
    val stock = Stock("C:/Users/insect/Desktop/股票数据/SH#600000.txt")
    val stocks = getAllStocks("C:/Users/insect/Desktop/stock_data_test")
    println(stocks["600000"]?.close)




}
fun test() {
    var s = generateSequence { 1 }.take(10).toList()


    fun comp(compare: (a: Int, b: Int) -> Int) = compare(1, 2)
    val sum: (Int, Int) -> Int = { x: Int, y: Int -> x + y }
    val sum2 = { x: Int, y: Int -> x + y }
}