package com.fonyou.employee.test;

public enum RangoPeso {

    RANGO_0_19(0D,19D, 10000D),
    RANGO_20_49(20D, 49d, 50000D),
    RANGO_50_79(50D,79D, 80000D),
    RANGO_MAYOR_80(80D,100000D);

    private final Double pesoInicial;
    private final Double pesoFinal;
    private final Double precioRango;

    RangoPeso(Double pesoInicial, Double precioRango) {
        this.pesoFinal = 81D;
        this.pesoInicial = pesoInicial;
        this.precioRango = precioRango;
    }

    RangoPeso(Double pesoInicial, Double pesoFinal, Double precioRango) {
        this.pesoInicial = pesoInicial;
        this.pesoFinal = pesoFinal;
        this.precioRango = precioRango;
    }

    public Double getPesoInicial() {
        return pesoInicial;
    }

    public Double getPesoFinal() {
        return pesoFinal;
    }

    public Double getPrecioRango() {
        return precioRango;
    }
}
