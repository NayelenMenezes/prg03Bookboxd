package br.com.ifba.bookboxd;

import br.com.ifba.bookboxd.usuario.controller.UsuarioController;
import br.com.ifba.bookboxd.view.LoginView;
import javax.swing.SwingUtilities;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class BookboxdApplication {

	public static void main(String[] args) {
            System.setProperty("java.awt.headless", "false");

            // Inicializa o contexto do Spring Boot no modo desktop
            ConfigurableApplicationContext context = SpringApplication.run(BookboxdApplication.class, args);
            
            
            UsuarioController usuarioController = context.getBean(UsuarioController.class);
                
            SwingUtilities.invokeLater(() -> {
            LoginView loginView = new LoginView(usuarioController);
            loginView.setVisible(true);
        });
    }
}



