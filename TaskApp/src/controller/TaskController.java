package controller; // Paquete al que pertenece esta clase

import view.TaskView; // Importa la clase TaskView de la capa de vista
import model.Task;    // Importa la clase Task del modelo

// Controlador que maneja la lógica entre la vista y el modelo
public class TaskController {
    private TaskView view; // Referencia a la vista

    // Constructor que recibe una instancia de la vista
    public TaskController(TaskView view) {
        this.view = view;

        // Asocia acciones de botones a métodos del controlador
        view.addAddButtonListener(e -> addTask());
        view.addEditButtonListener(e -> editTask());
        view.addDeleteButtonListener(e -> deleteTask());
        view.addCompleteButtonListener(e -> completeTask());
    }

    // Método privado para agregar una tarea
    private void addTask() {
        // Solicita al usuario el título y la descripción de la tarea
        String title = view.showInputDialog("Ingrese el título:");
        String description = view.showInputDialog("Ingrese la descripción:");
        // Si ambos datos son válidos, se crea y agrega la tarea
        if (title != null && description != null) {
            view.addTaskToList(new Task(title, description));
        }
    }

    // Método privado para editar una tarea seleccionada
    private void editTask() {
        int index = view.getSelectedIndex(); // Obtiene el índice de la tarea seleccionada
        if (index != -1) {
            Task selected = view.getSelectedTask(); // Obtiene la tarea seleccionada
            // Solicita nuevos valores con los actuales como predeterminados
            String newTitle = view.showInputDialog("Nuevo título:", selected.getTitle());
            String newDesc = view.showInputDialog("Nueva descripción:", selected.getDescription());
            // Si los nuevos valores no son nulos, se actualiza la tarea
            if (newTitle != null && newDesc != null) {
                selected.setTitle(newTitle);
                selected.setDescription(newDesc);
                view.updateTaskAt(index, selected); // Actualiza la tarea en la vista
            }
        } else {
            // Si no hay selección, muestra un mensaje
            view.showMessage("Selecciona una tarea para editar.");
        }
    }

    // Método privado para eliminar una tarea seleccionada
    private void deleteTask() {
        int index = view.getSelectedIndex(); // Obtiene el índice de la tarea seleccionada
        if (index != -1) {
            view.removeTaskAt(index); // Elimina la tarea de la lista
        } else {
            view.showMessage("Selecciona una tarea para eliminar."); // Muestra un mensaje si no hay selección
        }
    }

    // Método privado para marcar una tarea como completada
    private void completeTask() {
        int index = view.getSelectedIndex(); // Obtiene el índice de la tarea seleccionada
        if (index != -1) {
            Task selected = view.getSelectedTask(); // Obtiene la tarea seleccionada
            selected.setCompleted(true); // Marca la tarea como completada
            view.updateTaskAt(index, selected); // Actualiza la tarea en la vista
        } else {
            view.showMessage("Selecciona una tarea para completar."); // Mensaje si no hay selección
        }
    }
}
