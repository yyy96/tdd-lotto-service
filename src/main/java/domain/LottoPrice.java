package domain;

public class LottoPrice {
    public static final String MESSAGE_LACK_OF_PRICE = "[오류] 금액은 음수가 될 수 없습니다.";
    private static final int LOTTO_PRICE = 1_000;
    private final int purchasePrice;
    private int manualLottoCount;

    public LottoPrice(int purchasePrice) {
        checkPriceRange(purchasePrice);
        this.purchasePrice = purchasePrice;
    }

    public int getPurchasePrice() {
        return purchasePrice;
    }

    public int getManualLottoCount() {
        return manualLottoCount;
    }

    public int getAutoLottoCount() {
        return (purchasePrice - (LOTTO_PRICE * manualLottoCount)) / LOTTO_PRICE;
    }

    public int manualLottoCount(int count) {
        this.manualLottoCount = count;
        return count;
    }

    private void checkPriceRange(int purchasePrice) {
        if (purchasePrice < 0) {
            throw new IllegalArgumentException(MESSAGE_LACK_OF_PRICE);
        }
    }
}
