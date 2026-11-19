# Consultas XPath sobre el ranking

`ranking.xml` 
 `xmllint --xpath "EXPRESIÓN" ranking.xml` 

Datos del archivo, en orden: Lucía 387 · Javier 319 · Marcos 319 · Hani 200 · Sofía 200 · Pablo 100 · Elena 0.

---

## Consulta 1. Selección de campos

- **Pregunta:** ¿Qué jugadores aparecen en el ranking?
- **Expresión:** `/ranking/numero/nombre`
- **Resultado esperado:** los 7 nombres en el orden del documento.
- **Resultado obtenido:** Lucía, Javier, Marcos, Hani, Sofía, Pablo, Elena. ✔ Coincide.

## Consulta 2. Filtro por puntuación

- **Pregunta:** ¿Qué jugadores han ganado la aventura? Para pasar de 300 puntos hay que derrotar a los tres enemigos y sumar la vida restante.
- **Expresión:** `/ranking/numero[puntuacion > 300]/nombre`
- **Resultado esperado:** Lucía, Javier y Marcos.
- **Resultado obtenido:** Lucía, Javier, Marcos. ✔ Coincide.

## Consulta 3. Filtro por jugador

- **Pregunta:** ¿Cuántos puntos tiene Hani?
- **Expresión:** `/ranking/numero[nombre='Hani']/puntuacion`
- **Resultado esperado:** 200.
- **Resultado obtenido:** 200. ✔ Coincide.

## Consulta 4. Dos condiciones en un mismo predicado

- **Pregunta:** ¿Qué jugadores derrotaron al menos a un enemigo pero no ganaron la aventura?
- **Expresión:** `/ranking/numero[puntuacion >= 100 and puntuacion < 300]/nombre`
- **Resultado esperado:** Hani, Sofía y Pablo. Quedan fuera Elena (0) y los que superan 300.
- **Resultado obtenido:** Hani, Sofía, Pablo. ✔ Coincide.

## Consulta 5. Función de recuento

- **Pregunta:** ¿Cuántos registros tiene el ranking? Sirve para comprobar que no se pasa de 10.
- **Expresión:** `count(/ranking/numero)`
- **Resultado obtenido:** 7. ✔ Coincide.

*Variante de agregación:* `sum(/ranking/numero/puntuacion)` → esperado 1525 (387+319+319+200+200+100+0), obtenido 1525. ✔