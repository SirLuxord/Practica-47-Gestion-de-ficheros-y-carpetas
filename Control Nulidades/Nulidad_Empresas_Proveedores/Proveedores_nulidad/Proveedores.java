package Nulidad_Empresas_Proveedores.Proveedores_nulidad;
import java.util.*;


public class Proveedores { 
    private String NombreProveedores;
    private String IdProveedores;
    private String Telefono;
    private String Email;
    private String Contacto;
    private String Nulidad;
    private ArrayList<Pago> Pagos = new ArrayList<Pago>();
    private String ListaPagos;



    public Proveedores(String NombreProveedores, String IdProveedores, String Telefono, String Email, String Contacto, String Pago, String IdPago, String Nulidad) { 
        this.NombreProveedores = NombreProveedores;
        this.IdProveedores = IdProveedores;
        this.Telefono = Telefono;
        this.Nulidad = Nulidad;
        this.Email = Email;
        this.setContacto(Contacto);
        this.pagoCompleto(Pago, IdPago);
    }

    private void setContacto(String Contacto){
        String patron = ("Contacto\\d+,\\s*");
        this.Contacto = Contacto.replaceAll(patron, "");
    }

    public void pagoCompleto(String Pago, String idPagoReal) {
        String patron = ("[^\\d]*");
        String idPago = idPagoReal.replaceAll(patron, "");
        float Pagodecimal = Float.parseFloat(Pago.replace(".","").replace(",", "."));
        Pago nuevoPago = new Pago(Pagodecimal, idPago);
        this.Pagos.add(nuevoPago);
    }

    public String getsumaPago(){
        float suma = 0;
        for (Pago pago : this.Pagos) {
            suma += pago.getcuantia();
        }
        String sumatexto = String.valueOf(suma);
        return sumatexto;
    }

    public String getlistaPagos(){
        StringBuilder TodoPagos = new StringBuilder();
        for (int i = 0; i < this.Pagos.size(); i++) {
            TodoPagos.append("El pago de la factura: " + this.Pagos.get(i).getid() + " es de " + this.Pagos.get(i).getcuantia()+ "\n");
        }
        this.ListaPagos = TodoPagos.toString();
        return this.ListaPagos;
    }

    public String getNombreProveedores(){
        return this.NombreProveedores;
    }

    public String getIdProveedores(){
        return this.IdProveedores;
    }

    public String getTelefono(){
        return this.Telefono;
    }


    public String getNulidad(){
        return this.Nulidad;
    }

    public String getEmail(){
        return this.Email;
    }

    public String getContacto(){
        return this.Contacto;
    }


    public void Imprimir() {
        System.out.print("Nombre de la empresa: " + this.NombreProveedores + "\n");
        System.out.print("Id de la empresa: " + this.IdProveedores + "\n");
        System.out.print("Telefono de la empresa: " + this.Telefono + "\n");
        System.out.print("Email de la empresa: " + this.Email + "\n");
        System.out.print("Contacto de la empresa: " + this.Contacto + "\n");
        System.out.print("Suma de los pagos: " + this.getsumaPago() + "\n");
        System.out.print("Lista de pagos: " + this.getlistaPagos() + "\n");
    }

}
