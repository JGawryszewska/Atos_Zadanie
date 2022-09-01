public class Exchange {

    private String currency;
    private String rate;

    public Exchange() {
    }

    public Exchange(String currency, String rate) {
        this.currency = currency;
        this.rate = rate;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getRate() {
        return rate;
    }

    public void setRate(String rate) {
        this.rate = rate;
    }

    public String convert(Exchange exchange, String amount) {
        return String.valueOf(Double.parseDouble(exchange.rate) * Double.parseDouble(amount));
    }

    @Override
    public String toString() {
        return currency + "  " + rate;
    }
}
