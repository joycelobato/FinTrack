package com.example.fintrack

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class AddExpenseActivity : AppCompatActivity() {

    private lateinit var btnDone: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_expense)

        // Variáveis que guardam os valores que o user adiciono
        val edtDespesa = findViewById<EditText>(R.id.edt_nome_despesa)
        val edtValor = findViewById<EditText>(R.id.edt_valor)
        val edtCategoria = findViewById<EditText>(R.id.edt_nome_categoria)

        // Função para clicar no botão para adicionar a despesa.
        btnDone.setOnClickListener{
            val despesa = edtDespesa.text.toString()
            val valor = edtValor.text.toString()
            val valorFloat = valor.toFloat()
            val categoria = edtCategoria.text.toString()

            // Antes de adicionar a despesa, ele vai verificar se os campos foram preenchidos
            if(despesa.isNotEmpty() && valor.isNotEmpty() && categoria.isNotEmpty()){

            }
        }

    }


    private fun addOrUpdateDespesa(
        id: Int,
        despesa: String,
        valor: Float,
        //actionType: ActionType
    ){

    }

}