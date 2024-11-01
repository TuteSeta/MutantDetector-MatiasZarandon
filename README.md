# 🧬 Mutant Detector API

¡Bienvenido al proyecto **Mutant Detector**! Esta aplicación es una API REST que analiza secuencias de ADN para determinar si un humano es mutante. 💻🔬

<p align="center">
  [![Mutant](https://github.com/user-attachments/assets/595d9046-ee7d-4908-a79c-775478051d78)](https://private-user-images.githubusercontent.com/162921383/382363397-634d7188-629c-4993-b035-a6ad9d41e273.gif?jwt=eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJnaXRodWIuY29tIiwiYXVkIjoicmF3LmdpdGh1YnVzZXJjb250ZW50LmNvbSIsImtleSI6ImtleTUiLCJleHAiOjE3MzA0ODM5NzksIm5iZiI6MTczMDQ4MzY3OSwicGF0aCI6Ii8xNjI5MjEzODMvMzgyMzYzMzk3LTYzNGQ3MTg4LTYyOWMtNDk5My1iMDM1LWE2YWQ5ZDQxZTI3My5naWY_WC1BbXotQWxnb3JpdGhtPUFXUzQtSE1BQy1TSEEyNTYmWC1BbXotQ3JlZGVudGlhbD1BS0lBVkNPRFlMU0E1M1BRSzRaQSUyRjIwMjQxMTAxJTJGdXMtZWFzdC0xJTJGczMlMkZhd3M0X3JlcXVlc3QmWC1BbXotRGF0ZT0yMDI0MTEwMVQxNzU0MzlaJlgtQW16LUV4cGlyZXM9MzAwJlgtQW16LVNpZ25hdHVyZT03YmIyOWVlMTJmYzlmZTc5OGQzNWQ2OWNjOTM4MDdmYmE5NjU4ZWI4ZTlhOWEwMGFjM2VmYThiYzk4ZjE1ZTViJlgtQW16LVNpZ25lZEhlYWRlcnM9aG9zdCJ9.qjnQCHqxwiNxax7T04nx4nHtH6SUzLmfr29ky5pq2MA)
</p>

## 📜 Funcionalidad

La API recibe una secuencia de ADN en formato JSON a través de una solicitud HTTP POST. Luego, utiliza un algoritmo de análisis para detectar patrones mutantes en la secuencia y responde si es mutante o no. También puedes obtener estadísticas sobre el número de secuencias analizadas a través de una solicitud HTTP GET.

## 🚀 Tecnologías Utilizadas

- **Java** + **Spring Boot**: Para la lógica de negocio y el manejo de las solicitudes HTTP.
- **H2 Database**: Base de datos en memoria para almacenar temporalmente las secuencias de ADN y estadísticas.
- **Postman**: Para probar los endpoints de la API.
- **JSON**: Formato de intercambio de datos entre el cliente y el servidor.

## 🌐 Endpoints de la API

### POST `/mutant`

Envía una secuencia de ADN en formato JSON para verificar si corresponde a un mutante. 

#### Ejemplo de solicitud en Postman

1. Abre Postman y selecciona el método `POST`.
2. Ingresa la URL de la API: `http://localhost:8080/mutant`.
3. En la pestaña **Body**, selecciona **raw** y **JSON**.
4. Ingresa el siguiente JSON:

```json
{
  "dna": ["ATGCGA", "CAGTGC", "TTATGT", "AGAAGG", "CCCCTA", "TCACTG"]
}
