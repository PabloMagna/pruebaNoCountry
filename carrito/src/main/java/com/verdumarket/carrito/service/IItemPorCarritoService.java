package com.verdumarket.carrito.service;

import com.verdumarket.carrito.dto.DatosCarritoItemsDTO;
import com.verdumarket.carrito.dto.DatosItemDTO;
import com.verdumarket.carrito.model.ItemPorCarrito;

public interface IItemPorCarritoService {
    public void GuardarItemCarrito(DatosCarritoItemsDTO datos);

    void cancelarItem(Long id);
}
