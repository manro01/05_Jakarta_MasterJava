/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rd.mx.jakarta.http.services;

import java.util.Arrays;
import java.util.List;
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
    
}
