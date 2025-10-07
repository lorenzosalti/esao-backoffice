import RecordCard from "../components/RecordCard"
import records from "../data/records.json"

function Records() {

  return (
    <>
      <div className="container text-center">
        <div className="row row-cols-3 gy-2">

          {records.map(record => (
            <RecordCard key={record.id} data={record} />
          ))}

        </div>
      </div>
    </>
  )
}

export default Records