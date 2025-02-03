import java.io.IOException;
import java.util.Scanner;

public class AppProcesos {

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

    public void abrirBloc() {
        try {
            new ProcessBuilder("notepad").start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void abrirTerminal() {
        String sistema = System.getProperty("os.name").toLowerCase();
        try {
            if (sistema.contains("win")) {
                new ProcessBuilder("cmd", "/c", "start").start();
            } else if (sistema.contains("mac")) {
                new ProcessBuilder("open", "-a", "Terminal").start();
            } else if (sistema.contains("nux")) {
                new ProcessBuilder("x-terminal-emulator").start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public ProcessBuilder navegar(String url){
       return new ProcessBuilder("cmd", "/c", "start", "chrome", url);
    }

    public void abrirGoolgle() {
        String sistema = System.getProperty("os.name").toLowerCase();
        boolean repetir = true;
        while (repetir) {
            try {
                if (sistema.contains("win")) {
                    System.out.println("""
                            Qué página quieres visitar: 
                            1 -> NASA.
                            2 -> Logros de Einstein.
                            3 -> Wikipedia Metafísica.
                            4 -> Mujeres en la ciencia.
                            5 -> Otro.
                            6 -> Salir.
                            """);

                    int num = new Scanner(System.in).nextInt();

                    switch (num) {
                        case 1 -> navegar("https://www.nasa.gov/").start();
                        case 2 ->
                                navegar("https://lafabricadeinventos.com/blog/los-inventos-de-albert-einstein-que-cambiaron-el-mundo/").start();
                        case 3 -> navegar("https://es.wikipedia.org/wiki/Metaf%C3%ADsica").start();
                        case 4 ->
                                navegar("https://mujeresconciencia.com/2016/03/28/women-in-science-50-fearless-pioneers-who-changed-the-world/").start();
                        case 5 -> {
                            System.out.println("Introduce lo que quiera buscar: ");
                            String pagina = new Scanner(System.in).nextLine();
                            navegar("https://www.google.com/search?q=" + pagina).start();
                        }
                        case 6 -> repetir = false;
                    }

                } else if (sistema.contains("mac")) {
                    new ProcessBuilder("open", "-a", "Google Chrome", "https://www.google.com").start();
                } else if (sistema.contains("nux")) {
                    new ProcessBuilder("google-chrome", "https://www.google.com").start();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}