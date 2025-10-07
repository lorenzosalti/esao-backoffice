import { Outlet } from "react-router-dom"
import Header from "../components/Header"
import Footer from "../components/Footer"
import { useContext } from "react"
import GlobalContext from "../contexts/GlobalContext"
import Loading from "../components/Loading"


function DefaultLayout() {

  const { isLoading } = useContext(GlobalContext)

  return (
    <>
      <Header />
      <main>
        {isLoading && <Loading />}
        <Outlet />
      </main>
      <Footer />
    </>
  )
}

export default DefaultLayout