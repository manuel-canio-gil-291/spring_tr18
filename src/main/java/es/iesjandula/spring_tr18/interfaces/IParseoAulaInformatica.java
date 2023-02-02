package es.iesjandula.spring_tr18.interfaces;

import java.util.Scanner;

import es.iesjandula.spring_tr18.errors.ApplicationError;

public interface IParseoAulaInformatica 
{
    void parsearFicheroAulaInformatica(Scanner scanner) throws ApplicationError;    
}
