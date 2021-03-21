package com.xantrikoding.githubapp.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.xantrikoding.githubapp.R
import com.xantrikoding.githubapp.data.Coder
import com.xantrikoding.githubapp.data.DetailActivity
import com.xantrikoding.githubapp.databinding.ItemRowCoderBinding

class ListCoderAdapter(private val listCoder: ArrayList<Coder>) :
    RecyclerView.Adapter<ListCoderAdapter.ListViewHolder>() {

    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): ListViewHolder {
        val binding =
            ItemRowCoderBinding.inflate(LayoutInflater.from(viewGroup.context), viewGroup, false)
        return ListViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        holder.bind(listCoder[position])
    }

    override fun getItemCount(): Int = listCoder.size

    inner class ListViewHolder(private val binding: ItemRowCoderBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(coder: Coder) {
            with(binding) {
                Glide.with(itemView.context)
                    .load(coder.photo)
                    .apply(RequestOptions().override(55, 55))
                    .into(imgItemPhoto)

                tvItemName.text = coder.name
                tvUserName.text = coder.userName
                tvItemDescription.text = coder.description

                itemView.setOnClickListener {
                    val toastMessage = itemView.resources.getString(R.string.toast_message)
                    Toast.makeText(
                        itemView.context,
                        "$toastMessage ${coder.name}",
                        Toast.LENGTH_SHORT
                    ).show()

                    val detailIntent = Intent(itemView.context, DetailActivity::class.java)
                    detailIntent.putExtra(DetailActivity.EXTRA_DETAIL, coder)
                    itemView.context.startActivity(detailIntent)
                }
            }
        }
    }
}