import { useState } from "react"
import { products } from "../sample data/products"
function Products() {

    return (
        <div>
            <h1>List of Products</h1>
            <table>

                <tr>
                    <td>Sr. No</td>
                    <td>Name</td>
                    <td>Brand</td>
                    <td>Category</td>
                    <td>Price</td>
                    <td>In Stock</td>
                    <td> </td>
                </tr>

                <tbody>
                    {
                        products.map((p, index) => (
                            <tr>
                                <td>{index + 1}</td>
                                <td>{p.name}</td>
                                <td>{p.brand}</td>
                                <td>{p.category}</td>
                                <td>{p.price}</td>
                                <td>{p.inStock? "true" : "false"}</td>
                                <td> </td>
                            </tr>
                        ))
                    }

                </tbody>
            </table>
        </div>
    )
}

export default Products