package Nulidad_Empresas_Proveedores.Proveedores_nulidad;

public class Pago {
    private float cuantia;
    private String id;

    public Pago(float cuantia, String id) {
        this.cuantia = cuantia;
        this.id = id;
    }

    public float getcuantia(){
        return this.cuantia;
    }

    public String getid(){
        return this.id;
    }

    public void setcuantia(float cuantia){
        this.cuantia = cuantia;
    }

    public void setid(String id){
        this.id = id;
    }
}
