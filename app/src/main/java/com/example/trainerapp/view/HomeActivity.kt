package com.example.trainerapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.trainerapp.databinding.ActivityHomeBinding
import com.google.firebase.auth.FirebaseAuth

enum class ProviderType {
    BASIC
}

class HomeActivity : AppCompatActivity() {
    private lateinit var binding: ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Obtener información del usuario actual
        val user = FirebaseAuth.getInstance().currentUser

        // Verificar si el usuario está registrado o es un invitado
        if (user != null) {
            // Mostrar botones de Challenge y Custom
            binding.challengeButton.visibility = View.VISIBLE
            binding.customButton.visibility = View.VISIBLE

            // Obtener el nombre del usuario y mostrarlo en la vista de bienvenida
            val name = user.displayName
            binding.welcomeTextView.text = "¡Bienvenido, $name!"
        } else {
            // Ocultar botón de Custom y mostrar candado cerrado
            binding.customButton.isEnabled = false
            binding.lockImageView.visibility = View.VISIBLE
        }

        // Configurar elevación para apilar los ImageView
        binding.challengeButton.elevation = 2.0f
        binding.customButton.elevation = 1.0f

        // Configurar listener para el botón de Challenge
        binding.challengeButton.setOnClickListener {
            // Abrir pantalla de selección de entrenamiento propuesto
        }

        // Configurar listener para el botón de Custom
        binding.customButton.setOnClickListener {
            if (user != null) {
                // Abrir pantalla de definición de entrenamiento personalizado
            } else {
                // Mostrar mensaje de que debe registrarse para acceder a esta funcionalidad
            }
        }
    }
}
