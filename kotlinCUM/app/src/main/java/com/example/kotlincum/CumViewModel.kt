package com.example.kotlincum

import androidx.lifecycle.ViewModel

class CumViewModel : ViewModel() {
    var notas: MutableList<Double> = mutableListOf()
    var uvs: MutableList<Int> = mutableListOf()

    fun addnota(nota: Double) {
        notas.add(nota)
    }

    fun adduv(uv: Int) {
        uvs.add(uv)
    }

    fun calcularCum(): Double {
        var totaluvs = 0
        var weightedSum = 0.0

        for (i in 0 until notas.size) {
            totaluvs += uvs[i]
            weightedSum += notas[i] * uvs[i]
        }

        return if (totaluvs == 0) {
            0.0
        } else {
            weightedSum / totaluvs
        }
    }
}
