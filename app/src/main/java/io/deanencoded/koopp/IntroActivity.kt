package io.deanencoded.koopp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_intro.*

class IntroActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_intro)

        btn_check_in.setOnClickListener {
            startActivity(Intent(this@IntroActivity, HomeActivity::class.java))
        }
    }
}
