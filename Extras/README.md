# El despertar del héroe: Turno de noche

Juego de combate por turnos para la consola, hecho en Java.

Eres **el cajero de una tienda** en pleno turno de noche. Entran tres asaltantes, uno detrás de otro, y tienes que defenderte con lo que tienes a mano en la caja: un rollo de tickets, el escáner de códigos o la grapadora. ¿Aguantarás hasta el final del turno?

---

## Índice

- [Cómo se juega](#cómo-se-juega)
- [Cómo ejecutarlo](#cómo-ejecutarlo)
- [Estructura del proyecto](#estructura-del-proyecto)
- [Cómo funciona por dentro](#cómo-funciona-por-dentro)
- [Autora] (#Autora)


## Cómo se juega

Al abrir el juego aparece un menú con cuatro opciones:

```
1. Nueva partida
2. Consultar ranking
3. Ayuda
4. Salir
```

Al empezar una partida escribes tu nombre y te enfrentas a tres asaltantes, cada uno más fuerte que el anterior:

| Nivel | Enemigo | Vida |
|---|---|---|
| 1 | Novato | 40 |
| 2 | Profesional | 60 |
| 3 | Experto | 80 |

**Tu personaje (el cajero)**

- Empieza con **100 de vida**.
- Tiene **3 bebidas energéticas** en el inventario. Cada una cura **25 de vida**.
- Cada ataque quita entre **10 y 20** de vida al enemigo.

Los asaltantes te lanzan productos de la tienda (cajas de cereales, detergente, melones…) y te quitan entre **5 y 15** de vida por ataque.

**En cada turno puedes elegir:**

| Opción | Acción | ¿Gasta el turno? |
|---|---|---|
| 1 | Atacar | Sí, y el enemigo responde |
| 2 | Beber una energética | Sí, y el enemigo responde (no puedes beber con la vida al máximo ni sin bebidas) |
| 3 | Ver el inventario | No |
| 4 | Abandonar la partida | Termina la partida |

**Puntuación**

- **100 puntos** por cada enemigo derrotado.
- Si vences a los tres, se suma **la vida que te quede**.
- Ejemplo: ganas con 22 de vida → 300 + 22 = **322 puntos**.

La partida termina al vencer al tercer enemigo, al quedarte sin vida o al abandonar. En todos los casos tu puntuación se guarda en el ranking.

---

## Cómo ejecutarlo

1. Descarga el proyecto:

   ```
   git clone [enlace-al-repositorio]
   cd [nombre-de-la-carpeta]
   ```

2. Compila todos los archivos (desde la carpeta raíz del proyecto):

   ```
   javac -encoding UTF-8 -d bin *.java personajes/*.java personajes/NivelesEnemigo/*.java
   ```

3. Ejecuta el juego:

   ```
   java -cp bin Main
   ```

**Desde Visual Studio Code:** abre `Main.java` y pulsa **Run**.

---

## Estructura del proyecto

```
├── Main.java               → Arranca el juego y muestra el menú
├── Metodos.java            → La lógica del juego: menú, combates, puntuación y ranking
├── CrearXML.java           → Crea el fichero del ranking la primera vez
├── LeerXML.java            → Lee el ranking al abrir el juego
├── ranking.xml             → Aquí se guardan las puntuaciones
└── personajes/
    ├── Juego.java          → Todas las constantes del juego (vidas, daños, nombres…)
    ├── Personaje.java      → Lo que tienen en común todos los personajes
    ├── Cajero.java         → El jugador y su inventario de bebidas
    ├── Asaltante.java      → El enemigo genérico
    └── NivelesEnemigo/
        ├── Novato.java
        ├── Profesional.java
        ├── Experto.java
        ├── IVida.java      ┐
        ├── IAtaque.java    ├ Interfaces que deben cumplir los enemigos
        └── IObjeto.java    ┘
---

## Cómo funciona por dentro

**Los personajes.** Todos parten de la clase `Personaje`, que guarda el nombre, la vida y el daño, y sabe atacar, recibir daño y curarse. El `Cajero` y el `Asaltante` heredan de ella, y los tres enemigos heredan de `Asaltante`:

```
Personaje
├── Cajero
└── Asaltante
    ├── Novato
    ├── Profesional
    └── Experto
```

**Las constantes.** Todos los números del juego (vida máxima, daño, número de bebidas…) están en `Juego.java`. Si quieres cambiar algo, por ejemplo que el cajero haga más daño, solo tienes que tocarlo ahí.

**Una partida, paso a paso:**

1. Se crea un cajero nuevo, con la vida y las bebidas al máximo.
2. Para cada nivel (1, 2 y 3) se crea su enemigo y empieza un combate.
3. El combate se repite turno a turno hasta que alguien gana o el jugador abandona.
4. Al terminar, se calculan los puntos y se guardan en el ranking.


---

## Autora

** [Haninti] **

