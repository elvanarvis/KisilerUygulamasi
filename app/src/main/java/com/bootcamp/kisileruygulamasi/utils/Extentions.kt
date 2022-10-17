package com.bootcamp.kisileruygulamasi.utils

import android.view.View
import androidx.navigation.NavDirections
import androidx.navigation.Navigation
import com.bootcamp.kisileruygulamasi.R

fun Navigation.gecisYap(view: View, id: Int){
    findNavController(view).navigate(id)
}

fun Navigation.gecisYap(view: View, id: NavDirections){
    findNavController(view).navigate(id)
}