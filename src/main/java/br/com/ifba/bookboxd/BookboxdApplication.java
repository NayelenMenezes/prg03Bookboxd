package br.com.ifba.bookboxd;

import br.com.ifba.bookboxd.view.BookboxdView;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class BookboxdApplication {

	public static void main(String[] args) {
            System.setProperty("java.awt.headless", "false");

            // Inicializa o contexto do Spring Boot no modo desktop
            ConfigurableApplicationContext context = new SpringApplicationBuilder(BookboxdApplication.class)
                    .web(WebApplicationType.NONE)
                    .run(args);

                
            java.awt.EventQueue.invokeLater(() -> {
                try {
                // Aplica o visual nimbus
                for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                    if ("Nimbus".equals(info.getName())) {
                        javax.swing.UIManager.setLookAndFeel(info.getClassName());
                        break;
                    }
                }
                
                //Pega a tela direto do gerenciador do spring boot
                BookboxdView tela = context.getBean(BookboxdView.class);
                
                // Centraliza e força a exibição
                tela.setLocationRelativeTo(null); 
                tela.setVisible(true);
                
                System.out.println("====== TELA INICIALIZADA COM SUCESSO ======");
                
            } catch (Exception ex) {
                java.util.logging.Logger.getLogger(BookboxdApplication.class.getName())
                        .log(java.util.logging.Level.SEVERE, "Erro crítico na inicialização da UI", ex);
            }
        });
	}

}


