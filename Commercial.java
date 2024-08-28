import java.util.ArrayList;
import java.util.Date;

class CompanyShares {
    private String stockSymbol;
    private int numberOfShares;
    private Date dateTime;

    public CompanyShares(String stockSymbol, int numberOfShares) {
        this.stockSymbol = stockSymbol;
        this.numberOfShares = numberOfShares;
        this.dateTime = new Date(); // Set to current date and time
    }

    public void updateShares(int shares) {
        this.numberOfShares += shares;
        this.dateTime = new Date(); // Update date and time
    }

    @Override
    public String toString() {
        return "Stock Symbol: " + stockSymbol + ", Number of Shares: " + numberOfShares + ", Date: " + dateTime;
    }
}

class StockAccount {
    private ArrayList<CompanyShares> companySharesList = new ArrayList<>();

    public void buy(String stockSymbol, int numberOfShares) {
        for (CompanyShares shares : companySharesList) {
            if (shares.toString().contains(stockSymbol)) {
                shares.updateShares(numberOfShares);
                return;
            }
        }
        companySharesList.add(new CompanyShares(stockSymbol, numberOfShares));
    }

    public void sell(String stockSymbol, int numberOfShares) {
        for (CompanyShares shares : companySharesList) {
            if (shares.toString().contains(stockSymbol)) {
                shares.updateShares(-numberOfShares);
                return;
            }
        }
        System.out.println("Stock not found!");
    }

    public void printStockAccount() {
        for (CompanyShares shares : companySharesList) {
            System.out.println(shares);
        }
    }
}

public class StockAccountTest {
    public static void main(String[] args) {
        StockAccount account = new StockAccount();
        account.buy("AAPL", 50);
        account.buy("GOOG", 100);
        account.sell("AAPL", 20);
        account.printStockAccount();
    }
}
