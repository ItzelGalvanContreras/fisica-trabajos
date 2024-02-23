import javax.swing.JOptionPane;

public class CalculalanotacionCientifica {

    public static void main(String[] args) {
        while (true) {
            String opcion = JOptionPane.showInputDialog("Selecciona una opción:\n1. Convertir notación científica a número\n2. Convertir número a notación científica\n3. Salir");

            switch (opcion) {
                case "1":
                    convertirNotacionCientificaANumero();
                    break;
                case "2":
                    convertirNumeroANotacionCientifica();
                    break;
                case "3":
                    JOptionPane.showMessageDialog(null, "¡Chao!");
                    System.exit(0);
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opción no válida. Inténtelo otra vez.");
            }
        }
    }

    private static void convertirNotacionCientificaANumero() {
        String entrada = JOptionPane.showInputDialog("Ingrese un número en notación científica (por ejemplo, 1.23x4):");
        try {
            double resultado = Double.parseDouble(entrada);
            JOptionPane.showMessageDialog(null, "Resultado: " + resultado);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Entrada no válida. Inténtelo de nuevo.");
        }
    }

    private static void convertirNumeroANotacionCientifica() {
        String entrada = JOptionPane.showInputDialog("Ingrese un número:");
        try {
            double numero = Double.parseDouble(entrada);
            String notacionCientifica = String.format("%.2e", numero);
            JOptionPane.showMessageDialog(null, "Resultado: " + notacionCientifica);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Entrada no válida. Inténtelo de nuevo.");
        }
    }
}
