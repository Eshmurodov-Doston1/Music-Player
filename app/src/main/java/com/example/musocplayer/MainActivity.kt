package com.example.musocplayer

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView
import com.example.musocplayer.adapters.MusikAdapter
import com.example.musocplayer.musik.Mp3
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    lateinit var mp3List: ArrayList<Mp3>
    lateinit var  musikAdapter: MusikAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        loadData()
        musikAdapter = MusikAdapter(this,mp3List)
        rv.adapter = musikAdapter
        var itemTouch = object:ItemTouchHelper.Callback(){
            override fun getMovementFlags(
                recyclerView: RecyclerView,
                viewHolder: RecyclerView.ViewHolder
            ): Int {
                var dragFlags = ItemTouchHelper.UP or ItemTouchHelper.DOWN
                var swipeFlags  = ItemTouchHelper.END
                return makeMovementFlags(dragFlags,swipeFlags)
            }

            override fun onMove(
                recyclerView: RecyclerView,
                viewHolder: RecyclerView.ViewHolder,
                target: RecyclerView.ViewHolder
            ): Boolean {
             musikAdapter.onItemMove(viewHolder.adapterPosition,target.adapterPosition)
                return true
            }

            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
                  musikAdapter.onItemDismiss(viewHolder.adapterPosition)
            }

        }
        var itemTouchHelper = ItemTouchHelper(itemTouch)
        itemTouchHelper.attachToRecyclerView(rv)
    }

    private fun loadData() {
        mp3List = ArrayList()
            mp3List.add(Mp3("Janob Rasul","Captiva"))
            mp3List.add(Mp3("Janob Rasul","90-60"))
            mp3List.add(Mp3("Janob Rasul","Nari_Nari Na-Na"))
            mp3List.add(Mp3("Janob Rasul","Sog`indingmi"))
            mp3List.add(Mp3("Janob Rasul","Super"))
            mp3List.add(Mp3("Janob Rasul","Lazgi"))
            mp3List.add(Mp3("Janob Rasul","Yomonsan"))
            mp3List.add(Mp3("Janob Rasul","Yolg`ondunyo"))
            mp3List.add(Mp3("Janob Rasul","Sanam"))
            mp3List.add(Mp3("Janob Rasul","Arzimaysan"))
            mp3List.add(Mp3("Ozodbek Nazarbekov","Laylim"))
            mp3List.add(Mp3("Ozodbek Nazarbekov","Qo`lingda imkon"))
            mp3List.add(Mp3("Ozodbek Nazarbekov","Birkami to`lmagan dunyo"))
            mp3List.add(Mp3("Ozodbek Nazarbekov","Opa meni yo`qlab keling"))
            mp3List.add(Mp3("Ozodbek Nazarbekov","Yangi yil"))
            mp3List.add(Mp3("Ozodbek Nazarbekov","Sevarmisan"))
            mp3List.add(Mp3("Ozodbek Nazarbekov","Inson qasidasi"))
            mp3List.add(Mp3("Ozodbek Nazarbekov","Bolam dema"))
            mp3List.add(Mp3("Ozodbek Nazarbekov","Vatan"))
            mp3List.add(Mp3("Ozodbek Nazarbekov","Lola"))
            mp3List.add(Mp3("Sardor Toirov","Hasrat"))
            mp3List.add(Mp3("Sardor Toirov","Baxtingni top"))
            mp3List.add(Mp3("Sardor Toirov","Malikam"))
            mp3List.add(Mp3("Sardor Toirov","Singlim"))
            mp3List.add(Mp3("Sardor Toirov","Sevmasam"))
            mp3List.add(Mp3("Sardor Toirov","Majbur"))
            mp3List.add(Mp3("Sardor Toirov","Hasrat"))

    }
}