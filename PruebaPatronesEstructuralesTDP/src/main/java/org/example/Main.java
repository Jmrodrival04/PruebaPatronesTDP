package org.example;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class Main {
    private static final List<Elemento> todosElementos = new ArrayList<>();
    private static final List<KitElemento> todosKits = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input;
        double precio;
        int codigo, codigoKit;

        while (true) {
            System.out.println("Elija una opción:");
            System.out.println("1. Agregar Elemento Simple");
            System.out.println("2. Crear Kit de Elementos");
            System.out.println("3. Agregar Elemento a Kit");
            System.out.println("4. Mostrar Precio de Kit");
            System.out.println("5. Salir");
            input = scanner.nextLine();

            switch (input) {
                case "1":
                    System.out.println("Introduce el código del elemento:");
                    codigo = Integer.parseInt(scanner.nextLine());
                    System.out.println("Introduce el precio del elemento:");
                    precio = Double.parseDouble(scanner.nextLine());
                    todosElementos.add(new ElementoSimple(codigo, precio));
                    System.out.println("Elemento agregado.");
                    break;
                case "2":
                    System.out.println("Introduce el código del kit:");
                    codigoKit = Integer.parseInt(scanner.nextLine());
                    todosKits.add(new KitElemento(codigoKit, new DescuentoFijo(10)));
                    System.out.println("Kit creado.");
                    break;
                case "3":
                    System.out.println("Introduce el código del kit:");
                    final int codigoKitFinal = Integer.parseInt(scanner.nextLine());
                    System.out.println("Introduce el código del elemento a agregar:");
                    final int codigoFinal = Integer.parseInt(scanner.nextLine());
                    KitElemento kit = todosKits.stream().filter(k -> k.getCodigo() == codigoKitFinal).findFirst().orElse(null);
                    Elemento elemento = todosElementos.stream().filter(e -> e.getCodigo() == codigoFinal).findFirst().orElse(null);
                    if (kit != null && elemento != null) {
                        kit.agregarElemento(elemento);
                        System.out.println("Elemento agregado al kit.");
                    } else {
                        System.out.println("Kit o elemento no encontrado.");
                    }
                    break;
                case "4":
                    System.out.println("Introduce el código del kit para ver el precio:");
                    final int kitCodigoConsulta = Integer.parseInt(scanner.nextLine());
                    kit = todosKits.stream().filter(k -> k.getCodigo() == kitCodigoConsulta).findFirst().orElse(null);
                    if (kit != null) {
                        System.out.println("Precio del kit: $" + kit.getPrecio());
                    } else {
                        System.out.println("Kit no encontrado.");
                    }
                    break;
                case "5":
                    System.out.println("Saliendo...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Opción no válida.");
                    break;
            }
        }
    }
}
