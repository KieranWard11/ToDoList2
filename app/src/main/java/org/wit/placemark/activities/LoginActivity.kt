package org.wit.placemark.activities

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.user_login.*
import kotlinx.android.synthetic.main.user_registration.*
import kotlinx.android.synthetic.main.user_registration.email
import kotlinx.android.synthetic.main.user_registration.password
import org.wit.placemark.R
import org.wit.placemark.helpers.DatabaseHelper

class LoginActivity : AppCompatActivity() {

  lateinit var handler:DatabaseHelper

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_login)

    handler= DatabaseHelper(this)

    showHome()

    registration.setOnClickListener {
      showRegistration()
    }

    login.setOnClickListener {
      showLogin()
    }

    save.setOnClickListener {
      handler.insertUserData(name.text.toString(), email.text.toString(), password.text.toString())
      showHome()
    }

    login_button.setOnClickListener {
      if (handler.userPresent(login_email.text.toString(), login_password.text.toString()))
        Toast.makeText(this, "Login Success", Toast.LENGTH_SHORT).show()
      else
        Toast.makeText(this, "Username or password is incorrect", Toast.LENGTH_SHORT).show()
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