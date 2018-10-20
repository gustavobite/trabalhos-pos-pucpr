package br.com.gbiteapps.activities

import android.app.Activity
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener  {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnGo.setOnClickListener(this)
        askOnClick.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.btnGo -> {
                val intent = Intent(this, SecondActivity::class.java)
                intent.putExtra("message", "Mensagem da acticity anterior!!")
                startActivity(intent)
            }
            R.id.askOnClick -> {
                val intent = Intent(this, SecondActivity::class.java)
                Log.d("puc", "antes de startar activity")
                startActivityForResult(intent, 1)
                Log.d("puc", "depois de startar activity")
            }
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == 1) {
            if (resultCode == Activity.RESULT_OK)
                Toast.makeText(this, data?.getStringExtra("response"), Toast.LENGTH_SHORT).show()
            else if (resultCode == Activity.RESULT_CANCELED)
                Toast.makeText(this, "Não há respostas!", Toast.LENGTH_SHORT).show()
        }
    }
}
