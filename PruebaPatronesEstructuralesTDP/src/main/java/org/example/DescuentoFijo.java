package org.example;

class DescuentoFijo implements Descuento {
    private final double porcentajeDescuento;

    public DescuentoFijo(double porcentajeDescuento) {
        this.porcentajeDescuento = porcentajeDescuento;
    }

    @Override
    public double aplicarDescuento(double precio) {
        return precio * (1 - porcentajeDescuento / 100);
    }
}