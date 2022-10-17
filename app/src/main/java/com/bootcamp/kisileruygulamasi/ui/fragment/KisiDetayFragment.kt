package com.bootcamp.kisileruygulamasi.ui.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.bootcamp.kisileruygulamasi.R
import com.bootcamp.kisileruygulamasi.databinding.FragmentKisiDetayBinding
import com.bootcamp.kisileruygulamasi.ui.ViewModel.KisiDetayViewModel
import com.bootcamp.kisileruygulamasi.ui.ViewModel.KisiKayitViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class KisiDetayFragment : Fragment(R.layout.fragment_kisi_detay) {

    private lateinit var viewModel: KisiDetayViewModel
    private lateinit var binding: FragmentKisiDetayBinding
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = DataBindingUtil.bind(view)!!


        binding.kisiDetayFragment = this
        binding.apply {

            kisiDetayToolbarBaslik = "Kişi Detay"
            val bundle: KisiDetayFragmentArgs by navArgs()
            val gelenKisi = bundle.nesne
            kisiNesnesi = gelenKisi

        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val tempViewModel: KisiDetayViewModel by viewModels()
        viewModel = tempViewModel
    }

    fun butonGuncelle(kisi_id: Int, kisi_ad: String, kisi_tel: String) {
        viewModel.guncelle(kisi_id, kisi_ad, kisi_tel)
    }
}

