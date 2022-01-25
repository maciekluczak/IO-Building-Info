# Building Info
Dla administratorów budynków, którzy pragną optymalizować koszty zarządzania budynkami  nasza aplikacja Building Info umożliwi pozyskanie informacji o parametrach budynku na poziomie pomieszczeń, kondygnacji oraz całych budynków. Aplikacja będzie dostępna poprzez GUI a także jako zdalne API dzięki czemu można ją zintegrować z istniejącymi narzędziami.


## Struktura danych 
- Lokacja to budynek, poziom, lub pomieszczenie
- Budynek może składać się z poziomów a te z pomieszczeń
- Każda lokalizacja jest charakteryzowana przez:
  - id – unikalny identyfikator
  - name – opcjonalna nazwa lokalizacji
- Pomieszczenie dodatkowo jest charakteryzowane przez:
  - area = powierzchnia w m^2
  - cube = kubatura pomieszczenia w m^3
  - heating = poziom zużycia energii ogrzewania (float)
  - light – łączna moc oświetlenia

## Diagram UML


<img width="613" alt="diagramUML" src="https://user-images.githubusercontent.com/67105405/150929486-7147201a-e139-4a9c-8121-c1a33dad9907.png">




## Akcje naprawcze
W celu sprawniejszej pracy po przydzeleniu zadań ustaliśmy termin kolejnego spotkania w celu cząstkowego podsumowania wyników i ustalenia kolejnego termin spotkania.
Średnio wypadały one raz na 8 dni, nie było potrzeby organizowania ich często ponieważ w razie małych wątpliwości dotyczących implementacji kodu komunikowaliśmy się między sobą w czasie rzeczywistym. Podejście to poprawiło spójność w implementacji kodu i pozwoliło uniknąć niekontrolowanemu nagromadzeniu sie pracy w przededniu oddania sprintu.
