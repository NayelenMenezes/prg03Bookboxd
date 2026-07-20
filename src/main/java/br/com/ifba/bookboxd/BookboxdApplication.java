package br.com.ifba.bookboxd;

import br.com.ifba.bookboxd.view.LoginView;
import javax.swing.SwingUtilities;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

//main responsavel por abrir a tela view
@SpringBootApplication
public class BookboxdApplication {

	public static void main(String[] args) {
            System.setProperty("java.awt.headless", "false");

            // Inicializa o contexto do Spring Boot no modo desktop
            ConfigurableApplicationContext context = SpringApplication.run(BookboxdApplication.class, args);
           
                
            SwingUtilities.invokeLater(() -> {
                LoginView loginView = context.getBean(LoginView.class);
                loginView.setVisible(true);
            });
        }
}



