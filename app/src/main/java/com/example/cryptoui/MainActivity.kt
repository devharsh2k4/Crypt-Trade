package com.example.cryptoui

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.outlined.Favorite
import androidx.compose.material3.AssistChip
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.TopAppBarScrollBehavior
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {

    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {


        super.onCreate(savedInstanceState)
        setContent {

            Column(
                modifier = Modifier.fillMaxSize()

            ) {
                TradeTopBar(scrollBehavior = TopAppBarDefaults.pinnedScrollBehavior())
                Spacer(modifier = Modifier.padding(10.dp))
                BalanceBar()
                CongoBar()
                AssistChip()
                CoinList()

            }
        }
    }








    @Composable
    fun CoinList() {
        val coinName = mutableListOf("Bitcoin", "Polygon", "Ethereum", "Cardano", "Polkadot")
        val coinShortName = mutableListOf("BTC", "MATIC", "ETH", "ADA", "DOT")
        val gain = mutableListOf("+0.67%", "+0.82%", "-0.87%", "-0.15%", "+0.51%")
        val price = mutableListOf("$224", "$335", "$447", "$565", "$234")
        val coinIcon = mutableListOf(
            R.drawable.bitcoin,
            R.drawable.polygon,
            R.drawable.ethereum,
            R.drawable.ada,
            R.drawable.dot
        )

        LazyColumn {
            items(5) { index ->


                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(15.dp),
                ) {
                    Row(
                        horizontalArrangement = Arrangement.SpaceAround,
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Image(
                            painterResource(id = coinIcon[index]),
                            contentDescription = "icons of coins",
                            contentScale = ContentScale.Fit,
                            modifier = Modifier
                                .padding(top = 20.dp)
                                .size(40.dp)
                        )
//                      Spacer(modifier = Modifier.padding(15.dp))
                        Column(modifier = Modifier.padding(top = 20.dp)) {
                            Text(
                                text = coinName[index],
                                fontSize = 20.sp,
                                fontWeight = FontWeight.Medium
                            )
                            Text(
                                text = coinShortName[index],
                                fontWeight = FontWeight.Thin
                            )
                        }
                        Spacer(
                            modifier = Modifier
                                .padding(40.dp)
                                .padding(start = 60.dp)
                        )

                        Column(
                            verticalArrangement = Arrangement.Center,
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Spacer(modifier = Modifier.padding(top = 20.dp))
                            Text(
                                text = gain[index],
                                fontSize = 20.sp
                            )
                            Spacer(modifier = Modifier.padding(top = 5.dp))
                            Text(
                                text = price[index],
                                fontWeight = FontWeight.Thin
                            )
                        }


                    }
                }


            }
        }
    }

    @Composable
    fun AssistChip() {
        Row(modifier = Modifier.padding(10.dp)) {
            AssistChip(
                onClick = { },
                label = { Text("Coin") },

                )
            Spacer(modifier = Modifier.padding(10.dp))
            AssistChip(
                onClick = { },
                label = { Text("Watchlist") },

                )
            Spacer(modifier = Modifier.padding(30.dp))
            AssistChip(
                onClick = { },
                label = {
                    Text(
                        "24H Change \uD83D\uDD25",
                        textAlign = TextAlign.Center
                    )
                },

                )
        }
    }


    @Composable
    fun CongoBar() {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp),
            shape = RoundedCornerShape(10.dp),
            elevation = CardDefaults.cardElevation(10.dp),

            ) {
            Column(
                modifier = Modifier.fillMaxWidth(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Spacer(modifier = Modifier.padding(5.dp))
                Icon(
                    imageVector = Icons.Outlined.Favorite,
                    contentDescription = "Congrats"
                )
                Spacer(modifier = Modifier.padding(5.dp))
                Text(
                    text = "Congrats, you have a reward!",
                    fontSize = 25.sp,
                    fontWeight = FontWeight.Bold
                )
                Spacer(modifier = Modifier.padding(5.dp))
                Text(
                    text = "New User Zone",
                )
                Spacer(modifier = Modifier.padding(5.dp))
                Button(onClick = { /*TODO*/ }) {
                    Text(text = "Unlock 50 USDT")
                }
                Spacer(modifier = Modifier.padding(5.dp))
            }
        }
    }

    @Composable
    fun BalanceBar() {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 30.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Column {
                Text(
                    text = "Total Balance",
                    fontSize = 15.sp,
                    textAlign = TextAlign.Center
                )
                Text(
                    text = "$0.5641",
                    fontSize = 30.sp,
                    textAlign = TextAlign.Center
                )
            }

            Card(
                shape = CardDefaults.elevatedShape,
                elevation = CardDefaults.cardElevation(15.dp),
                modifier = Modifier.padding(top = 7.dp)
            ) {
                IconButton(onClick = { }) {
                    Icon(
                        imageVector = Icons.Filled.ArrowForward,
                        contentDescription = "NEXT"
                    )
                }
            }
        }
    }

    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun TradeTopBar(scrollBehavior: TopAppBarScrollBehavior) {

        Card(
            elevation = CardDefaults.cardElevation(15.dp),
            modifier = Modifier.wrapContentHeight(align = Alignment.Top)
        ) {
            Row(
                modifier = Modifier
                    .height(50.dp)
                    .fillMaxWidth()

            ) {
                IconButton(onClick = { /* doSomething() */ }) {

                    Icon(
                        imageVector = Icons.Filled.AccountCircle,
                        contentDescription = "Profile"
                    )


                }
                Spacer(modifier = Modifier.padding(5.dp))
                Text(
                    "Harsh",
                    textAlign = TextAlign.Justify,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    fontFamily = FontFamily.Default,
                    modifier = Modifier.padding(top = 10.dp)
                )
                Spacer(modifier = Modifier.padding(80.dp))
                IconButton(onClick = { /* doSomething() */ }) {
                    Icon(
                        imageVector = Icons.Filled.Search,
                        contentDescription = "Search"
                    )
                }
                Spacer(modifier = Modifier.padding(5.dp))
                IconButton(onClick = { /* doSomething() */ }) {
                    Icon(
                        imageVector = Icons.Filled.Refresh,
                        contentDescription = "Refresh"
                    )
                }
            }
        }
    }
}














