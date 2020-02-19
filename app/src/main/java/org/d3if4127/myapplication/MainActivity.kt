package org.d3if4127.myapplication

import android.content.ActivityNotFoundException
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import org.d3if4127.myapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private var scoreA = 0
    private var scoreB = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        if (savedInstanceState != null) {
            scoreA = savedInstanceState.getInt("pointsA")
            scoreB = savedInstanceState.getInt("pointsB")

            binding.pointsA.text = scoreA.toString()
            binding.pointsB.text = scoreB.toString()
        }

        binding.btnFreeThrowA.setOnClickListener {
            scoreA += 1
            binding.pointsA.text = scoreA.toString()
        }
        binding.btnPlusDuaA.setOnClickListener {
            scoreA += 2
            binding.pointsA.text = scoreA.toString()
        }
        binding.btnPlusTigaA.setOnClickListener {
            scoreA += 3
            binding.pointsA.text = scoreA.toString()
        }

        binding.btnFreeThrowB.setOnClickListener {
            scoreB += 1
            binding.pointsB.text = scoreB.toString()
        }
        binding.btnPlusDuaB.setOnClickListener {
            scoreB += 2
            binding.pointsB.text = scoreB.toString()
        }
        binding.btnPlusTigaB.setOnClickListener {
            scoreB += 3
            binding.pointsB.text = scoreB.toString()
        }


        binding.btnReset.setOnClickListener {
            scoreA = 0
            scoreB = 0

            binding.pointsA.text = "0"
            binding.pointsB.text = "0"
        }

    }

    override fun onSaveInstanceState(outState: Bundle) {
        outState.putInt("pointsA", Integer.parseInt(binding.pointsA.text.toString()))
        outState.putInt("pointsB", Integer.parseInt(binding.pointsB.text.toString()))
        super.onSaveInstanceState(outState)
    }


    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.toAbout-> {
                try {
                    startActivity(Intent(this, About::class.java))
                }catch (ex: ActivityNotFoundException) {
                    Toast.makeText(this, "Activity Tidak ada", Toast.LENGTH_LONG).show()
                }
            }
        }
        return super.onOptionsItemSelected(item)
    }
}
