package br.com.ifba.bookboxd.infrastruture.util;

import java.time.LocalDate;

public class StringUtil {
    
    // Verifica se a string é nula ou composta apenas por espaços
    public static boolean isEmpty(String str) {
        return str == null || str.trim().isEmpty();
    }

    // Verifica se a string contém apenas números 
    public static boolean isNumeric(String str) {
        if (str == null) return false;
        return str.matches("\\d+");
    }
    
    // Valida se um ano está em intervalo razoável 
    public static boolean isAnoValido(int ano) {
        return ano >= 1000 && ano <= LocalDate.now().getYear();
    }

    // Valida formato de email 
    public static boolean isEmailValido(String email) {
        if (isEmpty(email)) return false;
        return email.matches("^[\\w.-]+@[\\w.-]+\\.[a-zA-Z]{2,}$");
    }
}