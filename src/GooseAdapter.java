public class GooseAdapter implements Quackable {

    //Make Goose able to use with Quackable

    Goose goose;

    public GooseAdapter(Goose goose){
        this.goose = goose;
    }

    @Override
    public void quack() {
        goose.honk();
    }
}
