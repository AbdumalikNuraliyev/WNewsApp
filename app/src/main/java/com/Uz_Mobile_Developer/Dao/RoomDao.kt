package com.Uz_Mobile_Developer.Dao

import androidx.room.*
import com.Uz_Mobile_Developer.Model.Task

@Dao
interface RoomDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(task: Task): Long

    @Query("SELECT * FROM task")
    fun allTask(): List<Task>

    @Delete
    fun delete(task: Task)

    @Update
    fun edit(task: Task)

}