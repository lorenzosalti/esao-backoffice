

function Footer() {

  const currentYear = new Date().getFullYear();

  return (
    <footer className="mt-5 py-5">
      <div className="container">
        <div className="row">

          <div className="col-md-6 text-center text-md-start mb-2 mb-md-0">
            <small>
              &copy; {currentYear} Every Sound At Once. Tutti i diritti riservati.
            </small>
          </div>

          <div className="col-md-6 text-center text-md-end">
            <small>
              <a href="/about" className=" text-decoration-none me-3">
                Informazioni
              </a>
              <a href="/conditions" className=" text-decoration-none">
                Guida ai gradi
              </a>
            </small>
          </div>

        </div>
      </div>
    </footer>
  )
}

export default Footer  