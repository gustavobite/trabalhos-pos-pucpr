package br.com.gbiteapps.activities

import android.app.Activity
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_second.*

class SecondActivity : AppCompatActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        val msg = intent.getStringExtra("message")
        txtMessage.setText(msg)

        btnOk.setOnClickListener(this)
        btnCancel.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when(v?.id) {
            R.id.btnOk -> {
                val intent = Intent().putExtra("response", txtResponse.text.toString())
                setResult(Activity.RESULT_OK, intent)
                finish()
            }
            R.id.btnCancel -> {
                setResult(Activity.RESULT_CANCELED)
                finish()
            }
        }
    }
}
