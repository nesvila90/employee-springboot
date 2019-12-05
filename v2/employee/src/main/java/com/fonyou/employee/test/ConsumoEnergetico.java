package com.fonyou.employee.test;

public enum ConsumoEnergetico {

    CATEGORIA_A('A', 100000.0),
    CATEGORIA_B('B', 80000.0),
    CATEGORIA_C('C', 60000.0),
    CATEGORIA_D('D', 50000.0),
    CATEGORIA_E('E', 30000.0),
    CATEGORIA_F('F', 10000.0);


    private final char categoria;
    private final Double precio;

    ConsumoEnergetico(char categoria, Double precio) {
        this.categoria = categoria;
        this.precio = precio;
    }

    public char getCategoria() {
        return categoria;
    }

    public Double getPrecio() {
        return precio;
    }


}
