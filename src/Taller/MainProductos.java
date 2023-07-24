package Taller;

import java.lang.reflect.Array;
import java.util.*;

public class MainProductos {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Map<String, ArrayList<Productos>> productosPorCategoria = new HashMap<>();
        int opcion;
        Productos prod = new Productos();

        do{
            System.out.println("Menú de opciones");
            System.out.println("1. Agregar productos");
            System.out.println("2. Añadir prod a cat");
            System.out.println("3. Mostrar productos por categoria");
            System.out.println("4. Mostrar información de un producto por código");
            System.out.println("5. Actualizar stock");
            System.out.println("6. Todos los productos.");
            System.out.println("7. Eliminar producto por codigo.");
            System.out.println("8. Ver total valor.");
            System.out.println("8. Precio más alto y más bajo.");
            System.out.println("0. Salir de la aplicación");
            System.out.println(" ");
            opcion = sc.nextInt();

            switch(opcion){
                case 1:
                    addProduct(prod);
                    break;
                case 2:
                    organizePerCategory(productosPorCategoria, prod);
                    break;
                case 3:
                    showCategories(productosPorCategoria);
                    break;
                case 4:
                    showProductById(prod);
                    break;
                case 5:
                    updateStock(prod);
                    break;
                case 6:
                    getAllProducts(prod);
                    break;
                case 7:
                    deleteProduct(prod);
                    break;
                case 8:
                    getStoreTotal(prod);
                    break;
                case 9:
                    getMinMax(prod);
                    break;
                case 0:
                    System.out.println("Saliendo");
                    break;
                default:
                    System.out.println("Option not available");
                    break;
            }


        }while(opcion!=0);
    }


    public static void addProduct(Productos prod){
        Scanner sc = new Scanner(System.in);

        System.out.print("Codigo del producto: ");
        int codigo = sc.nextInt();
        sc.nextLine();
        System.out.print("Nombre del producto nuevo: ");
        String nombre = sc.nextLine();
        System.out.print("Precio del producto nuevo: ");
        double precio = sc.nextDouble();
        sc.nextLine();
        System.out.print("Stock del producto nuevo: ");
        int stock = sc.nextInt();


        prod.addProduct(codigo, nombre, precio, stock);
        System.out.println(" ");
    }
    public static void organizePerCategory(Map<String, ArrayList<Productos>> productosPorCategoria, Productos prod){
        List<String> categories = Arrays.asList("Aseo", "Comida", "Higiene", "Entretenimiento");
        Scanner sc = new Scanner(System.in);


        //For para revisar y añadir nuevas categorias en caso de ser necesario
        for(String categorias : categories){
            if(!productosPorCategoria.containsKey(categorias)){
                productosPorCategoria.put(categorias, new ArrayList<>());
            }
        }

        System.out.println("Las categorias disponibles al momento son");
        //For para imprimir las categorías actuales
        for(String cat : productosPorCategoria.keySet()){
            System.out.println(cat);
        }

        System.out.println("Dame el nombre del producto al cual quieras categorizar");
        String productName = sc.nextLine();

        System.out.println("Dame la categoria a la que pertenece " + productName);
        String catName = sc.nextLine();


        for(Productos productos : prod.getListaProductos()){
            //If para chequear si el producto existe en la lista de productos
            if(productos.getNombre().equalsIgnoreCase(productName)){
                //For para revisar si la categoría existe y añadir a la misma el producto
                for(Map.Entry<String, ArrayList<Productos>> entry : productosPorCategoria.entrySet()){
                    //If para revisar si la categoría existe, en caso de ser true añadir el producto
                    if(entry.getKey().equalsIgnoreCase(catName)){
                        entry.getValue().add(productos);
                        break;
                    }
                }
            }
        }

        System.out.println(productosPorCategoria.entrySet());
    }

    public static void showCategories(Map<String, ArrayList<Productos>> productosPorCategoria){

       //Map.Entry sirve para revisar las entradas de un map aparte siempre y cuanto se mantenga
       //El tipo de dato
       for(Map.Entry<String, ArrayList<Productos>> entry : productosPorCategoria.entrySet()){
           String cat = entry.getKey();
           //Comprobación si el arrayList esta vacío o no
           if(entry.getValue().size() > 0){
               System.out.println("La categoria es " + cat);
               //Iterando por los elementos para imprimirlos.
               for(Productos prod : entry.getValue()){
                   System.out.println("Codigo: " + prod.getCodigo() + " Nombre: " + prod.getNombre() +
                           " Precio: " + prod.getPrecio() + " Stock " + prod.getStock());
               }
           }
           System.out.println(" ");
       }
    }

    public static void showProductById(Productos prod){
        Scanner sc = new Scanner(System.in);

        System.out.println("Dame el código del producto a buscar");
        int codInput = sc.nextInt();

        prod.getProductById(codInput);

        System.out.println(" ");
    }

    public static void updateStock(Productos prod){
        Scanner sc = new Scanner(System.in);

        System.out.println("Dame el código de producto");
        int codigo = sc.nextInt();
        System.out.println("Dame el stock actualizado");
        int newStock = sc.nextInt();

        prod.updateStock(codigo, newStock);
    }

    public static void deleteProduct (Productos prod){
        Scanner sc = new Scanner(System.in);
        System.out.println("Dame el código de producto a eliminar");
        int codigo = sc.nextInt();

        prod.removeProduct(codigo);

        System.out.println("Producto " + codigo + " eliminado");
    }

    public static void getAllProducts(Productos prod){
        prod.getProductList();
    }

    public static void getStoreTotal(Productos prod){
        prod.getTotalStock();
        System.out.println(" ");
    }

    public static void getMinMax(Productos prod){
        prod.getMinMax();
    }
}
