package com.fonyou.employee.test;

public class Lavadora extends Electrodomestico {

    private static final double CARGA_POR_DEFECTO = 5D;
    private static final double CARGA_CONDICION = 30D;
    private static final double PRECIO_CARGA_MAYOR_30KG = 50000D;
    private Double carga;

    public Lavadora() {
        this.carga = CARGA_POR_DEFECTO;
    }

    public Lavadora(Double precioBase, Double peso) {
        super(precioBase, peso);
        this.carga = CARGA_POR_DEFECTO;
    }

    public Lavadora(Double precioBase, String color, char consumoEnergetico, Double peso, Double carga) {
        super(precioBase, color, consumoEnergetico, peso);
        this.carga = carga;
    }

    public Double getCarga() {
        return carga;
    }

    public Double precionFinal() {
        Double precio = 0D;
        if (getCarga() >= CARGA_CONDICION) {
            precio = getPrecioBase() + (getPrecioBase() * PRECIO_CARGA_MAYOR_30KG);
        }
        return precio + super.precioFinal();
    }
}
