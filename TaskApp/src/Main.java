import view.TaskView;          // Importa la clase de la vista
import controller.TaskController; // Importa la clase del controlador

// Clase principal que ejecuta la aplicación
public class Main {
    public static void main(String[] args) {
        // Asegura que la interfaz gráfica se ejecute en el hilo de eventos de Swing
        javax.swing.SwingUtilities.invokeLater(() -> {
            TaskView view = new TaskView();      // Crea la vista
            new TaskController(view);            // Crea el controlador y le pasa la vista
        });
    }
}
