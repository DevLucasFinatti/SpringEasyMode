package prototype;

/**
 * Implementação concreta do Prototype.
 * Representa um documento que pode ser clonado.
 */
public class Document implements Prototype {
    private String title;
    private String content;

    public Document(String title, String content) {
        this.title = title;
        this.content = content;
    }

    // Getters e Setters
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    // Método de clonagem
    @Override
    public Prototype clone() {
        return new Document(title, content);
    }

    public void print() {
        System.out.println("Title: " + title);
        System.out.println("Content: " + content);
    }
}
