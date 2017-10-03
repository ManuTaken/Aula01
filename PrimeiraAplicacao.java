package primeiraaplicacao;



public class PrimeiraAplicacao {



    public static void main(String[] args) {

       

//        System.out.println("Calcular as operações abaixo");

//

//        System.out.println("Declarar as Variaveis");

//

//        int a = 10;

//        int b = 20;

//

//        System.out.println("a+b=" + (a + b) + "//" + "a+a=" + (a + a) + "//" + "b-a=" + (b - a));

        

        Carro meuCarro = new Carro();

        meuCarro.setChassi("a123b");

        meuCarro.setCor("Azul");

        meuCarro.setModelo("Uno");

        

        System.out.println("chassi:"+meuCarro.getChassi()+"//"+"cor:"+meuCarro.getcor()+"//"+"modelo:"+meuCarro.getmodelo());

        

        meuCarro.setCor("Amarelo");

        

        System.out.println("chassi:"+meuCarro.getChassi()+"//"+"cor:"+meuCarro.getcor()+"//"+"modelo:"+meuCarro.getmodelo());

    }



}
