package lotto;

import java.util.List;

import lotto.controller.LottoController;
import lotto.domain.LottoNumbers;
import lotto.dto.PrizeStack;
import lotto.view.ResultView;

public class Lotto {
	public static void main(String[] args) {
		LottoController controller = new LottoController();
		List<LottoNumbers> lottoNumbers = controller.buyLotto();
		ResultView.printPurchasedLotto(lottoNumbers);
		LottoNumbers winningNumbers = controller.inputWinnings();
		PrizeStack prizeStack = controller.calculatedResult(winningNumbers, lottoNumbers);
		ResultView.printLottoResult(prizeStack);

	}
}