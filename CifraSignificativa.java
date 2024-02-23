import javax.swing.JOptionPane;
import javax.swing.UIManager;

public class CifraSignificativa {

    public static void main(String[] args) {
        // Establecer el color de fondo de la ventana en verde
        UIManager.put("OptionPane.background", new java.awt.Color(144, 238, 144));
        UIManager.put("Panel.background", new java.awt.Color(144, 238, 144));

        // Pedir al usuario que ingrese un número
        String entrada = JOptionPane.showInputDialog("Ingrese un número positivo o negativo:");

        // Calcular y mostrar las cifras significativas
        calcularCifrasSignificativas(entrada);
    }

    private static void calcularCifrasSignificativas(String entrada) {
        try {
            double numero = Double.parseDouble(entrada);

            // Convertir el número a cadena para analizar las cifras significativas
            String numeroComoCadena = String.valueOf(numero);

            // Eliminar los ceros a la izquierda antes del primer número distinto de cero
            numeroComoCadena = numeroComoCadena.replaceFirst("^0+", "");

            // Contar las cifras significativas después del punto decimal
            int cifrasDespuesDelPunto = 0;
            boolean contarCeros = false;

            for (int i = 0; i < numeroComoCadena.length(); i++) {
                char caracter = numeroComoCadena.charAt(i);

                if (caracter == '.') {
                    contarCeros = true;
                } else if (Character.isDigit(caracter)) {
                    if (contarCeros) {
                        cifrasDespuesDelPunto++;
                    }
                } else {
                    contarCeros = false;
                }
            }

            // Mostrar el resultado en una ventana
            JOptionPane.showMessageDialog(null, "Cifras significativas:\nEstas son las cifras significativas: " +
                    numeroComoCadena.substring(0, cifrasDespuesDelPunto + 1) +
                    "\nCantidad de cifras significativas: " + cifrasDespuesDelPunto);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Entrada no válida. Inténtelo de nuevo.");
        }
    }
}
