import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        String nomeMaisAlto = "";
        double pSum = 0.0, aFemininoSum = 0.0, maiorAltura = 0.0;

        System.out.print("Qual a quantidade de atletas? ");
        int n = sc.nextInt();

        int countMasculino = 0;
        int countFeminino = 0;
        for (int i = 1; i <= n; i++) {
            System.out.printf("Digite os dados do atleta numero: %d\n", i);
            sc.nextLine();
            System.out.print("Nome: ");
            String nome = sc.nextLine();
            System.out.print("Sexo: ");
            String sexo = sc.next();

            while (!sexo.equalsIgnoreCase("M") && !sexo.equalsIgnoreCase("F")) {
                System.out.print("Valor invalido! Favor digitar F ou M: ");
                sexo = sc.next();
            }

            System.out.print("Altura: ");
            double altura = sc.nextDouble();
            while (altura <= 0) {
                System.out.print("Valor invalido! Favor digitar um valor positivo: ");
                altura = sc.nextDouble();
            }

            System.out.print("Peso: ");
            double peso = sc.nextDouble();
            while (peso <= 0) {
                System.out.print("Valor invalido! Favor digitar um valor positivo: ");
                peso = sc.nextDouble();
            }

            if (altura > maiorAltura) {
                maiorAltura = altura;
                nomeMaisAlto = nome;
            }

            pSum += peso;

            if (sexo.equalsIgnoreCase("M")) {
                countMasculino++;
            } else {
                countFeminino++;
                aFemininoSum += altura;
            }
        }
        sc.close();

        System.out.println("\nRELATÓRIO:");
        System.out.printf("Peso médio dos atletas: %.2f\n", pSum / n);
        System.out.printf("Atleta mais alto: %s\n", nomeMaisAlto);
        System.out.printf("Porcentagem de homens: %.1f%%\n", (countMasculino / (double)n)*100);

        if (countFeminino > 0) {
            System.out.printf("Altura média das mulheres: %.2f", aFemininoSum /countFeminino);
        } else {
            System.out.println("Não há mulheres cadastradas");
        }
    }
}
