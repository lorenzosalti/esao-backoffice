

function Header() {

  return (
    <header>
      <nav className="navbar navbar-expand-lg">
        <div className="container-fluid">
          <a className="navbar-brand" href="/">
            <img src="../images/ESAO-logo.png" alt="ESAO" />
          </a>
          <button className="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
            <span className="navbar-toggler-icon"></span>
          </button>
          <div className="collapse navbar-collapse" id="navbarNav">
            <ul className="navbar-nav">
              <li className="nav-item">
                <a className="nav-link fs-5" href="/">Home</a>
              </li>
              <li className="nav-item">
                <a className="nav-link fs-5" href="/records">Dischi</a>
              </li>
              <li className="nav-item">
                <a className="nav-link fs-5" href="/conditions">Conservazione</a>
              </li>
            </ul>
          </div>
        </div>
      </nav>
    </header>
  )
}

export default Header      