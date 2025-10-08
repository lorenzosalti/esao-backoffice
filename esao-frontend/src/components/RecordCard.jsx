

function RecordCard({ data }) {

  const { id, title, artist, pressingYear, coverPath } = data

  return (
    <div className="col-lg-3 col-md-4 col-sm-6 mb-4">
      <div className="card h-100 shadow-sm border-0">
        <a href={`/records/${id}`} className="text-decoration-none">
          {coverPath
            ? <img src={coverPath}
              className="card-img-top"
              alt="Copertina"
              style={{ height: '250px', objectFit: 'cover' }} />
            : <img src="../images/missing-cover.png"
              alt="Copertina Mancante"
              style={{ height: '250px', objectFit: 'cover' }} />}
        </a>
        <div className="card-body d-flex flex-column">
          <h5 className="card-title text-truncate mb-1 heading">{title}</h5>
          <h6 className="card-subtitle mb-2 text-truncate">by {artist}</h6>
          <p className="card-text small mb-3">{pressingYear}</p>
          <div className="mt-auto">
            <a href={`/records/${id}`} className="btn btn-sm w-100">Dettagli</a>
          </div>
        </div>
      </div>
    </div>
  )
}

export default RecordCard