# ProjectBlog

Dieses Projekt ist Teil des Moduls "Verteilte Systeme" und implementiert eine einfache Blog-Anwendung unter Verwendung des Quarkus Frameworks. 

## Projektstruktur

Das Projekt ist in folgende Pakete unterteilt:
- **`boundary`**: Beinhaltet die REST-API-Implementierungen.
- **`control`**: Enthält die Logik.
- **`entity`**: Definiert die JPA-Entitäten.
- **`repository`**: Implementiert die Datenzugriffsschicht mit Panache.
- **`ini`**: Initialisiert Standarddaten bei Projektstart.

## Voraussetzungen

- **Docker**: Für die Datenbank (MySQL) und den Keycloak-Server.
- **JDK 11 oder höher**
- **Maven**: Für das Build-Management.

## Projekt starten

1. Stelle sicher, dass Docker läuft.
2. Starte das Projekt im Entwicklungsmodus:
   ```bash
   ./mvnw quarkus:dev
3. Nach dem Start kannst du die Anwendung im Browser über die folgende URL aufrufen: http://localhost:8080.

# Rest-API-Endpunkte
## Blog-Ressourcen
- GET /blogs: Listet alle Blog-Einträge auf. (Zugriff: Öffentlich)
- POST /blogs: Erstellt einen neuen Blog-Eintrag. (Zugriff: Rollen user, admin)
- PUT /blogs/{id}: Aktualisiert einen Blog-Eintrag vollständig. (Zugriff: Rollen user, admin)
- PATCH /blogs/{id}: Aktualisiert einen Blog-Eintrag teilweise. (Zugriff: Rollen user, admin)
- DELETE /blogs/{title}: Löscht einen Blog-Eintrag. (Zugriff: Rolle admin)

# Sicherheitskonfiguration

- Keycloak: Das Projekt verwendet Keycloak für die Authentifizierung und Autorisierung.
    - Client ID: backend-service
    - Realm: blog
    - Benutzer und Rollen:
        - Benutzer rich mit Rolle admin
        - Benutzer peter mit Rolle user
- Die entsprechenden Konfigurationen sind in der application.properties definiert.

# Datenbank

- MySQL: Die Datenbank wird bei Projektstart automatisch als Docker-Container eingerichtet.
- Panache: Zur Interaktion mit der Datenbank werden Panache-Repositories verwendet.

# Tests

- BlogServiceTest: Testet die Geschäftslogik für das Erstellen und Abrufen von Blogs.
- KeyCloakTest: Überprüft die Autorisierung und Authentifizierung über Keycloak.

