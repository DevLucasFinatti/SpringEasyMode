package mediator;

import java.util.ArrayList;
import java.util.List;

/**
 * Mediator concreto que gerencia a comunicação entre usuários.
 */
public class ChatMediator implements Mediator {
    private List<User> users;

    public ChatMediator() {
        users = new ArrayList<>();
    }

    @Override
    public void sendMessage(String message, User user) {
        for (User u : users) {
            // Não envia para o usuário que enviou a mensagem
            if (u != user) {
                u.receive(message);
            }
        }
    }

    @Override
    public void addUser(User user) {
        users.add(user);
    }
}
