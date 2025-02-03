import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        AppProcesos app = new AppProcesos();
        boolean repetir = true;

        while(repetir) {
            try {
                System.out.println("""
                        Elige que aplicación quieres abrir:
                        1 -> Terminal.
                        2 -> Bloc de notas.
                        3 -> Google.
                        4 -> Salir.
                        """);

                String eleccion = new Scanner(System.in).nextLine();
                int eleccionNumero = Integer.parseInt(eleccion);
                switch (eleccionNumero) {
                    case 1 -> app.abrirTerminal();
                    case 2 -> app.abrirBloc();
                    case 3 -> app.abrirGoolgle();
                    case 4 -> {
                        repetir = false;
                        System.out.println("Gracias por usar el programa ;P");
                    }
                }

            } catch (NumberFormatException n) {
                System.out.println("El número introducido no es correcto");
            }
        }

    }

}

