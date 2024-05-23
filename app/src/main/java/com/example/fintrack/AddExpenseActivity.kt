package com.example.fintrack

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import androidx.activity.viewModels
import android.widget.Button
import android.widget.EditText
import com.example.fintrack.local.Expense

class AddExpenseActivity : AppCompatActivity() {

    private var despesa: Expense? = null
    private lateinit var btnDone: Button

    private val viewModel: DespesaAddViewModel by viewModels{
        DespesaAddViewModel.getVMFactory(application)
    }

    companion object{
        private const val DESPESA_ADD_EXTRA = "despesa.extra.add"

        // Aula pegando resultado de uma activity.
        fun start(context: Context, despesa: Expense?): Intent{
            val intent = Intent(context, AddExpenseActivity::class.java)
                .apply {
                    putExtra(DESPESA_ADD_EXTRA, despesa)
                }
            return intent
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_expense)

        //Recuperar tudo, Aula pegando resultado
        despesa = intent.getSerializableExtra(DESPESA_ADD_EXTRA) as Expense?

        // Variáveis que guardam os valores que o user adiciono
        val edtDespesa = findViewById<EditText>(R.id.edt_nome_despesa)
        val edtValor = findViewById<EditText>(R.id.edt_valor)
        val edtCategoria = findViewById<EditText>(R.id.edt_nome_categoria)

        //btnDone = findViewById<Button>(R.id.btn_done)

        // Função para clicar no botão para adicionar a despesa.
        btnDone.setOnClickListener{
            val despesa = edtDespesa.text.toString()
            val valor = edtValor.text.toString()
            val valorFloat = valor.toFloat()
            val categoria = edtCategoria.text.toString()

            // Antes de adicionar a despesa, ele vai verificar se os campos foram preenchidos
            if(despesa.isNotEmpty() && valorFloat.isNotEmpty() && categoria.isNotEmpty()){
                if(despesa == null){
                    //Criar despesa nova
                    addOrUpdateDespesa(0 ,despesa, categoria, valor,  ActionType.CREATE)
                }else{
                    //editar tarefa existente
                    addOrUpdateTask(despesa!!.id,despesa, categoria, ActionType.UPDATE)
                }
            }else{
                showMessage(it, "Fields are required")
            }
        }

    }


    private fun addOrUpdateDespesa(
        id: Int,
        despesa: String,
        categoria: String,
        valor: Float,
        actionType: ActionType
    ){
        val despesa = Expense(id, despesa, categoria, valor)
        performAction(despesa, actionType)
    }

        // Function for set in before view - AULA Add new task
        private fun performAction(despesa: Expense, actionType: ActionType){
            val despesaAction = DespesaAction(despesa, actionType.name)
            viewModel.execute(despesaAction)
            finish()
        }

}