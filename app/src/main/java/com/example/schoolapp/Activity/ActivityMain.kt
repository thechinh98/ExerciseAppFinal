package com.example.schoolapp.Activity

import android.app.Fragment
import android.content.Context
import android.os.Bundle
import android.service.autofill.OnClickAction
import android.util.AttributeSet
import android.util.Log
import android.view.GestureDetector
import android.view.MotionEvent
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.get
import androidx.viewpager.widget.ViewPager
import com.example.schoolapp.Adapter.NewFeedAdapter
import com.example.schoolapp.Adapter.ViewPagerAdapter
import com.example.schoolapp.Adapter.ViewPagerAdapter.*
import com.example.schoolapp.Fragment.ChatFragment
import com.example.schoolapp.Fragment.NewFeedFragment
import com.example.schoolapp.R
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_chat.*
import kotlinx.android.synthetic.main.fragment_new_feed2.*


class ActivityMain : AppCompatActivity() {


    var currentId = 0
    var newFeedFragment = NewFeedFragment()
    var chatFragment = ChatFragment()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        lateinit var pagerAdapter: ViewPagerAdapter
        val indi1 = findViewById<ImageView>(R.id.indicator1)
        val indi2 = findViewById<ImageView>(R.id.indicator2)
        val indi3 = findViewById<ImageView>(R.id.indicator3)
        val indi4 = findViewById<ImageView>(R.id.indicator4)
        val imgHome = findViewById<ImageView>(R.id.img_home)
        val imgChat = findViewById<ImageView>(R.id.img_chat)
        var viewPager = findViewById<ViewPager>(R.id.view_pager)
        pagerAdapter = ViewPagerAdapter(supportFragmentManager,newFeedFragment, chatFragment)
        viewPager.adapter = pagerAdapter
        viewPager.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {
            override fun onPageScrollStateChanged(state: Int) {

            }

            override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {
            }

            override fun onPageSelected(position: Int) {
                when (position) {
                    0 -> {
                        indi1.setImageResource(R.drawable.selection)
                        indi2.setImageResource(R.drawable.blank_rec)
                        indi3.setImageResource(R.drawable.blank_rec)
                        indi4.setImageResource(R.drawable.blank_rec)
                        imgHome.setImageResource(R.drawable.group_7)
                        imgChat.setImageResource(R.drawable.group_8)
                    }
                    1 -> {
                        indi1.setImageResource(R.drawable.blank_rec)
                        indi2.setImageResource(R.drawable.selection)
                        indi3.setImageResource(R.drawable.blank_rec)
                        indi4.setImageResource(R.drawable.blank_rec)
                        imgHome.setImageResource(R.drawable.ic_home_gray)
                        imgChat.setImageResource(R.drawable.ic_chat_blue)
                    }
                    2 -> {
                        indi1.setImageResource(R.drawable.blank_rec)
                        indi2.setImageResource(R.drawable.blank_rec)
                        indi3.setImageResource(R.drawable.selection)
                        indi4.setImageResource(R.drawable.blank_rec)
                        imgChat.setImageResource(R.drawable.group_8)
                        imgHome.setImageResource(R.drawable.ic_home_gray)
                    }
                    3 -> {
                        indi1.setImageResource(R.drawable.blank_rec)
                        indi2.setImageResource(R.drawable.blank_rec)
                        indi3.setImageResource(R.drawable.blank_rec)
                        indi4.setImageResource(R.drawable.selection)
                        imgChat.setImageResource(R.drawable.group_8)
                        imgHome.setImageResource(R.drawable.ic_home_gray)
                    }
                }
            }

        })

        img_home.setOnClickListener {
            viewPager.setCurrentItem(0)
        }
        img_chat.setOnClickListener {
            viewPager.setCurrentItem(1)
        }
        img_noti.setOnClickListener {
            viewPager.setCurrentItem(2)
        }
        img_profile.setOnClickListener {
            viewPager.setCurrentItem(3)
            Log.d("BEST","Clicked" )
        }
        view_pager.setOnClickListener {
            chatFragment.changeOrderList()
        }
    }
    fun chatViewPageChange(){
        view_pager.setCurrentItem(1)
        chatFragment.changeOrderList()
    }

}
