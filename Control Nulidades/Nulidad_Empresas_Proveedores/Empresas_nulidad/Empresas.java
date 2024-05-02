package Nulidad_Empresas_Proveedores.Empresas_nulidad;

//import java.util.*;

public class Empresas {
    private String CodigoEmpresa;
    private String NombreEmpresa;
    private String NombreEmpleado;
    private String CargoEmpleado;
    private String TipoCarta;
    private String Email;
    

    public Empresas(String CodigoEmpresa,String NombreEmpresa, String NombreEmpleado, String CargoEmpleado, String TipoCarta, String Email) {
        this.CodigoEmpresa = CodigoEmpresa;
        this.NombreEmpresa = NombreEmpresa;
        this.NombreEmpleado = NombreEmpleado;
        this.CargoEmpleado = CargoEmpleado;
        this.TipoCarta = TipoCarta;
        this.Email = Email;
    }
    /*
    public void setCodigoEmpresa() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese el codigo de la empresa: ");
        this.CodigoEmpresa = scanner.nextLine();
    }


    public void setNombreEmpresa(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese el nombre de la empresa: ");
        this.NombreEmpresa = scanner.nextLine();
    }

    public void setNombreEmpleado(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese el nombre del empleado: ");
        this.NombreEmpleado = scanner.nextLine();
    }

    public void setCargoEmpleado(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese el cargo del empleado: ");
        this.CargoEmpleado = scanner.nextLine();
    }

    public void setTipoCarta(){
        try{
            Scanner scanner = new Scanner(System.in);
            System.out.print("Ingrese el tipo de carta: ");
            this.TipoCarta = scanner.nextLine();
        } catch(InputMismatchException e){
            System.out.println("Ingrese un numero entero entre 1 o 2");
        }
    }
    */
    public String getCodigoEmpresa(){
        return this.CodigoEmpresa;
    }

    public String getNombreEmpresa(){
        return this.NombreEmpresa;
    }

    public String getNombreEmpleado(){
        return this.NombreEmpleado;
    }

    public String getCargoEmpleado(){
        return this.CargoEmpleado;
    }


    public String gettipocarta(){
        return this.TipoCarta;
    }

    public String getEmail(){
        return this.Email;
    }
}
