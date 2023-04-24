package com.example.workouterapp.model

import com.example.trainerapp.model.Training
import com.google.firebase.firestore.FirebaseFirestore

class FirebaseManager {

    private val db: FirebaseFirestore = FirebaseFirestore.getInstance()

    fun saveTraining(workout: Training) {
        db.collection("Training")
            .document(workout.id)
            .set(workout)
    }

    fun getTraining(id: String, onComplete: (Training?) -> Unit) {
        db.collection("Training")
            .document(id)
            .get()
            .addOnSuccessListener { document ->
                if (document.exists()) {
                    val workout = document.toObject(Training::class.java)
                    onComplete(workout)
                } else {
                    onComplete(null)
                }
            }
            .addOnFailureListener { e ->
                onComplete(null)
            }
    }
}
