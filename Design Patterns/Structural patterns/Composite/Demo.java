package composite;

/**
 * Cliente.
 * Demonstra a estrutura de arquivos e pastas.
 */
public class Demo {
    public static void main(String[] args) {
        FileSystemComponent file1 = new File("documento.txt");
        FileSystemComponent file2 = new File("imagem.jpg");

        Directory dir1 = new Directory("Documentos");
        dir1.add(file1);
        dir1.add(file2);

        Directory dir2 = new Directory("Fotos");
        FileSystemComponent file3 = new File("vacation.png");
        dir2.add(file3);

        Directory root = new Directory("Raiz");
        root.add(dir1);
        root.add(dir2);

        root.showDetails();
    }
}
