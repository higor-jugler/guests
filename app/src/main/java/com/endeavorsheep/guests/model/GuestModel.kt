package com.endeavorsheep.guests.model

import androidx.room.Entity

@Entity
data class GuestModel(
    val id: Int,
    var name: String,
    var presence: Boolean
)
