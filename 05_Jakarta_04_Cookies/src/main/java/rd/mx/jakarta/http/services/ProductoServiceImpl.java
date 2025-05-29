/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rd.mx.jakarta.http.services;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import rd.mx.jakarta.http.models.Producto;

public class ProductoServiceImpl implements ProductoService
{

    @Override
    public List<Producto> listar() 
    {
        return Arrays.asList(new Producto(1L, "notebook", "computacion", 175000), 
                new Producto(2L, "mesa escritorio", "oficina", 100000), 
                new Producto(3L, "teclado mécanico", "computacion", 40000));
    }
    
    /**
     * 
     * Nota que se va a hacer un stream de la lista que se obtiene de listar() (que es un List)
     * @param nombre
     * @return Optional<Producto> si se encuentra un producto regresa ese producto en el optional
     *  si no encuentra ese producto o es una busqueda en blanco regresa un Optinoal vacio
    */
    @Override
    public Optional<Producto> buscarProducto(String nombre)
    {
        if(nombre==null || nombre.isBlank())
        {
            return Optional.empty();
        }
        return listar().stream().filter(p -> p.getNombre().contains(nombre)).findFirst();
        
        /* asi lo tiene el maestro
        */
        /*
        @Override
        public Optional<Producto> buscarProducto(String nombre) 
        {
            return listar().stream().filter(p -> {
                if (nombre == null || nombre.isBlank()) 
                {
                    return false;
                }
                return p.getNombre().contains(nombre);
            }).findFirst();
        }
        
        */
    }
    
}
