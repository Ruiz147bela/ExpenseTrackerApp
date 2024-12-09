import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.Isabela.expensetracker.ExpenseAdapter
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {

    private val expenses = mutableListOf<Expense>()
    private lateinit var adapter: ExpenseAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Configurar RecyclerView
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerViewExpenses)
        adapter = ExpenseAdapter(expenses)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter

        // Configurar botón flotante
        val fab = findViewById<FloatingActionButton>(R.id.fabAddExpense)
        fab.setOnClickListener {
            addSampleExpense()
        }
    }

    private fun addSampleExpense() {
        val newExpense = Expense(
            id = expenses.size + 1,
            title = "Nueva Tarea ${expenses.size + 1}",
            amount = (10..100).random().toDouble(),
            date = "01/01/2024"
        )
        expenses.add(newExpense)
        adapter.notifyDataSetChanged()
    }
}
