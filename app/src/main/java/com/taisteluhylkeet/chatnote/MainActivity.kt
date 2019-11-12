package com.taisteluhylkeet.chatnote

import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem

import kotlinx.android.synthetic.main.activity_main.*
import androidx.core.os.HandlerCompat.postDelayed
import com.github.bassaer.chatmessageview.util.ChatBot
//import android.R
import androidx.core.content.ContextCompat
import com.github.bassaer.chatmessageview.view.ChatView
import android.graphics.BitmapFactory
import android.graphics.Bitmap
import android.app.Activity
//import android.os.Message
import android.view.View
import com.github.bassaer.chatmessageview.model.Message
import com.github.bassaer.chatmessageview.model.ChatUser


class MessengerActivity : Activity() {
    var mChatView: ChatView? = null
    public override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //User id
        val myId = 0
        //User icon
        val myIcon = BitmapFactory.decodeResource(resources, R.drawable.face_2)
        //User name
        val myName = "Atte"

        val me = ChatUser(myId, myName, myIcon)

        mChatView = findViewById(R.id.chat_view) as ChatView

        mChatView?.setRightBubbleColor(ContextCompat.getColor(this, R.color.green500))
        mChatView?.setLeftBubbleColor(R.color.WHITE)
        mChatView?.setBackgroundColor(ContextCompat.getColor(this, R.color.blueGray500))
        mChatView?.setSendButtonColor(ContextCompat.getColor(this, R.color.blueGray500))
        mChatView?.setSendIcon(R.drawable.ic_action_send)
        mChatView?.setRightMessageTextColor(R.color.WHITE)
        mChatView?.setLeftMessageTextColor(R.color.BLACK)
        mChatView?.setUsernameTextColor(R.color.WHITE)
        mChatView?.setSendTimeTextColor(R.color.WHITE)
        mChatView?.setDateSeparatorColor(R.color.WHITE)
        mChatView!!.setInputTextHint("new message...")
        mChatView?.setMessageMarginTop(5)
        mChatView?.setMessageMarginBottom(5)


        mChatView!!.setOnClickSendButtonListener(object : View.OnClickListener {
            override fun onClick(view: View) {
                //new message
                val message = Message.Builder()
                    .setUser(me)
                    .setRight(true)
                    .setText(mChatView!!.inputText)
                    .hideIcon(true)
                    .build()
                //Set to chat view
                mChatView!!.send(message)
                //Reset edit text
                mChatView!!.inputText = ""

            }

        })

    }
}

class MainActivity : AppCompatActivity() {
    var mChatView: ChatView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }

        //User id
        val myId = 0
        //User icon
        val myIcon = BitmapFactory.decodeResource(resources, R.drawable.face_2)
        //User name
        val myName = "Atte"

        val me = ChatUser(myId, myName, myIcon)

        mChatView = findViewById(R.id.chat_view) as ChatView
        mChatView?.setRightBubbleColor(ContextCompat.getColor(this, R.color.green500))
        mChatView?.setLeftBubbleColor(R.color.WHITE)
        mChatView?.setBackgroundColor(ContextCompat.getColor(this, R.color.blueGray500))
        mChatView?.setSendButtonColor(ContextCompat.getColor(this, R.color.blueGray500))
        mChatView?.setSendIcon(R.drawable.ic_action_send)
        mChatView?.setRightMessageTextColor(R.color.WHITE)
        mChatView?.setLeftMessageTextColor(R.color.BLACK)
        mChatView?.setUsernameTextColor(R.color.WHITE)
        mChatView?.setSendTimeTextColor(R.color.WHITE)
        mChatView?.setDateSeparatorColor(R.color.WHITE)
        mChatView!!.setInputTextHint("new message...")
        mChatView?.setMessageMarginTop(5)
        mChatView?.setMessageMarginBottom(5)

        mChatView!!.setOnClickSendButtonListener(object : View.OnClickListener {
            override fun onClick(view: View) {
                //new message
                val message = Message.Builder()
                    .setUser(me)
                    .setRight(true)
                    .setText(mChatView!!.inputText)
                    .hideIcon(true)
                    .build()
                //Set to chat view
                mChatView!!.send(message)
                //Reset edit text
                mChatView!!.inputText = ""

            }

        })

    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }
}

/*class MessengerActivity : Activity() {

    private var mChatView: ChatView? = null

    public override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_messenger)

        //User id
        val myId = 0
        //User icon
        val myIcon = BitmapFactory.decodeResource(resources, R.drawable.face_2)
        //User name
        val myName = "Michael"

        val yourId = 1
        val yourIcon = BitmapFactory.decodeResource(resources, R.drawable.face_1)
        val yourName = "Emily"

        val me = User(myId, myName, myIcon)
        val you = User(yourId, yourName, yourIcon)

        mChatView = findViewById(R.id.chat_view) as ChatView

        //Set UI parameters if you need
        mChatView!!.setRightBubbleColor(ContextCompat.getColor(this, R.color.green500))
        mChatView!!.setLeftBubbleColor(Color.WHITE)
        mChatView!!.setBackgroundColor(ContextCompat.getColor(this, R.color.blueGray500))
        mChatView!!.setSendButtonColor(ContextCompat.getColor(this, R.color.cyan500))
        mChatView!!.setSendIcon(R.drawable.ic_action_send)
        mChatView!!.setRightMessageTextColor(Color.WHITE)
        mChatView!!.setLeftMessageTextColor(Color.BLACK)
        mChatView!!.setUsernameTextColor(Color.WHITE)
        mChatView!!.setSendTimeTextColor(Color.WHITE)
        mChatView!!.setDateSeparatorColor(Color.WHITE)
        mChatView!!.setInputTextHint("new message...")
        mChatView!!.setMessageMarginTop(5)
        mChatView!!.setMessageMarginBottom(5)

        //Click Send Button
        mChatView!!.setOnClickSendButtonListener(object : View.OnClickListener() {
            fun onClick(view: View) {
                //new message
                val message = Message.Builder()
                    .setUser(me)
                    .setRight(true)
                    .setText(mChatView!!.inputText)
                    .hideIcon(true)
                    .build()
                //Set to chat view
                mChatView!!.send(message)
                //Reset edit text
                mChatView!!.inputText = ""

            }

        })

    }
}*/
