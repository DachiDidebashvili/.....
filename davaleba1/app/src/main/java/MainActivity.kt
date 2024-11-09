import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MainScreen(onNextClick = {
                startActivity(Intent(this, SecondActivity::class.java))
            })
        }
    }
}

@Composable
fun MainScreen(onNextClick: () -> Unit) {
    var textFieldState by remember { mutableStateOf(TextFieldValue("")) }
    var displayedNumber by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center
    ) {
        OutlinedTextField(
            value = textFieldState,
            onValueChange = { textFieldState = it },
            label = { Text("Enter your number here") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp))

        Text(text = if (displayedNumber.isEmpty()) "" else "Your number is $displayedNumber")

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = { displayedNumber = textFieldState.text },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Okay")
        }

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = onNextClick,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Next")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MainScreenPreview() {
    MainScreen(onNextClick = {})
}
