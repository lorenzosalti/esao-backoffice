import { BrowserRouter, Routes, Route } from "react-router-dom"
import Records from "./pages/Records"
import RecordDetails from "./pages/RecordDetails"

function App() {

  return (
    <BrowserRouter>
      <Routes>
        <Route path="/" element={<h1>Pagina di Home</h1>} />
        <Route path="/records" element={<Records />} />
        <Route path="/records/:id" element={<RecordDetails />} />
        <Route path="*" element={<h1>404 Not Found</h1>} />
      </Routes>
    </BrowserRouter>
  )
}

export default App
