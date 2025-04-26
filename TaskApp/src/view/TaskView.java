package view; // Paquete al que pertenece esta clase

import javax.swing.*;            // Importa componentes de la interfaz gráfica
import java.awt.*;              // Importa clases para gestión de diseño (layouts)
import java.awt.event.ActionListener; // Importa la interfaz para manejar eventos
import model.Task;              // Importa la clase Task del modelo

// Clase que representa la interfaz gráfica para gestionar tareas
public class TaskView extends JFrame {
    // Modelo de lista que contiene objetos Task
    private DefaultListModel<Task> taskListModel = new DefaultListModel<>();
    // Lista visual para mostrar las tareas
    private JList<Task> taskList = new JList<>(taskListModel);
    // Botones para interactuar con las tareas
    private JButton addButton = new JButton("Agregar");
    private JButton editButton = new JButton("Editar");
    private JButton deleteButton = new JButton("Eliminar");
    private JButton completeButton = new JButton("Completar");

    // Constructor que configura la ventana
    public TaskView() {
        setTitle("Lista de Tareas");          // Título de la ventana
        setSize(400, 300);                    // Tamaño de la ventana
        setDefaultCloseOperation(EXIT_ON_CLOSE); // Cierra el programa al cerrar la ventana
        setLayout(new BorderLayout());        // Establece el layout principal

        // Panel inferior para contener los botones
        JPanel buttonsPanel = new JPanel();
        buttonsPanel.add(addButton);
        buttonsPanel.add(editButton);
        buttonsPanel.add(deleteButton);
        buttonsPanel.add(completeButton);

        // Agrega la lista de tareas al centro con scroll
        add(new JScrollPane(taskList), BorderLayout.CENTER);
        // Agrega los botones en la parte inferior
        add(buttonsPanel, BorderLayout.SOUTH);

        setVisible(true); // Muestra la ventana
    }

    // Agrega una tarea al modelo de la lista
    public void addTaskToList(Task task) {
        taskListModel.addElement(task);
    }

    // Fuerza el repintado de la lista (opcional si se actualiza visualmente)
    public void updateTaskList() {
        taskList.repaint();
    }

    // Devuelve la tarea actualmente seleccionada
    public Task getSelectedTask() {
        return taskList.getSelectedValue();
    }

    // Devuelve el índice de la tarea seleccionada
    public int getSelectedIndex() {
        return taskList.getSelectedIndex();
    }

    // Actualiza una tarea específica en el modelo de la lista
    public void updateTaskAt(int index, Task task) {
        taskListModel.set(index, task);
    }

    // Elimina una tarea específica del modelo de la lista
    public void removeTaskAt(int index) {
        taskListModel.remove(index);
    }

    // Muestra un cuadro de diálogo para ingresar texto (sin valor inicial)
    public String showInputDialog(String message) {
        return JOptionPane.showInputDialog(this, message);
    }
    
    // Muestra un cuadro de diálogo para ingresar texto con un valor inicial
    public String showInputDialog(String message, String initialValue) {
        return (String) JOptionPane.showInputDialog(
            this,
            message,
            "Editar tarea",
            JOptionPane.PLAIN_MESSAGE,
            null,
            null,
            initialValue
        );
    }

    // Muestra un cuadro de diálogo con un mensaje informativo
    public void showMessage(String message) {
        JOptionPane.showMessageDialog(this, message);
    }

    // Asocia un listener al botón de agregar
    public void addAddButtonListener(ActionListener listener) {
        addButton.addActionListener(listener);
    }

    // Asocia un listener al botón de editar
    public void addEditButtonListener(ActionListener listener) {
        editButton.addActionListener(listener);
    }

    // Asocia un listener al botón de eliminar
    public void addDeleteButtonListener(ActionListener listener) {
        deleteButton.addActionListener(listener);
    }

    // Asocia un listener al botón de completar
    public void addCompleteButtonListener(ActionListener listener) {
        completeButton.addActionListener(listener);
    }
}