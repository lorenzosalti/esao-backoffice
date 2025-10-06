# Every Sound At Once

L’obiettivo di questo progetto è creare un backoffice in Spring e un frontend in React per gestire e visualizzare una collezione di vinili.

---

## Parte 1: Backoffice in Spring

L'accesso al backoffice richiederà un'autenticazione gestita da Spring Security. Una volta loggato, l'utente potrà gestire l'entità principale *Record*, che corrisponde ai Dischi della collezione, e l'entità *Condition*, che descrive lo stato di conservazione del vinile. 
Le due entità sono collegate tramite una relazione **1-N**.

Per entrambe le entità sono implementate tutte le operazioni **CRUD** (Creazione, Lettura, Aggiornamento, Eliminazione).

---

## Parte 2: Frontend in React

Per i visitatori non autenticati (*guest*) è stata creata un'app in React che permette di:

- Visualizzare la lista degli elementi *Record*
- Vedere i dettagli di un singolo *Record*
- Mostrare anche le informazioni riguardo lo stato di conservazione del vinile (*Condition*)

Questa app comunica con il backend tramite chiamate **AJAX** ad **API REST**, quindi nel backend è stato creato un set di endpoint **API** per recuperare i dati.