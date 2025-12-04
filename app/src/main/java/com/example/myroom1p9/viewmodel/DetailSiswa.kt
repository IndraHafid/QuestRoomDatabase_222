package com.example.myroom1p9.viewmodel

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.example.myroom1p9.repositori.RepositoriSiswa

class DetailViewModel(
    savedStateHandle: SavedStateHandle,
    private val repositoriSiswa: RepositoriSiswa
) : ViewModel() {

}

/**
 * UI state for ItemDetailsScreen
 */
data class DetailSiswaUiState(
    val detailSiswa: DetailSiswa = DetailSiswa()
)