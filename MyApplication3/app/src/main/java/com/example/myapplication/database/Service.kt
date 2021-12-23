package com.example.myapplication.database

import Word
interface Service {

        fun AddWord(word:Word)
        fun listOfWords():ArrayList<Word>
    fun deleteWord(word: Word)
    fun edit(word: Word, id: Int)
}