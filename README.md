--
# ProjectBlog 26.04.2024
- Ein Projekt im Bereich verteilte Systeme
# Projekt starten
- ./mvnw quarkus:dev
- im Terminal mit der "w" Funktion, den Browser automatisch öffnen und in die DEV-Ansicht wechseln
- über http://localhost:8080/blog die Klasse aufrufen. (Willkommenstext Blog)

  
# Erstellung des Verzeichnisses hftm-rb 12.05.2024
- Grundaufbau eines quarkus Projekts.
- Diverse Tests mit DEV-Umgebung.
- Erstellung der Klasse Blog.java
- Erstellung der TestKlasse AktuelleZeit.java

# Erster Kontakt mit Dependency Injection und Testing 17.05.2024
- Erstellung der Verzeichnisse control, entity, repository 
- Anpassung der Files BlogService, Blog und Repository
- Erstellung der Testklasse BlogServiceTest für interne Tests.

# DB-Anbindung mit Quarkus Panache
- Dependencies Hibernate ORM with Panache und JDBC Driver MySQL hizugefügt
- Beim Start wird automatisch eine Docker(falls verfügbar) eingerichtet
- Entitys angepasst 
- BlogRepository mit PanacheRepository ausgestattet
- BlogService mit listAll() für alle Datenbank-Einträge angepasst.
