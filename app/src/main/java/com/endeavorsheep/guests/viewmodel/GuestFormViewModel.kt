package com.endeavorsheep.guests.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.endeavorsheep.guests.model.GuestModel
import com.endeavorsheep.guests.model.SuccessFailure
import com.endeavorsheep.guests.repository.GuestRepository

class GuestFormViewModel(application: Application) : AndroidViewModel(application) {
    private val repository = GuestRepository(application)

    private val guestModel = MutableLiveData<GuestModel>()
    val guest: LiveData<GuestModel> = guestModel

    private val _saveGuest = MutableLiveData<SuccessFailure>()
    val saveGuest: LiveData<SuccessFailure> = _saveGuest

    fun save(guest: GuestModel) {
        val successFailure = SuccessFailure(true, "")
        if (guest.id == 0) {
            successFailure.success = repository.insert(guest)
        } else {
            repository.insert(guest)
        }
    }

    fun get(id: Int) {
        guestModel.value = repository.get(id)
    }
}