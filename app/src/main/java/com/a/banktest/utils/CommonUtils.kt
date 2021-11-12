package com.a.banktest.utils

import java.lang.Exception
import java.text.SimpleDateFormat
import java.util.regex.Pattern

object CommonUtils {

val simpleDateFormat = SimpleDateFormat("dd/MM/yyyy")

    fun isPanValid(panNumber: String): Boolean {
        return if (panNumber.trim().isNotEmpty()) {
            Pattern.compile("[A-Z]{5}[0-9]{4}[A-Z]{1}").matcher(panNumber).matches()
        } else {
            panNumber.trim().isNotBlank()
        }
    }

    fun isDay(day:String):Boolean{
        return try {
            val d = day.toInt()
            if(d>0 && d<32) true else false
        }catch (e:Exception){
            false
        }
    }
       fun isMonth(month:String):Boolean{
        return try {
            val d = month.toInt()
            if(d>0 && d<13) true else false
        }catch (e:Exception){
            false
        }
    }

   fun isYear(year:String):Boolean{
        return try {
            val d = year.toInt()
            if(d>1899 && d<2020) true else false
        }catch (e:Exception){
            false
        }
    }


    fun isValidDate(time:String):Boolean{
      return  try {
          simpleDateFormat.setLenient(false);
       val date =   simpleDateFormat.parse(time)
          if(date !=null) true else false
        }catch (e:Exception){
            e.printStackTrace()
            false
        }
    }

}