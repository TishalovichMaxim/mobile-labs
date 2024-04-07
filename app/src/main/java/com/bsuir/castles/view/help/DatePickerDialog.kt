package com.bsuir.castles.view.help

import androidx.compose.foundation.layout.Box
import androidx.compose.material3.Button
import androidx.compose.material3.DatePicker
import androidx.compose.material3.DatePickerDialog
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.SelectableDates
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDatePickerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableLongStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import java.text.SimpleDateFormat
import java.util.Date

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyDatePickerDialog(
    onConfirm: (Date?) -> Unit,
    onDismiss: () -> Unit
) {
    val datePickerState = rememberDatePickerState(selectableDates = object : SelectableDates {
        override fun isSelectableDate(utcTimeMillis: Long): Boolean {
            return utcTimeMillis < System.currentTimeMillis()
        }
    })

    var selectedDate: Date? by remember {
        mutableStateOf(null)
    }

    datePickerState.selectedDateMillis?.let {
        selectedDate = Date(it)
    }

    DatePickerDialog(
        onDismissRequest = { onDismiss() },
        confirmButton = {
            Button(onClick = {
                onConfirm(selectedDate)
                onDismiss()
            }

            ) {
                Text(text = "OK")
            }
        },
        dismissButton = {
            Button(onClick = {
                onDismiss()
            }) {
                Text(text = "Cancel")
            }
        }
    ) {
        DatePicker(
            state = datePickerState
        )
    }
}

@Composable
fun MyDatePickerDialog() {
    //var date by remember {
    //    mutableStateOf("Choose..")
    //}

    //var showDatePicker by remember {
    //    mutableStateOf(false)
    //}

    //Box(contentAlignment = Alignment.Center) {
    //    Button(onClick = { showDatePicker = true }) {
    //        Text(text = date)
    //    }
    //}

    //if (showDatePicker) {
    //    MyDatePickerDialog(
    //        onDateSelected = { date = it },
    //        onDismiss = { showDatePicker = false }
    //    )
    //}
}