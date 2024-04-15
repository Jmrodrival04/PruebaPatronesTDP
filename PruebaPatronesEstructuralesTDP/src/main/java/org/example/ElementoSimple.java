package org.example;

class ElementoSimple implements Elemento {
    private final double precio;
    private final int codigo;

    public ElementoSimple(int codigo, double precio) {
        this.codigo = codigo;
        this.precio = precio;
    }

    @Override
    public double getPrecio() {
        return precio;
    }

    @Override
    public int getCodigo() {
        return codigo;
    }
}