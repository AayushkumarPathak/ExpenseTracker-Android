# Contributing to MoneyMaster

Thank you for your interest in contributing to MoneyMaster! This document provides guidelines and information for contributors.

## Table of Contents

- [Code of Conduct](#code-of-conduct)
- [Getting Started](#getting-started)
- [Development Setup](#development-setup)
- [How to Contribute](#how-to-contribute)
- [Pull Request Process](#pull-request-process)
- [Coding Standards](#coding-standards)
- [Testing](#testing)
- [Reporting Issues](#reporting-issues)
- [Feature Requests](#feature-requests)

## Code of Conduct

This project and everyone participating in it is governed by our [Code of Conduct](CODE_OF_CONDUCT.md). By participating, you are expected to uphold this code. Please report unacceptable behavior to [INSERT CONTACT EMAIL].

## Getting Started

### Prerequisites

Before you begin, ensure you have the following installed:

- **Android Studio**: Arctic Fox or later
- **Android SDK**: API 26 or higher
- **Kotlin**: Version 1.8+
- **Git**: For version control
- **Java**: JDK 8 or higher

### Development Setup

1. **Fork the Repository**
   ```bash
   # Fork the repository on GitHub, then clone your fork
   git clone https://github.com/YOUR_USERNAME/MoneyMaster-Personal-Finance-Management-Android-App_.git
   cd MoneyMaster-Personal-Finance-Management-Android-App_
   ```

2. **Add Upstream Remote**
   ```bash
   git remote add upstream https://github.com/ORIGINAL_OWNER/MoneyMaster-Personal-Finance-Management-Android-App_.git
   ```

3. **Open in Android Studio**
   - Launch Android Studio
   - Select "Open an existing project"
   - Navigate to the cloned directory and select it
   - Wait for Gradle sync to complete

4. **Build the Project**
   - Click "Build" → "Make Project" or use `Ctrl+F9`
   - Ensure the build completes without errors

## How to Contribute

### Types of Contributions

We welcome several types of contributions:

- **Bug Fixes**: Fix existing issues
- **Feature Development**: Implement new features
- **Documentation**: Improve or add documentation
- **UI/UX Improvements**: Enhance user interface and experience
- **Performance Optimizations**: Improve app performance
- **Testing**: Add or improve test coverage

### Contribution Workflow

1. **Check Existing Issues**
   - Look for existing issues that match what you want to work on
   - Comment on the issue to express your interest
   - Wait for maintainer approval before starting work

2. **Create a Branch**
   ```bash
   git checkout -b feature/your-feature-name
   # or
   git checkout -b bugfix/issue-number-description
   ```

3. **Make Your Changes**
   - Write clean, readable code
   - Follow the coding standards
   - Add tests if applicable
   - Update documentation as needed

4. **Test Your Changes**
   - Test on different Android versions
   - Test on different screen sizes
   - Ensure no regressions

5. **Commit Your Changes**
   ```bash
   git add .
   git commit -m "Add: Brief description of changes"
   ```

6. **Push and Create Pull Request**
   ```bash
   git push origin feature/your-feature-name
   ```

## Pull Request Process

### Before Submitting

- [ ] Code follows the project's coding standards
- [ ] Self-review of your code has been performed
- [ ] Code has been tested on multiple devices/emulators
- [ ] Documentation has been updated if necessary
- [ ] No new warnings or errors are introduced

### Pull Request Template

When creating a pull request, please include:

1. **Description**: Clear description of what the PR does
2. **Type**: Bug fix, feature, documentation, etc.
3. **Testing**: How you tested the changes
4. **Screenshots**: If UI changes are involved
5. **Related Issues**: Link to any related issues

### Review Process

1. **Automated Checks**: CI/CD pipeline will run tests
2. **Code Review**: Maintainers will review your code
3. **Feedback**: Address any feedback or requested changes
4. **Approval**: Once approved, your PR will be merged

## Coding Standards

### Kotlin Style Guide

- Follow [Kotlin Coding Conventions](https://kotlinlang.org/docs/coding-conventions.html)
- Use meaningful variable and function names
- Add comments for complex logic
- Keep functions small and focused

### Code Formatting

- Use 4 spaces for indentation
- Maximum line length: 120 characters
- Use trailing commas in multi-line collections
- Prefer `val` over `var` when possible

### Example Code Style

```kotlin
class TransactionManager {
    private val dataManager: DataManager
    
    constructor(dataManager: DataManager) {
        this.dataManager = dataManager
    }
    
    fun addTransaction(transaction: Transaction): Boolean {
        return try {
            dataManager.saveTransaction(transaction)
            true
        } catch (e: Exception) {
            Log.e("TransactionManager", "Failed to add transaction", e)
            false
        }
    }
}
```

### File Organization

- Keep related classes in the same package
- Use meaningful package names
- Separate UI, business logic, and data layers
- Follow the existing project structure

## Testing

### Unit Testing

- Write unit tests for business logic
- Use JUnit 4 for testing framework
- Aim for high test coverage on critical paths

### UI Testing

- Test user interactions and flows
- Use Espresso for UI testing
- Test on different screen sizes and orientations

### Manual Testing

- Test on physical devices when possible
- Test on different Android versions
- Verify accessibility features work correctly

## Reporting Issues

### Bug Reports

When reporting bugs, please include:

1. **Environment**:
   - Android version
   - Device model
   - App version

2. **Steps to Reproduce**:
   - Clear, numbered steps
   - Expected vs actual behavior

3. **Additional Context**:
   - Screenshots or screen recordings
   - Logcat output (if relevant)
   - Any workarounds you've found

### Issue Template

```markdown
**Describe the bug**
A clear and concise description of what the bug is.

**To Reproduce**
Steps to reproduce the behavior:
1. Go to '...'
2. Click on '....'
3. Scroll down to '....'
4. See error

**Expected behavior**
A clear and concise description of what you expected to happen.

**Screenshots**
If applicable, add screenshots to help explain your problem.

**Environment:**
 - Android Version: [e.g. 11]
 - Device: [e.g. Pixel 5]
 - App Version: [e.g. 1.0.0]

**Additional context**
Add any other context about the problem here.
```

## Feature Requests

### Before Requesting

- Check if the feature already exists
- Search existing issues for similar requests
- Consider if it aligns with the project's goals

### Feature Request Template

```markdown
**Is your feature request related to a problem? Please describe.**
A clear and concise description of what the problem is.

**Describe the solution you'd like**
A clear and concise description of what you want to happen.

**Describe alternatives you've considered**
A clear and concise description of any alternative solutions or features you've considered.

**Additional context**
Add any other context or screenshots about the feature request here.
```

## Development Guidelines

### Architecture

- Follow MVVM pattern where applicable
- Keep activities and fragments lightweight
- Use dependency injection for better testability
- Separate concerns between UI, business logic, and data

### Performance

- Optimize for smooth scrolling and animations
- Use lazy loading for large datasets
- Implement proper memory management
- Avoid memory leaks in activities and fragments

### Security

- Never commit sensitive data (API keys, passwords)
- Use secure storage for user data
- Validate all user inputs
- Follow Android security best practices

## Getting Help

- **Documentation**: Check the README and code comments
- **Issues**: Search existing issues for similar problems
- **Discussions**: Use GitHub Discussions for questions
- **Contact**: Reach out to maintainers for urgent issues

## Recognition

Contributors will be recognized in:
- README.md contributors section
- Release notes for significant contributions
- GitHub contributor statistics

Thank you for contributing to MoneyMaster! 🚀
