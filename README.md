
# 🛒 E-Commerce System – Fawry Internship Challenge 2025

## 📋 Overview

This project is a simulation of a simplified **e-commerce system** built in **Java**. It models key components of an online store, such as:
- Products (with or without expiration or shipping needs)
- A shopping cart
- Customers
- Checkout flow
- Shipping service

This system is designed to demonstrate **object-oriented programming principles** (inheritance, interfaces, polymorphism) and clean architectural thinking.

## 🎯 Features

✅ Define products with:
- `name`, `price`, and `quantity`

✅ Support different product behaviors:
- Some products **expire** (like cheese or biscuits or Milk)
- Some products **require shipping** (like TVs and cheese)
- Some products are **digital/non-shippable** (like scratch cards)

✅ Shopping Cart:
- Add products with a quantity ≤ available stock
- Prevent adding expired products
- Calculate **subtotal**
- Prevent checkout if:
  - Cart is empty
  - Customer has insufficient balance
  - Product is out of stock or expired

✅ Checkout Flow:
- Calculate and display:
  - Order subtotal
  - Shipping fees (flat rate)
  - Final amount paid
  - Customer’s remaining balance
- List all shippable items and send them to the `ShippingService`

✅ Shipping Service:
- Accepts a list of objects implementing the `ShippableItem` interface
- Displays:
  - Each item's quantity and weight
  - Total package weight

## 🔧 Tech Stack

- **Java 21+**
- Pure OOP

## Classes

| Class | Responsibility |
|-------|----------------|
| `Product` | Base class for all products |
| `ExpirableProduct` | Products that can expire |
| `ShippableProducts` | Products that require shipping |
| `ShippableExpirableProduct` | Products that expire **and** need shipping |
| `Cart` | Manages items added to the cart |
| `Customer` | Has a balance and can checkout |
| `ShippingService` | Handles shipment logic |
| `ShippableItems` | Interface for items that can be shipped |
| `ExpireItems` | Interface for items that can expire |

## 🧪 Example

```java
            Cart cart = new Cart();
            Customer customer = new Customer("Karimelnekheily", 4000, cart);

            //As cheese are expirable and shippable
            ShippableExpirableProduct cheese = new ShippableExpirableProduct("Cheese", 70, 10, 0.4, LocalDate.of(2025, 7, 27));
            //Tv shippable but not expired
            ShippableProducts tv = new ShippableProducts("TV", 1200, 20, 0.7);
            //scratch card not expired and not shippable
            Product scratchCard = new Product("Scratch Card", 130, 10);

            cart.addItem(cheese, 2);
            cart.addItem(tv, 1);
            cart.addItem(scratchCard, 1);

            customer.checkout(customer, cart);
```
## Image
```
![Fawry](https://github.com/karimelnekheily/Ecommerce-System-Challenge/blob/master/output_image_fawry.png?raw=true)
```

### ✅ Sample Output:

```
** Shipment notice **
1x TV 700g
2x Cheese 400g
Total package weight 1.5kg

** Checkout Receipt **
1X TV 1200
2X Cheese 70
1X Scratch Card 130
-----------------------
Subtotal: 1470.0
Shipping : 30.0
Amount: 1500.0
Remaining Balance: 2500.0
Checkout Done! 🎉
```

## 📦 How to Run

1. Clone the repo https://github.com/karimelnekheily/Ecommerce-System-Challenge.git
2. Open the project in any Java IDE
3. Run the `Main.java` file

## Trainee

**Karim Elnekheily** 
