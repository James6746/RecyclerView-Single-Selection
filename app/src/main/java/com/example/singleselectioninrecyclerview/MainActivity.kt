package com.example.singleselectioninrecyclerview

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.SimpleItemAnimator

class MainActivity : AppCompatActivity() {
    lateinit var recyclerView: RecyclerView
    lateinit var myAdapter: MyAdapter
    lateinit var arrayList: ArrayList<MyItem>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initViews()
    }

    private fun initViews() {
        recyclerView = findViewById(R.id.recyclerView)
        (recyclerView.itemAnimator as SimpleItemAnimator).supportsChangeAnimations = false
        recyclerView.layoutManager =
            LinearLayoutManager(applicationContext, LinearLayoutManager.HORIZONTAL, false)
        refreshAdapter(getItemList())
    }

    private fun getItemList(): ArrayList<MyItem> {
        arrayList = ArrayList()

        for (i in 0..20) {
            arrayList.add(MyItem(false))
        }

        return arrayList
    }

    private fun refreshAdapter(itemList: ArrayList<MyItem>) {
        myAdapter = MyAdapter(this, itemList)
        recyclerView.adapter = myAdapter
    }
}