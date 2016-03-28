
public class TennisGame1 implements TennisGame {
    
    private int scoreP1 = 0;
    private int scoreP2 = 0;
    private String player1Name = "player1";
    private String player2Name = "player2";

    public TennisGame1(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }

    public void wonPoint(String playerName) {
        if (playerName == player1Name)
            scoreP1 += 1;
        else
            scoreP2 += 1;
    }

    public String getScore() {
        String score = "";
        if (scoreP1==scoreP2)
        {
            score = findNameScore(scoreP1, true);
        }
        else if (scoreP1>=4 || scoreP2>=4)
        {
            score = findWinnerOrAdvantage();
        }
        else
        {
        	score=findNameScore(scoreP1, false);
            score+="-";
            score+=findNameScore(scoreP2, false);
        }
        return score;
    }

	private String findWinnerOrAdvantage() {
		String score = scoreP1 > scoreP2 ? player1Name : player2Name;
        return ((scoreP1-scoreP2)*(scoreP1-scoreP2) == 1) ? "Advantage " + score : "Win for " + score;
	}

    /**
     * retourne le score en terme tennis
     * @param scoreNum
     * @param equality
     * @return String le score
     */
	private String findNameScore(int scoreNum, boolean equality) {
		String nameScore = "";
		String equalScore = "-All";
		switch(scoreNum)
		{
		    case 0:
		    case 1:
		    case 2:
		        nameScore=ScoreTitle.getNameFromScore(scoreNum)+( equality?equalScore:"");
		        break;
		    case 3:
		    	if(!equality){
		    		 nameScore=ScoreTitle.getNameFromScore(scoreNum);
				     break;
		    	}
		    default:
		    	nameScore=ScoreTitle.DEUCE.getTitle();
	        break;
		}
		return nameScore;
	}
}
