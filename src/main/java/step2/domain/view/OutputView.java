package step2.domain.view;

import step2.domain.LottoMatchingCount;
import step2.domain.LottoResult;
import step2.domain.LottoTicket;
import step2.domain.LottoNumbers;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

public class OutputView {

    public void viewLottoNumbers(LottoTicket lottoTicket) {
        System.out.println(lottoTicket.getLottoNumbersList().size() + "개를 구매했습니다.");
        lottoTicket.getLottoNumbersList()
                .stream()
                .map(LottoNumbers::getLottoNumbers)
                .collect(Collectors.toList())
                .forEach(System.out::println);
    }

    public void viewResult(LottoResult lottoResult, String lottoMoney) {
        Arrays.stream(LottoMatchingCount.values())
                .limit(LottoMatchingCount.values().length - 1)
                .forEach(enumList -> System.out.format("%d 개 일치 (%s)원 - %d개\n", enumList.getCount(), enumList.getMoney(), Math.toIntExact(lottoResult.getResultMap().getOrDefault(enumList.getCount(), 0L))));

        System.out.println("총 수익률은" + lottoResult.getMargin(lottoMoney) + "입니다.");
    }
}