import { useState } from "react"

const CreateProduct = ()=>{

    const [name,setName] = useState() 
    const [price,setPrice] = useState() 
    const [category,setCategory] = useState() 
    const [sCount,setSCount] = useState() 

    const addProduct = (e)=>{
        e.preventDefault() 
        console.log(name)
        console.log(price)
        console.log(category)
        console.log(sCount)
    }
    return(
        <div className="container">
            <div className="row">
                
            </div>
            <div className="row mt-4">
                <div className="col-sm-3"></div>
                <div className="col-md-6">
                     <form onSubmit={(e)=> addProduct(e)}> 
                    <div className="card">
                        <div className="card-header">
                            Enter Product Details
                        </div>
                        <div className="card-body">
                             <div className="mb-4">
                                <label>Product Name: </label>
                                <input type="text" className="form-control" 
                                onChange={(e)=> setName(e.target.value)}
                                />
                             </div>
                             <div className="mb-4">
                                <label>Product Price: </label>
                                <input type="number" className="form-control" 
                                onChange={(e)=> setPrice(e.target.value)}/>
                             </div>
                             <div className="mb-4">
                                <label>Category Name: </label>
                                <select className="form-control" onChange={(e)=> setCategory(e.target.value)}>
                                    <option value="">---select category----</option>
                                    <option value="mobile">Mobiles</option>
                                    <option value="laptop">Laptop</option>
                                    <option value="desktop">Desktop</option>
                                </select>
                             </div>
                             <div className="mb-4">
                                <label>Stock Count: </label>
                                <input type="number" className="form-control" 
                                onChange={(e)=> setSCount(e.target.value)}/>
                             </div>
                        </div>
                        <div className="card-footer">
                            <input type="submit" value="Add Product" className="btn btn-secondary"/>
                         </div>

                    </div>
                    </form>
                </div>
                <div className="col-sm-3"></div>
            </div>
            <div className="row">
                    
            </div>
        </div>
    )
}

export default CreateProduct