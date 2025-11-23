# 🎮 SEMESTRAL BREAKDOWN – Java Console Game

A 30-day **college survival simulation** game written in Java.  
Manage your **money, energy, stress, and grades** while dealing with **random events, weekly limits, and strategic choices**.  
Your goal? **Finish the 30-day semester with a passing grade (≥75%)**—without going bankrupt, collapsing, or having a mental breakdown.

---

## 📌 Overview

This game simulates what it's like to survive a semester as a college student.  
Each day, the player chooses an action while reacting to random life events.  
Balancing your stats is the key to success:

- 💵 Money  
- ⚡ Energy  
- 😵 Stress  
- 📚 Grade

You start with:

- **$300**  
- **100 Energy**  
- **0 Stress**  
- **70% Grade** *(below passing—so you must improve!)*

Survive all **30 days** and finish with a **grade ≥ 75%** to pass.

---

## 🎲 Daily Actions

You can choose **one action per day**, each with consequences:

| Action | Effect |
|-------|--------|
| **Study** | +2% grade, +12 stress, -12 energy, -$50 |
| **Work** | +$200, +15 stress, -1% grade, -15 energy |
| **Rest** | +15 energy, -5 stress, +$30 |
| **Hang Out** | -$80, -5 energy, -10 stress |

### Weekly Limits
Your character gets tired of routines, so each week you can only:

- 📖 Study **4×**
- 💼 Work **3×**
- 🛏️ Rest **5×**
- 🎉 Hang Out **3×**

Counters reset every 7 days.

---

## ⚡ Random Events

Random events occur with increasing chance as the semester progresses:

Examples include:

- **Exam Week Event**  
- **Allowance Delay**  
- **Power Outage**  
- **Rainy Day**  
- **Good Day Boost**

Events can raise or lower your stats, forcing you to adapt.

---

## 🧠 Game Mechanics & Effects

### Stress Effects
High stress gradually drains your stats:

- **≥ 90:** Energy -6 daily, Grade -1  
- **≥ 75:** Energy -3  
- **≥ 60:** Energy -1  

### Energy Effects

- **> 85:** Stress naturally decreases  
- **< 25:** Warning  
- **< 15:** Grade -1  

### Grade Cap

Your grade cannot exceed **95%**.

---

## 💀 Game Over Conditions

You lose **instantly** if any of the following happen:

- **Energy ≤ 0** → Collapse  
- **Money ≤ 0** → Bankruptcy  
- **Stress ≥ 100** → Mental breakdown  

At the **end of 30 days**, you also lose if:

- **Grade < 75%**

---

## 🏆 Final Score

Your total score is calculated using:

- Money  
- Energy  
- Stress (lower = better)  
- Grade  

Feedback levels:

- ⭐ **Outstanding**
- 👍 Great Job
- 🙂 Good Effort
- ❌ Try Again

---
