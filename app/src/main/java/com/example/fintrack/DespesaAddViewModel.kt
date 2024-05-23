package com.example.fintrack

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.fintrack.local.Expense
import com.example.fintrack.local.ExpenseDao


class DespesaAddViewModel(
    private val expenseDao: ExpenseDao
): ViewModel(){

    fun execute(despesaAction: DespesaAction) {
        when (despesaAction.actionType) {
            ActionType.DELETE.name -> deleteByID(despesaAction.despesa!!.id)
            ActionType.CREATE.name -> insertIntoDataBase(despesaAction.despesa!!)
            ActionType.UPDATE.name -> updateIntoDataBase(despesaAction.despesa!!)

        }
    }

    private fun insertIntoDataBase(despesa: Expense) {
        viewModelScope.launch {
            expenseDao.insert(despesa)
        }
    }

    private fun updateIntoDataBase(despesa: Expense) {
        viewModelScope.launch {
            expenseDao.update(despesa)
        }
    }

    private fun deleteByID(id: Int) {
        viewModelScope.launch {
            expenseDao.deleteById(id)
        }
    }

    companion object{

        fun getVMFactory(application: Application): ViewModelProvider.Factory{

            val dataBaseInstance = (application as FinTrackApplication).getAppDataBase()
            val dao = dataBaseInstance.expenseDao()
            val factory = object : ViewModelProvider.Factory{
                override fun <T : ViewModel> create(modelClass: Class<T>): T {
                    return DespesaAddViewModel(dao) as T
                }
            }
            return factory
        }
    }

}