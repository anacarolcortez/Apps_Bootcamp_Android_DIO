package com.dio.diocontatosui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ContactAdapter(var listener: ClickContact) : RecyclerView.Adapter<ContactAdapter.ContactAdapterViewHolder>() {

    private val list: MutableList<Contact> = mutableListOf()

    class ContactAdapterViewHolder(itemView : View, var list: List<Contact>, var listener: ClickContact): RecyclerView.ViewHolder(itemView){
        private val name: TextView = itemView.findViewById(R.id.txtName)
        private val phone: TextView = itemView.findViewById(R.id.txtPhone)
        private val avatar: ImageView = itemView.findViewById(R.id.imgPhoto) as ImageView

        init{
            itemView.setOnClickListener {
                listener.clickContactCard(list[adapterPosition])
            }
        }

        fun bind(contact: Contact){
            name.text = contact.name
            phone.text = contact.phone
            avatar.setImageResource(contact.photo)
        }
    }

    //responsável por criar a view
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactAdapterViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.contact_item, parent, false)
        return ContactAdapterViewHolder(view, list, listener)
    }

    //responsável por informar a quantidade de itens
    override fun getItemCount(): Int {
        return list.size
    }

    //responsável por popular o item na lista
    override fun onBindViewHolder(holder: ContactAdapterViewHolder, position: Int) {
        holder.bind(list[position])
    }

    fun updateList(list: List<Contact>){
        this.list.clear()
        this.list.addAll(list)
        notifyDataSetChanged()
    }
}