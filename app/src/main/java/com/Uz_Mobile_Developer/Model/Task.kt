package com.Uz_Mobile_Developer.Model

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity
data class Task(
    @PrimaryKey(autoGenerate = true)
    var id: Int? = null,
    var note: String? = null,
    var decs: String? = null,
    var deadline: String? = null,
    var time: String? = null,
    var priority: String? = null
):Serializable
