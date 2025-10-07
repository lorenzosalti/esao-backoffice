import { useEffect, useState } from "react"
import RecordCard from "../components/RecordCard"
import axios from "axios"

function Records() {

  const [records, setRecords] = useState([]);

  const recordsUrl = "http://127.0.0.1:8080/api/records"

  function getRecords() {

    axios.get(recordsUrl)
      .then(res =>
        setRecords(res.data)
      )
      .catch(err => console.error(err))
  }

  useEffect(getRecords, [])

  return (
    <>
      <div className="container text-center">
        <div className="row row-cols-3 gy-2">

          {records.length ? records.map(record => (
            <RecordCard key={record.id} data={record} />
          )) : <h2>404 Nessun disco trovato</h2>}

        </div>
      </div>
    </>
  )
}

export default Records