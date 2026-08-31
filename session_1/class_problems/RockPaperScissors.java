import java.util.*;

class RockPaperScissors
{
    static String playRound(String playerMove, String computerMove)
    {
        if(playerMove.equalsIgnoreCase(computerMove))
        {
            return "Draw";
        }
        else if((playerMove.equalsIgnoreCase("Rock") && computerMove.equalsIgnoreCase("Scissors")) ||
                (playerMove.equalsIgnoreCase("Paper") && computerMove.equalsIgnoreCase("Rock")) ||
                (playerMove.equalsIgnoreCase("Scissors") && computerMove.equalsIgnoreCase("Paper")))
        {
            return "Player Wins";
        }
        else
        {
            return "Computer Wins";
        }
    }

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        Random random = new Random();

        String[] moves = {"Rock", "Paper", "Scissors"};

        int wins = 0;
        int losses = 0;
        int draws = 0;

        System.out.println("Round | Player Move | Computer Move | Result");

        for(int i = 1; i <= 5; i++)
        {
            System.out.print("Enter your move: ");
            String playerMove = sc.nextLine();

            String computerMove = moves[random.nextInt(3)];

            String result = playRound(playerMove, computerMove);

            System.out.println(i + "     | " + playerMove + "       | "
                               + computerMove + "      | " + result);

            if(result.equals("Player Wins"))
            {
                wins++;
            }
            else if(result.equals("Computer Wins"))
            {
                losses++;
            }
            else
            {
                draws++;
            }
        }

        double winPercentage = (wins * 100.0) / 5;

        System.out.println("\nFinal Summary");
        System.out.println("Wins: " + wins);
        System.out.println("Losses: " + losses);
        System.out.println("Draws: " + draws);
        System.out.printf("Win %% = %.1f%%", winPercentage);
    }
}