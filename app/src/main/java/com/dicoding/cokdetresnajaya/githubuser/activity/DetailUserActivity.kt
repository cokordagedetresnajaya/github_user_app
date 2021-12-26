package com.dicoding.cokdetresnajaya.githubuser.activity

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.dicoding.cokdetresnajaya.githubuser.R
import com.dicoding.cokdetresnajaya.githubuser.data.User

class DetailUserActivity : AppCompatActivity() {
    private lateinit var imgAvatar: ImageView
    private lateinit var tvName: TextView
    private lateinit var tvLocation: TextView
    private lateinit var tvCompany: TextView
    private lateinit var tvFollowers: TextView
    private lateinit var tvFollowing: TextView
    private lateinit var tvRepository: TextView
    private lateinit var btnSendEmail: Button

    companion object{
        const val EXTRA_USER = "extra_user"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_user)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        tvName = findViewById(R.id.tv_name)
        tvLocation = findViewById(R.id.tv_location)
        tvCompany = findViewById(R.id.tv_company)
        tvFollowers = findViewById(R.id.tv_followers)
        tvFollowing = findViewById(R.id.tv_following)
        tvRepository = findViewById(R.id.tv_repository)
        imgAvatar = findViewById(R.id.img_avatar)
        btnSendEmail = findViewById(R.id.btn_send_email)

        val user = intent.getParcelableExtra<User>(EXTRA_USER) as User

        supportActionBar?.setTitle("@${user.username}")

        tvName.text = user.name
        tvLocation.text = "Stay in ${user.location}"
        tvCompany.text = "Work at ${user.company}"
        tvFollowers.text = user.followers
        tvFollowing.text = user.following
        tvRepository.text = user.repository

        Glide.with(this)
            .load(user.avatar)
            .circleCrop()
            .into(imgAvatar)

        btnSendEmail.setOnClickListener {
            val sendEmailIntent = Intent(Intent.ACTION_VIEW,Uri.parse("mailto:${user.email}"))
            startActivity(sendEmailIntent)
        }
    }
}