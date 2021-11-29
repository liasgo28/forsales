package br.com.forsales.common;

/**
 * Enum for possibles flags of cards
 */
public enum CardFlagEnum {
    M("Mastercard"),
    V("Visa"),
    A("American Express");

    private String description;

    CardFlagEnum(String description){
        this.description = description;
    }

    /**
     * Getter
     *
     * @return description from Card Flag
     */
    public String getDescription() {
        return description;
    }
}
