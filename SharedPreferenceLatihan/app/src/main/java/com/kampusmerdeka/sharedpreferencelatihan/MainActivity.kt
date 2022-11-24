package com.kampusmerdeka.sharedpreferencelatihan

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.kampusmerdeka.sharedpreferencelatihan.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val sharedPref = getSharedPreferences("myPref", MODE_PRIVATE)
        val editor = sharedPref.edit()

        binding.apply {
            btnSave.setOnClickListener {
                val userName = edtUsername.text.toString()
                val email = edtEmail.text.toString()

                editor.apply {
                    putString("user_name", userName)
                    putString("email", email)
                    apply()
                }
                toastSave()

                binding.edtUsername.text.clear()
                binding.edtEmail.text.clear()
            }

            btnLoad.setOnClickListener {
                val userName = sharedPref.getString("user_name", null)
                val email = sharedPref.getString("email", null)

                tvUsername.text = userName
                tvEmail.text = email

                toastLoad()
            }

            btnClear.setOnClickListener {
                val userName = sharedPref.getString("user_name", null)
                val email = sharedPref.getString("email", null)

                if (userName != null && email != null) {
                    tvUsername.text = ""
                    tvEmail.text = ""

                    toastClear()
                } else {
                    toastClearEmpty()
                }
            }
        }
    }

    private fun toastSave() {
        Toast.makeText(this, "Save data successfully", Toast.LENGTH_SHORT).show()
    }

    private fun toastLoad() {
        Toast.makeText(this, "Data successfully loaded", Toast.LENGTH_SHORT).show()
    }

    private fun toastClear() {
        Toast.makeText(this, "Data has been cleared", Toast.LENGTH_SHORT).show()
    }

    private fun toastClearEmpty() {
        Toast.makeText(this, "Please save data first", Toast.LENGTH_SHORT).show()
    }
}