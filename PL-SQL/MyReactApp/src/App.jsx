/*
//this is the content which appears finally
function App(){  // This is a react component
 return ( // Every react component, must return a JSX : HTML + CSS + Javascript 
  <div>
      <h1>Hello React</h1>
  </div>
 )
}
// if we are importing the app in the main.jsx then sure we need to export here
 export default App;
 */
//  -------------------------------------------------------------------------------
import ArithmeticComponent from "./components/ArithmeticComponent";
import Products from "./components/Products";
import CreateProduct from "./components/createProduct";
function App(){ // This is the Parent component in react 

  return(  // This return fn has to be there in every react component. It returns JSX
    // <div>
    //   <h1>Hello React</h1>
    // </div>
    <div>
       {/*<ArithmeticComponent /> */} 
       {/*  <Products /> */}
       <CreateProduct />
    </div>
  )
}
export default App; 
// This is mandatory. If we dont export the fn, we cannot import it anywhere else
/*
JSX : JavaScript Extension (HTML + CSS) : HTML + CSS + JavaScript 
*/