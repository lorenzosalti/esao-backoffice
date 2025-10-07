import { useEffect, useState } from "react";
import { useParams } from "react-router-dom";
import axios from "axios";


function RecordDetails() {

  const { id } = useParams();
  const [record, setRecord] = useState({});

  const recordUrl = `http://127.0.0.1:8080/api/records/${id}`;

  function getRecord() {
    axios.get(recordUrl)
      .then(res =>
        setRecord(res.data)
      )
      .catch(err => console.error(err))
  };

  useEffect(getRecord, [id]);

  const { title, artist, pressingYear, isFirstPress, duration, description, listeningLink, coverPath, condition } = record;

  return (
    <>
      <div className="container mt-5">

        <div className="row mb-4">
          <div className="col-12">
            <h1 className="display-4 fw-bold">{title}</h1>
            <p className="lead text-muted">{artist}</p>
            <hr />
          </div>
        </div>

        <div className="row">
          <div className="col-md-5 mb-4">
            <img
              src={coverPath}
              className="img-fluid rounded shadow-lg"
              alt={`Copertina di ${title}`}
            />
            <a
              href={listeningLink}
              target="_blank"
              rel="noopener noreferrer"
              className="btn btn-primary btn-lg mt-4 w-100"
            >
              🎧 Ascolta il Disco Esternamente
            </a>
          </div>

          <div className="col-md-7 mb-4">
            <div className="card shadow-sm mb-4">
              <div className="card-header bg-light">
                Dettagli Tecnici
              </div>
              <ul className="list-group list-group-flush">
                <li className="list-group-item">
                  Anno di stampa: <strong>{pressingYear}</strong>
                </li>
                <li className="list-group-item">
                  Durata totale: <strong>{duration}</strong>
                </li>
                <li className="list-group-item d-flex align-items-center">
                  Prima Stampa:  {isFirstPress ? <span className={`badge bg-success fs-6`}>sì</span> : <span className={`badge bg-danger fs-6`}>no</span>}
                </li>
                {/* <li className="list-group-item">
                  Stato di conservazione: <strong>{condition.name}</strong>
                </li> */}
              </ul>
            </div>
            <h4 className="mt-4">Descrizione</h4>
            <p className="text-secondary">{description}</p>
          </div>
        </div>
        {/* Sezione per lo stato di conservazione (un'idea carina) */}
        {/* <div className="row mt-4">
          <div className="col-12">
            {condition.description}
          </div>
        </div> */}
      </div>
    </>
  );
}

export default RecordDetails
