package com.bootcamp.kisileruygulamasi.ui.fragment

import android.os.Bundle
import android.util.Log
import android.view.*
import android.widget.LinearLayout
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.core.app.ActivityCompat
import androidx.fragment.app.Fragment
import androidx.core.view.MenuProvider
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.bootcamp.kisileruygulamasi.R
import com.bootcamp.kisileruygulamasi.data.entity.Kisiler
import com.bootcamp.kisileruygulamasi.databinding.FragmentAnaSayfaBinding
import com.bootcamp.kisileruygulamasi.ui.ViewModel.AnaSayfaViewModel
import com.bootcamp.kisileruygulamasi.ui.ViewModel.KisiKayitViewModel
import com.bootcamp.kisileruygulamasi.ui.adapter.KisilerAdapter
import com.bootcamp.kisileruygulamasi.utils.gecisYap
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AnaSayfaFragment : Fragment(R.layout.fragment_ana_sayfa), SearchView.OnQueryTextListener {

    private lateinit var viewModel: AnaSayfaViewModel
    private lateinit var binding: FragmentAnaSayfaBinding
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = DataBindingUtil.bind(view)!!

        binding.anasayfaFragment = this

        viewModel.kisilerListesi.observe(viewLifecycleOwner) {
            val adapter = KisilerAdapter(requireContext(), it, viewModel)
            binding.kisilerAdapter = adapter

        }

        binding.apply {

            //rv.layoutManager = StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL)

            anasayfaToolbarBaslik = "Kişiler"

            (activity as AppCompatActivity).setSupportActionBar(toolbarAnaSayfa)




            requireActivity().addMenuProvider(object : MenuProvider {
                override fun onCreateMenu(menu: Menu, menuInflater: MenuInflater) {
                    menuInflater.inflate(R.menu.toolbar_menu, menu)
                    val item = menu.findItem(R.id.action_ara)
                    val searchView = item.actionView as SearchView
                    searchView.setOnQueryTextListener(this@AnaSayfaFragment)
                }

                override fun onMenuItemSelected(menuItem: MenuItem): Boolean {

                    /* when (menuItem.itemId) {
                         R.id.action_ara -> {
                             Toast.makeText(requireContext(), "Hiii", Toast.LENGTH_SHORT).show()
                             return true
                         }
                         else -> return false
                     }*/
                    return false

                }
            }, viewLifecycleOwner, Lifecycle.State.RESUMED)

        }

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val tempViewModel: AnaSayfaViewModel by viewModels()
        viewModel = tempViewModel
    }

    fun fabTikla(view: View) {
        Navigation.gecisYap(view,R.id.action_anaSayfaFragment_to_kisiKayitFragment)

    }

    override fun onQueryTextSubmit(query: String): Boolean { //ara tuşuna basınca sonuç gelecek

        viewModel.ara(query)
        return true
    }

    override fun onQueryTextChange(newText: String): Boolean { //her harf girince değişecek

        viewModel.ara(newText)
        return true
    }

}

