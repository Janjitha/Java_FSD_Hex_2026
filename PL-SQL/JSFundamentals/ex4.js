// Simulating an API call 
const response = [
    {id: 1, name: 'Apple Iphone 7', price: 500},
    {id: 2, name: 'OnePlus 3', price: 350},
    {id: 3, name: 'Oppo 20', price: 300},
    {id: 4, name: 'Samsung 5', price: 400},
    {id: 5, name: 'Realme 4', price: 370}
]

// Fn for fetchng product by id 
function getById(id){
    return new Promise((resolve,reject) =>{
        setTimeout(()=>{
            const product = response.find(p=> p.id === id)
            if(product !== undefined){
                resolve(product)
            }
            else{
                reject('Product not found')
            }
        }, 1);  //1 sec delay is buying myself some time for processing-API call
    })
}
 
// console.log(getById(2)); // This returns the promise 

getById(20)
.then(p => console.log(`Product: ${p.id}, ${p.name} , ${p.price}`))
.catch(err => console.log(`Error: ${err}`))

// getById(2) : Product: 2, OnePlus 3 , 350
// getById(100) : Error: Product not found

// Modern Way fo calling and handling API : async - await 

const getByidHandle = async (id)=>{
    try{
        const p =  await getById(id)
        console.log(`Product: ${p.id}, ${p.name} , ${p.price}`)
    }
    catch(err){
        console.log(`Error: ${err}`)
    }
}
getByidHandle(2) //Product: 2, OnePlus 3 , 350
getByidHandle(100) //Error: Product not found