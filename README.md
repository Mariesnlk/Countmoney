# Countmoney

## Goal
Web application designed to process data used in the sale of goods in the grocery mini-supermarket "ZLAGODA". It will 
help to more conveniently track the number and price of units of all goods available in the store, sales history, list 
of all types of goods sold in the supermarket, their main characteristics, information about all employees and regular 
customers who have a customer card, this mini-supermarket . Provide access to the necessary information to cashiers and
managers of the mini-supermarket.

## Requirements

###Employee

The system keeps records of employees of the grocery mini-supermarket, storing the following information about each of them: employee ID, name, position, salary, start date of work, date of birth, contact phone number, address. The database stores information about two types of employees: employees who holds the position of manager, they perform the issuance of return agreements and invoices, and cashiers who prints checks.

Not all employees, but only managers have the right to issue invoices and return agreements.
Not all employees, but only cashiers have the right to print checks.

###Category

All products sold in the store belong to a certain product category. Several products can belong to one product's category, but one product's type belongs to only one category. The database stores the following information about each category: category_number, name.

###Goods

Each "Goods" can own only two "Goods in the store": ordinary goods and promotional goods.
The database stores the following information about each product: product id, name, manufacturer and product characteristics.

###Goods in the store

The database stores information about all products sold in the supermarket, both regular and promotional products. A product becomes promotional if the expiration date is about to expire and the number of units of this product in the store is significant. The database stores the following information about each product in the store: UPC-product, UPC-product promotional for this regular product, selling price, number of units of product and information on whether it is a promotional or regular product.
If the supermarket still has a certain number of units of a certain product that was purchased at one price and a new batch of this product arrives at a new purchase price and, accordingly, a new sale price, then the whole product is revalued: that is, the old batch and new batch will have a new the sale price, which is determined according to the new purchase price of the goods.

The markup on goods is determined by the mini-supermarket and is standard for all types of goods. It is 30% of the purchase price.

The product becomes promotional, in accordance with the lower selling price, by reducing the markup of the mini-supermarket on this type of product. The mark-up on the promotional product is also a certain mini-supermarket and is standard for all types of promotional products. It is 20% of the purchase price.

VAT is 20% of the already formed selling price of the goods.

The selling price of the goods is calculated as follows:
purchase. price + purchase. price * 0.3 + 0.2 * (purchase price + purchase price * 0.3).

The new price of the goods remaining in the store at the time of receipt of the new delivery is calculated as follows:
new purchase. price + new purchase. price * 0.3 + 0.2 * (new purchase price + new purchase price * 0.3).

The promotional price of the goods is calculated as follows:
purchase. price + purchase. price * 0.2 + 0.2 * (purchase price + purchase price * 0.2).

###Check

The database for 3 years stores information about all checks that were printed in the supermarket by cashiers for the entire period, including: check_number, date, total amount and VAT.

The total amount is the amount of money that the buyer must pay for all purchased goods in the check. This amount includes VAT.

VAT is the amount of money, the share of which is only VAT from the total amount, calculated by the formula: (total amount * 0.2) /1.2.
VAT is charged on all goods of the mini-supermarket, including promotional ones (see calculation of the promotional price of the goods).
 This mini-supermarket does not sell social goods on which the state does not impose VAT.

The database also contains a list of goods with the number of units of these goods purchased by each check and the selling price of the goods, because after the revaluation of the goods due to changes in the purchase price it will not be possible to determine the real selling price of the goods. ("sales" relationship with "quantity" and "price" relationship attributes).
One check can indicate several types of goods that the buyer wants to buy, and the purchase of one type of goods can be made by many buyers, ie one type of goods can be present in many checks. An attribute of this connection is the number of units of goods that the buyer wants to buy. Each check provides information about the goods purchased by the buyer, but the goods of a certain type may not necessarily be indicated in the check, if the buyer did not plan to purchase goods of this type.

###Customer card

The supermarket has regular customers who are given a customer card with a certain percentage to reduce the price of payment. The amount that the buyer must pay according to one check can be reduced only by using one customer card.
 The database stores the following information about each customer's card: card_number, name of the cardholder, his contact phone number, address and discount percentage.

###Manager requests:

- make a list of employees holding the position of cashier, sorted by name;
- make a list of goods belonging to a certain category, sorted by name;
- find the phone number and address of the employee's last name;
- make a list of all products sorted by name;
- make a list of all categories sorted by name;
- make a list of all products belonging to a certain category:
- make a list of goods in the store that belong to a particular product;
- for UPC-goods to find the selling price of goods, the number of available units of goods.
- make a list of all promotional products, sorted by number of units of goods / by name;
- make a list of all non-promotional products, sorted by number of units of goods / by name;
- make a list of checks printed by a certain cashier for a certain period of time (with the ability to view purchased goods, their number and price);
- make a list of checks printed by all cashiers for a certain period of time (with the ability to view purchased goods, their number and price);
- the total amount of goods sold from checks printed by a certain cashier for a certain period of time;
- the total amount of goods sold from checks printed by all cashiers for a certain period of time;
- determine the total number of units of a particular product sold over a period of time;
- make a list of all regular customers who have a customer card, by fields of name, phone, address (if specified);
- make a list of all regular customers who have a customer card with a certain percentage;
- for UPC-goods to find the selling price of the goods, the number of available units of goods, the name and characteristics of the goods.

###Cashier requests:

- make a list of checks printed by this cashier for a certain period of time;
- print all the information about this check by the check number;
- display all information about the buyer with a specific name that has a customer card;
- list of all regular customers who have a customer card with a certain percentage;
- make a list of goods belonging to a certain category, sorted by name;
- make a list of all products, sorted by name;
- make a list of all promotional products, sorted by number of units of goods / by name;
- make a list of all non-promotional products, sorted by number of units of goods / by name;
- make a list of all goods, information about the sale of which is in this check;
- for UPC-goods to find the selling price of goods, the number of available units of goods.
- find all information about yourself by employee_id.

## Installation and running

### Prerequisites
- JDK, JRE 8 or later,
- Gradle,
- Spring MVC and Spring Boot,
- Spring Data
- Spring Security
- MySQL.

## Set up
- Clone the project to local repository.
- Add Apache Tomcat in Edit Configuration.
- Create database splitwise_db.


