package com.dicoding.githubuserapp

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.dicoding.githubuserapp.databinding.ActivityUserDetailBinding

class DetailUserActivity  : AppCompatActivity() {

    private lateinit var detailBinding: ActivityUserDetailBinding
    private lateinit var user: ModelUser

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        detailBinding = ActivityUserDetailBinding.inflate(layoutInflater)
        setContentView(detailBinding.root)

        user = intent.extras?.get(EXTRA_DETAIL) as ModelUser
        parseDetailUser (user)
    }


    private fun parseDetailUser (user: ModelUser) {
        detailBinding.apply {
            detailName.text = user.name
            detailUsername.text = user.username
            detailRepository.text = user.repository
            detailFollowers.text = user.followers
            detailFollowing.text = user.following
            detailCompany.text = user.company
            detailLocation.text = user.location

            Glide
                .with(this@DetailUserActivity)
                .load(user.avatar)
                .into(detailAvatar)
        }
    }
    companion object {
        const val EXTRA_DETAIL = "extra_detail"
    }

}