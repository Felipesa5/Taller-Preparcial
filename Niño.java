public class Niño {
    String nombre;
    int edad;
    boolean tieneMaterialesEspeciales;
    boolean tieneClasesIntensivas;
    boolean tieneTalleresFinDeSemana;

    public Niño() {

    }

    public Niño(String nombre, int edad, boolean tieneMaterialesEspeciales, boolean tieneClasesIntensivas, boolean tieneTalleresFinDeSemana) {
        this.nombre = nombre;
        this.edad = edad;
        this.tieneMaterialesEspeciales = tieneMaterialesEspeciales;
        this.tieneClasesIntensivas = tieneClasesIntensivas;
        this.tieneTalleresFinDeSemana = tieneTalleresFinDeSemana;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public boolean isTieneMaterialesEspeciales() {
        return tieneMaterialesEspeciales;
    }

    public void setTieneMaterialesEspeciales(boolean tieneMaterialesEspeciales) {
        this.tieneMaterialesEspeciales = tieneMaterialesEspeciales;
    }

    public boolean isTieneClasesIntensivas() {
        return tieneClasesIntensivas;
    }

    public void setTieneClasesIntensivas(boolean tieneClasesIntensivas) {
        this.tieneClasesIntensivas = tieneClasesIntensivas;
    }

    public boolean isTieneTalleresFinDeSemana() {
        return tieneTalleresFinDeSemana;
    }

    public void setTieneTalleresFinDeSemana(boolean tieneTalleresFinDeSemana) {
        this.tieneTalleresFinDeSemana = tieneTalleresFinDeSemana;
    }
}