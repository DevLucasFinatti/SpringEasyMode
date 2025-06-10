package chain_of_responsibility;

/**
 * Handler abstrato que define a interface para processamento e o próximo da cadeia.
 */
public abstract class Handler {
    protected Handler next;

    public void setNext(Handler next) {
        this.next = next;
    }

    public abstract void handleRequest(int amount);
}
