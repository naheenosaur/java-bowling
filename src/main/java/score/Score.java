package score;

import java.util.List;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;

public class Score {
    public static final int MIN_SCORE = 0;
    public static final int MAX_SCORE = 10;
    private static final String SCORE_OVER_TEN = "점수는 10 점 이상이 될 수 없습니다.";
    private static final List<Score> scoreList = IntStream.rangeClosed(MIN_SCORE, MAX_SCORE).boxed()
            .map(Score::new).collect(toList());
    private int score;

    private Score(int score) {
        this.score = score;
    }

    public static Score of(int score) {
        try {
            return scoreList.get(score);
        } catch (Exception e) {
            throw new IllegalArgumentException(SCORE_OVER_TEN);
        }
    }

    public int getScore() {
        return this.score;
    }
}