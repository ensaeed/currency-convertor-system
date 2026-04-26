package models;

public class ConversionTestData {


        private String fromCurrency;
        private String toCurrency;
        private double amount;
        private double expectedRate;

        public String getFromCurrency() { return fromCurrency; }
        public String getToCurrency() { return toCurrency; }
        public double getAmount() { return amount; }
        public double getExpectedRate() { return expectedRate; }

        public void setFromCurrency(String fromCurrency) { this.fromCurrency = fromCurrency; }
        public void setToCurrency(String toCurrency) { this.toCurrency = toCurrency; }
        public void setAmount(double amount) { this.amount = amount; }
        public void setExpectedRate(double expectedRate) { this.expectedRate = expectedRate; }
    }

