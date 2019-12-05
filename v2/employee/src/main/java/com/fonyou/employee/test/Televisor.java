package com.fonyou.employee.test;

public class Televisor extends Electrodomestico {

    private static final double PRECIO_ADICIONAL_TDT_POR_DEFECTO = 50000D;
    private static final double RESOLUCION_POR_DEFECTO = 40D;
    private static final double PRECIO_RESOLUCION_MAYOR_40_PULGADAS = 0.30D;
    private static final boolean SINTONIZADOR_TDT_POR_DEFECTO = false;

    private Resolucion resolucion;
    private Boolean sintonizadorTdt;

    public Televisor() {
        this.resolucion = new Resolucion(RESOLUCION_POR_DEFECTO);
        this.sintonizadorTdt = SINTONIZADOR_TDT_POR_DEFECTO;
    }

    public Televisor(Double precioBase, Double peso) {
        super(precioBase, peso);
        this.resolucion = new Resolucion(RESOLUCION_POR_DEFECTO);
        this.sintonizadorTdt = SINTONIZADOR_TDT_POR_DEFECTO;
    }

    public Televisor(Double precioBase, String color, char consumoEnergetico, Double peso, Double valorResolucion, Boolean sintonizadorTdt) {
        super(precioBase, color, consumoEnergetico, peso);
        this.resolucion = new Resolucion(valorResolucion);
        this.sintonizadorTdt = sintonizadorTdt;
    }

    public Resolucion getResolucion() {
        return resolucion;
    }

    public Boolean getSintonizadorTdt() {
        return sintonizadorTdt;
    }

    @Override
    public Double precioFinal() {
        Double precio = 0D;
        if (getResolucion().getValor() > RESOLUCION_POR_DEFECTO) {
            precio = getPrecioBase() + (getPrecioBase() * PRECIO_RESOLUCION_MAYOR_40_PULGADAS);
        }
        if (getSintonizadorTdt()) {
            precio = precio + PRECIO_ADICIONAL_TDT_POR_DEFECTO;
        }
        return precio + super.precioFinal();
    }

    private static class Resolucion {

        private Double valor;

        public Resolucion(Double valor) {
            this.valor = valor;
        }

        public Double getValor() {
            return valor;
        }

        public String getResolucion() {
            return new StringBuilder().append(valor).append(" ").append(Medida.PULGADAS.name()).toString();
        }

        private enum Medida {
            PULGADAS;
        }
    }


}
