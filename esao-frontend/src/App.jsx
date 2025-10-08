import { BrowserRouter, Routes, Route } from "react-router-dom"
import Records from "./pages/Records"
import RecordDetails from "./pages/RecordDetails"
import DefaultLayout from "./layouts/DefaultLayout"
import GlobalContext from "./contexts/GlobalContext"
import { useState } from "react"
import Conditions from "./pages/Conditions"
import Home from "./pages/Home"

function App() {

  const [isLoading, setIsLoading] = useState(false);

  return (
    <GlobalContext.Provider value={{
      isLoading,
      setIsLoading
    }}>
      <BrowserRouter>
        <Routes>
          <Route element={<DefaultLayout />}>
            <Route path="/" element={<Home />} />
            <Route path="/records" element={<Records />} />
            <Route path="/records/:id" element={<RecordDetails />} />
            <Route path="/conditions" element={<Conditions />} />
            <Route path="*" element={<h1>404 Not Found</h1>} />
          </Route>
        </Routes>
      </BrowserRouter>
    </GlobalContext.Provider>
  )
}

export default App
