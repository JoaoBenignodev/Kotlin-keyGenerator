package com.example.keygenerator

import android.os.Bundle
import android.widget.Toast
import android.widget.Button
import android.widget.TextView
import android.widget.CheckBox
import android.widget.ImageButton
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.keygenerator.ui.theme.KeyGeneratorTheme
import java.lang.StringBuilder
import android.content.Intent


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val upperCaseCheckbox = findViewById<CheckBox>(R.id.upperCaseSelector)
        val lowerCaseCheckbox = findViewById<CheckBox>(R.id.lowerCaseCheckbox)
        val digitsCheckbox = findViewById<CheckBox>(R.id.digitsCheckbox)
        val punctuationCheckbox = findViewById<CheckBox>(R.id.punctuationCheckbox)
        val generateButton = findViewById<Button>(R.id.generateButton)
        val generatedPassword = findViewById<TextView>(R.id.generatedKey)
        val switchActivity = findViewById<Button>(R.id.img_btn_members)

        class RandomizedKeyGenerator {

            private val upperCaseLetters: String = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
            private val lowerCaseLetters: String = "abcdefghijklmnopqrstuvwxyz"
            private val digits: String = "0123456789"
            private val punctuation: String = "@#_-^~`!?'\"$()+=-/[]{}|"

            fun characterSelection(): String? {
                var resultString: String? = null

                if (upperCaseCheckbox.isChecked || lowerCaseCheckbox.isChecked || digitsCheckbox.isChecked || punctuationCheckbox.isChecked) {
                    val stringBuilder = StringBuilder()

                    if (upperCaseCheckbox.isChecked) {
                        stringBuilder.append(upperCaseLetters)
                    }
                    if (lowerCaseCheckbox.isChecked) {
                        stringBuilder.append(lowerCaseLetters)
                    }
                    if (digitsCheckbox.isChecked) {
                        stringBuilder.append(digits)
                    }
                    if (punctuationCheckbox.isChecked) {
                        stringBuilder.append(punctuation)
                    }

                    resultString = stringBuilder.toString()
                } else {
                    Toast.makeText(this@MainActivity, "At least one of the characters needs to be selected!", Toast.LENGTH_SHORT).show()
                }

                return resultString
            }

            fun generateRandomKey(selectedCharacters: String?): String {
                selectedCharacters?.let {
                    val length: Int = 26
                    val keySampleSB = StringBuilder(length)

                    for (i in 0 until length) {
                        val randomizer: Int = (it.indices).random()
                        keySampleSB.append(it[randomizer])
                    }
                    return keySampleSB.toString()
                }
                return ""
            }
        }

        val randomizerObj = RandomizedKeyGenerator()
        generateButton.setOnClickListener{

            generatedPassword.text = (randomizerObj.generateRandomKey(randomizerObj.characterSelection()))

        }
        switchActivity.setOnClickListener {
            val intent = Intent(this, SecondDisplay::class.java)
            startActivity(intent)
        }
        }
    }