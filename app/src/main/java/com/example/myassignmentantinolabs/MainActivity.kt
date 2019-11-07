package com.example.myassignmentantinolabs

import android.annotation.SuppressLint
import android.opengl.Visibility
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.LinearLayout
import android.widget.ProgressBar
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myassignmentantinolabs.adapter.DestinationAdapter
import com.example.myassignmentantinolabs.model.Destination
import com.example.myassignmentantinolabs.services.DestinationService
import com.example.myassignmentantinolabs.services.ServiceBuilder
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    private var progressBar: ProgressBar? = null
    private var recyclerView: RecyclerView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        progressBar = findViewById<ProgressBar>(R.id.progressBar) as ProgressBar

        recyclerView = findViewById(R.id.destiny_recycler_view) as RecyclerView

    }

    override fun onResume() {
        super.onResume()
        loadDestinations()
    }

    private fun loadDestinations() {
        progressBar!!.visibility = View.VISIBLE;

        val destinationService = ServiceBuilder.buildService(DestinationService::class.java)

        val requestCall = destinationService.getDestinationList()

        requestCall.enqueue(object: Callback<List<Destination>> {

            @SuppressLint("WrongConstant")
            override fun onResponse(call: Call<List<Destination>>, response: Response<List<Destination>>) {
                if (response.isSuccessful) {
                    progressBar!!.visibility = View.GONE;
                    val destinationList = response.body()!!
                  //  destiny_recycler_view.adapter = DestinationAdapter(destinationList)

                    //adding a layoutmanager
                    recyclerView?.layoutManager = LinearLayoutManager(applicationContext, LinearLayout.VERTICAL, false)

                    //creating our adapter
                    val adapter = DestinationAdapter(destinationList)

                    //now adding the adapter to recyclerview
                    recyclerView?.adapter = adapter
                }
            }

            override fun onFailure(call: Call<List<Destination>>, t: Throwable) {


            }
        })
    }
}
