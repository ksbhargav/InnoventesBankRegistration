package com.a.banktest.ui

import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.a.banktest.utils.CommonUtils

class MainViewModel :ViewModel() {
    val panNumber = MutableLiveData<String>("")
    val day = MutableLiveData<String>("")
    val month = MutableLiveData<String>("")
    val year = MutableLiveData<String>("")
    val date = MutableLiveData<String>("")


    init {
      println("valid date ${CommonUtils.isValidDate("33/22/2020")}")
    }

    val isValidPan = MediatorLiveData<Boolean>().apply {
        addSource(panNumber) {
            value = CommonUtils.isPanValid(it)
        }
    }

    val isValidDay = MediatorLiveData<Boolean>().apply {
        addSource(day){
            date.value = it+"/" + month.value+"/"+ year.value
            value = CommonUtils.isDay(it)
        }
    }
    val isValidMonth = MediatorLiveData<Boolean>().apply {
        addSource(month){
            date.value = day.value +"/" + it + "/"+ year.value
            value = CommonUtils.isMonth(it)
        }
    }
    val isValidYear = MediatorLiveData<Boolean>().apply {
        addSource(year){
            date.value = day.value+"/" + month.value + "/"+ it
            value = CommonUtils.isYear(it)
        }
    }

    val isValidDate = MediatorLiveData<Boolean>().apply {
        addSource(date){
            value = CommonUtils.isValidDate(it)
        }
    }


}