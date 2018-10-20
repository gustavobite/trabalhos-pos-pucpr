package br.com.gbiteapps.activities

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener  {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnGo.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.btnGo -> {
                val intent = Intent(this, SecondActivity::class.java)
                intent.putExtra("message", "Mensagem da acticity anterior!!")
                startActivity(intent)
            }
            /*else -> {

            }*/
        }
    }
}
