public class Computer {
    public Computer(){
    }

    public int guessNumCom(){
        int computerNumber=(int)(10*Math.random());
        System.out.println("Computer has choosen :"+computerNumber);
        return computerNumber;
    }
}
