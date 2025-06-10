package mediator;

/**
 * Cliente que demonstra o uso do padrão Mediator com o chat.
 */
public class Client {
    public static void main(String[] args) {
        Mediator chatMediator = new ChatMediator();

        User user1 = new ConcreteUser(chatMediator, "Alice");
        User user2 = new ConcreteUser(chatMediator, "Bob");
        User user3 = new ConcreteUser(chatMediator, "Charlie");

        chatMediator.addUser(user1);
        chatMediator.addUser(user2);
        chatMediator.addUser(user3);

        user1.send("Olá pessoal!");
        user2.send("Oi Alice!");
        user3.send("E aí, pessoal?");
    }
}
