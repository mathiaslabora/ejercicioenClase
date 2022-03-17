package reactividadJava;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.function.Predicate;

class Factura {
    String descripcion;
    int precio;
    int cantidad;
    LocalDate fecha;
    String codigo;

    Factura(String descripcion, int precio, int cantidad, LocalDate fecha, String codigo) {
        this.descripcion = descripcion;
        this.precio = precio;
        this.cantidad = cantidad;
        this.fecha = fecha;
        this.codigo = codigo;
    }

    String getDescripcion() {
        return descripcion;
    }

    int getImporte() {
        return precio;
    }

    int getCantidad() {
        return cantidad;
    }

    LocalDate getFecha() {
        return fecha;
    }

    String getCodigo() {
        return codigo;
    }
}


public class JavaApp {


    public static void main(String[] args) {

        Factura f = new Factura("Ordenador", 1200, 15, LocalDate.of(2019, 03, 04), "a1");
        Factura f2 = new Factura("Movil", 300, 42, LocalDate.of(2020, 03, 24), "a3");
        Factura f3 = new Factura("Impresora", 450, 20, LocalDate.of(2020, 10, 31), "a4");
        Factura f4 = new Factura("Imac", 860, 24, LocalDate.of(2020, 04, 15), "a5");

        List<Factura> lista = new ArrayList<Factura>();

        lista.add(f);
        lista.add(f2);
        lista.add(f3);
        lista.add(f4);

        Predicate<Factura> predicado = new Predicate<Factura>() {
            @Override
            public boolean test(Factura t) {
                System.out.println("Iteracion");
                return t.getImporte() > 300;
            }
        };

        Predicate<Factura> predicado1 = new Predicate<Factura>() {
            @Override
            public boolean test(Factura t) {
                System.out.println("Iteracion");
                return t.getImporte() == 300;
            }
        };

        Predicate<Factura> predicado2 = new Predicate<Factura>() {
            @Override
            public boolean test(Factura t) {
                System.out.println("CANT");
                return t.getCantidad() > 20;
            }
        };
       /* Factura facturaFiltro = lista.stream()
                .filter(elemento -> elemento.getImporte()>300)
                .findFirst()
                .get();
        System.out.println(facturaFiltro.getImporte());
*/


        Predicate<Factura> predicado3 = new Predicate<Factura>() {
            @Override
            public boolean test(Factura t) {
                System.out.println("fecha");
                //return t.getFecha().before(new Date(20,05,13));
                return t.getFecha().isAfter(LocalDate.of(2020, 03, 24));
            }
        };

        Predicate<Factura> predicado4 = new Predicate<Factura>() {
            @Override
            public boolean test(Factura t) {
                System.out.println("fecha");
                //return t.getFecha().before(new Date(20,05,13));
                return t.getFecha().isBefore(LocalDate.of(2020, 02, 24));
            }
        };

        Predicate<Factura> predicado5 = new Predicate<Factura>() {
            @Override
            public boolean test(Factura t) {
                System.out.println("cantidad");
                //return t.getFecha().before(new Date(20,05,13));
                return t.getCantidad() < 20;
            }
        };

        Predicate<Factura> predicado6 = new Predicate<Factura>() {
            @Override
            public boolean test(Factura t) {
                System.out.println("cantidad");
                //return t.getFecha().before(new Date(20,05,13));
                return t.getCantidad() == 20;
            }
        };

        Factura facturaFiltro = lista.stream()
                .filter(predicado).findFirst().get();

        System.out.println("Factura Unica " + facturaFiltro.getImporte() + "Factura: " + facturaFiltro.getCodigo());

        Factura facturaFiltro1 = lista.stream()
                .filter(predicado1).findFirst().get();
        System.out.println("Factura segun cantidad " + facturaFiltro1.getImporte() + "Factura: " + facturaFiltro1.getCodigo());

        Factura facturaFiltro2 = lista.stream()
                .filter(predicado2).findFirst().get();
        System.out.println("Factura por cantidad mayor a 20" + facturaFiltro2.getCantidad() + "Factura: " + facturaFiltro2.getCodigo());

        Factura facturaFiltro3 = lista.stream()
                .filter(predicado3).findFirst().get();

        System.out.println("Factura siguiente por fecha " + facturaFiltro3.getFecha() + " Factura: " + facturaFiltro3.getCodigo());

        Factura facturaFiltro4 = lista.stream()
                .filter(predicado4).findFirst().get();

        System.out.println("Factura anterior por fecha " + facturaFiltro4.getFecha() + " Factura: " + facturaFiltro4.getCodigo());

        Factura facturaFiltro5 = lista.stream()
                .filter(predicado5).findFirst().get();

        System.out.println("Factura segun cantidad menor a 20  cantidad:" + facturaFiltro5.getCantidad() + " Factura: " + facturaFiltro5.getCodigo());

        Factura facturaFiltro6 = lista.stream()
                .filter(predicado6).findFirst().get();

        System.out.println("Factura segun cantidad menor a 20  cantidad:" + facturaFiltro6.getCantidad() + " Factura: " + facturaFiltro6.getCodigo());

    }
}
