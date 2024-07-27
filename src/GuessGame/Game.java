package GuessGame;

public class Game {
    public static void main(String[] args){
        Computer c=new Computer();
        int computerNumber=c.guessNumCom();
        //System.out.println("GuessGame.Computer has choosen number: "+computerNumber);

        Player p=new Player();
        while(true){
            boolean flag=true;
            for(int i=1;i<=3;i++){
                int playerNumber=p.guessNumPla();
                if(playerNumber==computerNumber) {
                    System.out.println("GuessGame.Player" + i + "has won!!!");
                    flag=false;
                    break;
                }else{
                    System.out.println("Better luck in next game player"+i);
                }
            }
            if(!flag)break;
        }
    }

}
