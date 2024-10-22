package com.example.nit3213app.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.nit3213app.R
import com.example.nit3213app.model.Entity

class EntityAdapter(
    private val entities: List<Entity>,
    private val onItemClick: (Entity) -> Unit
) : RecyclerView.Adapter<EntityAdapter.EntityViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EntityViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_entity, parent, false)
        return EntityViewHolder(view)
    }

    override fun onBindViewHolder(holder: EntityViewHolder, position: Int) {
        val entity = entities[position]
        holder.bind(entity)
        holder.itemView.setOnClickListener { onItemClick(entity) }
    }

    override fun getItemCount() = entities.size

    class EntityViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val property1TextView: TextView = itemView.findViewById(R.id.property1)
        private val property2TextView: TextView = itemView.findViewById(R.id.property2)

        fun bind(entity: Entity) {
            property1TextView.text = entity.property1
            property2TextView.text = entity.property2
        }
    }
}