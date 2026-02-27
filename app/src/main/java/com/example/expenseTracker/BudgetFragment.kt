package com.example.expenseTracker

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.google.android.material.button.MaterialButton
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.progressindicator.LinearProgressIndicator
import java.text.NumberFormat
import com.example.expenseTracker.utils.DataManager
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.util.Currency

class BudgetFragment : Fragment() {
    private lateinit var budgetAmountInput: TextInputEditText
    private lateinit var saveBudgetButton: MaterialButton
    private lateinit var budgetProgressText: TextView
    private lateinit var spentAmountText: TextView
    private lateinit var remainingAmountText: TextView
    private lateinit var budgetProgressBar: LinearProgressIndicator
    private lateinit var budgetWarningText: TextView
    private val dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy")

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_budget, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        budgetAmountInput = view.findViewById(R.id.budgetAmountInput)
        saveBudgetButton = view.findViewById(R.id.saveBudgetButton)
        budgetProgressText = view.findViewById(R.id.budgetProgressText)
        spentAmountText = view.findViewById(R.id.spentAmountText)
        remainingAmountText = view.findViewById(R.id.remainingAmountText)
        budgetProgressBar = view.findViewById(R.id.budgetProgressBar)
        budgetWarningText = view.findViewById(R.id.budgetWarningText)

        loadSavedBudget()

        saveBudgetButton.setOnClickListener {
            saveBudget()
        }

        updateBudgetProgress()
    }

    private fun loadSavedBudget() {
        val sharedPrefs = requireContext().getSharedPreferences("BudgetPrefs", 0)
        val savedBudget = sharedPrefs.getFloat("monthly_budget", 0f)
        if (savedBudget > 0) {
            budgetAmountInput.setText(savedBudget.toString())
        }
    }

    private fun saveBudget() {
        val budgetAmount = budgetAmountInput.text.toString().toFloatOrNull() ?: 0f
        val sharedPrefs = requireContext().getSharedPreferences("BudgetPrefs", 0)
        sharedPrefs.edit().putFloat("monthly_budget", budgetAmount).apply()

        // ✅ Hide keyboard
        hideKeyboard()

        // ✅ Clear input field
        budgetAmountInput.text?.clear()

        // ✅ Optional: Show confirmation
        Toast.makeText(requireContext(), "Budget saved successfully!", Toast.LENGTH_SHORT).show()

        updateBudgetProgress()
    }

    private fun hideKeyboard() {
        val inputMethodManager = requireContext().getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        val currentFocusView = requireActivity().currentFocus ?: View(requireContext())
        inputMethodManager.hideSoftInputFromWindow(currentFocusView.windowToken, 0)
    }

    private fun getCurrencyFormatter(): NumberFormat {
        val selectedCurrency = DataManager.getSelectedCurrency(requireContext())
        return NumberFormat.getCurrencyInstance().apply {
            currency = Currency.getInstance(selectedCurrency.code)
        }
    }

    private fun updateBudgetProgress() {
        val sharedPrefs = requireContext().getSharedPreferences("BudgetPrefs", 0)
        val monthlyBudget = sharedPrefs.getFloat("monthly_budget", 0f)
        val totalExpenses = calculateMonthlyExpenses()
        val remainingAmount = monthlyBudget - totalExpenses
        val currencyFormatter = getCurrencyFormatter()

        budgetProgressText.text = "Monthly Budget: ${currencyFormatter.format(monthlyBudget)}"
        spentAmountText.text = "Spent: ${currencyFormatter.format(totalExpenses)}"
        remainingAmountText.text = "Remaining: ${currencyFormatter.format(remainingAmount)}"

        if (monthlyBudget > 0) {
            val progress = (totalExpenses / monthlyBudget * 100).toInt()
            budgetProgressBar.progress = progress.coerceIn(0, 100)

            when {
                progress >= 100 -> {
                    budgetWarningText.text = "Warning: You have exceeded your monthly budget!"
                    budgetWarningText.visibility = View.VISIBLE
                }
                progress >= 80 -> {
                    budgetWarningText.text = "Warning: You are close to exceeding your monthly budget!"
                    budgetWarningText.visibility = View.VISIBLE
                }
                else -> {
                    budgetWarningText.visibility = View.GONE
                }
            }
        }
    }

    private fun calculateMonthlyExpenses(): Float {
        val transactions = DataManager.loadTransactions(requireContext())
        val currentMonth = LocalDate.now().monthValue
        val currentYear = LocalDate.now().year

        return transactions
            .filter { it.isExpense }
            .filter {
                try {
                    val transactionDate = LocalDate.parse(it.date, dateFormatter)
                    transactionDate.monthValue == currentMonth && transactionDate.year == currentYear
                } catch (e: Exception) {
                    false
                }
            }
            .sumOf { it.amount }
            .toFloat()
    }

    companion object {
        fun newInstance() = BudgetFragment()
    }
}
