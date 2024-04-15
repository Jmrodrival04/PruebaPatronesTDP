package org.example;

import java.util.ArrayList;
import java.util.List;

class KitElemento implements Elemento {
    private final List<Elemento> elementos;
    private final int codigo;
    private final Descuento descuento;

    public KitElemento(int codigo, Descuento descuento) {
        this.codigo = codigo;
        this.descuento = descuento;
        this.elementos = new ArrayList<>();
    }

    public void agregarElemento(Elemento elemento) {
        elementos.add(elemento);
    }

    @Override
    public double getPrecio() {
        double precioTotal = elementos.stream().mapToDouble(Elemento::getPrecio).sum();
        return descuento.aplicarDescuento(precioTotal);
    }

    @Override
    public int getCodigo() {
        return codigo;
    }
}