package com.example.tictactoe

import android.app.Dialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.Window
import android.widget.Button
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.dialog.*


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }
    var cnt=0

    fun clickbtn(view: View) {
        cnt=cnt+1
        var cellid = 0
        val busel = view as Button

        when (busel.id) {
            R.id.button1 ->
                cellid = 1

            R.id.button9 ->
                cellid = 9

            R.id.button2 ->
                cellid = 2
            R.id.button3 ->
                cellid = 3
            R.id.button4 ->
                cellid = 4
            R.id.button5 ->
                cellid = 5
            R.id.button6 ->
                cellid = 6
            R.id.button7 ->
                cellid = 7
            R.id.button8 ->
                cellid = 8

        }
        tap(cellid,busel)
    }




    var curplayer=1
    var p1ids= arrayListOf<Int>()
    var p2ids= arrayListOf<Int>()
    fun tap(cellid:Int,selbtn:Button){
        if(curplayer==1) {
            selbtn.text = "X"
            curplayer = 2
            p1ids.add(cellid)
        }else{

                selbtn.text = "0"
                curplayer = 1
                p2ids.add(cellid)
            }
        selbtn.isEnabled=false
        winner()
        }

    fun winner(){
    var win=-1

        if(p1ids.contains(1) && p1ids.contains(2) && p1ids.contains(3)){
            win=1
        }
        if(p1ids.contains(4) && p1ids.contains(5) && p1ids.contains(6)){
            win=1
        }
        if(p1ids.contains(7) && p1ids.contains(8) && p1ids.contains(9)){
            win=1
        }
        if(p2ids.contains(1) && p2ids.contains(2) && p2ids.contains(3)){
            win=2
        }
        if(p2ids.contains(4) && p2ids.contains(5) && p2ids.contains(6)){
            win=2
        }
        if(p2ids.contains(7) && p2ids.contains(8) && p2ids.contains(9)){
            win=2
        }
        if(p1ids.contains(1) && p1ids.contains(4) && p1ids.contains(7)){
            win=1
        }
        if(p1ids.contains(2) && p1ids.contains(5) && p1ids.contains(8)){
            win=1
        }
        if(p1ids.contains(3) && p1ids.contains(6) && p1ids.contains(9)){
            win=1
        }
        if(p2ids.contains(1) && p2ids.contains(4) && p2ids.contains(7)){
            win=2
        }
        if(p2ids.contains(2) && p2ids.contains(5) && p2ids.contains(8)){
            win=2
        }
        if(p2ids.contains(3) && p2ids.contains(6) && p2ids.contains(9)){
            win=2
        }
        if(p2ids.contains(1) && p2ids.contains(5) && p2ids.contains(9)){
            win=2
        }
        if(p1ids.contains(7) && p1ids.contains(5) && p1ids.contains(3)){
            win=1
        }
        if(p1ids.contains(1) && p1ids.contains(5) && p1ids.contains(9)){
            win=1
        }
        if(p2ids.contains(7) && p2ids.contains(5) && p2ids.contains(3)){
            win=2
        }

        if(win==1){
           // Toast.makeText(this,"Player 1 won",Toast.LENGTH_LONG).show()
            val dialog=Dialog(this)
            dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
            dialog.setCancelable(false)
            dialog.setContentView(R.layout.dialog)
            dialog.result.text="Player 1 Won"
            dialog.retry.setOnClickListener {
                var i= Intent(this,MainActivity::class.java)
                finish()
                startActivity(i)
            }
            dialog.show()
        }else if(win==2){
            val dialog=Dialog(this)
            dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
            dialog.setCancelable(false)
            dialog.setContentView(R.layout.dialog)
            dialog.result.text="Player 2 Won"
            dialog.retry.setOnClickListener {
                var i= Intent(this,MainActivity::class.java)
                finish()
                startActivity(i)
            }
            dialog.show()
        }else if(cnt==9){
            val dialog=Dialog(this)
            dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
            dialog.setCancelable(false)
            dialog.setContentView(R.layout.dialog)
            dialog.result.text="Match Draw"
            dialog.retry.setOnClickListener {
                var i= Intent(this,MainActivity::class.java)
                finish()
                startActivity(i)
            }
            dialog.show()

        }
    }



    }
