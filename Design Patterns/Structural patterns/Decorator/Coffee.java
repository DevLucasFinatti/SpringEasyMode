package decorator;

/**
 * Componente base.
 * Define a interface comum para cafés e decoradores.
 */
public interface Coffee {
    double getCost();         // custo do café
    String getDescription();  // descrição do café
}
