import axios from "axios";
import { useContext, useEffect, useState } from "react";
import GlobalContext from "../contexts/GlobalContext";


function Conditions() {

  const [conditions, setConditions] = useState([]);

  const { isLoading, setIsLoading } = useContext(GlobalContext);

  const conditionsUrl = "http://127.0.0.1:8080/api/conditions";

  function getConditions() {

    setIsLoading(true);

    axios.get(conditionsUrl)
      .then(res => {
        setConditions(res.data);
        setIsLoading(false);
      })
      .catch(err => {
        console.error(err);
        setIsLoading(false);
      })
  };

  useEffect(getConditions, []);

  return (
    <div className="container mt-5">
      <h1 className="mb-4 text-center heading">Guida agli Stati di Conservazione (Grading)</h1>
      <p className="lead text-center mb-5">
        Consulta questa legenda per comprendere il grado di usura dei vinili nella collezione.
      </p>

      <div className="row justify-content-center mb-5">
        <div className="col-lg-8">
          <ul className="list-group list-group-flush shadow-lg rounded">

            {conditions.length || isLoading ? conditions.map(condition => (
              <li key={condition.id} className="list-group-item py-3 px-4">
                <div >
                  <h3 className="fw-bold fs-5 heading">{condition.name}</h3>
                  <p>{condition.description}</p>
                </div>
              </li>
            )) : <h2>404 Nessuno stato trovato</h2>}

          </ul>
        </div>
      </div>
    </div>
  )

}

export default Conditions