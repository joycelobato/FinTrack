package com.example.fintrack

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.fintrack.local.Expense

class FinTrackAdapter(
    private val openFinTrackView:(expense: Expense ) -> Unit
)
    : ListAdapter<Expense, FintrackViewHolder>(FinTrackAdapter) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FintrackViewHolder {
        val view: View = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.item_despesa, parent, false)
        return FintrackViewHolder(view)
    }

    //Junta os dados e a UI
    override fun onBindViewHolder(holder: FintrackViewHolder, position: Int) {
        val expense = getItem(position)
        holder.bind(expense, openFinTrackView)
    }

    //Aula Animação com diffutil
    companion object : DiffUtil.ItemCallback<Expense>(){
        override fun areItemsTheSame(oldItem: Expense, newItem: Expense): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: Expense, newItem: Expense): Boolean {
            return oldItem.despesa == newItem.despesa
                    && oldItem.valor == newItem.valor
        }

    }


}

class FintrackViewHolder(private val view: View) : RecyclerView.ViewHolder(view){

    private val tvDespesa = view.findViewById<TextView>(R.id.tv_despesa)
    private val tvCategoria = view.findViewById<TextView>(R.id.tv_categoria)
    private val tvValor = view.findViewById<TextView>(R.id.tv_valor)
    fun bind(expense: Expense, openTaskDetailView:(expense: Expense) -> Unit){
        tvDespesa.text = expense.despesa
        tvCategoria.text = expense.categoria
        tvValor.text = expense.valor

        view.setOnClickListener{
            openTaskDetailView.invoke(expense)
        }

    }

}

