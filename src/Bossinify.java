import java.util.ArrayList;
import java.util.Scanner;
import java.util.Collections;

public class Bossinify {

    public static void main(String[] args) {
        var musicas = new ArrayList<Musica>();
        var leitor = new Scanner(System.in);
        var menu = "1-Cadastrar\n2-Ver todas (ordenado por nome)\n3-Ver todas (ordenado pro comprimento do titulo)\n4-Avaliar\n0-Sair";
        int op;
        do {
            do {
                System.out.println(menu);
                op = leitor.nextInt();
            } while (op < 0 || op > 3);
            switch (op) {
                case 1: {
                    System.out.println("Título:");
                    leitor.nextLine();
                    var titulo = leitor.nextLine();
                    musicas.add(new Musica(titulo));
                    System.out.println("Música cadastrada!");
                    break;
                }
                case 2: {
                    Collections.sort(musicas);
                    System.out.println(musicas);
                    break;
                }
                case 3: {
                    Collections.sort(
                        musicas, 
                        new ComprimentoDoTituloComparator(false)
                    );
                    System.out.println(musicas);
                    break;
                }
                case 0: {
                    System.out.println("Até logo");
                    break;
                }
            }
        } while (op != 0);
    }
}