package com.example.nit3213app.ui

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.nit3213app.R
import com.example.nit3213app.model.Entity

class DetailsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)

        // Retrieve the entity data passed from DashboardActivity
        val entity = intent.getParcelableExtra<Entity>("entity")

        // Find the TextViews and set their values
        val property1TextView = findViewById<TextView>(R.id.property1)
        val property2TextView = findViewById<TextView>(R.id.property2)
        val descriptionTextView = findViewById<TextView>(R.id.description)

        entity?.let {
            property1TextView.text = it.property1
            property2TextView.text = it.property2
            descriptionTextView.text = it.description
        }
    }
}
