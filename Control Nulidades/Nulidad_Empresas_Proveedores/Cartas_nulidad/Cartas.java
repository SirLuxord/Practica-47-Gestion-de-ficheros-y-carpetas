package Nulidad_Empresas_Proveedores.Cartas_nulidad;

import java.util.*;
import java.io.*;

import Nulidad_Empresas_Proveedores.Empresas_nulidad.Empresas;
import Nulidad_Empresas_Proveedores.Proveedores_nulidad.Proveedores;


public class  Cartas {

    public void borrar_archivos(){
        File cartas = new File("Nulidad_Empresas_Proveedores\\Cartas_nulidad\\Cartas_Fax_Nulidades_Hechos");
        File[] nulidad = cartas.listFiles();
        for(int i = 0; i < nulidad.length; i++){
            nulidad[i].delete();
        }
    }

    public ArrayList<String> archivo_filtro_carpeta(Empresas empresa){
        ArrayList<String> nombrenulidad = new ArrayList<String>();
        File nulidades = new File("Nulidad_Empresas_Proveedores\\Cartas_nulidad\\Nulidades");
        File[] nulidad = nulidades.listFiles(new FileFilter(){
            @Override
            public boolean accept(File pathname) {
                return pathname.getName().endsWith(empresa.getCodigoEmpresa() + ".txt");
            }
        });
        for(int i = 0; i < nulidad.length; i++){
            nombrenulidad.add(nulidad[i].getName().toString());
        }
        return nombrenulidad;
    }


    public String cartatostring(Empresas nombre){
        StringBuilder carta = new StringBuilder();
        try(FileReader reader = new FileReader("Nulidad_Empresas_Proveedores\\Cartas_nulidad\\Tipos_Carta\\" + nombre.gettipocarta() + ".txt");
        BufferedReader LeerArchivo = new BufferedReader(reader)){
            String linea;
            while((linea = LeerArchivo.readLine())!= null){
                carta.append(linea+"\n");
            }
        } catch (IOException e) {
            System.out.println("No se encontro el archivo y el nombre de la carta fue " + nombre.gettipocarta());
            
        }
        String carta_completa =carta.toString();
        return carta_completa;  
    }


    public ArrayList<Proveedores> crear_proveedores(String NombreNulidad){
        ArrayList<Proveedores> listaProveedores = new ArrayList<Proveedores>();
        try(FileReader reader = new FileReader("Nulidad_Empresas_Proveedores\\Cartas_nulidad\\Nulidades\\"+ NombreNulidad);
        BufferedReader LeerArchivo = new BufferedReader(reader)){
            String linea;
            while((linea = LeerArchivo.readLine())!= null){
                Boolean encontrado = false;
                String[] nulidadtxt = linea.split("\t");
                String codFactura = nulidadtxt[0];
                String nombreProveedor = nulidadtxt[1];
                String cuantia = nulidadtxt[2];
                String codProveedor = nulidadtxt[4];
                String nulidad = nulidadtxt[5];
                String telefono = nulidadtxt[6];
                String email = nulidadtxt[7];
                String nombrecontacto = nulidadtxt[8];
                for (Proveedores proveedor: listaProveedores){
                    if (proveedor.getIdProveedores().equals(codProveedor)){
                        encontrado = true;
                        proveedor.pagoCompleto((cuantia), codFactura);
                    }
                }
                if (encontrado == false){
                    listaProveedores.add(new Proveedores(nombreProveedor, codProveedor, telefono, email, nombrecontacto, cuantia, codFactura, nulidad));
                }   
            } 
        } catch (IOException e) {
            System.out.println("No se encontro el archivo");
        }
        return listaProveedores;
    }

    public void crear_cartas(ArrayList<Proveedores> listaProveedores, Empresas empresa, String carta){
        for (Proveedores proveedor: listaProveedores){
            String carta_proveedor = carta;
            carta_proveedor = carta_proveedor.replace("[Nombre_cliente]", proveedor.getContacto());
            carta_proveedor = carta_proveedor.replace("[Numero_nulidad]", proveedor.getNulidad());
            carta_proveedor = carta_proveedor.replace("[nombre_empresa]", proveedor.getNombreProveedores());
            carta_proveedor = carta_proveedor.replace("[total_servicios]", proveedor.getsumaPago());
            carta_proveedor = carta_proveedor.replace("[Lista_pago_servicios]", proveedor.getlistaPagos());
            carta_proveedor = carta_proveedor.replace("[correo_empresa_nulidad]", empresa.getEmail());
            carta_proveedor = carta_proveedor.replace("[Su_nombre]", empresa.getNombreEmpleado());
            carta_proveedor = carta_proveedor.replace("[Su_cargo]", empresa.getCargoEmpleado());
            carta_proveedor = carta_proveedor.replace("[Su_empresa]", empresa.getNombreEmpresa());
            try(FileWriter fw = new FileWriter("Nulidad_Empresas_Proveedores/Cartas_nulidad/Cartas_Fax_Nulidades_Hechos\\carta_" 
            + proveedor.getNulidad() + "_"+proveedor.getNombreProveedores() + empresa.getCodigoEmpresa() + ".txt");
            BufferedWriter bw = new BufferedWriter(fw)){
                bw.write(carta_proveedor);
                if (proveedor.getEmail().equals("0")){
                    System.out.println("Se ha enviado la carta de la nulidad" + proveedor.getNulidad() + " a la empresa " 
                    + proveedor.getNombreProveedores() + "mediante el número fax " + proveedor.getTelefono() + " por parte de la empresa " 
                    + empresa.getNombreEmpresa());
                } else {
                    System.out.println("Se ha enviado la carta de la nulidad" + proveedor.getNulidad() + " a la empresa " 
                    + proveedor.getNombreProveedores() + "mediante el email " + proveedor.getEmail() + " por parte de la empresa " 
                    + empresa.getNombreEmpresa());
                }
            } catch (IOException e){
                System.out.println("No se pudo crear el archivo");
            }
        }   
    }
}
