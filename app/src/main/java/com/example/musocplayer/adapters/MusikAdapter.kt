package com.example.musocplayer.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import androidx.recyclerview.widget.RecyclerView
import com.example.musocplayer.R
import com.example.musocplayer.musik.Mp3
import com.example.musocplayer.utils.ItemTouchHelperAdapter
import kotlinx.android.synthetic.main.mp3_item_view.view.*
import java.util.*
import kotlin.collections.ArrayList

class MusikAdapter(var context:Context,var mp3List:ArrayList<Mp3>):
        RecyclerView.Adapter<MusikAdapter.Vh>(),ItemTouchHelperAdapter {

    inner class Vh(itemView:View):RecyclerView.ViewHolder(itemView){
        fun onBind(mp3: Mp3){
         itemView.singer.text = mp3.singer_name
            itemView.musik_name.text = mp3.musik_name
            itemView.animation = AnimationUtils.loadAnimation(context,R.anim.anim1)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Vh {
        return Vh(LayoutInflater.from(parent.context).inflate(R.layout.mp3_item_view,parent,false))
    }

    override fun onBindViewHolder(holder: Vh, position: Int) {
          holder.onBind(mp3List[position])
    }

    override fun getItemCount(): Int {
       return mp3List.size
    }

    override fun onItemMove(fromePosition: Int, toPosition: Int) {
        if (fromePosition<toPosition){
             for (i in fromePosition until toPosition){
                 Collections.swap(mp3List,i,i+1)
             }
        }else{
            for (i in fromePosition downTo toPosition+1){
                Collections.swap(mp3List,i,i-1)
            }
        }
        notifyItemMoved(fromePosition,toPosition)
    }

    override fun onItemDismiss(position: Int) {
        mp3List.removeAt(position)
        notifyItemRemoved(position)
    }
}