
import org.jsoup.Jsoup;
import org.jsoup.nodes.*;

public class WebScraper {
	
	public static void main(String[] args) {
		
		// McDonald's Data
		Tree treeMcDonalds = new Tree();
		final String urlMcDonalds = "https://www.fastfoodprice.com/menu/mcdonalds-prices/";
		
		try {
		
			final Document docMcDonalds = Jsoup.connect(urlMcDonalds).get();
		
			System.out.println("\n*** McDonald's ***\n");
			
			System.out.println("Extra Value Meals: ");
			final String tableExtraValueMeals = "table.tablepress.tablepress-id-Mcdonalds1 tr";
			getData("McDonald's", docMcDonalds, tableExtraValueMeals, treeMcDonalds);

			System.out.println("\nAll Day Breakfast: ");
			final String tableAllDayBreakfast = "table.tablepress.tablepress-id-Mcdonalds2 tr";
			getData("McDonald's", docMcDonalds, tableAllDayBreakfast, treeMcDonalds);

			System.out.println("\nMcNuggets & Tenders: ");
			final String tableMcNuggestTenders = "table.tablepress.tablepress-id-Mcdonalds15 tr";
			getData("McDonald's", docMcDonalds, tableMcNuggestTenders, treeMcDonalds);
			
			System.out.println("\nEveryday Value: ");
			final String tableEverydayValue = "table.tablepress.tablepress-id-Mcdonalds6 tr";
			getData("McDonald's", docMcDonalds, tableEverydayValue, treeMcDonalds);
			
			System.out.println("\nFries & Sides: ");
			final String tableFriesSides = "table.tablepress.tablepress-id-Mcdonalds5 tr";
			getData("McDonald's", docMcDonalds, tableFriesSides, treeMcDonalds);
			
			System.out.println("\nSweets & Treats: ");
			final String tableSweetsTreats = "table.tablepress.tablepress-id-Mcdonalds8 tr";
			getData("McDonald's", docMcDonalds, tableSweetsTreats, treeMcDonalds);
			
			System.out.println("\nSalads & More: ");
			final String tableSaladsMore = "table.tablepress.tablepress-id-Mcdonalds3 tr";
			getData("McDonald's", docMcDonalds, tableSaladsMore, treeMcDonalds);
			
			
			System.out.println("\nEntire Menu: ");
			treeMcDonalds.reverseInOrder(treeMcDonalds.root);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	private static void getData(String restaurant, Document doc, String table, Tree treeEntire) {
		Tree tree = new Tree();
		for(Element row : doc.select(table)) {
			String item = row.select("td.column-1").text();
			String size = row.select("td.column-2").text();
			String calories = row.select("td.column-3").text();
			String price = row.select("td.column-4").text();
			calories = calories.replace("Cal", "");
			calories = calories.replace(".", "");
			if (!size.isEmpty()) {
				item = item + " " + size;
			} 
			if (calories.equals("Varies") || item.equals("BAKERY:") || price.equals("$0.00")) {
				continue;
			} else {
				Items i = new Items(item, Double.parseDouble(calories), price);
				tree.addNode(i);
				treeEntire.addNode(i);
			}
			
		}
		tree.reverseInOrder(tree.root);
	}
}
