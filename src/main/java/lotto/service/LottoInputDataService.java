package lotto.service;

import java.util.List;
import lotto.domain.Lotto;
import lotto.util.LottoUtil;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoInputDataService {
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();
    private final LottoUtil lottoUtil = new LottoUtil();

    public Lotto inputLottoData() {
        List<Integer> lottoNumbers = inputLottoNumbers();
        int bonusNumber = inputBonusNumber();
        return setLotto(lottoNumbers, bonusNumber);
    }

    public List<Integer> inputLottoNumbers() {
        outputView.askLottoNumbers();
        return lottoUtil.lottoNumbersParser(inputView.inputLottoNumbers());
    }

    public int inputBonusNumber() {
        outputView.askBonusNumber();
        return lottoUtil.bonusNumberParser(inputView.inputBonusNumber());
    }

    public Lotto setLotto(List<Integer> lottoNumbers, int bonusNumber) {
        Lotto lotto = new Lotto(lottoNumbers);
        lotto.setBonusNumber(bonusNumber);
        return lotto;
    }
}