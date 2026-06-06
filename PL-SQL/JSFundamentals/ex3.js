/**
 Array Method in JS 
 1. forEach
 2. filter
 3. sort
 4. map
 5. Reduce
 6. find 
 */

const products = [
    {id: 1, name: 'Apple Iphone 7', price: 500},
    {id: 2, name: 'OnePlus 3', price: 350},
    {id: 3, name: 'Oppo 20', price: 300},
    {id: 4, name: 'Samsung 5', price: 400},
    {id: 5, name: 'Realme 4', price: 370}
]
console.log(products.length)

// Iteration using forEach 
products.forEach(p=> console.log(p))

// Filter : Equivalent to list.stream() of Java
const productsMoreThan400 =products.filter(p=>p.price >= 400)
console.log(productsMoreThan400)
/**
 [
  { id: 1, name: 'Apple Iphone 7', price: 500 },
  { id: 4, name: 'Samsung 5', price: 400 }
]
 */

// Sorting : Sort as per price 
// Equivalent to list.stream().sort(<comparator>) in java
const sortedProductsByPriceAsc = products.sort((p1,p2)=>p1.price - p2.price)
console.log(sortedProductsByPriceAsc)
/**
 [
  { id: 3, name: 'Oppo 20', price: 300 },
  { id: 2, name: 'OnePlus 3', price: 350 },
  { id: 5, name: 'Realme 4', price: 370 },
  { id: 4, name: 'Samsung 5', price: 400 },
  { id: 1, name: 'Apple Iphone 7', price: 500 }
] 
 */
const sortedProductsByPriceDesc = products.sort((p1,p2)=>p2.price - p1.price)
console.log(sortedProductsByPriceDesc)
/**
 [
  { id: 1, name: 'Apple Iphone 7', price: 500 },
  { id: 4, name: 'Samsung 5', price: 400 },
  { id: 5, name: 'Realme 4', price: 370 },
  { id: 2, name: 'OnePlus 3', price: 350 },
  { id: 3, name: 'Oppo 20', price: 300 }
]
 */

// map Fn 
// Java Equivalent of list.stream().map
const productNames =  products.map(p=>p.name)
console.log(productNames)
/**
 [ 'Apple Iphone 7', 'Samsung 5', 'Realme 4', 'OnePlus 3', 'Oppo 20' ]
 */

// Array Reduce for Sum 
const totalPrice = products.reduce((sum,p)=> sum+p.price , 0)
console.log(totalPrice) // 1920
console.log(`Avg Price ${totalPrice / products.length}`) // Avg Price 384

// Find by Id 
const product = products.find(p=> p.id === 3)
console.log(product) //{ id: 3, name: 'Oppo 20', price: 300 }

const product1 = products.find(p=> p.id === 10)
console.log(product1 === undefined ? "Product could not be found" : product1  )  
//Product could not be found