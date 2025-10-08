import { Link } from 'react-router-dom';

function Home() {
  return (
    <>
      <section className="jumbotron jumbotron-fluid text-white text-center d-flex align-items-center">
        <div className="container position-relative z-index-1 p-5">
          <h1 className="display-2 fw-bold mb-3 heading">
            Il Ritmo della Passione
          </h1>
          <p className="lead fs-4 mb-4">
            Una collezione curata di vinili rari e classici, selezionati per te.
          </p>

          <Link to="/records" className="btn btn-lg shadow-lg" role="button">
            Inizia ad Esplorare la Collezione
          </Link>
        </div>
      </section>

      <section className="py-5">
        <div className="container">
          <div className="row justify-content-center">
            <div className="col-lg-8 text-center">
              <h2 className="mb-4 heading">Perché ho creato questa Vetrina</h2>
              <p className="fs-5">
                Questo sito nasce dal desiderio di condividere l'amore per il vinile e l'audio analogico. Ogni disco qui è catalogato con la massima cura, specificando l'anno di stampa e lo stato di conservazione. Non è solo una lista, è una guida all'eccellenza del vinile e, soprattutto, della musica.
              </p>
            </div>
          </div>
        </div>
      </section>

      <section className="py-5">
        <div className="container">
          <h2 className="text-center mb-5 heading">Risorse Utili per l'Esplorazione</h2>
          <div className="row g-4">

            <div className="col-md-6">
              <div className="card h-100 text-center shadow">
                <div className="card-body">

                  <h5 className="card-title mt-3 heading">Sfoglia l'Archivio Completo</h5>
                  <p className="card-text">
                    Vedi tutti i dischi della collezione.
                  </p>
                  <Link to="/records" className="btn shadow">
                    Vai alla Collezione
                  </Link>
                </div>
              </div>
            </div>

            <div className="col-md-6">
              <div className="card h-100 text-center shadow">
                <div className="card-body">

                  <h5 className="card-title mt-3 heading">Guida agli Stati di Conservazione</h5>
                  <p className="card-text">
                    Consulta la nostra guida per decifrare il grado di conservazione.
                  </p>
                  <Link to="/conditions" className="btn shadow">
                    Vedi la Guida ai gradi
                  </Link>
                </div>
              </div>
            </div>

          </div>
        </div>
      </section>
    </>
  );
}

export default Home;