package proxy;

/**
 * Cliente que usa o Proxy.
 */
public class Client {
    public static void main(String[] args) {
        Image image = new ImageProxy("foto_grande.jpg");

        // A imagem ainda não foi carregada do disco
        System.out.println("Imagem criada, mas não carregada ainda.");

        // Agora, o RealImage é carregado e mostrado só na primeira chamada
        image.display();

        // Segunda chamada não recarrega a imagem
        image.display();
    }
}
