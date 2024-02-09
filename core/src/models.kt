data class Position(
        val instrumentName: String,
        val amount: Int,
        val currency: Currency,
        val averagePrice: Double,
        val currentPrice: Double,
        val value: Double,
        val unrealizedPnl: Double
)

enum class Currency(val symbol: String) {
    Usd("$"),
    Eur("€"),
    Rub("₽")
}