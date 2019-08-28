package org.wit.placemark.activities

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import kotlinx.android.synthetic.main.activity_login.*
import org.wit.placemark.R

class LoginActivity : AppCompatActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_login)

    showHome()

    registration.setOnClickListener {
      showRegistration()
    }

    login.setOnClickListener {
      showLogin()
    }
  }

  private fun showRegistration() {
    registration_layout.visibility=View.VISIBLE
    login_layout.visibility=View.GONE
    home.visibility=View.GONE
  }

  private fun showLogin() {
    registration_layout.visibility=View.GONE
    login_layout.visibility=View.VISIBLE
    home.visibility=View.GONE
  }

  private fun showHome() {
    registration_layout.visibility=View.GONE
    login_layout.visibility=View.GONE
    home.visibility=View.VISIBLE
  }
}