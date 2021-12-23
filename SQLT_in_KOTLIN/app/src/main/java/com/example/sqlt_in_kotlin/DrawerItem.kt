package com.example.sqlt_in_kotlin

import android.view.ViewGroup
import com.example.sqlt_in_kotlin.Adapters.DrawerAdapter

abstract class DrawerItem<T : DrawerAdapter.ViewHolder?> {
    var isChecked = false
        protected set

    abstract fun createViewHolder(parent: ViewGroup?): T
    abstract fun bindViewHolder(holder: T)
    fun setChecked(isChecked: Boolean): DrawerItem<T> {
        this.isChecked = isChecked
        return this
    }

    val isSelectable: Boolean
        get() = true
}