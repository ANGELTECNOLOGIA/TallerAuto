package tallerautos;

public class Coche implements CajaCambios, Motor, Llantas {
    
    private int velocidades;
    private static int marchaMaxima;
    private boolean encendido;
    private float cantidadCombustibleLts;
    private boolean ponchado;

    public Coche(int velocidades, int marchaMaxima, boolean encendido, float cantidadCombustibleLts) {
        this.velocidades = velocidades;
        this.marchaMaxima = marchaMaxima;
        this.encendido = encendido;
        this.cantidadCombustibleLts = cantidadCombustibleLts;
        this.ponchado = false;
    }

    @Override
    public void cambioMarcha(int direccion) {
        if (!encendido) {
            System.out.println("¡Motor apagado! Enciéndelo primero.");
        }

        if (direccion == 1 || direccion == -1) {
            velocidades += direccion;
            
            if (velocidades > marchaMaxima) {
                velocidades = marchaMaxima;
                System.out.println("No puedes subir más marchas");
            } else if (velocidades < -1) {
                velocidades = -1;
                System.out.println("No puedes bajar más, reversa máxima");
            }
            
            System.out.println("Marcha actual: " + velocidades);
        }
    }

    @Override
    public void subirMarcha() {
        cambioMarcha(1); 
    }

    @Override
    public void bajarMarcha() {
        cambioMarcha(-1); 
    }

    @Override
    public void encender() {
        if (!encendido) {
            encendido = true;
            combustion();
            System.out.println("Motor encendido");
        } else {
            System.out.println("El motor ya está encendido");
        }
    }

    @Override
    public void apagar() {
        encendido = false;
        System.out.println("Motor apagado");
    }

    @Override
    public void combustion() {
        cantidadCombustibleLts -= 0.05f;
        System.out.println("Combustible restante: " + cantidadCombustibleLts + "L");
    }

    @Override
    public void acelerar() {
        if (!encendido) {
            System.out.println("¡Motor apagado! Enciéndelo primero.");
            return;
        }
        combustion();
        combustion();
        System.out.println("Acelerando...");
    }

    @Override
    public void rodarEnfrenteAtras(int direccion, int rpm) {
        if (!encendido) {
            System.out.println("¡Motor apagado! Enciéndelo primero.");
            return;
        }

        if (ponchado) {
            System.out.println("¡Llanta ponchada! No puede rodar");
        }

        String sentido = (direccion == 1) ? "adelante" : "atrás";
        System.out.println("Rodando " + sentido + " (" + rpm + " RPM)");
    }

    @Override
    public void rotarDerechaIzquierda(int grados) {
        if (!encendido) {
            System.out.println("¡Motor apagado! Enciéndelo primero.");
        }

        String direccion = (grados > 0) ? "derecha" : "izquierda";
        System.out.println("Girando " + Math.abs(grados) + "° a la " + direccion);
    }

    @Override
    public void poncharse() {
        ponchado = true;
        System.out.println("¡Llanta ponchada!");
    }

    @Override
    public void inflarse() {
        ponchado = false;
        System.out.println("Llanta inflada correctamente");
    }
}
