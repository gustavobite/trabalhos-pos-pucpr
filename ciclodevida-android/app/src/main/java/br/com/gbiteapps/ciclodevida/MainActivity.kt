package br.com.gbiteapps.ciclodevida

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.app.AlertDialog
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var msg: String? = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        show("Evento: onCreate\n")
    }

    override fun onResume() {
        super.onResume()
        show("Evento: onResume\n")
    }

    override fun onPause() {
        super.onPause()
        show("Evento: onPause\n")
    }

    override fun onBackPressed() {
        val builder = AlertDialog.Builder(this@MainActivity)
        builder.setTitle("Tem certeza que deseja sair?")
        builder.setMessage("Você tem certeza que quer fechar o app?")
        builder.setPositiveButton("Sim") {dialog, which ->
            super.onBackPressed()
        }
        builder.setNegativeButton("Não") {dialog, which ->
            Toast.makeText(this, "Parabéns, continue a usar o app!", Toast.LENGTH_SHORT).show()
        }

        val dialog: AlertDialog = builder.create()
        dialog.show()
    }

    fun show(text: String) {
        msg += text
        textView.setText(msg)
    }
}
