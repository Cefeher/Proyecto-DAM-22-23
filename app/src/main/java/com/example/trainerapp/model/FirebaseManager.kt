package com.example.trainerapp.model

import com.google.firebase.firestore.FirebaseFirestore

class FirebaseManager {

    private val db: FirebaseFirestore = FirebaseFirestore.getInstance()

    fun saveTraining(train: Training) {
        db.collection("trains")
            .document(train.id)
            .set(train)
    }

    fun getTraining(id: String, onComplete: (Training?) -> Unit) {
        db.collection("trains")
            .document(id)
            .get()
            .addOnSuccessListener { document ->
                if (document.exists()) {
                    val train = document.toObject(Training::class.java)
                    onComplete(train)
                } else {
                    onComplete(null)
                }
            }
            .addOnFailureListener { e ->
                onComplete(null)
            }
    }

    // otras funciones CRUD para trains y otros datos de la app

}
