# El despertar del héroe: Turno de noche

Juego de combate por turnos para la consola, hecho en Java.

Eres **el cajero de una tienda** en pleno turno de noche. Entran tres asaltantes, uno detrás de otro, y tienes que defenderte con lo que tienes a mano en la caja: un rollo de tickets, el escáner de códigos o la grapadora. ¿Aguantarás hasta el final del turno?

---

## Índice

- [Cómo se juega](#cómo-se-juega)
- [Cómo ejecutarlo](#cómo-ejecutarlo)
- [Estructura del proyecto](#estructura-del-proyecto)
- [Cómo funciona por dentro](#cómo-funciona-por-dentro)
- [El ranking (ranking.xml)](#el-ranking-rankingxml)
- [Validar el XML con la DTD](#validar-el-xml-con-la-dtd)
- [Consultas XPath](#consultas-xpath)
- [Generar la tabla HTML (XSLT)](#generar-la-tabla-html-xslt)
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
├── Metodos.java            → La lógica del juego: menú, combates, puntuación, ranking y XML
├── CrearXML.java           → Práctica de clase: crear un XML con DOM (base de guardarRanking)
├── LeerXML.java            → Práctica de clase: leer un XML con DOM (base de cargarRanking)
├── ranking.xml             → Aquí se guardan las puntuaciones (enlazado a la DTD)
├── ranking.dtd             → Reglas de estructura del ranking
├── consultas_xpath.md      → Las cinco consultas XPath numeradas
├── ranking.xsl             → Transformación del ranking a HTML
├── ranking.css             → Estilos de la tabla
├── ranking.html            → Tabla generada con Saxon (no se edita a mano)
├── README.md
├── .gitignore
├── pruebas/                → Copias para pruebas (no son el ranking real)
│   ├── error1_falta_puntuacion.xml
│   ├── error2_elemento_no_permitido.xml
│   ├── ranking_vacio.xml
│   ├── ranking_datos_incorrectos.xml
│   └── ranking_mal_formado.xml
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
```

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

## El ranking (ranking.xml)

- Está en la carpeta raíz. El juego lo **lee al arrancar** y lo **guarda al terminar cada partida**.
- Si no existe, el juego empieza con el ranking vacío y lo crea al terminar la primera partida.
- Si existe pero está dañado (mal formado, puntuación que no es un número, fuera de 0-400, nombre vacío, más de 10 registros o desordenado), el juego avisa y **no lo sobrescribe**: se puede jugar, pero no se guarda nada hasta corregirlo.
- **Restablecer una copia de prueba:** guarda antes una copia del ranking real y copia la que quieras probar encima. Las copias de `pruebas/` enlazan la DTD con `../ranking.dtd`, así que al copiarlas a la raíz cambia esa ruta por `ranking.dtd`.

  ```
  cp ranking.xml ranking_real.xml          # copia de seguridad
  cp pruebas/ranking_vacio.xml ranking.xml # probar ranking vacío
  cp ranking_real.xml ranking.xml          # volver al ranking real

  ```

  ---
  ---

## Consultas XPath

Las cinco consultas están en `consultas_xpath.md`. Se ejecutan así (ejemplo con la consulta 2):

```
xmllint --xpath "/ranking/numero[puntuacion > 300]/nombre/text()" ranking.xml
```

---

## Generar la tabla HTML (XSLT)

- **Entrada:** `ranking.xml` + `ranking.xsl`
- **Salida:** `ranking.html` (enlaza `ranking.css` con ruta relativa, así que deben estar en la misma carpeta)

```
java -jar saxon-he-12.5.jar -s:ranking.xml -xsl:ranking.xsl -o:ranking.html
```

(Cambia `saxon-he-12.5.jar` por el nombre y la ruta del `.jar` que hayas descargado.)

Después abre `ranking.html` en el navegador. Si cambias un dato de `ranking.xml` y repites el comando, la tabla se actualiza.

---


## Autora

** [Haninti] **

