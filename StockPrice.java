import java.util.ArrayList;
import java.util.List;

class Stock {
    private String name;
    private int numberOfShares;
    private double sharePrice;

    public Stock(String name, int numberOfShares, double sharePrice) {
        this.name = name;
        this.numberOfShares = numberOfShares;
        this.sharePrice = sharePrice;
    }

    public double calculateValue() {
        return numberOfShares * sharePrice;
    }

    public void printStockReport() {
        System.out.println("Stock Name: " + name);
        System.out.println("Number of Shares: " + numberOfShares);
        System.out.println("Share Price: " + sharePrice);
        System.out.println("Total Value: " + calculateValue());
    }
}

class StockPortfolio {
    private List<Stock> stocks;

    public StockPortfolio() {
        this.stocks = new ArrayList<>();
    }

    public void addStock(Stock stock) {
        stocks.add(stock);
    }

    public void printPortfolioReport() {
        double totalValue = 0;
        for (Stock stock : stocks) {
            stock.printStockReport();
            totalValue += stock.calculateValue();
        }
        System.out.println("Total Portfolio Value: " + totalValue);
    }
}

public class StockPrice {
    public static void main(String[] args) {
        StockPortfolio portfolio = new StockPortfolio();
        portfolio.addStock(new Stock("Apple", 50, 150));
        portfolio.addStock(new Stock("Google", 20, 2800));
        portfolio.printPortfolioReport();
    }
}
