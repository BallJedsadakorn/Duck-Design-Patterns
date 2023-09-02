public class DuckSimulator {
    public static void main(String[] args) {
        DuckSimulator simulator = new DuckSimulator();
        AbstractDuckFactory duckFactory = new CountingDuckFactory();
        CountingDuckFactory duckFactory1 = new CountingDuckFactory();
        CountingEchoDuckFactory duckFactory2 = new CountingEchoDuckFactory();
        simulator.simulate1(duckFactory);
        //simulator.simulate();
    }

    void simulate() {

        Quackable mallardDuck = new QuackCounter(new MallardDuck());
        Quackable redheadDuck = new QuackCounter(new RedheadDuck());
        Quackable duckCall = new QuackCounter(new DuckCall());
        Quackable rubberDuck = new QuackCounter(new RubberDuck());
        Quackable goose = new GooseAdapter(new Goose());
        Quackable pigeon = new PigeonAdapter(new Pigeon());

        Quackable mallardDuck1 = new QuackCounter(new QuackEcho(new MallardDuck()));
        Quackable redheadDuck1 = new QuackCounter(new QuackEcho(new RedheadDuck()));
        Quackable duckCall1 = new QuackCounter(new QuackEcho(new DuckCall()));
        Quackable rubberDuck1 = new QuackCounter(new QuackEcho(new RubberDuck()));

        System.out.println("\nDuck Simulator");
        simulate(mallardDuck);
        simulate(redheadDuck);
        simulate(duckCall);
        simulate(rubberDuck);
        System.out.println("========================================");
        simulate(mallardDuck1);
        simulate(redheadDuck1);
        simulate(duckCall1);
        simulate(rubberDuck1);

        System.out.println("The ducks quacked " +
                QuackCounter.getQuacks() + " times");
        System.out.println("\nGoose Simulator");
        simulate(goose);
        System.out.println("\nPigeon Simulator");
        simulate(pigeon);

    }

    void simulate(Quackable duck) {
        duck.quack();
    }

    void simulate(CountingEchoDuckFactory duckFactory) {

        // DuckFactory จะมีการสร้าง Duck เพียงอย่างเดียว ไม่มีการนับจำนวน Quack
        // CountingFactory จะมีการสร้าง Duck, นับ Quack แต่ไม่มี echo
        // CountingEchoDuckFactory จะมีการสร้าง Duck, นับ Quack,มีการ echo แต่ไม่ได้ถูกนับจำนวน
        // ถ้าอยากให้นับจำนวน echo ด้วย ให้เพิ่ม QuackCounter.numberOfQuacks = QuackCounter.getQuacks() + 1;
        // ใน QuackEcho

        Quackable mallardDuck = duckFactory.createMallardDuck();
        Quackable redheadDuck = duckFactory.createRedheadDuck();
        Quackable duckCall = duckFactory.createDuckCall();
        Quackable rubberDuck = duckFactory.createRubberDuck();
        Quackable gooseDuck = new GooseAdapter(new Goose());
        System.out.println("\nDuck Simulator: With Abstract Factory");
        simulate(mallardDuck);
        simulate(redheadDuck);
        simulate(duckCall);
        simulate(rubberDuck);
        simulate(gooseDuck);
        System.out.println("The ducks quacked " +
                QuackCounter.getQuacks() + " times");
    }



        void simulate1(AbstractDuckFactory duckFactory) {
            Quackable redheadDuck = duckFactory.createRedheadDuck();
            Quackable duckCall = duckFactory.createDuckCall();
            Quackable rubberDuck = duckFactory.createRubberDuck();
            Quackable gooseDuck = new GooseAdapter(new Goose());
            System.out.println("\nDuck Simulator: With Composite - Flocks");
            Flock flockOfDucks = new Flock();
            flockOfDucks.add(redheadDuck);
            flockOfDucks.add(duckCall);
            flockOfDucks.add(rubberDuck);
            flockOfDucks.add(gooseDuck);
            Flock flockOfMallards = new Flock();
            Quackable mallardOne = duckFactory.createMallardDuck();
            Quackable mallardTwo = duckFactory.createMallardDuck();
            Quackable mallardThree = duckFactory.createMallardDuck();
            Quackable mallardFour = duckFactory.createMallardDuck();
            flockOfMallards.add(mallardOne); // Quack 3 times   
            flockOfMallards.add(mallardTwo);
            flockOfMallards.add(mallardThree);
            flockOfMallards.add(mallardFour);
            flockOfDucks.add(flockOfMallards);
            System.out.println("\nDuck Simulator: Whole Flock Simulation");
            simulate(flockOfDucks);
            System.out.println("“\nDuck Simulator: Mallard Flock Simulation”");
            simulate(flockOfMallards);
            System.out.println("\nThe ducks quacked " +
                    QuackCounter.getQuacks() + " times");
        }

}