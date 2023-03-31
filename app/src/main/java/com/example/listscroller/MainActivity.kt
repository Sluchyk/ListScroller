package com.example.listscroller

import android.os.Bundle
import android.view.LayoutInflater
import android.widget.EditText
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.listscroller.model.Affirmation
import com.example.listscroller.model.adapter.ItemAdapter
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity :AppCompatActivity(),DetailsItem{
    private val data= mutableListOf<Affirmation>()
    private  val imageList= mutableListOf<Int>(R.drawable.image1,
        R.drawable.image2,
        R.drawable.image3,
        R.drawable.image4,
        R.drawable.image5
    )
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val recyclerView:RecyclerView=findViewById(R.id.recycler_view)
        val addButton:FloatingActionButton=findViewById(R.id.addingBtn)
        setAffirmation()
        recyclerView.layoutManager = LinearLayoutManager(this)
       recyclerView.adapter=ItemAdapter(data,this)
        addButton.setOnClickListener { addNewElem() }


    }
    private  fun addNewElem()
    {
         val newImage= mutableListOf<Int>(R.drawable.image6,
            R.drawable.image7,
            R.drawable.image8,
            R.drawable.image9,
            R.drawable.image10
        )
        val inflter = LayoutInflater.from(this)
        val v = inflter.inflate(R.layout.add_new_item,null)
        val userName = v.findViewById<EditText>(R.id.userName)
        val addDialog = AlertDialog.Builder(this)
        val recyclerView =findViewById<RecyclerView>(R.id.recycler_view)

        addDialog.setView(v)
        addDialog.setPositiveButton("Ok"){
                dialog,_->
            val names = userName.text.toString()
            if(names.isNotEmpty()){
            data.add(Affirmation(names,newImage[(0..5).random()]))
            recyclerView.adapter=ItemAdapter(data,this)
            }
            dialog.dismiss()
        }
        addDialog.setNegativeButton("Cancel"){
                dialog,_->
            dialog.dismiss()

        }
        addDialog.create()
        addDialog.show()
    }

    private  fun setAffirmation()
    {
        val   string= resources.getStringArray(R.array.affirmation_array)
        var count =0
         for (element in string)
         {
             data.add(Affirmation(element, imageList[count]))
             count++
         }

    }

    override fun clickOnItem(position: Int) {
        val inflter = LayoutInflater.from(this)
        val v = inflter.inflate(R.layout.activity_main2,null)
        val recyclerView:RecyclerView=findViewById(R.id.recycler_view)
        val addDialog = AlertDialog.Builder(this)
        addDialog.setPositiveButton("Delete"){
                dialog,_->
                data.removeAt(position)
                recyclerView.adapter=ItemAdapter(data,this)

            dialog.dismiss()
        }
        addDialog.setView(v)
        addDialog.setNegativeButton("Cancel"){
                dialog,_->
            dialog.dismiss()

        }
        addDialog.create()
        addDialog.show()
    }



}