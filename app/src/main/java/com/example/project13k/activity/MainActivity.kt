package com.example.project13k.activity

import android.content.Context
import android.os.Bundle
import android.view.animation.AnimationUtils
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.project13k.R
import com.example.project13k.adapter.CustomAdapter
import com.example.project13k.model.Member
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var context: Context
    private lateinit var members: ArrayList<Member>
    private lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initViews()

        refreshAdapter(prepareMemberList())

    }

    private fun initViews() {
        context = this
        recyclerView = main_recycler_view

        recyclerView.layoutManager = LinearLayoutManager(
            context,
            LinearLayoutManager.VERTICAL, false
        )

        //        val snapHelper = PagerSnapHelper()
        //        snapHelper.attachToRecyclerView(recyclerView)

        // animation
        val animationUtils =
            AnimationUtils.loadLayoutAnimation(context, R.anim.layout_animation_fall_down)
        recyclerView.layoutAnimation = animationUtils
    }

    private fun refreshAdapter(members: ArrayList<Member>) {
        val customAdapter = CustomAdapter(context, prepareMemberList())
        recyclerView.adapter = customAdapter
    }

    private fun prepareMemberList(): ArrayList<Member> {
        members = ArrayList()
        for (i in 1..30) members.add(Member("Muhammadrizo$i", "Nurullaxo'jayev$i"))
        return members
    }

}


