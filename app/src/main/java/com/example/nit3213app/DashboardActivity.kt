package com.example.nit3213app.ui


import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.nit3213app.R
import com.example.nit3213app.model.Entity
import com.example.nit3213app.ui.DetailsActivity
import com.example.nit3213app.viewmodel.DashboardViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DashboardActivity : AppCompatActivity() {

    private val viewModel: DashboardViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        // Observe the entities from the ViewModel and populate the RecyclerView
        viewModel.entities.observe(this) { entities ->
            recyclerView.adapter = EntityAdapter(entities) { entity ->
                // Navigate to DetailsActivity with the selected entity's data
                val intent = Intent(this, DetailsActivity::class.java)
                intent.putExtra("entity", entity)
                startActivity(intent)
            }
        }

        // Load entities from the ViewModel using the keypass retrieved from LoginActivity
        val keypass = intent.getStringExtra("keypass") ?: ""
        viewModel.loadEntities(keypass)
    }
}

// Adapter for displaying the list of entities
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