# 💰 ExpenseTracker - Personal Finance Management App


![Kotlin](https://img.shields.io/badge/kotlin-%230095D5.svg?style=for-the-badge&logo=kotlin&logoColor=white)




A  personal finance management Android application built with Kotlin that helps users track their income, expenses, manage budgets, and gain insights into their spending habits through beautiful visualizations.

## ✨ Features

### 🏠 **Dashboard & Overview**
- **Real-time Balance Tracking** - View your current financial status at a glance
- **Transaction Filtering** - Filter transactions by All, Income, or Expense categories
- **Balance Visibility Toggle** - Hide/show your balance for privacy
- **Quick Transaction Access** - Add new transactions with a floating action button

### 💳 **Transaction Management**
- **Add/Edit Transactions** - Create and modify income and expense entries
- **Smart Categorization** - Pre-defined categories for both income and expenses
- **Transaction Details** - Include title, amount, date, category, and notes
- **Transaction History** - View all your financial activities in chronological order
- **Delete Transactions** - Remove unwanted entries with confirmation

### 📊 **Analytics & Statistics**
- **Interactive Pie Charts** - Visual representation of spending patterns using MPAndroidChart
- **Category-wise Analysis** - Separate charts for income and expense categories
- **Comprehensive Overview** - All transactions combined in one chart
- **Real-time Updates** - Charts automatically update with new transactions

### 💰 **Budget Management**
- **Monthly Budget Setting** - Set and track your monthly spending limits
- **Progress Tracking** - Visual progress bar showing budget utilization
- **Smart Warnings** - Alerts when approaching or exceeding budget limits
- **Remaining Balance** - See how much you have left to spend

### 🌍 **Multi-Currency Support**
- **10+ Currencies** - Support for USD, EUR, GBP, JPY, LKR, INR, CNY, AUD, CAD, CHF
- **Dynamic Currency Switching** - Change currency settings on the fly
- **Consistent Formatting** - All amounts display in selected currency format

### 🔐 **User Authentication**
- **Secure Login/Registration** - Simple authentication system
- **Session Management** - Stay logged in across app sessions
- **Data Privacy** - User-specific data storage

### 📱 **User Experience**
- **Onboarding Flow** - Welcome screens introducing app features
- **Material Design** - Modern, intuitive UI following Google's design guidelines
- **Bottom Navigation** - Easy access to all major features
- **Responsive Layout** - Optimized for different screen sizes

### 💾 **Data Management**
- **Local Storage** - Secure data storage using SharedPreferences and JSON
- **Backup & Restore** - Export and import your financial data
- **Data Persistence** - Your data is saved locally and persists between sessions

## 🛠️ Technical Stack

- **Language**: Kotlin
- **Platform**: Android (API 26+)
- **UI Framework**: Material Design Components
- **Charts**: MPAndroidChart v3.1.0
- **Data Storage**: SharedPreferences + JSON (Gson)
- **Architecture**: Activity-based with Fragments
- **Build System**: Gradle

## 🚀 Getting Started

### Prerequisites
- Android Studio Arctic Fox or later
- Android SDK 26 or higher
- Kotlin 1.8+

### Installation

1. **Clone the repository**
   ```bash
   git clone https://github.com/yourusername/moneymaster.git
   cd moneymaster
   ```

2. **Open in Android Studio**
   - Launch Android Studio
   - Select "Open an existing project"
   - Navigate to the cloned directory and select it

3. **Build and Run**
   - Connect an Android device or start an emulator
   - Click the "Run" button or use `Ctrl+R`



## 📁 Project Structure

```
app/src/main/java/com/example/moneymaster/
├── adapter/
│   └── TransactionAdapter.kt          # RecyclerView adapter for transactions
├── auth/
│   ├── AuthManager.kt                 # Authentication logic
│   ├── LoginActivity.kt              # Login screen
│   └── SignupActivity.kt             # Registration screen
├── model/
│   ├── Currency.kt                   # Currency enum and utilities
│   └── Transaction.kt                # Transaction data model
├── onboarding/
│   ├── OnboardingActivity.kt         # Welcome screens
│   └── OnboardingFragment.kt         # Individual onboarding pages
├── utils/
│   ├── BackupUtils.kt                # Data backup/restore functionality
│   ├── CategoryUtils.kt              # Predefined categories
│   └── DataManager.kt                # Data persistence layer
├── AddEditTransactionActivity.kt     # Add new transactions
├── BudgetFragment.kt                 # Budget management
├── EditTransactionActivity.kt        # Edit existing transactions
├── MainActivity.kt                   # Main dashboard
├── SettingsFragment.kt               # App settings
├── SplashActivity.kt                 # App launch screen
└── StatisticsFragment.kt             # Analytics and charts
```

## 🎯 Key Features Deep Dive

### Transaction Management
- **Smart Categories**: Pre-defined categories for both income and expenses
- **Date Picker**: Easy date selection with calendar integration
- **Amount Validation**: Input validation for proper number formatting
- **Notes Support**: Additional details for each transaction

### Budget System
- **Monthly Tracking**: Track spending against monthly budget
- **Progress Visualization**: Linear progress bar with percentage
- **Warning System**: Alerts at 80% and 100% budget usage
- **Real-time Updates**: Budget status updates with each transaction

### Analytics Engine
- **Pie Chart Visualization**: Three different chart views
- **Category Breakdown**: See where your money goes
- **Percentage Display**: Understand spending distribution
- **Interactive Charts**: Tap for detailed information

### Data Security
- **Local Storage**: All data stored securely on device
- **JSON Serialization**: Efficient data storage and retrieval
- **Backup System**: Export/import functionality for data portability

## 🔧 Configuration

### Supported Currencies
- USD ($) - US Dollar
- EUR (€) - Euro
- GBP (£) - British Pound
- JPY (¥) - Japanese Yen
- LKR (Rs) - Sri Lankan Rupee
- INR (₹) - Indian Rupee
- CNY (¥) - Chinese Yuan
- AUD (A$) - Australian Dollar
- CAD (C$) - Canadian Dollar
- CHF (Fr) - Swiss Franc

### Transaction Categories

**Expense Categories:**
- Food & Dining
- Shopping
- Transportation
- Housing
- Utilities
- Entertainment
- Health & Medical
- Education
- Personal Care
- Travel
- Gifts & Donations
- Other

**Income Categories:**
- Salary
- Business
- Investments
- Freelance
- Rental
- Gifts
- Other

## 🚀 Future Enhancements

- [ ] **Cloud Sync** - Backup data to cloud services
- [ ] **Export Reports** - PDF/Excel export functionality
- [ ] **Recurring Transactions** - Set up automatic recurring entries
- [ ] **Goal Setting** - Financial goals and tracking
- [ ] **Dark Theme** - Dark mode support
- [ ] **Widgets** - Home screen widgets for quick access
- [ ] **Data Visualization** - More chart types and insights
- [ ] **Multi-language Support** - Internationalization

## 🤝 Contributing

We welcome contributions! Please feel free to submit a Pull Request. For major changes, please open an issue first to discuss what you would like to change.

### Development Setup
1. Fork the repository
2. Create a feature branch (`git checkout -b feature/AmazingFeature`)
3. Commit your changes (`git commit -m 'Add some AmazingFeature'`)
4. Push to the branch (`git push origin feature/AmazingFeature`)
5. Open a Pull Request

---

**Made with ❤️ for better Experience**
