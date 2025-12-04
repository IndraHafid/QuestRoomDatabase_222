package com.example.myroom1p9.view

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.myroom1p9.R
import com.example.myroom1p9.viewmodel.DetailViewModel
import com.example.myroom1p9.viewmodel.provider.PenyediaViewModel
import com.example.myroom1p9.view.route.DestinasiDetailSiswa
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailSiswaScreen(
    navigateToEditItem: (Int) -> Unit,
    navigateBack: () -> Unit,
    modifier: Modifier = Modifier,
    viewModel: DetailViewModel = viewModel(factory = PenyediaViewModel.Factory)
) {
    Scaffold(
        topBar = {
            SiswaTopAppBar(
                title = stringResource(DestinasiDetailSiswa.titleRes),
                canNavigateBack = true,
                navigateUp = navigateBack
            )
        },
        floatingActionButton = {
            val uiState = viewModel.uiDetailState.collectAsState()
            FloatingActionButton(
                onClick = { navigateToEditItem(uiState.value.detailSiswa.id) },
                shape = MaterialTheme.shapes.medium,
                modifier = Modifier.padding(dimensionResource(id = R.dimen.padding_large))

            ) {
                Icon(
                    imageVector = Icons.Default.Edit,
                    contentDescription = stringResource(R.string.update),
                )
            }
        }, modifier = modifier
    ) { innerPadding ->
        val uiState = viewModel.uiDetailState.collectAsState()
        val coroutineScope = rememberCoroutineScope()
        BodyDetailDataSiswa(
            detailSiswaUiState = uiState.value,
            onDelete = { coroutineScope.launch {
                viewModel.deleteSiswa()
                navigateBack()
            }},
            modifier = Modifier
                .padding(innerPadding)
                .verticalScroll(rememberScrollState())
        )
    }
}

