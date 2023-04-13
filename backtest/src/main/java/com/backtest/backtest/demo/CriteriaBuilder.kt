package com.backtest.backtest.demo

import java.math.BigDecimal
import java.math.RoundingMode
import kotlin.math.sqrt

class CriteriaBuilder {
    fun round(series: Array<BigDecimal>, precision: Int): Array<BigDecimal> {
        return series.map { it.setScale(precision, RoundingMode.HALF_UP) }.toTypedArray()
    }

    fun abs(series: Array<BigDecimal>): Array<BigDecimal> {
        return series.map { it.abs() }.toTypedArray()
    }

    fun max(series1: Array<BigDecimal>, series2: Array<BigDecimal>): Array<BigDecimal> {
        return series1.mapIndexed{ index, value -> value.max(series2[index]) }.toTypedArray()
    }

    fun min(series1: Array<BigDecimal>, series2: Array<BigDecimal>): Array<BigDecimal> {
        return series1.mapIndexed{ index, value -> value.min(series2[index]) }.toTypedArray()
    }

    fun ma(series: Array<BigDecimal>, n: Int): Array<BigDecimal> {
        return series.toList().windowed(size = n, step = 1, partialWindows = true) { window ->
            window.reduce { acc, bigDecimal -> acc + bigDecimal } / BigDecimal(n)
        }.toTypedArray()
    }

    fun nPeriodsAgo(series: Array<BigDecimal>, n: Int = 1): Array<BigDecimal> {
        return series.toList().windowed(size = n + 1, step = 1, partialWindows = true) { window ->
            window.first()
        }.toTypedArray()
    }

    fun diff(series: Array<BigDecimal>, n: Int = 1): Array<BigDecimal> {
        return series.toList().windowed(size = n + 1, step = 1, partialWindows = true) { window ->
            window.last() - window.first()
        }.toTypedArray()
    }

    fun std(series: Array<BigDecimal>, n: Int): Array<BigDecimal> {
        return series.toList().windowed(size = n, step = 1, partialWindows = true) { window ->
            val avg = window.reduce { acc, bigDecimal -> acc + bigDecimal } / BigDecimal(n)
            val sum = window.map { (it - avg).pow(2) }.reduce { acc, bigDecimal -> acc + bigDecimal }
            sqrt(sum.toDouble()).toBigDecimal()
        }.toTypedArray()
    }

    fun ifElse(
        boolSeries: Array<Boolean>,
        trueSeries: Array<BigDecimal>,
        falseSeries: Array<BigDecimal>
    ): Array<BigDecimal> {
        return boolSeries.mapIndexed { index, b ->
            if (b) trueSeries[index] else falseSeries[index]
        }.toTypedArray()
    }

    fun sumOverPeriods(series: Array<BigDecimal>, n: Int, minPeriods: Int? = null): Array<BigDecimal> {
        val sumFunc = { window: List<BigDecimal> -> window.reduce { acc, bigDecimal -> acc + bigDecimal } }
        return if (n > 0) {
            series.toList().windowed(size = n, step = 1, partialWindows = true) { window ->
                if (minPeriods != null && window.size < minPeriods) {
                    BigDecimal.ZERO
                } else {
                    sumFunc(window)
                }
            }.toTypedArray()
        } else {
            val result = mutableListOf<BigDecimal>()
            var sum = BigDecimal.ZERO
            series.forEach {
                sum += it
                result.add(sum)
            }
            result.toTypedArray()
        }
    }
}