package com.example.aboutme

import android.annotation.SuppressLint
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import com.example.aboutme.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //setContentView(R.layout.activity_main)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main) //Sustituye a la liena de arriba para relaccionar los objetos con el activity_main

        binding.doneButton.setOnClickListener {
            addNickname(it)
        }

        binding.nickNameText.setOnClickListener {
            updateNickname(it)
        }
    }


    private fun clickHandlerFunction(viewThatIsClicked: View){

    }
    private fun addNickname(view: View){
        //val editText = findViewById<EditText>(R.id.nickname_edit)
        //val nickname_text = findViewById<TextView>(R.id.nickName_text)

        //El binding es una manera mas eficiente de acceder a activity_main que finsViewById
        binding.nickNameText.text = binding.nicknameEdit.text
        binding.nicknameEdit.visibility = View.GONE
        binding.doneButton.visibility = View.GONE
        binding.nickNameText.visibility = View.VISIBLE
        view.visibility = View.GONE



        //Ocultar el teclado
        val inputMethodManager = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        inputMethodManager.hideSoftInputFromWindow(view.windowToken, 0)

    }


    private fun updateNickname(view: View){
        //val editText = findViewById<EditText>(R.id.nickname_edit)
        //val doneButton = findViewById<Button>(R.id.done_button)

        binding.apply {   //Para evitar poner el binding delante de cada variable
            nicknameEdit.visibility = View.VISIBLE
            doneButton.visibility = View.VISIBLE
            view.visibility = View.GONE

            nicknameEdit.requestFocus()
            // Show the keyboard.
            val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            imm.showSoftInput(nicknameEdit, 0)

        }





    }
}