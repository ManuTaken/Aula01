import java.util.Scanner;



public class MaiorNumero {



    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Digite o primeiro valor :");

        int n1 = sc.nextInt();

        System.out.println("Digite o segundo valor :");

        int n2 = sc.nextInt();

        if (n1 > n2) {

            System.out.println("O maior valor é " + n1);

        }

        if (n1 < n2) {

            System.out.println("O maior valor é " + n2);

        } if(n1==n2){

            System.out.println("Os Valores são iguais ");

        }



    }



}
