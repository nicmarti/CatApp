package models;

import play.db.jpa.Model;

import javax.persistence.Entity;
import java.util.Random;

@Entity
public class Cat extends Model {
    public String url;
    public Integer picked;

    public void picked() {
        if (picked == null) picked = 0;
        picked++;
        save();
    }

    public static Cat randomCat() {
        return randomCat(null);
    }

    public static Cat randomCat(Long id) {
        long count = Cat.count();
        Random random = new Random();
        int number = random.nextInt((int) count)+1;

        if(id!=null){
            while (number == id.intValue()) {
                number = random.nextInt((int) count)+1;
            }
        }
        Cat cat = Cat.findById(new Long(number));
        return cat;
    }
}
