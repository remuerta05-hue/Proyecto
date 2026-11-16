package personajes;

/**
 * El jugador: un cajero con un inventario de bebidas energéticas.
 * El inventario es un array de tamaño fijo y un contador de bebidas disponibles.
 */
public class Cajero extends Personaje
{
    private final String[] inventario = new String[Juego.NUM_BEBIDAS];
    private int numBebidas;

    public Cajero(String nombre, int vidaMax, int vidaMin, int danoMax, int danoMin, int bebidas) {
        super(nombre, vidaMax, vidaMin, vidaMax, danoMax, danoMin, danoMax);
        numBebidas = 0;
        while (numBebidas < bebidas && numBebidas < inventario.length) {
            inventario[numBebidas] = Juego.NOMBRE_BEBIDA;
            numBebidas++;
        }
    }

    /** 
     * @return */
      
    public int bebidas() {
        return numBebidas;
    }

     
    public void mostrarInventario() {
        System.out.println("--- Inventario ---");
        if (numBebidas == 0) {
            System.out.println("El inventario está vacío.");
        }
        for (int i = 0; i < numBebidas; i++) {
            System.out.println((i + 1) + ". " + inventario[i]);
        }
    }

    public void usarBebida() {
        if (numBebidas > 0) {
            numBebidas--;
            inventario[numBebidas] = null;    
            recuperarVida(Juego.CURACION_BEBIDA);
        }
    }

    public String describirAtaque(String[] objetosCajero) {
        int posicion = (int) (Math.random() * objetosCajero.length);
        return "El cajero ataca con " + objetosCajero[posicion];
    }

    public boolean tieneVidaCompleta() {
        return getVida() == getVidaMax();
    }
}

    





