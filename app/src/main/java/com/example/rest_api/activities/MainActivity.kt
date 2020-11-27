package com.example.rest_api.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.LinearLayout
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.rest_api.R
import com.example.rest_api.helpers.PostsAdapter
import com.example.rest_api.models.Post
import com.example.rest_api.services.Posts_api
import com.example.rest_api.services.Postsapi
import retrofit2.Response
import retrofit2.Call
import retrofit2.Callback
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.http.POST

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    private fun viewPosts() {
        val end  = Postsapi.buildPost(Posts_api::class.java)
        val requestCall = end.getPostList()

        requestCall.enqueue(object : retrofit2.Callback<List<Post>> {
            override fun onResponse(call: retrofit2.Call<List<Post>>, response: Response<List<Post>>) {
                Log.d("Response", "onResponse: ${response.body()}")
                if (response.isSuccessful){
                    val countryList  = response.body()!!
                    Log.d("Response", "countrylist size : ${countryList.size}")
                    posts_recycler.apply {
                        setHasFixedSize(true)
                        layoutManager = LinearLayoutManager(this@MainActivity)
                        adapter = PostsAdapter(response.body()!!)
                        setAdapter(posts_recycler.adapter)
                    }
                }else{
                    Toast.makeText(this@MainActivity, "Something went wrong ${response.message()}", Toast.LENGTH_SHORT).show()
                }
            }
            override fun onFailure(call: retrofit2.Call<List<Post>>, t: Throwable) {
                Toast.makeText(this@MainActivity, "Something went wrong $t", Toast.LENGTH_SHORT).show()
            }
        })
    }
}