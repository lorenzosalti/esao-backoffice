import { useContext, useEffect, useState } from "react";
import RecordCard from "../components/RecordCard";
import axios from "axios";
import GlobalContext from "../contexts/GlobalContext";

function Records() {

  const [records, setRecords] = useState([]);

  const { isLoading, setIsLoading } = useContext(GlobalContext);

  const recordsUrl = "http://127.0.0.1:8080/api/records";

  function getRecords() {
    setIsLoading(true);

    axios.get(recordsUrl)
      .then(res => {
        setRecords(res.data);
        setIsLoading(false);
      })
      .catch(err => {
        console.error(err);
        setIsLoading(false);
      })
  };

  useEffect(getRecords, []);

  return (
    <div className="for-background">
      <div className="container text-center py-5">
        <h1 className="text-center mb-5 heading">Dischi della collezione</h1>

        <div className="row row-cols-3 gy-2">

          {records.length || isLoading ? records.map(record => (
            <RecordCard key={record.id} data={record} />
          )) : <h2>404 Nessun disco trovato</h2>}

        </div>
      </div>
    </div>
  );
}

export default Records