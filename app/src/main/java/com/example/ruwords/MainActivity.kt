package com.example.ruwords

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.ruwords.ui.theme.RuWordsTheme
import com.github.demidko.aot.WordformMeaning.lookupForMeanings

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RuWordsTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    EnterText()
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun EnterText(){

    Column(Modifier.padding(10.dp)){
        Text(text = "Введите текст")
        var lastFocusState by remember { mutableStateOf(false) }
        var inputtext by remember { mutableStateOf(" ") }
        OutlinedTextField(value = inputtext,
            onValueChange = { inputtext = it},
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.5f)

                .align(Alignment.Start)
                ,
            maxLines = 5,
            enabled = true,
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Text,
                imeAction = ImeAction.Send
        ))
        Spacer(Modifier.size(10.dp))
        Button(
            onClick = { CheckText(inputtext)},
            Modifier
                .align(Alignment.CenterHorizontally)
                .fillMaxWidth()
        ) {
            Text("Проверить текст")

        }
        Spacer(Modifier.size(10.dp))
        Text(text = "Hello $inputtext!")
    }
}


fun CheckText(text: String)
{

    var meanings = lookupForMeanings("люди")
    var meanings1 = lookupForMeanings(text)

    //Text(text = "Hello $text!")
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    RuWordsTheme {
        Greeting("Android")
    }
}