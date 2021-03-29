package study.lotto.domain;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import study.lotto.domain.type.LottoMatch;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class LottoMatchTest {

    private static Stream<Arguments> rankRewardEntry() {
        return Stream.of(
                Arguments.of(6, 2_000_000_000, false),
                Arguments.of(5, 30_000_000, true),
                Arguments.of(5, 1_500_000, false),
                Arguments.of(4, 50_000, false),
                Arguments.of(3, 5_000, false),
                Arguments.of(2, 0, false),
                Arguments.of(1, 0, false),
                Arguments.of(0, 0, false)
        );
    }

    @ParameterizedTest(name = "{0} 개 숫자 맞추고 보너스 숫자 {2} 경우 당첨금 {1} 원 테스트")
    @MethodSource(value = "rankRewardEntry")
    void enumOf_숫자_매칭_및_당첨금_확인_테스트(long given, long expected, boolean bonus) {
        // given
        LottoMatch rank = LottoMatch.of(given, bonus);
        // when
        long won = rank.getWinningReward();
        // then
        assertThat(won).isEqualTo(expected);
    }

    private static Stream<Arguments> lottoMatchEntry() {
        return Stream.of(
                Arguments.of(LottoMatch.RANK_FIRST, 2_000_000_000, false),
                Arguments.of(LottoMatch.RANK_BONUS, 30_000_000, true),
                Arguments.of(LottoMatch.RANK_SECOND, 1_500_000, false),
                Arguments.of(LottoMatch.RANK_THIRD, 50_000, false),
                Arguments.of(LottoMatch.RANK_FOURTH, 5_000, false)
        );
    }
    @ParameterizedTest(name = "{0} 타입 enum에 존재하는지 확인 테스트")
    @MethodSource(value = "lottoMatchEntry")
    void name(LottoMatch given) {
        // given
        // when
        List<LottoMatch> all = LottoMatch.all();
        // then
        assertThat(all).contains(given);
    }

    @ParameterizedTest(name = "{0} 개 숫자 중 {1}개 매칭 보너스 숫자 {2} reward 확인 테스트")
    @MethodSource(value = "lottoMatchEntry")
    void test(LottoMatch given, long expected, boolean hasBonus) {
        // given
        long lGiven = Long.parseLong(given.toString());
        // when
        long winningReward = LottoMatch.of(lGiven, hasBonus).getWinningReward();
        // then
        assertThat(winningReward).isEqualTo(expected);
    }
}