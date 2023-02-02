package es.iesjandula.spring_tr18.interfaces;

import java.util.Scanner;

import es.iesjandula.spring_tr18.errors.ApplicationError;

public interface IParseoCarritoPCs 
{
    void parsearFicheroCarritoPCs(Scanner scanner) throws ApplicationError;    
}
