# Every Sound At Once

L’obiettivo di questo progetto è creare un backoffice in Spring e un frontend in React per gestire e visualizzare una collezione di vinili.

---

## Parte 1: Backoffice in Spring

L'accesso al backoffice richiederà un'autenticazione gestita da Spring Security. Una volta loggato, l'utente potrà gestire l'entità principale *Record*, che corrisponde ai Dischi della collezione, e l'entità *Condition*, che descrive lo stato di conservazione del vinile. 
Le due entità sono collegate tramite una relazione **1-N**.

Per entrambe le entità sono implementate tutte le operazioni **CRUD** (Creazione, Lettura, Aggiornamento, Eliminazione).