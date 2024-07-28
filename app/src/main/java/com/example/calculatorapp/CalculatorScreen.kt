package com.example.calculatorapp

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.calculatorapp.data.Events
import com.example.calculatorapp.data.Operations

@Composable
fun CalculatorScreen(

) {
    val viewmodel = CalculatorViewModel()
    Scaffold(
        topBar = { AppBar() }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxWidth()
        ) {
            Box(
                modifier = Modifier
                    .padding(16.dp)
                    .height(200.dp)
                    .fillMaxWidth()
            ) {
                Text(
                    text ="${viewmodel.state.value.firstNumber} ${viewmodel.state.value.operation?.symbol.orEmpty()} ${viewmodel.state.value.secondNumber}" ,
                    fontSize = 30.sp,
                    color = Color.Black,
                    modifier = Modifier.align(Alignment.BottomEnd),
                    maxLines = 3
                )
            }

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                Row {
                    CalButton(
                        symbol = "AC",
                        modifier = Modifier
                            .weight(1f)
                            .padding(8.dp),

                        onClick = { viewmodel.onEvent(Events.Clear) }
                    )
                    CalButton(
                        symbol = "Del",
                        modifier = Modifier
                            .weight(1f)
                            .padding(8.dp),
                        onClick = {
                            viewmodel.onEvent(Events.Delete)
                        }
                    )
                    CalButton(
                        symbol = "/",
                        modifier = Modifier
                            .weight(1f)
                            .padding(8.dp),
                        onClick = {
                            viewmodel.onEvent(Events.Operation(Operations.Divide))
                        }
                    )
                }
                Row {
                    CalButton(
                        symbol = "7",
                        modifier = Modifier
                            .weight(1f)
                            .padding(8.dp),
                        onClick = {
                            viewmodel.onEvent(Events.Number(7))
                        }
                    )
                    CalButton(
                        symbol = "8",
                        modifier = Modifier
                            .weight(1f)
                            .padding(8.dp),
                        onClick = {
                            viewmodel.onEvent(Events.Number(8))
                        }
                    )
                    CalButton(
                        symbol = "9",
                        modifier = Modifier
                            .weight(1f)
                            .padding(8.dp),
                        onClick = {
                            viewmodel.onEvent(Events.Number(9))
                        }
                    )
                    CalButton(
                        symbol = "*",
                        modifier = Modifier
                            .weight(1f)
                            .padding(8.dp),
                        onClick = {
                            viewmodel.onEvent(Events.Operation(Operations.Multiply))
                        }
                    )
                }
                Row {
                    CalButton(
                        symbol = "4",
                        modifier = Modifier
                            .weight(1f)
                            .padding(8.dp),
                        onClick = {
                            viewmodel.onEvent(Events.Number(4))
                        }
                    )
                    CalButton(
                        symbol = "5",
                        modifier = Modifier
                            .weight(1f)
                            .padding(8.dp),
                        onClick = {
                            viewmodel.onEvent(Events.Number(5))
                        }
                    )
                    CalButton(
                        symbol = "6",
                        modifier = Modifier
                            .weight(1f)
                            .padding(8.dp),
                        onClick = {
                            viewmodel.onEvent(Events.Number(6))
                        }
                    )
                    CalButton(
                        symbol = "-",
                        modifier = Modifier
                            .weight(1f)
                            .padding(8.dp),
                        onClick = {
                            viewmodel.onEvent(Events.Operation(Operations.Subtract))
                        }
                    )
                }
                Row {
                    CalButton(
                        symbol = "1",
                        modifier = Modifier
                            .weight(1f)
                            .padding(8.dp),
                        onClick = {
                            viewmodel.onEvent(Events.Number(1))
                        }
                    )
                    CalButton(
                        symbol = "2",
                        modifier = Modifier
                            .weight(1f)
                            .padding(8.dp),
                        onClick = {
                            viewmodel.onEvent(Events.Number(2))
                        }
                    )
                    CalButton(
                        symbol = "3",
                        modifier = Modifier
                            .weight(1f)
                            .padding(8.dp),
                        onClick = {
                            viewmodel.onEvent(Events.Number(3))
                        }
                    )
                    CalButton(
                        symbol = "+",
                        modifier = Modifier
                            .weight(1f)
                            .padding(8.dp),
                        onClick = {
                            viewmodel.onEvent(Events.Operation(Operations.Add))
                        }
                    )
                }
                Row {
                    CalButton(
                        symbol = "0",
                        modifier = Modifier
                            .weight(1f)
                            .padding(8.dp),
                        onClick = {
                            viewmodel.onEvent(Events.Number(0))
                        }
                    )
                    CalButton(
                        symbol = ".",
                        modifier = Modifier
                            .weight(1f)
                            .padding(8.dp),
                        onClick = {
                            viewmodel.onEvent(Events.Decimal)
                        }
                    )
                    CalButton(
                        symbol = "=",
                        modifier = Modifier
                            .weight(1f)
                            .padding(8.dp),
                        onClick = {
                            viewmodel.onEvent(Events.Calculate)
                        }
                    )
                }
            }
        }
    }
}
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppBar() {
    TopAppBar(
        title = {
            Text(
                text = "Calculator",
                modifier = Modifier
                    .padding(4.dp)
                    .fillMaxWidth(),
                color = Color.White,
                fontSize = 36.sp,
            )
        },
        colors = TopAppBarDefaults.smallTopAppBarColors(containerColor = Color.Cyan),
        )
}
@Composable
fun CalButton(
    symbol: String,
    modifier: Modifier = Modifier,
    onClick: () -> Unit
) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = modifier
            .size(60.dp)
            .background(color = MaterialTheme.colorScheme.primary, shape = CircleShape)
            .clickable { onClick() }
            .padding(16.dp)
    ) {
        Text(
            text = symbol,
            fontSize = 24.sp,
            color = Color.White
        )
    }
}
@Preview(showBackground = true)
@Composable
fun TopAppBArPreview(){
    AppBar()
}
@Preview(showBackground = true)
@Composable
fun CalculatorScreenPreview(){
    CalculatorScreen()
}
