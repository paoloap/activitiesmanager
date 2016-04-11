# activitiesmanager
Sistema software che gestisce una to-do list

Progetto Maven:


Implementare un Sistema Software che gestisca una TO-DO list (pagina JSP) per ogni utente (WORKER)mostri:
- le attività da eseguire;
- la lista completa (pagina JSP) che contenga TUTTE le attività presenti nel Sistema (pagina in sola lettura).

Nel Sistema vi sarà anche un altro tipo di Utente (ADMINISTRATOR) il quale si occuperà di assegnare le attività agli utenti. Quest’ultimo avrà:
- la pagina di riepilogo, la quale gli mostrerà lo stato delle Attività (ASSIGNED, IN WORKING, DONE)
- la pagina che contiene tutte le Attività.

Solo l’utente ADMINISTRATOR può cancellare eventuali Attività (Nome, Descrizione).

 

Elenco tabelle:

-          ACTIVITY: Id, Name, Description, Id_status, Id_user

-          ACTIVITY_STATUS: Id, Description

-          USER: Id, Name, Surname, Address, Birthday, City, Id_Role

-          USER_ROLE: Id, Description
