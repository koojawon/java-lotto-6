package model;

import camp.nextstep.edu.missionutils.Randoms;
import enums.WinType;
import java.util.ArrayList;
import java.util.List;

public class PurchasedLotto {
    List<Lotto> purchased;

    public PurchasedLotto(int amount) {
        this.purchased = new ArrayList<>();
        purchase(amount);
    }

    private void purchase(int amount) {
        for (int i = 0; i < amount; i++) {
            addLottoToPurchased();
        }
    }

    private void addLottoToPurchased() {
        List<Integer> integerList = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        purchased.add(new Lotto(integerList));
    }

    public List<WinType> checkLotto(List<Integer> bullseye, Integer bonusNum) {
        List<WinType> results = new ArrayList<>();

        purchased.forEach(e -> {
            Integer count = e.checkNumbers(bullseye);
            boolean bonus = false;
            if (count == 5) {
                bonus = e.checkBonus(bonusNum);
            }
            results.add(WinType.getByAttr(count, bonus));
        });
        return results;
    }


}