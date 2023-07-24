package Taller;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Productos {
    private int codigo;
    private String nombre;
    private double precio;
    private int stock;
    private List<Productos> listaProductos;

    public Productos(){
        listaProductos = new ArrayList<>();
    }

    public Productos(int codigo, String nombre, double precio, int stock){
        this.codigo = codigo;
        this.nombre = nombre;
        this.precio = precio;
        this.stock = stock;
    }

    //Getters
    public int getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public List<Productos> getListaProductos() {
        return listaProductos;
    }

    //Métodos (Esto deberia ir aparte según principios SOLID pero no los aplicaré en este taller)
    public void addProduct(int codigo, String nombre, double precio, int stock){
        listaProductos.add(new Productos(codigo, nombre, precio, stock));
    }

    public void getProductList(){
        for (Productos producto : listaProductos){
            System.out.println("Producto N°: " + producto.getCodigo());
            System.out.println("Nombre: " + producto.getNombre() + " - " + "Precio: " + producto.getPrecio() + " - " +
                    "stock: " + producto.getStock());
        }
    }

    public void getProductById(int codigo){
        for(Productos producto : listaProductos){
            if(producto.getCodigo() == codigo){
                System.out.println("Producto N°: " + producto.getCodigo());
                System.out.println("Nombre: " + producto.getNombre() + " - " + "Precio: " + producto.getPrecio() + " - " +
                        "stock: " + producto.getStock());
            }
        }
    }

    public void updateStock(int codigo, int newStock){
        for(Productos producto : listaProductos){
            if(producto.getCodigo() == codigo){
                producto.setStock(newStock);
            }
        }
    }

    public void removeProduct(int codigo){
        List<Productos> prodToEliminate = new ArrayList<>();

        for(Productos producto : listaProductos){
            if(producto.getCodigo() == codigo){
                prodToEliminate.add(producto);
            }
        }

        listaProductos.removeAll(prodToEliminate);
    }

    public void getTotalStock(){
        double acc = 0;

        for(Productos prod : listaProductos){
            double acc1= prod.getPrecio() * prod.getStock();
            acc+=acc1;
        }
        System.out.println("El valor total es " + acc);

    }

    public void getMinMax(){
        String nombreMax = "";
        String nombreMin = "";

        double maxPrice = 0;
        double minPrice = 0;
        for(Productos producto : listaProductos){
            if(producto.getPrecio() > maxPrice){
                maxPrice= producto.getPrecio();
                nombreMax = producto.getNombre();
            }else if(producto.getPrecio() < maxPrice){
                minPrice = producto.getPrecio();
                nombreMin= producto.getNombre();
            }
        }
        System.out.println("El precio más alto es : " + maxPrice + " del producto " + nombreMax);
        System.out.println("El precio más bajo es : " + minPrice + " del producto " + nombreMin);

    }
}
