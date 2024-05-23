package com.example.fintrack

import com.example.fintrack.local.Expense
import java.io.Serializable

enum class DespesaAction {
    DELETE,
    UPDATE,
    CREATE
}

data class DespesaAction(
    val despesa: Expense?,
    val actionType: String
) : Serializable