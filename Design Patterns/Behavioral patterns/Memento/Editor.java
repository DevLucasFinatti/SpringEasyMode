package memento;

/**
 * Originator que cria e restaura estados.
 */
public class Editor {
    private String content;

    public void setContent(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    /**
     * Cria um memento com o estado atual.
     */
    public Memento save() {
        return new Memento(content);
    }

    /**
     * Restaura o estado a partir de um memento.
     */
    public void restore(Memento memento) {
        content = memento.getState();
    }
}
