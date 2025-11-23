# 🎮 SEMESTRAL BREAKDOWN – Java Console Game

---

## 🏷️ 1. Project Title  
**College Life Survival: A 30-Day Student Simulation Game**

---

## 📘 2. Description / Overview  
This project is a Java-based **console simulation game** where the player takes the role of a college student trying to survive a 30-day semester. The player must manage four key stats—**Money, Energy, Stress, and Grade**—while performing daily actions and handling random events.  
Your goal is to finish the semester with **Grade ≥ 75%** while preventing burnout, bankruptcy, or excessive stress.

---

## 🧩 3. OOP Concepts Applied

### **🔒 a. Encapsulation**
- Player stats (money, energy, stress, grade) are **private**.
- Managed through getters, setters, and modifier methods.
- Protects data integrity throughout the game.

### **🌳 b. Inheritance**
- All events inherit from the abstract class **Event**.
- Examples: `ExamWeekEvent`, `PowerOutageEvent`, `AllowanceDelayEvent`, etc.
- Allows shared structure with unique effects.

### **🎭 c. Polymorphism**
- Game uses an `Event[]` to trigger random events.
- Each event overrides `apply(Player player)` to create different behaviors.
- Enables flexibility and easy expansion.

### **🧠 d. Abstraction**
- The `Event` abstract class defines the skeleton for all events.
- Game interacts with events without knowing their internal logic.

---

## 🧱 4. Program Structure

### **📍 Main Classes Overview**

#### **🎮 Game**
- Controls game flow and day progression.
- Manages actions, stat changes, events, and end conditions.

#### **🧍 Player**
- Holds the player's stats.
- Methods manage stat increases/decreases.
- Enforces weekly action limits.

#### **⚡ Event (Abstract)**
- Template for all random events.
- Subclasses implement unique effects.

#### **🌦️ Event Subclasses**
- `ExamWeekEvent`  
- `PowerOutageEvent`  
- `AllowanceDelayEvent`  
- `RainyDayEvent`  
- `GoodDayEvent`  

---

### **🗂️ Diagram**

---

## 🚀 5. How to Run the Program

---

## 🖥️ 6. Sample Output

---

## 🧑‍💻 7. Author and Acknowledgements

---

## 📚 8. Other Sections

### **a. Future Enhancements**
### **b. References**

---
