package com.example.listbuku

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView

class BukuAdapter(private var bookList :ArrayList<BaseResponse>) : RecyclerView.Adapter<BukuAdapter.bookViewHolder>() {


    inner class bookViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val namaBukuTextView: TextView = itemView.findViewById(R.id.tv_namaBuku)
        val kodeBukuTextView: TextView = itemView.findViewById(R.id.tv_kodeBuku)
        val tahunBukuTextView: TextView = itemView.findViewById(R.id.tv_tahunBuku)
        val namaPenerbitTextView: TextView = itemView.findViewById(R.id.tv_penerbit)
        val namaPenulisTextView: TextView = itemView.findViewById(R.id.tv_penulis)
        fun bind(baseResponse: BaseResponse){
            with(itemView){
                val namaBuku = baseResponse.judulBuku
                val kodeBuku = baseResponse.kodeBuku
                val tahunBuku = baseResponse.tahunTerbit
                val namaPenerbit = baseResponse.namaPenerbit
                val namaPenulis = baseResponse.namaPengarang
                namaBukuTextView.text = namaBuku
                kodeBukuTextView.text =kodeBuku
                tahunBukuTextView.text = tahunBuku
                namaPenerbitTextView.text =namaPenerbit
                namaPenulisTextView.text = namaPenulis




            }
        }
        //val cardviewbuku : CardView = itemView.findViewById(R.id.cardbuku)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): bookViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.card_buku, parent, false)
        return bookViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: bookViewHolder, position: Int) {
        holder.bind(bookList[position])
        holder.itemView.setOnClickListener { view ->
            val intent = Intent(view.context, EditBukuActivity::class.java).apply {
                putExtra("kodeBuku", bookList[holder.adapterPosition].kodeBuku)
                putExtra("judulBuku", bookList[holder.adapterPosition].judulBuku)
                putExtra("tahunTerbit", bookList[holder.adapterPosition].tahunTerbit)
                putExtra("namaPenerbit", bookList[holder.adapterPosition].namaPenerbit)
                putExtra("namaPengarang", bookList[holder.adapterPosition].namaPengarang)
            }
            view.context.startActivity(intent)
        }

//        var currentBook : BaseResponse= bookList[position]
//        holder.namaBukuTextView.text = currentBook.judulBuku
//        holder.kodeBukuTextView.text = currentBook.kodeBuku
//        holder.tahunBukuTextView.text = currentBook.tahunTerit
//        holder.namaPenulisTextView.text =currentBook.namaPengarang
//        holder.namaPenerbitTextView.text = currentBook.namaPenerbit
    }

    override fun getItemCount(): Int {
        return bookList.size
    }

}