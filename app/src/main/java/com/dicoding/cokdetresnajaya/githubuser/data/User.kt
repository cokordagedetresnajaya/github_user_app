package com.dicoding.cokdetresnajaya.githubuser.data

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class User(
    var name: String,
    var username: String,
    var avatar: Int,
    var email: String,
    var location: String,
    var repository: String,
    var company: String,
    var followers: String,
    var following: String,
) : Parcelable
