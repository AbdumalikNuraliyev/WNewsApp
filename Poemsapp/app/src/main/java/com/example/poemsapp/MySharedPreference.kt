package com.example.poemsapp

import android.content.Context
import android.content.SharedPreferences

object MySharedPreference {

    private const val NAME = "poem"
    private const val MODE = Context.MODE_PRIVATE
   private lateinit var preferences: SharedPreferences


    fun init(context: Context)
    {
        preferences =context.getSharedPreferences(NAME, MODE)
    }

    private inline fun SharedPreferences.edit(operation: (SharedPreferences.Editor) -> Unit)
    {
        val editor :SharedPreferences.Editor = edit()
        operation(editor)
        editor.apply()
    }


var listofUsers:String?
get() = preferences.getString("user","")
    set(value) = preferences.edit(){
        if (value!=null){
            it.putString("user",value)
        }
    }


   var listOfPoem:String?
   get() = preferences.getString("poem","")
    set(value) = preferences.edit(){
        if (value!=null){
            it.putString("poem",value)
        }
    }
}