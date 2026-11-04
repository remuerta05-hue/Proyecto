package personajes;
import java.util.Random;

public class Personaje
{
    private String nombre;
    private final int vidaMax;
    private final int vidaMin;
    private  int vida;
    private final int danoMax;
    private final int danoMin;
    private int dano;
    

    public Personaje(String nombre, int vidaMax,int vidaMin,int vida, int danoMax, int danoMin, int dano)

    {
        this.nombre = nombre;
        this.vidaMax = 0;
        this.vidaMin = 0;
        this.vida = 0;
        this.danoMax = 0;
        this.danoMin = 0;
        this.dano = 0;
    }

    //---------- get set----------------
  

    public int tieneVidaCompleta() {
        return vidaMax;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getVidaMax() {
        return vidaMax;
    }

    public int getVidaMin() {
        return vidaMin;
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

    public int getDano() {
        return dano;
    }

    public void setDano(int dano) {
        this.dano = dano;
    }

    //--------------metodos----------------

    public void mostrarDatos() {
        System.out.println("Nombre: " + this.nombre);
        System.out.println("Vida: " + this.vida);
        System.out.println("Daño: " + dano);
    }
    public void recibirDano(int dano) {
        vida = Math.max(0, vidaMax - dano);
    }

    public void recuperarVida (int cantidad) {
        vida = Math.min(vidaMax, vida + cantidad);
    }

    public int  atacar () {
    Random random = new Random();
    int ataque = random.nextInt(6) +15; 
    return ataque;
    }

    Juego juego= new Juego();
    public void curar (){
        setVida(getVida() + Juego.CURACION_BEBIDA);
    } //mirar si es correcto
    

    public void describirAtaqueCajero(){
         //getNombre() + " ataca con " + Juego.OBJETOS_CAJERO[(int) (Math.random() * Juego.OBJETOS_CAJERO.length)];
    }
    
    public String describirAtaqueAsaltante(){
        return getNombre() + " ataca con " + Juego.OBJETOS_ASALTANTE[(int) (Math.random() * Juego.OBJETOS_ASALTANTE.length)];
    }

   

    

    

    
    
}