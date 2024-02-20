package com.verdumarket.carrito.service;

import com.verdumarket.carrito.dto.DatosCarritoItemsDTO;
import com.verdumarket.carrito.dto.DatosItemDTO;
import com.verdumarket.carrito.model.Carrito;
import com.verdumarket.carrito.model.EstadoCarrito;
import com.verdumarket.carrito.model.EstadoItem;
import com.verdumarket.carrito.model.ItemPorCarrito;
import com.verdumarket.carrito.repository.CarritoRepository;
import com.verdumarket.carrito.repository.ItemPorCarritoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;

@Service
public class ItemPorCarritoService implements IItemPorCarritoService{
    @Autowired
    private ItemPorCarritoRepository itemPorCarritoRepository;
    @Autowired
    private CarritoRepository carritoRepository;

    @Override
    public void GuardarItemCarrito(DatosCarritoItemsDTO datos) {
        Carrito carrito = buscarCarritoPorIds(datos.getIdComprador(), datos.getIdVendedor());
        if (carrito == null) {
            // Si no existe el carrito, lo creamos y lo guardamos para obtener su ID
            carrito = Carrito.builder()
                    .estadoCarrito(EstadoCarrito.ACTIVO)
                    .idComprador(datos.getIdComprador())
                    .idVendedor(datos.getIdVendedor())
                    .precioEnvio(BigDecimal.valueOf(0.0))//poner precio envio
                    .precioTotal(BigDecimal.valueOf(0.0))
                    .listadoItems(new ArrayList<ItemPorCarrito>())
                    .build();
            carrito = carritoRepository.saveAndFlush(carrito); // Guardamos el carrito y obtenemos el ID asignado
        }

        // Creamos el ítem del carrito
        ItemPorCarrito item = new ItemPorCarrito();

        ItemPorCarrito itemDB = itemPorCarritoRepository.retornarIdItemSiExiste(datos.getIdProducto(),
                carrito.getIdCarrito());

        item.setIdProducto(datos.getIdProducto());
        item.setNombreProducto(datos.getNombreProducto());
        item.setCarrito(carrito);
        item.setEstadoItem(EstadoItem.ACTIVO);
        if (itemDB != null) {

            item.setIdItemPorCarrito(itemDB.getIdItemPorCarrito());
            item.setCantidad(datos.getCantidad() + itemDB.getCantidad());
                //sumamos big
            BigDecimal precioDatos = datos.getPrecio() != null ? datos.getPrecio() : BigDecimal.ZERO;
            BigDecimal precioItemPorCarrito = itemDB.getPrecio() != null ? itemDB.getPrecio() : BigDecimal.ZERO;

            BigDecimal nuevoPrecio = precioDatos.add(precioItemPorCarrito);
            item.setPrecio(nuevoPrecio);

            itemPorCarritoRepository.save(item);
        }else{
            item.setPrecio(datos.getPrecio());
            item.setCantidad(datos.getCantidad());

            carrito.getListadoItems().add(item);
        }





        carrito.actualizarPrecioTotal();

        carritoRepository.save(carrito);
    }

    @Override
    public void cancelarItem(Long id) {
        ItemPorCarrito item = itemPorCarritoRepository.findById(id).orElse(null);
        if(item != null){
            item.setPrecio(new BigDecimal(0));
            item.setCantidad(0);
            item.setEstadoItem(EstadoItem.INACTIVO);
            itemPorCarritoRepository.save(item);
        }
    }


    private Carrito buscarCarritoPorIds(Long idComprador, Long idVendedor){
        Carrito carrito = carritoRepository.findByIdCompradorIdVendedor(idComprador,idVendedor);
        return carrito;
    }

//    private void actualizarPrecioTotal(Carrito carrito) {
//        BigDecimal totalItems = BigDecimal.ZERO;
//        if (carrito.getListadoItems() != null) {
//            for (ItemPorCarrito item : carrito.getListadoItems()) {
//                BigDecimal precioItem = item.getPrecio();
//                // Verificar si el precio del ítem es nulo
//                if (precioItem == null) {
//                    precioItem = BigDecimal.ZERO;
//                }
//                totalItems = totalItems.add(precioItem);
//            }
//        }
//        carrito.setPrecioTotal(totalItems.add(carrito.getPrecioEnvio()));
//        carritoRepository.save(carrito); // Guardamos el carrito actualizado en la base de datos
//    }



}
