# Aula01


public class CamaroteSuperior extends Vip {

    

   String localizacao="Camarote Superior";

   float taxa=25;

   float camSup;



    public String getLocalizacao() {

        return localizacao;

    }



    public void setLocalizacao(String localizacao) {

        this.localizacao = localizacao;

    }



    public float getCamSup() {

        return camSup;

    }



    public void setCamSup(float camSup) {

        this.camSup = camSup;

    }

   

    

    public void camaroteSup()

    {

        this.camSup= taxa + valor + adicional;

            

        System.out.println("Valor do ingresso: R$"+camSup);

        System.out.println("Localização do seu Ingresso: "+ localizacao);

    }

        

    

    

    

}
