package com.dicoding.cokdetresnajaya.githubuser

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private lateinit var rvUsers: RecyclerView
    private val list = ArrayList<User>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rvUsers = findViewById(R.id.rv_users)
        rvUsers.setHasFixedSize(true)

        list.addAll(listUsers)
        showRecyclerList()
    }

    private val listUsers: ArrayList<User>
        get() {
            val name = resources.getStringArray(R.array.name)
            val username = resources.getStringArray(R.array.username)
            val avatar = resources.obtainTypedArray(R.array.avatar)
            val email = resources.getStringArray(R.array.email)
            val location = resources.getStringArray(R.array.location)
            val company = resources.getStringArray(R.array.company)
            val followers = resources.getStringArray(R.array.followers)
            val following = resources.getStringArray(R.array.following)
            val repository = resources.getStringArray(R.array.repository)

            val listUser = ArrayList<User>()

            for (i in name.indices) {
                val user = User(name[i],username[i],avatar.getResourceId(i,-1),email[i],location[i],repository[i],company[i],followers[i],following[i])
                listUser.add(user)
            }

            return listUser
        }

    private fun showRecyclerList() {
        rvUsers.layoutManager = LinearLayoutManager(this)
        val listUserAdapter = ListUserAdapter(list)
        rvUsers.adapter = listUserAdapter

        listUserAdapter.setOnItemClickCallback(object: ListUserAdapter.OnItemClickCallback {
            override fun onItemClicked(data: User) {
                detailSelectedUser(data)
            }
        })
    }

    private fun detailSelectedUser(user: User) {
        val detailUserIntent = Intent(this@MainActivity, DetailUserActivity::class.java)
        detailUserIntent.putExtra(DetailUserActivity.EXTRA_USER,user)
        startActivity(detailUserIntent)
    }
}