package com.example.fintrack.local

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity
data class Expense(
    @PrimaryKey(autoGenerate = true) // Faz com que toda tarefa tenha um id único no banco de dados.
    val id: Int = 0,
    var despesa: String,
    var categoria: String,
    var valor: String
): Serializable
