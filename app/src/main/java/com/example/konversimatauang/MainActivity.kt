package com.example.konversimatauang

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import java.text.NumberFormat
import java.util.*


class MainActivity : AppCompatActivity() {
    var input_uang: EditText? = null
    var rp_usd: Button? = null
    var rp_euro: Button? = null
    var rp_yen: Button? = null
    var hasil_konversi: TextView? = null
    var angka = 0.0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        input_uang = findViewById<View>(R.id.uang_input) as EditText
        rp_usd = findViewById<View>(R.id.rpusd) as Button
        rp_euro = findViewById<View>(R.id.rpeuro) as Button
        rp_yen = findViewById<View>(R.id.rpyen) as Button
        hasil_konversi = findViewById<View>(R.id.hasil_konversi) as TextView
    }

    fun cek(): Boolean {
        if (input_uang!!.text.toString().isEmpty()) {
            Toast.makeText(this, "Silahkan masukan jumlah uang", Toast.LENGTH_SHORT).show()
            return false
        }
        return true
    }

    fun toYEN(v: View?) {
        if (!cek()) {
            return
        }
        try {
            angka = input_uang!!.text.toString().toDouble()
        } catch (ex: Exception) {
            Toast.makeText(this, "Masukkan angka", Toast.LENGTH_SHORT).show()
        }
        val hasil = angka / 132
        hasil_konversi!!.text = NumberFormat.getCurrencyInstance(Locale.JAPAN).format(hasil)
        Toast.makeText(this, "1 Yen = Rp 132", Toast.LENGTH_SHORT).show()
    }

    fun toEuro(v: View?) {
        if (!cek()) {
            return
        }
        try {
            angka = input_uang!!.text.toString().toDouble()
        } catch (e: Exception) {
            Toast.makeText(this, "Masukkan angka", Toast.LENGTH_SHORT).show()
        }
        val hasil = angka / 17228
        hasil_konversi!!.text = NumberFormat.getCurrencyInstance(Locale.GERMANY).format(hasil)
        Toast.makeText(this, "1 Euro = Rp 17.228", Toast.LENGTH_SHORT).show()
    }

    fun toUSD(v: View?) {
        if (!cek()) {
            return
        }
        try {
            angka = input_uang!!.text.toString().toDouble()
        } catch (e: Exception) {
            Toast.makeText(this, "Masukkan angka", Toast.LENGTH_SHORT).show()
        }
        val hasil = angka / 14808
        hasil_konversi!!.text = NumberFormat.getCurrencyInstance(Locale.US).format(hasil)
        Toast.makeText(this, "1 U\$D = Rp 14808", Toast.LENGTH_SHORT).show()
    }
}