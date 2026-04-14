# 📝 Quiz Management System

A terminal-based **Quiz Management System** built in Java that allows admins to create and manage quizzes, and students to take them — all from a colorful, interactive command-line interface.

---

## ✨ Features

### 👤 User Management
- **Register** a new account with a username, password, and role
- **Login** with role-based access (Admin or Student)
- Persistent user data stored via file-based database

### 🛠️ Admin Panel
- **Create Quizzes** — define a quiz ID, title, and add multiple-choice questions (4 options each)
- **View Quizzes** — list all available quizzes with their IDs and titles
- **Logout**

### 🎓 Student Panel
- **View Quizzes** — browse all available quizzes
- **Take a Quiz** — answer questions interactively and receive a score
- **Logout**

---

## 🗂️ Project Structure

```
Quiz-Management-System/
│
├── Main.java           # Entry point; handles menus and navigation
├── User.java           # User model (username, password, role)
├── UserManager.java    # Register and login logic
├── Quiz.java           # Quiz model (ID, title, questions)
├── Question.java       # Question model (text, options, correct answer)
├── QuizManager.java    # Quiz creation, retrieval, and quiz-taking logic
├── FileDatabase.java   # File I/O for persisting users and quizzes
└── Design.java         # Terminal styling (colors, spacing, screen utilities)
```

---

## 🚀 Getting Started

### Prerequisites
- **Java JDK 8** or higher
- A terminal that supports **ANSI escape codes** (Linux/macOS Terminal, Windows Terminal)

### Compile

```bash
javac *.java
```

### Run

```bash
java Main
```

---

## 🖥️ Usage

### 1. Register an Account
- Choose **Registration** from the main menu
- Enter a username, password, and role (`admin` or `student`)

### 2. Login
- Choose **Login** and enter your credentials
- You will be directed to either the **Admin Panel** or **Student Panel** based on your role

### 3. Admin: Create a Quiz
- Select **Create Quiz** from the Admin Panel
- Enter a unique Quiz ID and a title
- Add questions one by one — each with 4 options and a correct answer (1–4)
- Type `done` when finished adding questions

### 4. Student: Take a Quiz
- Select **Take Quiz** from the Student Panel
- Enter the Quiz ID you want to attempt
- Answer each question by entering the option number (1–4)
- Your score is displayed at the end

---

## 💾 Data Persistence

User and quiz data are saved to local files via `FileDatabase`, so all quizzes and accounts persist between sessions.

---

## 🎨 Terminal UI

The app uses the `Design` utility class for a styled CLI experience, featuring:
- Color-coded prompts and messages (ANSI colors)
- Dynamic centering based on terminal width/height
- Screen clearing and animated transitions
- A custom Java ASCII art logo on launch

---

## 🙋‍♂️ Author

**Nayeem Ahammed**  
[GitHub](https://github.com/Nayeem-Ahammed)

---

## 📄 License

This project is open source and available under the [MIT License](LICENSE).
