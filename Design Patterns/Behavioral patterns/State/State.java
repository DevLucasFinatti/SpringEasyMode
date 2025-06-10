package state;

/**
 * Interface comum para todos os estados.
 */
public interface State {
    void handle(Context context);
}
