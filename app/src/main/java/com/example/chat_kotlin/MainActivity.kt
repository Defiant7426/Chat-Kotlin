package com.example.chat_kotlin

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.chat_kotlin.Fragmentos.FragmentChats
import com.example.chat_kotlin.Fragmentos.FragmentPerfil
import com.example.chat_kotlin.Fragmentos.FragmentUsuarios
import com.example.chat_kotlin.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding // esto significa que se generará una clase para cada layout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        verFragmentoPerfil() // Fragmento por defecto

        binding.bottomNV.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.item_perfil -> {
                    // Visualizamos el fragmento de perfil
                    verFragmentoPerfil()
                    true
                }
                R.id.item_usuarios -> {
                    // Visualizamos el fragmento de usuarios}
                    verFragmentoUsuarios()
                    true
                }
                R.id.item_chats -> {
                    // Visualizamos el fragmento de chats
                    verFragmentoChats()
                    true
                }
                else -> false
            }
        }
    }


    private fun verFragmentoPerfil()
    {
        binding.titleTV.text = "Perfil"

        val fragment = FragmentPerfil()
        val fragmentTransaction = supportFragmentManager.beginTransaction()
        fragmentTransaction.replace(binding.fragmentoFL.id,fragment, "Fragment Perfil")
        fragmentTransaction.commit()
    }

    private fun verFragmentoUsuarios()
    {
        binding.titleTV.text = "Usuarios"

        val fragment = FragmentUsuarios()
        val fragmentTransaction = supportFragmentManager.beginTransaction()
        fragmentTransaction.replace(binding.fragmentoFL.id,fragment, "Fragment Usuarios")
        fragmentTransaction.commit()
    }

    private fun verFragmentoChats()
    {
        binding.titleTV.text = "Chats"

        val fragment = FragmentChats()
        val fragmentTransaction = supportFragmentManager.beginTransaction()
        fragmentTransaction.replace(binding.fragmentoFL.id,fragment, "Fragment Chats")
        fragmentTransaction.commit()
    }
}