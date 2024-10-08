import { BrowserRouter, Routes, Route } from 'react-router-dom'
import Home from './pages/Home'
import Register from './pages/Register'
import Login from './pages/Login'




function App() {

  return (
    <div>
      <BrowserRouter>
        <Routes>
          <Route index element={<Home/>} />
          <Route path="/home" element={<Home/>} />
          <Route path="/register" element={<Register/>} />     
          <Route path="/login" element={<Login/>} />          
     
        </Routes>
      </BrowserRouter>
    </div>
  )
  
}

export default App
