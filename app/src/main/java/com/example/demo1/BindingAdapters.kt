package com.example.demo1

import android.R.attr.value
import android.widget.EditText
import androidx.databinding.BindingAdapter

@BindingAdapter("formattedDouble")
fun formattedDouble(editText: EditText, formattedDouble: Double){
     value.let{
        editText.setText(String.format("%.2f", it))
    }
}