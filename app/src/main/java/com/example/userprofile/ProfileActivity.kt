package com.example.userprofile

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import kotlinx.android.synthetic.main.activity_profile.*

const val PROFILE_EXTRA = "PROFILE_EXTRA"

class ProfileActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)
        initViews()
    }

    private fun initViews() {
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = "This is your profile!"

        //creates value with parcelable item
        val profile = intent.getParcelableExtra<Profile>(PROFILE_EXTRA)

        //checks if there is an existing profile
        if (profile != null) {
            tvName.text = getString(R.string.name, profile.firstName, profile.lastName)
            tvDescription.text = profile.description
            //if image is present, replace the profile image
            if (profile.imageUri != null) {
                ivProfileImage.setImageURI(profile.imageUri)
            }
        }
    }
    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        return when (item?.itemId) {
            android.R.id.home -> {
                finish()
                true
            }
            else -> return super.onOptionsItemSelected(item)
        }
    }




}
