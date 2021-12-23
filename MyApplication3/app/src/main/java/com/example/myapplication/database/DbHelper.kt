package com.example.myapplication.database

import Word
import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
class DbHelper(context: Context) : SQLiteOpenHelper(
    context, Constants.DATABASE_NAME,
    null, Constants.DATABASE_VERSION
), Service {
    override fun onCreate(db: SQLiteDatabase?) {


        var query =
            "create table ${Constants.TABLE_NAME}(${Constants.ID} Integer primary key autoincrement,   ${Constants.WORD} text , ${Constants.TRANSLATE} text)"

        db?.execSQL(query)


    }

    override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) {


    }

    override fun AddWord(word: Word) {


        val db = this.writableDatabase
        val contentValues = ContentValues()
        contentValues.put(Constants.WORD, word.word)
        contentValues.put(Constants.TRANSLATE, word.translate)
        db.insert(Constants.TABLE_NAME, null, contentValues)
        db.close()


    }
    override fun deleteWord(word: Word){

        val db = this.readableDatabase
        db.delete(Constants.TABLE_NAME, Constants.WORD + " LIKE ?", arrayOf(word.word))
        db.close()

    }
    override fun listOfWords(): ArrayList<Word> {

        var list =ArrayList<Word>()
        var query = "select *from ${Constants.TABLE_NAME}"
        val db = this.writableDatabase

        val cursor = db.rawQuery(query, null)

        if(cursor.moveToFirst())
        {
            do {
                val id = cursor.getInt(0)
                val word = cursor.getString(1)
                val translate = cursor.getString(2)
                val wordObj = Word(id, word, translate)
                list.add(wordObj)

            }while (cursor.moveToNext())
        }
        return list
    }

    override fun edit(word: Word, id: Int) {

        val db = this.writableDatabase
        val contentValues = ContentValues()
        contentValues.put(Constants.WORD, word.word)
        contentValues.put(Constants.TRANSLATE, word.translate)
        db.update(Constants.TABLE_NAME, contentValues, "${Constants.ID} = $id", null)
        db.close()
    }


}