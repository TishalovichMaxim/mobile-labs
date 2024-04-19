package com.bsuir.castles.view

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.bsuir.castles.view.help.MyDatePickerDialog
import com.bsuir.castles.viewmodel.SignUpViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@Composable
fun SignUpScreen() {
    val viewModel = viewModel<SignUpViewModel>()

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "Credentials",
            fontSize = 22.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .padding(vertical = 13.dp),
        )

        TextField(
            value = viewModel.email,
            onValueChange = { viewModel.email = it },
            label = { Text(text = "Input your email") },
            maxLines = 1
        )

        Spacer(
            modifier = Modifier
                .padding(top = 5.dp)
        )

        TextField (
            value = viewModel.password,
            onValueChange = { viewModel.password = it },
            label = { Text(text = "Input your password") },
            maxLines = 1,
            visualTransformation = PasswordVisualTransformation(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
        )

        Spacer(
            modifier = Modifier
                .padding(top = 5.dp)
        )

        TextField(
            value = viewModel.confirmationPassword,
            onValueChange = { viewModel.confirmationPassword = it },
            label = { Text(text = "Confirm your password") },
            maxLines = 1,
            visualTransformation = PasswordVisualTransformation(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password)
        )

        HorizontalDivider(
            modifier = Modifier
                .padding(vertical = 20.dp)
        )

        Text(
            text = "Personal info",
            fontSize = 22.sp,
            fontWeight = FontWeight.Bold,
        )

        TextField(
            value = viewModel.firstName,
            onValueChange = { viewModel.firstName = it },
            label = { Text(text = "Input your first name") },
            maxLines = 1,
        )

        Spacer(
            modifier = Modifier
                .padding(top = 5.dp)
        )

        TextField(
            value = viewModel.lastName,
            onValueChange = { viewModel.lastName = it },
            label = { Text(text = "Input your last name") },
            maxLines = 1
        )

        Spacer(
            modifier = Modifier
                .padding(top = 5.dp)
        )

        TextField(
            value = viewModel.bio,
            onValueChange = { viewModel.bio = it },
            label = { Text(text = "Write something about yourself") },
        )

        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "Birthdate: ",
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold
            )

            Box(contentAlignment = Alignment.Center) {
                Button(onClick = { viewModel.showDatePicker = true }) {
                    Text(text = viewModel.getDateString())
                }
            }

            if (viewModel.showDatePicker) {
                MyDatePickerDialog(
                    onConfirm = { viewModel.date = it },
                    onDismiss = { viewModel.showDatePicker = false }
                )
            }
        }

        HorizontalDivider(
            modifier = Modifier
                .padding(vertical = 8.dp)
        )

        Text(
            "Already have an account?",
            modifier = Modifier
                .clickable {
                    viewModel.goToSignInScreen()
                },
            style = TextStyle(),
            textDecoration = TextDecoration.Underline
        )

        Spacer(
            modifier = Modifier
                .padding(vertical = 6.dp)
        )

        Button(onClick = {
            CoroutineScope(Dispatchers.Main).launch {
                viewModel.signUp()
            }
        }) {
            Text(text = "Sign up")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun SignUpScreenPreview() {
    SignUpScreen()
}
