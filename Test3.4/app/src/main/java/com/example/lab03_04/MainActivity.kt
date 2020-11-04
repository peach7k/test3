package com.example.lab03_04

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ActionMode
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.widget.AbsListView
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.core.view.size
import kotlinx.android.synthetic.main.activity_main.*
import java.util.EnumSet.range

class MainActivity : AppCompatActivity() {

    private val itemList = ArrayList<item>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initItem()
        val adapter =BaseAdapter(this,R.layout.item_layout,itemList)
        listView.adapter =adapter
        with(listView){
            choiceMode = ListView.CHOICE_MODE_MULTIPLE_MODAL
            setMultiChoiceModeListener(object:AbsListView.MultiChoiceModeListener{
                var num = 0
                override fun onCreateActionMode(mode: ActionMode, menu: Menu?): Boolean {
                    val menuInflater : MenuInflater = mode.menuInflater
                    menuInflater.inflate(R.menu.actionmode_menu,menu)
                    num = 0
                    adapter.notifyDataSetChanged()
                    return true
                }

                override fun onPrepareActionMode(mode: ActionMode?, menu: Menu?): Boolean {
                    adapter.notifyDataSetChanged()
                    return false
                }

                public fun refresh(boolean: Boolean){
                    for (index in 0 until itemList.size){
                        itemList.get(index).Bo =boolean
                    }
                }

                override fun onActionItemClicked(mode: ActionMode?, item: MenuItem?): Boolean {
                    when(item?.itemId){
                        R.id.menu_all ->{
                            num = 0
                            var selectedNum = 0
                            for (index in 0 until itemList.size){
                                if (itemList.get(index).Bo){
                                    selectedNum++
                                }
                            }
                            if (selectedNum == itemList.size){
                                refresh(false)
                                num = 0
                            }else{
                                refresh(true)
                                num = itemList.size
                            }
                            adapter.notifyDataSetChanged()
                            if (mode != null) {
                                mode.title ="$num Selected"
                            }
                            return true
                        }
                        R.id.menu_delete ->{
                            var size =itemList.size-1
                            for(index in size downTo 0){
                                if (itemList.get(index).Bo){
                                    itemList.removeAt(index)
                                }
                            }
                            adapter.notifyDataSetChanged()
                            num = 0
                            refresh(false)
                            if (mode != null) {
                                mode.title ="$num Selected"
                            }
                            return true
                        }
                    }
                  return true
                }

                override fun onDestroyActionMode(mode: ActionMode?) {
                    refresh(false)
                    adapter.notifyDataSetChanged()
                }

                override fun onItemCheckedStateChanged(
                    mode: ActionMode?,
                    position: Int,
                    id: Long,
                    checked: Boolean
                ) {
                    if (itemList.get(position).Bo){
                        itemList.get(position).Bo=false
                        adapter.notifyDataSetChanged()
                        num--
                    }else {
                        itemList.get(position).Bo=true
                        adapter.notifyDataSetChanged()
                        num++
                    }
                    if (mode != null) {
                        mode.title = "$num Selected"
                    }
                }

            })
        }
    }

    fun initItem(){
        itemList.add(item("one"))
        itemList.add(item("two"))
        itemList.add(item("three"))
        itemList.add(item("four"))
        itemList.add(item("five"))
        itemList.add(item("six"))
        itemList.add(item("seven"))
        itemList.add(item("eight"))
        itemList.add(item("nine"))
        itemList.add(item("ten"))
    }
}