package com.grupo.integrador;

import com.grupo.integrador.gui.LoginForm;
import com.grupo.integrador.logic.Biblioteca;
import javax.swing.SwingUtilities;

public class Integrador {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Biblioteca biblioteca = new Biblioteca();
            LoginForm loginForm = new LoginForm(biblioteca);
            loginForm.setVisible(true);
        });
    }
}
