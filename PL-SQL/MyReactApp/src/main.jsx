import { StrictMode } from 'react'
import { createRoot } from 'react-dom/client'
// if we need we can keep this css or else if using bootstrap then we can use that and import that here
// import './index.css' 
import App from './App.jsx'

createRoot(document.getElementById('root')).render(
  //its an extra while learning no need this we can comment the strictmode
  // <StrictMode>
    <App />  //its PARENT switch on's the app
  // </StrictMode>,
)
