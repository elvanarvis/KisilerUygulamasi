package com.bootcamp.kisileruygulamasi.ui.adapter

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.bootcamp.kisileruygulamasi.R
import com.bootcamp.kisileruygulamasi.data.entity.Kisiler
import com.bootcamp.kisileruygulamasi.databinding.CardTasarimBinding
import com.bootcamp.kisileruygulamasi.ui.ViewModel.AnaSayfaViewModel
import com.bootcamp.kisileruygulamasi.ui.fragment.AnaSayfaFragmentDirections
import com.bootcamp.kisileruygulamasi.utils.gecisYap
import com.google.android.material.snackbar.Snackbar

class KisilerAdapter(var mContext: Context, var kisilerListesi: List<Kisiler>, var viewModel: AnaSayfaViewModel) :
    RecyclerView.Adapter<KisilerAdapter.CardTasarimTutucu>() {

    inner class CardTasarimTutucu(binding: CardTasarimBinding) :
        RecyclerView.ViewHolder(binding.root) {

        var binding: CardTasarimBinding

        init {
            this.binding = binding
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardTasarimTutucu {
        val binding: CardTasarimBinding = DataBindingUtil.inflate(
            LayoutInflater.from(mContext),
            R.layout.card_tasarim, parent, false
        )
        return CardTasarimTutucu(binding)
    }

    override fun onBindViewHolder(holder: CardTasarimTutucu, position: Int) {
        val kisi = kisilerListesi.get(position)
        val b = holder.binding
        b.kisiNesnesi = kisi

        b.satirCard.setOnClickListener {

            val gecis =
                AnaSayfaFragmentDirections.actionAnaSayfaFragmentToKisiDetayFragment(nesne = kisi)
            Navigation.gecisYap(it,gecis)
        }

        b.imageSil.setOnClickListener {
            Snackbar.make(it, "${kisi.kisi_ad} silinsin mi?", Snackbar.LENGTH_LONG)
                .setAction("Evet") {
                    viewModel.sil(kisi.kisi_id)
                }
                .show()

        }
    }

    override fun getItemCount(): Int {
        return kisilerListesi.size
    }
}