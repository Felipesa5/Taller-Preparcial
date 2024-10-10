import java.text.DecimalFormat;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class Main {
    public static void main(String[] args) {
        DecimalFormat formater = new DecimalFormat("###,###.##");

        ArrayList<Programa> programas = new ArrayList<>();

        Programa dibujo = new Programa("Dibujo", 2500000, 6, 7);
        Programa pintura = new Programa("Pintura", 2700000, 8, 9);
        Programa escultura = new Programa("Escultura", 3000000, 10, 12);

        programas.add(dibujo);
        programas.add(pintura);
        programas.add(escultura);

        int deseaAñadirNuevoNiño = JOptionPane.YES_OPTION;

        do {
            String nombre = JOptionPane.showInputDialog("Ingrese el nombre del niño");
            String edadTxt = JOptionPane.showInputDialog("Ingrese la edad de: " + nombre);
            int edad = Integer.parseInt(edadTxt);

            Programa programaAplicable = null;

            for (Programa programa : programas) {
                if (edad >= programa.getEdadMinima() && edad <= programa.getEdadMaxima()) {
                    programaAplicable = programa;
                    break;
                }
            }

            if (programaAplicable == null) {
                JOptionPane.showMessageDialog(null, "No hay programas aplicables");
            } else {
                int deseaMatricular = JOptionPane.showConfirmDialog(null,
                        "Le aplica el programa: " + programaAplicable.getNombre() + " con valor: $"
                                + formater.format(programaAplicable.getValorBase()),
                        "¿Desea matricular el niño?", JOptionPane.YES_NO_OPTION);
                if (deseaMatricular == JOptionPane.YES_OPTION) {
                    double totalAPagar = programaAplicable.getValorBase();

                    Niño niño = new Niño(nombre, edad, false, false, false);
                    programaAplicable.obtenerEstudiantes().add(niño);

                    int tieneMaterialesEspeciales = JOptionPane.showConfirmDialog(null,
                            "¿Desea añadir materiales especiales por un valor de: "
                                    + formater.format(programaAplicable.VALOR_MATERIALES_ESPECIALES) + "?",
                            "Añadir valor adicional", JOptionPane.YES_NO_OPTION);
                    if (tieneMaterialesEspeciales == JOptionPane.YES_OPTION) {
                        niño.setTieneMaterialesEspeciales(true);
                        totalAPagar += programaAplicable.VALOR_MATERIALES_ESPECIALES;
                    }

                    int tieneClasesIntensivas = JOptionPane.showConfirmDialog(null,
                            "¿Desea añadir clases intensivas por un valor de: "
                                    + formater.format(programaAplicable.VALOR_CLASES_INTENSIVAS) + "?",
                            "Añadir valor adicional", JOptionPane.YES_NO_OPTION);
                    if (tieneClasesIntensivas == JOptionPane.YES_OPTION) {
                        niño.setTieneClasesIntensivas(true);
                        totalAPagar += programaAplicable.VALOR_CLASES_INTENSIVAS;
                    }

                    int tieneTalleresFinDeSemana = JOptionPane.showConfirmDialog(null,
                            "Desea añadir talleres de fines de semana por valor de: "
                                    + formater.format(programaAplicable.VALOR_TALLERES_FIN_DE_SEMANA) + "?",
                            "Añadir valor adicional", JOptionPane.YES_NO_OPTION);
                    if (tieneTalleresFinDeSemana == JOptionPane.YES_OPTION) {
                        niño.setTieneTalleresFinDeSemana(true);
                        totalAPagar += programaAplicable.VALOR_TALLERES_FIN_DE_SEMANA;
                    }

                    JOptionPane.showMessageDialog(null, "VALOR TOTAL A PAGAR: $" + formater.format(totalAPagar),
                            "VALOR TOTAL", JOptionPane.INFORMATION_MESSAGE);
                }
            }
            deseaAñadirNuevoNiño = JOptionPane.showConfirmDialog(null, "¿Desea añadir un nuevo niño?", "Continuar", JOptionPane.YES_NO_OPTION);
        } while (deseaAñadirNuevoNiño == JOptionPane.YES_OPTION);

        double materiales = 0;
        double clasesIntensivas = 0;
        double talleresFinSemana = 0;
        double totalNiño = 0;
        double totalPrograma = 0;
        double totalEscuela = 0;
        String informacion = "";
        for (Programa programa : programas) {
            informacion += "Nombre programa: " + programa.getNombre() + "\n";
            ArrayList<Niño> estudiantesPrograma = programa.obtenerEstudiantes();

            if (estudiantesPrograma.size() > 0) {
                for (Niño niño : estudiantesPrograma) {
                    totalNiño += programa.getValorBase();
                    if (niño.tieneMaterialesEspeciales){
                        materiales += programa.VALOR_MATERIALES_ESPECIALES;
                    }
                    if (niño.tieneClasesIntensivas) {
                        clasesIntensivas += programa.VALOR_CLASES_INTENSIVAS;
                    }
                    if (niño.tieneTalleresFinDeSemana) {
                        talleresFinSemana += programa.VALOR_TALLERES_FIN_DE_SEMANA;
                    }
                    totalNiño += materiales + talleresFinSemana + clasesIntensivas;

                    informacion += String.format("* %s (%d años):\n"+ 
                  "    --Base: $%s \n" + 
                  "    --Materiales: %s \n"+
                  "    --Clases intensivas: %s \n"+
                  "    --Talleres fin de semana: %s \n"+
                  "    TOTAL A PAGAR: %s \n"

                    , niño.getNombre(), niño.getEdad(), formater.format(programa.getValorBase()), 
                    formater.format(materiales) , formater.format(clasesIntensivas),
                    formater.format(talleresFinSemana),formater.format(totalNiño)
                    );
                    totalPrograma += totalNiño;
                     totalNiño = 0;
                }

                informacion += "--------------------------------------------------------\n";    
                informacion += "        TOTAL PROGRAMA : "+ programa.getNombre() +"  "+ formater.format(totalPrograma) + "\n\n";
                totalEscuela += totalPrograma;
            } else {
                informacion += "No hay estudiantes matriculados en este programa.\n";

            }
            informacion += "--------------------------------------------------------\n\n";
            totalPrograma = 0;
        }
        informacion += "TOTAL ESCUELA: "+  formater.format(totalEscuela) ;
        JOptionPane.showMessageDialog(null, informacion);
    }
}
     

   


      


//Crear un botón que confirme si el niño se va a inscribir
// De ser así que pregunte si quiere agregarle los valores adicionales (Materiales, Clases extras y talleres)
// El diagrama se crea en LUCICHART

