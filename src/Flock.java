import java.util.ArrayList;
import java.util.Iterator;

public class Flock implements Quackable {

    ArrayList <Quackable> quackers = new ArrayList <>();

    public void add(Quackable quacker) {

        quackers.add(quacker);

    }

    public void quack() {
        if (!quackers.isEmpty()) {

            Quackable firstQuacker = quackers.get(0);

            for (Quackable quacker : quackers) {
                if (quacker == firstQuacker) {
                    quacker.quack();
                    quacker.quack();
                    quacker.quack();
                } else {
                    quacker.quack();
                }
            }
        }
    }
}
