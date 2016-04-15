Progetto Maven:

Implementare un Sistema Software che gestisca una TO-DO list (pagina JSP) per ogni utente (WORKER)mostri:
- le attività da eseguire;
- la lista completa (pagina JSP) che contenga TUTTE le attività presenti nel Sistema (pagina in sola lettura).

Nel Sistema vi sarà anche un altro tipo di Utente (ADMINISTRATOR) il quale si occuperà di assegnare le attività agli utenti. Quest’ultimo avrà:
- la pagina di riepilogo, la quale gli mostrerà lo stato delle Attività (CREATED, ASSIGNED, IN WORKING, DONE)
- la pagina che contiene tutte le Attività.

Solo l’utente ADMINISTRATOR può cancellare eventuali Attività (Nome, Descrizione).

 

  

   

    

     

     Elenco tabelle:

     -          ACTIVITY: Id, Name, Description, Id_Activity_type,  Id_status, Id_user

     -          ACTIVITY_TYPE: Id_type, Name

     §  Conference;

     §  Selling;

     §  Buying;

     §  ……

     -          ACTIVITY_STATUS: Id, Description

     §  CREATED;

     §  ASSIGNED;

     §  IN_WORKING;

     §  DONE.

     -          USER: Id, Name, Password, Surname,  Address, Birthday, City, Id_Role

     -          USER_ROLE: Id, Name

     -          USER_PERMISSION: Id,Name

     §  Add Activity (WORKER & ADMINISTRATOR)

     §  Delete Activity (ADMINISTRATOR)

     §  Edit Activity (WORKER & ADMINISTRATOR)

     §  Define new Administrator (ADMINISTRATOR)

     §  Assign Activity to User (WORKER & ADMINISTRATOR)

     §  Change Activity Owner (ADMINISTRATOR)

     -          ROLE_PERMISSIONS: Id_role, Id_Permission

      !!!!! E’ solo l’ADMINISTRATOR che assegna le ACTIVITY !!!!

      1)      Log in: utente NON presente, gli viene data la possibilità di registrarsi tramite un FORM (viene salvato all’interno della Tabella USER)

      a.       Deve almeno esistere  un utente ADMINISTRATOR!

      2)      L’utente registrato può creare una nuova Attività: questa Attività, inizialmente, non verrà assegnata ad alcun utente ed il suo stato di Default è CREATED (quindi, ACTIVITY.ID_USER = NULL)

      3)      L’ADMINISTRATOR, si vedrà nella propria Home Page, l’elenco di TUTTE le Activity presenti nel Sistema. Tra queste vedrà, quindi, anche quelle nello stato CREATED.

      Lui selezionerà quelle nello stato CREATED per poterle assegnare ad un utente ben preciso (ASSIGNED)

      4)      Il WORKER, una volta loggato, si vedrà questa nuova Activity sulla sua Pagina à click sul tasto DETAILS à click sul tasto IN_WORKING à click sul tasto DONE

       

       Dettagli Tecnici:

       Il Progetto deve essere strutturato in 3 Layer à 1. Web; 2. Services; 3. DAO  è  DB

        

	 

	  

	  Steps:

	  1.      . Creazione di Schema e Tabelle (con vincoli referenziali);

	  2.      . Creazione delle Entity (con relative annotazioni)

	  3.      . Definizione dei servizi esposti dal layer Services (dal WEB verso SERVICES):

	  a.       Log-in Utente;  

	  b.      Registrazione Utente;

	  c.       CRUD delle Activity (alla creazione, default: CREATED – DELETE valida solo per ADMINISTRATOR);

	  NB: prima di qualsiasi operazione, verificare nella Tabella ROLE_PERMISSIONS se tale operazione l’utente in sessione può farla (possibilità di implementarlo direttamente con Spring).
