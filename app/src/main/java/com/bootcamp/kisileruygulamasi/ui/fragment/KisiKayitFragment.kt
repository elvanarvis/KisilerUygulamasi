package com.bootcamp.kisileruygulamasi.ui.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import com.bootcamp.kisileruygulamasi.R
import com.bootcamp.kisileruygulamasi.databinding.FragmentKisiKayitBinding
import com.bootcamp.kisileruygulamasi.ui.ViewModel.KisiKayitViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class KisiKayitFragment : Fragment(R.layout.fragment_kisi_kayit) {

    private lateinit var binding: FragmentKisiKayitBinding
    private lateinit var viewModel: KisiKayitViewModel

    //override fun onCreate(savedInstanceState: Bundle?,container : ViewGroup*, savedInstanceBundle?) {
       // DataBindingUtil.inflate(inflater,,container,false)
      //  super.onCreate(savedInstanceState)
    //}
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding = DataBindingUtil.bind(view)!!
        super.onViewCreated(view, savedInstanceState)

        binding.kisiKayitFragment = this
        binding.apply {

            kisiKayitToolbarBaslik = "Kişi Kayıt"

        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val tempViewModel:KisiKayitViewModel by viewModels()
        viewModel = tempViewModel
    }

    fun buttonKaydet(kisi_ad: String, kisi_tel: String){
        viewModel.kaydet(kisi_ad,kisi_tel)
    }
}

