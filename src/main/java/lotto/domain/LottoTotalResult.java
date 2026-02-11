package lotto.domain;

import java.util.EnumMap;
import java.util.Map;

public class LottoTotalResult {

    private static int LOTTO_PRICE = 1000;
    private final Map<Rank, Integer> rankCounts = new EnumMap<>(Rank.class);
    private final int totalPrice;
    private final int totalProfit;

    public LottoTotalResult(LottoResults lottoResults) {
        this.totalPrice = lottoResults.lottoResults.size() * LOTTO_PRICE;
        int profitSum = 0;
        for (Rank rank : Rank.values()) {
            rankCounts.put(rank, 0);
        }

        for (Rank rank : lottoResults.getLottoResultRanks()) {
            rankCounts.put(rank, rankCounts.get(rank) + 1);
            profitSum += rank.getWinningMoney();
        }

        this.totalProfit = profitSum;
    }

    public int getCount(Rank rank) {
        return rankCounts.getOrDefault(rank, 0);
    }

    public Map<Rank, Integer> getRankCounts() {
        return rankCounts;
    }

    public String getTotalResultString() {
        StringBuilder sb = new StringBuilder();

        for (Rank rank : Rank.values()) {
            if (rank == Rank.MISS) {
                continue;
            }

            int count = rankCounts.getOrDefault(rank, 0);

            sb.append(rank.getRanking())
                    .append("개 일치 (")
                    .append(rank.getWinningMoney())
                    .append("원) - ")
                    .append(count)
                    .append("개\n");
        }

        return sb.toString();
    }

    public double getProfit() {
        return (double) totalProfit / totalPrice;
    }
}
