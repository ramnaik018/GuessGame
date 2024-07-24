import java.util.Scanner;
public class Player {
    public Player(){
    }

    public int guessNumPla(){
        Scanner sc=new Scanner(System.in);
        System.out.println("Please choose a number between 0 - 9 :" );
        return sc.nextInt();
    }
}
