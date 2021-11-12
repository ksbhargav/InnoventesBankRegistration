package com.a.banktest.ui

import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Spannable
import android.text.SpannableString
import android.text.style.ForegroundColorSpan
import android.text.style.StyleSpan
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.a.banktest.R
import com.a.banktest.databinding.MainDataBinding
import org.koin.android.ext.android.inject

class MainActivity : AppCompatActivity() {

    lateinit var binding : MainDataBinding
    val viewModel : MainViewModel by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil. setContentView(this, R.layout.activity_main)
        binding.lifecycleOwner = this
        binding.viewModel = viewModel


        setSpannables()

        binding.nextbtn.setOnClickListener {
            Toast.makeText(this,getString(R.string.details_submitted),Toast.LENGTH_LONG).show()
            finish()
        }
        binding.dontpanTxt.setOnClickListener {
            finish()
        }

    }

    fun setSpannables(){
        val spannable = SpannableString(getString(R.string.providing_pan_date___))
        spannable.setSpan(
            ForegroundColorSpan(resources.getColor(R.color.borderColor)),
            113, // start
            123, // end
            Spannable.SPAN_EXCLUSIVE_INCLUSIVE
        )
        spannable.setSpan(
            StyleSpan(Typeface.BOLD),
            113, // start
            123, // end
            Spannable.SPAN_EXCLUSIVE_INCLUSIVE)

        binding.paragraph.text = spannable

    }
}