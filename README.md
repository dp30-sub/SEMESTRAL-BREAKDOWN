
---

<p align="center">

![Java](https://img.shields.io/badge/Java-17-red?style=for-the-badge&logo=java)
![Console](https://img.shields.io/badge/Console%20Game-000000?style=for-the-badge&logo=gnu-bash)
![Status](https://img.shields.io/badge/Status-Completed-brightgreen?style=for-the-badge)
![License](https://img.shields.io/badge/License-Free-blue?style=for-the-badge)

</p>

---

## 📌 Overview

**College Life Survival** is a 30-day **strategy simulation game** written in Java.  
You take on the role of a student managing:

- 💵 Money  
- ⚡ Energy  
- 😵 Stress  
- 📚 Grade  

Your mission: **Survive 30 days WITHOUT collapsing, going bankrupt, or failing academically.**

The semester starts with:

- **$300**
- **100 Energy**
- **0 Stress**
- **70% Grade** *(below passing — pressure is ON)*

Your final goal is to end with **≥ 75% Grade** while keeping all stats above critical levels.

---

## 🎲 Gameplay Mechanics

### ✨ Daily Actions (Choose 1 per day)

| Action | Effect |
|-------|--------|
| **Study** | +2% grade, +12 stress, -12 energy, -$50 |
| **Work** | +$200, +15 stress, -1% grade, -15 energy |
| **Rest** | +15 energy, -5 stress, +$30 |
| **Hang Out** | -$80, -5 energy, -10 stress |

### 🔁 Weekly Limits  
Reset every 7 days:

- 📖 Study: **4×**
- 💼 Work: **3×**
- 🛏️ Rest: **5×**
- 🎉 Hang Out: **3×**

---

## ⚡ Random Events

Your days will be influenced by unpredictable events such as:

- **Exam Week Pressure**
- **Allowance Delay**
- **Power Outage**
- **Rainy Day Mood Drop**
- **Good Day Boost**

Chance of events increases as the semester progresses.

---

## 🧠 Stat Effects & Balancing

### Stress Impact  
- **≥ 90:** Energy -6/day, Grade -1  
- **≥ 75:** Energy -3/day  
- **≥ 60:** Energy -1/day  

### Energy Impact  
- **> 85:** Stress -3 (naturally)  
- **< 25:** Warning  
- **< 15:** Grade -1/day  

### Grade Cap  
📌 Maximum: **95%**

---

## 💀 Game Over Conditions

You instantly lose if:

- ⚡ **Energy ≤ 0** → Collapse  
- 💵 **Money ≤ 0** → Bankrupt  
- 😵 **Stress ≥ 100** → Mental Breakdown  

End-semester failure if:  
📚 **Grade < 75%**

---

## 🏆 Final Score Calculation

Score is based on:

- Money  
- Energy  
- Stress (lower = better)  
- Grade  

Outcome categories:

- 🌟 **Outstanding**
- 👍 Great Job
- 🙂 Good Effort
- ❌ Try Again

---
