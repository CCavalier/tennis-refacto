
public enum ScoreTitle {

	LOVE(0, "Love"),
	FIFTEEN(1, "Fifteen"),
	THIRTY(2,"Thirty"),
	FORTY(3, "Forty"),
	DEUCE(4, "Deuce");
	
	private String title;
	private int score;

	private ScoreTitle(int score, String title){
		this.setScore(score);
		this.setTitle(title);
	}
	
	public static String getNameFromScore(int score){
		for(ScoreTitle title: ScoreTitle.values()){
			if(title.getScore()==score){
				return title.getTitle();
			}
		}
		return "";
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}
	
	
}
