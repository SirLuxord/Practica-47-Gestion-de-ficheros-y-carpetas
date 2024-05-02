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
