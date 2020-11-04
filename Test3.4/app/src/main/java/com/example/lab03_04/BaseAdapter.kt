package com.example.lab03_04

import android.app.Activity
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Adapter
import android.widget.ArrayAdapter
import android.widget.TextView

class BaseAdapter(activity: Activity,val resouceId:Int,data:List<item>):ArrayAdapter<item>(activity,resouceId,data) {
    inner class ViewHolder(val itemName:TextView)

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val view:View
        val viewHolder:ViewHolder
        if (convertView == null) {
            view = LayoutInflater.from(context).inflate(resouceId, parent, false)
            val itemName: TextView = view.findViewById(R.id.itemName)
            viewHolder = ViewHolder(itemName)
            view.tag = viewHolder
        } else {
            view = convertView
            viewHolder = view.tag as ViewHolder
        }

        val item = getItem(position)
        if (item != null) {
            viewHolder.itemName.text =item.itemName
            if (item.Bo)
                viewHolder.itemName.setBackgroundColor(Color.GREEN)
            else
                viewHolder.itemName.setBackgroundColor(Color.WHITE)
        }
        return view
    }
}