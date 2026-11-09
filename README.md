# Service A

Hello-World-Service mit **Java 21 + Spring Boot (Maven)**.
**Rolle: Daten-Consumer** – holt die Daten von Service B (`/api/items`) und gibt sie unter `/items` aus.

Maven muss nicht installiert sein – der Maven Wrapper (`mvnw`) lädt es beim ersten Start.

## Starten

```powershell
.\mvnw.cmd spring-boot:run      # Windows
./mvnw spring-boot:run          # Linux / macOS
```

Oder als JAR:

```powershell
.\mvnw.cmd package
java -jar target/service-a-0.0.1-SNAPSHOT.jar
```

Läuft auf `http://localhost:3000` (Port via Umgebungsvariable `PORT` änderbar).

| Endpoint  | Antwort                                        |
|-----------|------------------------------------------------|
| `/`       | `{"message":"Hello World from Service A"}`     |
| `/health` | `{"status":"UP","service":"service-a"}`        |
| `/items`  | Daten von Service B, oder `503`, wenn B nicht läuft |

Die Adresse von Service B ist standardmässig `http://localhost:5000` und lässt sich über die Umgebungsvariable `SERVICE_B_URL` ändern.
