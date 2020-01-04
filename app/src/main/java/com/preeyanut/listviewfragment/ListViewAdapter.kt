package com.preeyanut.listviewfragment

import android.content.Context
import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.core.content.ContextCompat.startActivity
import com.bumptech.glide.Glide
import org.json.JSONArray

class ListViewAdapter(context: Context,val jsonArray: JSONArray) : BaseAdapter() {

    private val thiscontext:Context = context
    private val inflater: LayoutInflater = thiscontext.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val view: View
        val holder: ViewHolder

        if(convertView == null){
            view = inflater.inflate(R.layout.layout_listview,parent,false)

            holder = ViewHolder()

            holder.title = view.findViewById(R.id.listview_name)
            holder.description = view.findViewById(R.id.listview_description)
            holder.image = view.findViewById(R.id.listview_image)

            view.tag = holder
        }else{
            view = convertView
            holder = convertView.tag as ViewHolder
        }

        val title = holder.title
        val description = holder.description
        val image = holder.image

        title.setText(jsonArray.getJSONObject(position).getString("title").toString())
        description.setText(jsonArray.getJSONObject(position).getString("description").toString())

        Glide.with(thiscontext)
            .load(jsonArray.getJSONObject(position).getString("image").toString())
            .into(image)

        return view
    }

    override fun getItem(position: Int): Any {
        return jsonArray.getJSONObject(position)
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getCount(): Int {
        return jsonArray.length()
    }

}

class ViewHolder {
    lateinit var title: TextView
    lateinit var description: TextView
    lateinit var image: ImageView
}
