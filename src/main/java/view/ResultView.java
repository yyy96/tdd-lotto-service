package view;

import domain.Rank;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

public class ResultView {
    private static final String MESSAGE_LOTTO_COUNT = "개를 구매했습니다";
    private static final String MESSAGE_STATISTIC = "당첨 통계";
    private static final String MESSAGE_STATISTIC_LINE = "---------";
    private static final String MESSAGE_MATCH_IS = "개 일치";
    private static final String MESSAGE_WON = "원";
    private static final String MESSAGE_BONUS_MATCH = ", 보너스 볼 일치";
    private static final String MESSAGE_MATCH_COUNT = "개";
    private static final String MESSAGE_RATIO_RESULT = "총 수익률은 ";
    private static final String MESSAGE_RATIO_RESULT_END = "입니다.";

    public void printLottoCount(int lottoCount) {
        System.out.println(lottoCount + MESSAGE_LOTTO_COUNT);
    }

    public void printAllLotto(List<Integer> lotto) {
        System.out.println(lotto);
    }

    public void printResultStatistic(Map<Rank, Integer> lottoResult) {
        System.out.println("\n" + MESSAGE_STATISTIC + "\n" + MESSAGE_STATISTIC_LINE);

        for (Rank rank : Rank.values()) {
            printRank(rank, lottoResult);
        }
    }

    public void printRank(Rank rank, Map<Rank, Integer> lottoResult) {
        if (rank == Rank.FAIL) {
            return;
        } else if (rank == Rank.SECOND) {
            System.out.println(rank.getMathCount() + MESSAGE_MATCH_IS + MESSAGE_BONUS_MATCH
                    + " (" + rank.getPrize() + MESSAGE_WON + ")- "
                    + lottoResult.getOrDefault(rank, 0) + MESSAGE_MATCH_COUNT);
            return;
        }
        System.out.println(rank.getMathCount() + MESSAGE_MATCH_IS
                + " (" + rank.getPrize() + MESSAGE_WON + ")- "
                + lottoResult.getOrDefault(rank, 0) + MESSAGE_MATCH_COUNT);
    }

    public void printResultRatio(BigDecimal prizeRatio) {
        System.out.println(MESSAGE_RATIO_RESULT + prizeRatio + MESSAGE_RATIO_RESULT_END);
    }
}
