package br.com.glmiyamoto.vendasdemo.controllers;

import java.util.Arrays;
import java.util.List;

import br.com.glmiyamoto.vendasdemo.model.Message;

/**
 * Created by Gustavo on 2016/03/20.
 */
public class MessageController {

    private static MessageController mInstance;

    public static MessageController getInstance() {
        synchronized (MessageController.class) {
            if (mInstance == null) {
                mInstance = new MessageController();
            }

            return mInstance;
        }
    }

    private MessageController() {
        // Avoid instance
    }

    /**
     * Return all registered messages
     * @return
     */
    public List<Message> getMessages() {
        final UserController userCtrl = UserController.getInstance();
        int id = 1;
        return Arrays.asList(new Message[]{
                new Message(id++, userCtrl.getUserById(2), false),
                new Message(id++, userCtrl.getUserById(16), false),
                new Message(id++, userCtrl.getUserById(4), false),
                new Message(id++, userCtrl.getUserById(8), false),
                new Message(id++, userCtrl.getUserById(5), false),
                new Message(id++, userCtrl.getUserById(11), false),
                new Message(id++, userCtrl.getUserById(13), false),
                new Message(id++, userCtrl.getUserById(9), false),
                new Message(id++, userCtrl.getUserById(10), false),
                new Message(id++, userCtrl.getUserById(12), false),
                new Message(id++, userCtrl.getUserById(6), false),
                new Message(id++, userCtrl.getUserById(7), false),
                new Message(id++, userCtrl.getUserById(14), false),
                new Message(id++, userCtrl.getUserById(15), false),
                new Message(id++, userCtrl.getUserById(17), false),
                new Message(id++, userCtrl.getUserById(3), false),
                new Message(id++, userCtrl.getUserById(18), false)
        });
    }
}
