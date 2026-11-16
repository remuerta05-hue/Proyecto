package personajes;


public class Personaje
{
    private String nombre;
    private final int vidaMax;
    private final int vidaMin;
    private  int vida;
    private final int danoMax;
    private final int danoMin;
    private final int dano; 
    
    

    public Personaje(String nombre, int vidaMax, int vidaMin, int vida, int danoMax, int danoMin, int dano)

    {
        this.nombre = nombre;
        this.vidaMax = vidaMax;
        this.vidaMin = vidaMin;
        this.vida = vidaMax;
        this.danoMax = danoMax;
        this.danoMin = danoMin;
        this.dano = dano;
        
    }

    //---------- get set----------------
  
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getVidaMax() {
        return vidaMax;
    }

    public int getVida() {
        return vida;
    }

    public void setVida(int vida) {
        this.vida = vida;
    }

    public int getDanoMax() {
        return danoMax;
    }

    public int getDanoMin() {
        return danoMin;
    }
    

    //--------------metodos----------------

    public void mostrarDatos() {
        System.out.println("Nombre: " + this.nombre);
        System.out.println("Vida: " + this.vida);
        System.out.println("Daño: " + dano);
    }
    

    public void recibirDano(int dano) {
        vida = Math.max(0, vida - dano);
    }

    public void recuperarVida (int cantidad) {
        vida = Math.min(vidaMax, vida + cantidad);
    }
    public boolean estaVivo() {
    return vida > 0;
    }

    public int atacar() {
       return (int) (Math.random() * (danoMax - danoMin + 1)) + danoMin;
    }
}