public class PigeonAdapter implements Quackable {

    //Make Pigeon able to use with Quackable

    Pigeon pigeon;

    @Override
    public void quack() {

        pigeon.coo();
        pigeon.coo();
        //1 Quack = 2 Coo
    }

    public PigeonAdapter(Pigeon pigeon){
        this.pigeon = pigeon;
    }

}
