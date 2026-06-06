// Functions in JS 
/**
 * Type 1: Traditional 
 * Type 2: Arrow Fn 
 */

// Traditional way 
function welcome(name){
    return `Hello ${name}`
}
console.log(welcome('Ron'))

// Arrow Fn 
const fn = (name) =>  {
    return `Hello ${name}`;
}

const fn1 = (name) =>`Hello ${name}` 
 
console.log(fn1('hermione'))

// Ex : Tradional to Array 
function sumT(n1,n2){
    return n1+n2; 
}

// Arrow Fn 
const sumA = (n1,n2) => n1+n2
console.log(sumA(2,3))