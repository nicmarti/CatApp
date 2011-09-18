package controllers;

import play.mvc.*;


import models.*;

import java.util.List;


/**
 * Play! Framework sample application I wrote for fun, cause fun is important.
 * @author Nicolas Martignole
 */
public class Application extends Controller {

    /**
     * Picks two random cat and render the view.
     * The index.html uses the showCat.html tag.
     */
    public static void index() {
        Cat cat1 = Cat.randomCat();
        Cat cat2 = Cat.randomCat(cat1.id);
        render(cat1, cat2);
    }

    /**
     * This actions gets called by Ajax, when the user selects a Cat.
     * @param id is the Cat's id.
     * @param panelId is the panel to refresh.
     */
    public static void pickACat(Long id, Long panelId) {
        notFoundIfNull(id, "No valid id specified");
        notFoundIfNull(panelId, "No panel Id specified");
        Cat c = Cat.findById(id);
        notFoundIfNull(c);
        c.picked();

        // Pick another cat, not being the selecte one
        Cat newCat = Cat.randomCat(c.id);
        render(newCat, panelId);
    }


    public static void stats() {
        List<Cat> cats=Cat.findAll();
        render(cats);
    }
}
