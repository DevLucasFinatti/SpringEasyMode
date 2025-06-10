package prototype;

/**
 * Classe cliente.
 * Demonstra a clonagem de objetos usando o padrão Prototype.
 */
public class Demo {
    public static void main(String[] args) {
        Document original = new Document("Relatório", "Conteúdo confidencial.");
        System.out.println("Documento Original:");
        original.print();

        // Clonando o documento
        Document copia = (Document) original.clone();
        copia.setTitle("Cópia do Relatório");

        System.out.println("\nDocumento Clonado:");
        copia.print();
    }
}
