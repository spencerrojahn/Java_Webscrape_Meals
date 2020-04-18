# Java_Webscrape_Meals

This project retrieves the calories and prices of McDonald's menu items, and returns a modified McDonald's menu with the items in order from highest to lowest calories/cost ratio. This project helps people, including me, see which menu items are the best bang for your buck. Meaning, which items have the most calories for their given price.

WebScraper.java contains the physical web scraping of each of the menu tables from the given website.

Items.java contains the Items class that stores each menu item (along with its calorie count and price).

Tree.java creates an implementation of a binary seach tree that stores the Items objects based on the calories/cost ratios.

