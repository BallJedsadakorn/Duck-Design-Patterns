public class QuackEcho implements Quackable{

    Quackable duck;

    public QuackEcho (Quackable duck){

        this.duck = duck;
    }

    @Override
    public void quack() {

        //regular sound
        duck.quack();

        System.out.print("Echo: ");
        // echo sound
        duck.quack();

        // QuackCounter.numberOfQuacks = QuackCounter.getQuacks() + 1; ถ้าอยากนับจำนวน echo ด้วยให้ใช้บรรทัดนี้

    }


}
