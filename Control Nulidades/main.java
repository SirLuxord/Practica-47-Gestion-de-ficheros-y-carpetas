import java.util.*;

import Nulidad_Empresas_Proveedores.Proveedores_nulidad.Proveedores;
import Nulidad_Empresas_Proveedores.Cartas_nulidad.*;
import Nulidad_Empresas_Proveedores.Empresas_nulidad.Empresas;

public class main {
    public static void main(String[] args) {
        ArrayList<Empresas> listaEmpresas = new ArrayList<Empresas>();
        
        listaEmpresas.add(new Empresas("_IESCan", "IESCanarias", "Juan Pérez","Gerente", "Modelo carta empresa 1", "Iescanarias@example.com"));
        listaEmpresas.add(new Empresas("_IESSall", "IESLaSalle", "Mario López","Asistente administrativo", "Modelo carta empresa 2", "Ieslasalle@example.com"));
        Boolean Consola = true;
        /* 
        Empresas IESCanarias = new Empresas("_IESCan", "IESCanarias", "Juan Pérez","Gerente", "Modelo carta empresa 1");
        Empresas IESSall = new Empresas("_IESSall", "IESLaSalle", "Mario López","Asistente administrativo", "Modelo carta empresa 2");
        */
        Cartas carta = new Cartas();
        while (Consola ==true){
            Scanner entrada = new Scanner(System.in);
            System.out.println("Eliga un número de entre las opciones disponibles");
            System.out.println("1. Crear y enviar cartas");
            System.out.println("2. Cerrar el programa y eliminar archivos");
            int opcion = entrada.nextInt();
            try{
                switch (opcion) {
                    case 1:
                        try{
                            Scanner scanner = new Scanner(System.in);
                            System.out.println("Ingrese el numero de la empresa: ");
                            for(int i = 0; i < listaEmpresas.size(); i++) {
                                System.out.println((i+1) + listaEmpresas.get(i).getNombreEmpresa());
                            }
                            int numeroempresa = scanner.nextInt()-1;
                            String modelocarta = carta.cartatostring(listaEmpresas.get(numeroempresa));
                            ArrayList<String> listanulidades = carta.archivo_filtro_carpeta(listaEmpresas.get(numeroempresa));
                            for (String nulidad : listanulidades){
                                ArrayList<Proveedores> listaproveedores = carta.crear_proveedores(nulidad);
                                carta.crear_cartas(listaproveedores, listaEmpresas.get(numeroempresa), modelocarta);
                            }
                        } catch (InputMismatchException |ArrayIndexOutOfBoundsException e){
                            System.out.println("Ingrese un numero entero que este en la lista");
                        }
                        break;
                    case 2:
                        Consola = false;
                        carta.borrar_archivos();
                        entrada.close();
                        break;
                }
            }catch (InputMismatchException |ArrayIndexOutOfBoundsException e){
                System.out.println("Ingrese un numero entero de entre las opciones disponibles");
            }
        }
            
    }
}
