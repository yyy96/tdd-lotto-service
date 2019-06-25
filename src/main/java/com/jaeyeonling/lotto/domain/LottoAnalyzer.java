package com.jaeyeonling.lotto.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoAnalyzer {

    private static final int DEFAULT_MATCH_COUNT = 0;
    private static final int INCREMENT_MATCH_COUNT = 1;

    private final WinningLotto winningLotto;

    public LottoAnalyzer(final WinningLotto winningLotto) {
        this.winningLotto = winningLotto;
    }

    public LottoGameReport analyze(final List<Lotto> lottos) {
        return new LottoGameReport(countOfEachLottoPrizeByLottos(lottos));
    }

    private Map<LottoPrize, Integer> countOfEachLottoPrizeByLottos(final List<Lotto> lottos) {
        final Map<LottoPrize, Integer> countOfEachLottoPrize = new HashMap<>();
        for (final Lotto lotto : lottos) {
            final LottoPrize prize = winningLotto.match(lotto);
            countLottoPrize(countOfEachLottoPrize, prize);
        }

        return countOfEachLottoPrize;
    }

    private void countLottoPrize(final Map<LottoPrize, Integer> countOfEachLottoPrize,
                                 final LottoPrize prize) {
        final int currentMatchCount = countOfEachLottoPrize.getOrDefault(prize, DEFAULT_MATCH_COUNT);
        countOfEachLottoPrize.put(prize, currentMatchCount + INCREMENT_MATCH_COUNT);
    }
}