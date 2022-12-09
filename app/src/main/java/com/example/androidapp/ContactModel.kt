package com.example.androidapp

import com.google.gson.annotations.SerializedName

data class ContactModel(
    @SerializedName("name") var name: String?,
    @SerializedName("number") var number: String?) {

    var ohyea: String = "CTF_JAVA_x"

    fun getNumbers(): String {
        return number.toString()
    }
    fun getNames(): String {
        return name.toString()
    }
}