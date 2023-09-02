public class CountingDuckFactory extends AbstractDuckFactory {

    // มีการนับจำนวนการ quack แน่นอนเนื่องจากกำหนดตั้งแต่ตอนสร้าง object

    public Quackable createMallardDuck() {
        return new QuackCounter(
                new MallardDuck()
        );
    }

    public Quackable createRedheadDuck() {
        return new QuackCounter(
                new RedheadDuck()
        );
    }

    public Quackable createDuckCall() {
        return new QuackCounter(
                new DuckCall()
        );
    }

    public Quackable createRubberDuck() {
        return new QuackCounter(
                new RubberDuck()
        );
    }
}