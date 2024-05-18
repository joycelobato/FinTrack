package com.example.fintrack

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText

class AddExpenseActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_expense)

        // Add nome da despesa
        val edtDespesa = findViewById<EditText>(R.id.edt_nome_despesa)


    }
}