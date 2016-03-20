package br.com.glmiyamoto.vendasdemo.controllers;

import android.content.Context;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import br.com.glmiyamoto.vendasdemo.model.Item;
import br.com.glmiyamoto.vendasdemo.model.Message;
import br.com.glmiyamoto.vendasdemo.model.User;

/**
 * Created by Gustavo on 2016/03/20.
 */
public final class UserController {

    private static UserController mInstance;

    public static UserController getInstance() {
        synchronized (UserController.class) {
            if (mInstance == null) {
                mInstance = new UserController();
            }

            return mInstance;
        }
    }

    private UserController() {
        // Avoid instance
    }

    public User getAppUser() {
        final User user = getUserById(1);
        user.setBalance(2562.29f);
        user.setSales(SalesController.getInstance().getSales());
        user.setMessages(MessageController.getInstance().getMessages());
        return user;
    }

    public User getUserById(final int id) {
        return getUsers().get(id - 1);
    }

    public List<User> getUsers() {
        int id = 1;
        return Arrays.asList(new User[]{
                new User(id++, "Gustavo Miyamoto", "gmiyamoto@vendasdemo.com.br", ""),
                new User(id++, "José Augusto", "jose.augusto@vendasdemo.com.br", null),
                new User(id++, "Pedro Ramos", "pedro.ramos@vendasdemo.com.br", null),
                new User(id++, "Leonardo Oliveira", "leonardo.oliveira@vendasdemo.com.br", ""),
                new User(id++, "Paula Silva", "paula.silva@vendasdemo.com.br", null),
                new User(id++, "Lucas Costa", "lucas.costa@vendasdemo.com.br", null),
                new User(id++, "Lucia Motta", "lucia.motta@vendasdemo.com.br", null),
                new User(id++, "Felipe Neto", "felipe.neto@vendasdemo.com.br", ""),
                new User(id++, "Andreia Oliveira", "andreia.oliveira@vendasdemo.com.br", null),
                new User(id++, "Veronia Souza", "veronica.souza@vendasdemo.com.br", null),
                new User(id++, "Marcos Silva", "marcos.silva@vendasdemo.com.br", ""),
                new User(id++, "Monica Vasconcelos", "monica.vasconcelos@vendasdemo.com.br", null),
                new User(id++, "David Mattos", "david.mattos@vendasdemo.com.br", null),
                new User(id++, "Rogerio Santos", "rogerio.santos@vendasdemo.com.br", ""),
                new User(id++, "Magali Ramos", "magali.ramos@vendasdemo.com.br", null),
                new User(id++, "Maria Cavalcante", "maria.cavalcante@vendasdemo.com.br", null),
                new User(id++, "Erica dos Santos", "erica.santos@vendasdemo.com.br", null),
                new User(id++, "Daniel Gontijo", "daniel.gontijo@vendasdemo.com.br", ""),
                new User(id++, "Gabriel Oliveira", "gabriel.oliveira@vendasdemo.com.br", null)
        });
    }
}
