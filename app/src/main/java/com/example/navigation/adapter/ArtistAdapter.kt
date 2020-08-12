package com.example.newapp.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.navigation.R
import com.example.navigation.model.Artist
import kotlinx.android.synthetic.main.item.view.*


class ArtistAdapter(var articleList: ArrayList<Artist>) :
    RecyclerView.Adapter<ArtistAdapter.ArtistViewHolder>()  {


    var mClickListener : ClickListener? = null

    fun setOnclickListener(clickListener: ClickListener){
        this.mClickListener = clickListener

    }
    fun  updateArticle(artistList: ArrayList<Artist>){
        this.articleList = artistList
        notifyDataSetChanged()
    }

    inner  class ArtistViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) ,
        View.OnClickListener{

        lateinit var artist: Artist
//        private var view : View = itemView

        init {
            itemView.setOnClickListener(this)
        }

        fun bind(artist: Artist) {
            this.artist = artist
            itemView.t2.text = artist.name
            itemView.t3.text = artist.addess

        }

        override fun onClick(view: View) {
            mClickListener?.onClick(artist)
        }
    }

    //choose layout
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArtistViewHolder {
        var view = LayoutInflater.from(parent.context).inflate(
            R.layout.item,
            parent, false
        )
        return ArtistViewHolder(view)
    }

    //count
    override fun getItemCount(): Int {
        return articleList.size

    }

    //position
    override fun onBindViewHolder(holder: ArtistViewHolder, position: Int) {
        holder.bind(articleList[position])
    }

    interface ClickListener{
        fun onClick(artist: Artist)
    }



}