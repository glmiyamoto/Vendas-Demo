package br.com.glmiyamoto.vendasdemo.controllers;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Random;

import br.com.glmiyamoto.vendasdemo.model.Item;

/**
 * Created by Gustavo on 2016/03/20.
 */
public class SalesController {

    private static SalesController mInstance;

    public static SalesController getInstance() {
        synchronized (SalesController.class) {
            if (mInstance == null) {
                mInstance = new SalesController();
            }

            return mInstance;
        }
    }

    private SalesController() {
        // Avoid instance
    }

    /**
     * Return all registered sales item
     * @return
     */
    public List<Item> getSales() {
        int id = 1;
        return Arrays.asList(new Item[]{
                new Item(id++, randomName(), randomValue(), new Date(), true),
                new Item(id++, randomName(), randomValue(), new Date(), false),
                new Item(id++, randomName(), randomValue(), new Date(), true),
                new Item(id++, randomName(), randomValue(), new Date(), false),
                new Item(id++, randomName(), randomValue(), new Date(), false),
                new Item(id++, randomName(), randomValue(), new Date(), false),
                new Item(id++, randomName(), randomValue(), new Date(), false),
                new Item(id++, randomName(), randomValue(), new Date(), true),
                new Item(id++, randomName(), randomValue(), new Date(), true),
                new Item(id++, randomName(), randomValue(), new Date(), false),
                new Item(id++, randomName(), randomValue(), new Date(), false),
                new Item(id++, randomName(), randomValue(), new Date(), false),
                new Item(id++, randomName(), randomValue(), new Date(), false),
                new Item(id++, randomName(), randomValue(), new Date(), true),
                new Item(id++, randomName(), randomValue(), new Date(), false)
        });
    }

    /**
     * Generate sales item name randomly
     * @return
     */
    private String randomName() {
        final List<String> names = Arrays.asList(new String[] {
                "Como decorar uma festa infantil maravilhosa com muitas cores variadas para alegrar e animar as criaças.",
                "Todo dia é dia de aprender algo novo. Esse aprendizado ou reflexão pode ser através de uma mensagem.",
                "Segurança, conforto, estabilidade. Tudo que uma mulher procura em um homem e um homem procura em um carro.",
                "Teste de minhas vendas... Teste teste teste teste... Teste..."
        });

        final Random random = new Random();
        return names.get(random.nextInt(names.size()));
    }

    /**
     * Generate sales item value randomly
     * @return
     */
    private float randomValue() {
        final Random random = new Random();
        return random.nextInt(10000) + 1000;
    }
}
