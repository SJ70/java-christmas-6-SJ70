package christmas.domain.badge;

import java.util.Arrays;
import java.util.Comparator;

public enum Badge {

    NONE("없음", 0),
    STAR("별", 5000),
    TREE("트리", 10000),
    SANTA("산타", 20000);

    private final String name;
    private final int minimumBenefitAmount;

    Badge(String name, int minimumBenefitAmount) {
        this.name = name;
        this.minimumBenefitAmount = minimumBenefitAmount;
    }

    public static Badge fromBenefitAmount(int benefitAmount) {
        return Arrays.stream(values())
                .filter(badge -> badge.minimumBenefitAmount <= benefitAmount)
                .max(Comparator.comparingInt(o -> o.minimumBenefitAmount))
                .orElseThrow(() -> new IllegalArgumentException(ErrorMessages.INVALID_BENEFIT_AMOUNT.getMessage()));
    }

    public String getName() {
        return name;
    }
}
