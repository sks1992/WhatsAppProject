package sk.sksv.whatsappproject.presentation.home_screen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import sk.sksv.whatsappproject.R
import sk.sksv.whatsappproject.presentation.bottom_navigation.BottomNavigation
import sk.sksv.whatsappproject.presentation.chat_box.ChatListModel

@Composable
@Preview(showSystemUi = true)
fun HomeScreen(modifier: Modifier = Modifier) {

    val chatData = listOf(
        ChatListModel(
            image = R.drawable.salman_khan,
            name = "Salman Khan",
            time = "10:00 AM",
            message = "Hi Rashmika",
        ),
        ChatListModel(
            image = R.drawable.rashmika,
            name = "Rashmika",
            time = "11:00 AM",
            message = "Hi Salman",
        ),
        ChatListModel(
            image = R.drawable.sharukh_khan,
            name = "Sharukh Khan",
            time = "11:30 AM",
            message = "Hi Salman",
        ),
        ChatListModel(
            image = R.drawable.sharadha_kapoor,
            name = "Sharadha Kapoor",
            time = "10:00 PM",
            message = "Hi Rashmika",
        ),
        ChatListModel(
            image = R.drawable.salman_khan,
            name = "Salman Khan",
            time = "10:00 AM",
            message = "Hi Rashmika",
        ),
        ChatListModel(
            image = R.drawable.rashmika,
            name = "Rashmika",
            time = "11:00 AM",
            message = "Hi Salman",
        ),
        ChatListModel(
            image = R.drawable.sharukh_khan,
            name = "Sharukh Khan",
            time = "11:30 AM",
            message = "Hi Salman",
        ),
        ChatListModel(
            image = R.drawable.sharadha_kapoor,
            name = "Sharadha Kapoor",
            time = "10:00 PM",
            message = "Hi Rashmika",
        ),
    )
    Scaffold(
        floatingActionButton = {
            FloatingActionButton(
                onClick = {},
                containerColor = colorResource(id = R.color.light_green),
                contentColor = Color.White
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.add_chat),
                    contentDescription = null,
                    modifier.size(28.dp)
                )
            }
        },
        bottomBar = { BottomNavigation() }
    ) {
        Column(modifier = Modifier.padding(it)) {
            Spacer(modifier = Modifier.height(8.dp))
            Box(modifier = Modifier.fillMaxWidth()) {
                Text(
                    text = "WhatsApp",
                    fontSize = 28.sp,
                    color = colorResource(R.color.light_green),
                    modifier = Modifier
                        .align(
                            Alignment.CenterStart
                        )
                        .padding(start = 16.dp),
                    fontWeight = FontWeight.Bold
                )

                Row(modifier = Modifier.align(Alignment.CenterEnd)) {
                    IconButton(onClick = {}) {
                        Icon(
                            painter = painterResource(R.drawable.camera),
                            contentDescription = null,
                            modifier = Modifier.size(28.dp)
                        )
                    }
                    IconButton(onClick = {}) {
                        Icon(
                            painter = painterResource(R.drawable.search),
                            contentDescription = null,
                            modifier = Modifier.size(28.dp)
                        )
                    }
                    IconButton(onClick = {}) {
                        Icon(
                            painter = painterResource(R.drawable.more),
                            contentDescription = null,
                            modifier = Modifier.size(28.dp)
                        )
                    }
                }
            }
            HorizontalDivider()
            LazyColumn {
                items(chatData.size) { index ->
                    ChatDesign(chatData[index])
                }
            }
        }
    }
}