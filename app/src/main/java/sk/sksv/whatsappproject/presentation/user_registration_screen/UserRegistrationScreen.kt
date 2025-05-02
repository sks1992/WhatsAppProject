package sk.sksv.whatsappproject.presentation.user_registration_screen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import sk.sksv.whatsappproject.R

@Composable
@Preview(showSystemUi = true)
fun UserRegistrationScreen(modifier: Modifier = Modifier) {

    var expended by remember {
        mutableStateOf(false)
    }
    var selectedCountry by remember {
        mutableStateOf("India")
    }
    var countryCode by remember {
        mutableStateOf("+91")
    }

    var phoneNumber by remember {
        mutableStateOf("")
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Text(
            text = "Enter Your Phone Number",
            fontSize = 20.sp,
            color = colorResource(R.color.dark_green),
            fontWeight = FontWeight.Bold
        )
        Spacer(modifier = Modifier.height(24.dp))
        Row {
            Text(text = "WhatsApp will need to verify your phone number")
            Spacer(modifier = Modifier.width(4.dp))
            Text(text = "what's", color = colorResource(R.color.dark_green))
        }
        Text(text = "my number ?", color = colorResource(R.color.dark_green))
        Spacer(modifier = Modifier.height(16.dp))
        TextButton(onClick = { expended = true }, modifier = Modifier.fillMaxWidth()) {
            Box(modifier = Modifier.width(230.dp)) {
                //52.07
                Text(
                    text = selectedCountry,
                    modifier = Modifier.align(Alignment.Center),
                    fontSize = 16.sp, color = Color.Black,
                )
                Icon(
                    imageVector = Icons.Default.ArrowDropDown, contentDescription = null,
                    modifier.align(Alignment.CenterEnd),
                    tint = colorResource(id = R.color.light_green)
                )
            }
        }
        HorizontalDivider(
            modifier =
                Modifier.padding(horizontal = 66.dp),
            thickness = 2.dp, color = colorResource(id = R.color.light_green),
        )
        DropdownMenu(expanded = expended, onDismissRequest = { expended = false },
            modifier= Modifier.fillMaxWidth()) {
            listOf<String>("India", "US", "Japan", "Canada", "KSA").forEach { country ->
                DropdownMenuItem(text = { Text(country) }, onClick = {
                    selectedCountry = country
                    expended = false
                })
            }
        }
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Row {
                TextField(
                    value = countryCode,
                    onValueChange = {
                        countryCode = it
                    },
                    modifier = Modifier.width(70.dp),
                    singleLine = true,
                    textStyle = LocalTextStyle.current.copy(fontSize = 18.sp),
                    colors = TextFieldDefaults.colors(
                        focusedTextColor = Color.Green,
                        unfocusedContainerColor = Color.Transparent,
                        focusedContainerColor = Color.Transparent,
                        unfocusedIndicatorColor = colorResource(R.color.light_green),
                        focusedIndicatorColor = colorResource(R.color.dark_green),
                    )
                )
                TextField(
                    value = phoneNumber,
                    onValueChange = {
                        phoneNumber = it
                    },
                    placeholder = {
                        Text("Phone Number")
                    },
                    singleLine = true,
                    colors = TextFieldDefaults.colors(
                        focusedTextColor = Color.Green,
                        unfocusedContainerColor = Color.Transparent,
                        focusedContainerColor = Color.Transparent,
                        unfocusedIndicatorColor = colorResource(R.color.light_green),
                        focusedIndicatorColor = colorResource(R.color.dark_green),
                    )
                )
            }
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                "Carrier charges may apply",
                fontSize = 14.sp,
                color = MaterialTheme.colorScheme.onSurface.copy(
                    alpha = 0.6f
                )
            )
            Spacer(modifier = Modifier.height(26.dp))
            Button(onClick = {}, shape = RoundedCornerShape(6.dp), colors = ButtonDefaults.buttonColors(
                containerColor = colorResource(R.color.dark_green)
            )) {
                Text("NEXT", fontSize = 16.sp)
            }
        }
    }
}