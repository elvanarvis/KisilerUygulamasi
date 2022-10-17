package com.bootcamp.kisileruygulamasi.data.datasource

import android.util.Log
import com.bootcamp.kisileruygulamasi.data.entity.Kisiler
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class KisilerDataSource {

    suspend fun kaydet(kisi_ad: String, kisi_tel: String) {
        Log.e("Kişi Kaydet", "$kisi_ad - $kisi_tel")
    }

    suspend fun guncelle(kisi_id: Int, kisi_ad: String, kisi_tel: String) {
        Log.e("Kişi Güncelle", "$kisi_id - $kisi_ad - $kisi_tel")
    }

    suspend fun kisileriYukle(): List<Kisiler> = withContext(Dispatchers.IO) {
        val kisilerList = ArrayList<Kisiler>()

        val k1 = Kisiler(1, "Ahmet", "11111")
        val k3 = Kisiler(3, "Zeynep", "55555")
        val k2 = Kisiler(2, "Beyza", "33333")

        kisilerList.add(k1)
        kisilerList.add(k2)
        kisilerList.add(k3)

        return@withContext kisilerList
    }

    suspend fun ara(aramaKelimesi: String): List<Kisiler> = withContext(Dispatchers.IO) {
        val kisilerList = ArrayList<Kisiler>()

        val k1 = Kisiler(1, "Ahmet", "11111")

        kisilerList.add(k1)

        return@withContext kisilerList
    }

    suspend fun sil(kisi_id: Int) {
        Log.e("KişiSil", kisi_id.toString())
    }
}