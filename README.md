# 🎮 SEMESTRAL BREAKDOWN – Java Console Game

## 1. Project Title
**College Life Survival: A 30-Day Student Simulation Game**

---

## 2. Description / Overview  
This project is a Java-based **console simulation game** where the player takes the role of a college student trying to survive a 30-day semester. The player must manage four key stats—**Money, Energy, Stress, and Grade**—while dealing with daily actions and random events.  
The main challenge is to finish the semester with **Grade ≥ 75%**, while avoiding burnout, bankruptcy, or mental breakdown. The game demonstrates decision-making, resource management, and stat-balancing mechanics, packaged in an object-oriented design.

---

## 3. OOP Concepts Applied

### **a. Encapsulation**
- Player attributes (money, energy, stress, grade) are stored as **private fields**.
- Access and modification are handled through **getter, setter, and modifier methods**.
- This prevents direct manipulation from other classes, ensuring data safety.

### **b. Inheritance**
- All random events inherit from a base abstract class **Event**.
- Example subclasses: `ExamWeekEvent`, `AllowanceDelayEvent`, `PowerOutageEvent`, `GoodDayEvent`, etc.
- This allows events to share common behavior while having unique effects.

### **c. Polymorphism**
- The game stores events in an `Event[]` array and triggers them randomly.
- Each event overrides the `apply(Player player)` method, allowing **different behavior** depending on the event type.
- This makes the program flexible and extendable.

### **d. Abstraction**
- The abstract class `Event` defines the structure of all event types.
- The player interacts with events through a **general interface**, without knowing their internal details.
- Complex internal logic (event effects, stat changes) is hidden.

---

## 4. Program Structure

### **Main Classes**

#### **`Game`**
- Controls the main game loop.
- Handles daily actions, random events, weekly limits, stat clamping, and game-over conditions.
- Manages progression across 30 days.

#### **`Player`**
- Stores and manages the player’s stats.
- Contains methods to modify attributes (energy, stress, grade, money).
- Implements weekly limits for study, work, rest, and hangout actions.

#### **`Event` (Abstract Class)**
- Base structure for all random events.
- Subclasses override the `apply()` method to add specific effects.

#### **Event Subclasses (Examples)**
- `ExamWeekEvent`
- `AllowanceDelayEvent`
- `PowerOutageEvent`
- `RainyDayEvent`
- `GoodDayEvent`

Each subclass modifies player stats differently.

---

### **Class Relationship Diagram **

