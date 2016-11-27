# PooPrajitura

## Ce am facut

#### In PlayerAchievement si am adaugat 2 noi stats : 
  * BEST_BALL_LOSER
  * BEST_INTERCEPTER
  
#### In CountingGraph am facut 3 noi functii:
  * addEdgeSpecial care foloseste o matrice 2 * nr_player pentru a tine 2 statistici: numarul de mingi pierdute si furate
  * getNodeWithHighestDegreeSpecial care returneaza cheia cu cele mai multe mingi furate
  * getNodeWithLowestDegreeSpecial care returneaza cheia cu cele mai multe mingi pierdute
  Numarul de mingi pierdute este retinut negativ pentru identificare mai usoara
  
#### In GameplayAnalyzer am creeat un nou obiect gModif in care folosesc matricea de nr_player * nr_player doar ca 2 * nr_player

## Codul nu este absolut deloc modular, nu respecta aproape deloc paradigma POO si pe alocuri este duplicat, dar este cel mai mic cod pe care am putut sa il scriu pentru a rezolva cerinta, iar dumneavoastra cautati o solutie corecta, nu una si eleganta

>Prima persoana care ofera pe acest thread o solutie ***corecta*** de extindere codul de la NBA Stats For Coaches pentru a calcula <...> castiga o prajitura.
