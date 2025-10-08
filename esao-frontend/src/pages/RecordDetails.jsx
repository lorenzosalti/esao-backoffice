import { useContext, useEffect, useState } from "react";
import { Link, useParams } from "react-router-dom";
import axios from "axios";
import GlobalContext from "../contexts/GlobalContext";


function RecordDetails() {

  const { id } = useParams();
  const [record, setRecord] = useState({});

  const { setIsLoading } = useContext(GlobalContext);

  const recordUrl = `http://127.0.0.1:8080/api/records/${id}`;

  function getRecord() {

    setIsLoading(true);

    axios.get(recordUrl)
      .then(res => {
        setRecord(res.data);
        setIsLoading(false);

      })
      .catch(err => {
        console.error(err);
        setIsLoading(false);
      })
  };

  useEffect(getRecord, [id]);

  const { title, artist, pressingYear, isFirstPress, duration, description, listeningLink, coverPath, condition } = record;

  return (
    <>
      <div className="container mt-5">

        <div className="row mb-4">
          <div className="col-12">
            <h1 className="display-4 fw-bold">{title}</h1>
            <p className="lead text-muted">by {artist}</p>
            <hr />
          </div>
        </div>

        <div className="row">
          <div className="col-md-5 mb-4">
            <img src={coverPath} className="img-fluid rounded shadow-lg" alt={`Copertina di ${title}`} />
          </div>

          <div className="col-md-7 mb-4">
            <div className="row mb-4">
              <div className="col">
                <h4 className="mb-3">Dettagli Tecnici</h4>
                <ul className="list-group list-group-flush shadow-lg rounded">
                  <li className="list-group-item py-3 px-4">
                    Durata totale: <strong>{duration}</strong>
                  </li>
                  <li className="list-group-item py-3 px-4">
                    Anno di stampa: <strong>{pressingYear}</strong>
                  </li>
                  <li className="list-group-item py-3 px-4 d-flex align-items-center">
                    <span>Prima Stampa: {isFirstPress ? <span className="badge bg-success fs-6">&#10003;</span> : <span className="badge bg-danger fs-6">&#10005;</span>}</span>
                  </li>
                  <li className="list-group-item py-3 px-4 d-flex justify-content-between">
                    <span>Stato di conservazione: <strong>{condition?.name}</strong></span>
                    <Link to="/conditions" className="btn btn-sm btn-primary shadow">Guida ai gradi</Link>
                  </li>
                </ul>
              </div>
            </div>
            <h4 className="mt-4">Descrizione</h4>
            <p className="text-secondary">{description}</p>
            <a href={listeningLink} target="_blank" className="btn btn-primary btn-lg mt-4 w-100 shadow">
              Ascolta il Disco
            </a>
          </div>
        </div>
      </div >
    </>
  );
}

export default RecordDetails
