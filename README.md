MyStore shop final test project 	


  Search tests

    1. Search test

      • random one name of product from list of products on home page

      • enter product name into search field

      • click search button

      • check in the search result there is name of product that you are searching for
      
    2. Search test - dropdown
    
      • type ‘HUMMINGBIRD’ in search input (do not click search button)
      
      • when dropdown appears check if all results contains text ‘HUMMINGBIRD
      
      
  Product and categories tests
    
    3. Categories
      
      • iterate through each category (with loop)
      
      • each time check if name of opened category matches what you clicked
      
      • each time check if filters side menu is displayed
      
      • each time check count how many products is in category and check if label “There are X products” contains correct X number of products in that category
      
      • now do the same for subcategories (under clothes and accessoriess)
      
    4. Filters
    
      • go to Art category
      
      • Select $8.00 - $10.00 filter
      
      • check if now in list of products there are only products that matched selected price filter
      
      • clear filter
      
      • check if list was refreshed with all products
      
  Basket and checkout tests
    
    5. Product successfully added to your shopping cart
      
      • Go to art category
      
      • open THE BEST IS YET POSTER
      
      • set quantity to 3
      
      • click add to card button
      
      • check if popup has correct name, price, quantity, there are X items in your cart, Total products value
      
      • click continue shopping
      
      • check if cart icon has update quantity of products – Cart (X)
      
    6. Basket - generic test
    
      • add 5 random products to basket, with random quantities in range of 1-5 (remember all details -> name, quantity price, total price)
      
      • go to basket using it’s url
      
      • check a) if list of items on basket page have all products that you have added, and each product have correct details (name, quantity price, total price)
      
      • check b) if total order value is correct
      
      • delete each product one after another, each time after removing one of them, check repeat check a) and b) (so there will be a) b) executed 4 times each time for each procut and when 0 products left check if empty basket label was displayed)

    7. Checkout
      
      • login with user that have already some orders in history
      
      • add THE BEST IS YET POSTER to the basket
      
      • click on proceed to checkout button on product popup
      
      • click ‘Billing address differs from shipping address’
      
      • fill invoice address form
      
      • select shipping method
      
      • select Pay by Check
      
      • accept terms of service
      
      • click order button
      
      • on order confirmation page check if details -> name, quantity price, total price, ‘shipping and handling’, Payment method, Shipping method, check payments      details are correct
      
      • remember Order reference number
      
      • go to order history
      
      • find Order reference number on the list
      
      • open order details page by clicking ‘Details’ button
      
      • check if date, total price, payment (Awaiting check payment), delivery and invoice address status are correct






