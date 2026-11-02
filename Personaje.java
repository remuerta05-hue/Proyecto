
public class Personaje
{
    private String nombre;
    private int vidaMax;
    private int danoMax;
    private int danoMin;
    

    public Personaje(String nombre, int vidaMax,  int danoMax, int danoMin)

    {
        this.nombre= nombre;
        this.vidaMax= 0;
        this.danoMax= 0;
        this.danoMin= 0;

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

    public void setVidaMax(int vidaMax) {
        this.vidaMax = vidaMax;
    }



    public int getDanoMax() {
        return danoMax;
    }


    public void setDanoMax(int danoMax) {
        this.danoMax = danoMax;
    }


    public int getDanoMin() {
        return danoMin;
    }


    public void setDanoMin (int danoMin) {
        this.danoMin = danoMin;

    }

    public boolean tieneVidaCompleta() {
        return vidaMax==vidaMax;
    }

    public void recibirDano(int dano) {
        vidaMax = Math.max(0, vidaMax - dano);
    }

    public int atacar () {
        return aleatorio ( danoMin,danoMax) ;
    }

    public  void 

    
    
}