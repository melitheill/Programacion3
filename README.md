# 🏭 Trabajo Práctico Especial – Programación 3 – UNICEN (2025)

Este proyecto implementa una solución para el problema de secuenciación de máquinas en una fábrica de autopartes,
utilizando dos enfoques clásicos de algoritmos: **Backtracking** y **Greedy**.

---

## 👥 Integrantes
- **Santiago Gonzales** – [sagonzalez@alumnos.exa.unicen.edu.ar](mailto:sagonzalez@alumnos.exa.unicen.edu.ar)
- **Melina Theill Cabral** – [mtheill@alumnos.exa.unicen.edu.ar](mailto:mtheill@alumnos.exa.unicen.edu.ar)  
---

## 🧠 Algoritmos implementados

### 🔁 Backtracking

- Explora todas las combinaciones posibles para alcanzar la cantidad total de piezas.
- Usa poda cuando:
  - La suma supera el objetivo.
  - Ya existe una solución mejor.
- Devuelve la solución óptima y la cantidad de estados generados.

### ⚡ Greedy

- Selecciona la máquina más grande que no exceda el número restante de piezas.
- No garantiza óptimo pero es eficiente.
- Informa la cantidad de candidatos considerados.
