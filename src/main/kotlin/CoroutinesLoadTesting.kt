import kotlinx.coroutines.*
import de.horst.java.LoadTesting

fun main() = runBlocking { // this: CoroutineScope

    println("Batch Run start (database open)") // This line will be printed before nested launch
    coroutineScope { // Creates a new coroutine scope
        val terminalIds = listOf(1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20)
        for (terminalId in terminalIds) {
            launch {
                println("Batch Run Campaign: $terminalId")
				var loadTesting = LoadTesting()
				loadTesting.init(terminalId);
            }
        }

    }

    println("Batch Run closed (database close) ")// This line is not printed until nested launch completes
}