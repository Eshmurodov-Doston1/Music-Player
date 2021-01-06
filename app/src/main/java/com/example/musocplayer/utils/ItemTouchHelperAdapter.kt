package com.example.musocplayer.utils

import java.text.FieldPosition

interface ItemTouchHelperAdapter {
    fun onItemMove(fromePosition:Int,toPosition:Int)
    fun onItemDismiss(position:Int)
}