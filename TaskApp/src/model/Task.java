package model; // Paquete al que pertenece esta clase

// Clase que representa una tarea en el sistema
public class Task {
    private String title;        // Título de la tarea
    private String description;  // Descripción de la tarea
    private boolean completed;   // Estado de completitud

    // Constructor que inicializa una tarea con título y descripción
    public Task(String title, String description) {
        this.title = title;
        this.description = description;
        this.completed = false; // Por defecto, la tarea no está completada
    }

    // Devuelve el título de la tarea
    public String getTitle() {
        return title;
    }

    // Devuelve la descripción de la tarea
    public String getDescription() {
        return description;
    }

    // Devuelve si la tarea está completada
    public boolean isCompleted() {
        return completed;
    }

    // Permite establecer un nuevo título
    public void setTitle(String title) {
        this.title = title;
    }

    // Permite establecer una nueva descripción
    public void setDescription(String description) {
        this.description = description;
    }

    // Permite establecer el estado de completitud
    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    // Representación en texto de la tarea, con un indicador de completitud
    @Override
    public String toString() {
        return (completed ? "[X] " : "[ ] ") + title + " - " + description;
    }
}

