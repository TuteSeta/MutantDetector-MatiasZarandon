# 🧬 Mutant Detector API

¡Bienvenido al proyecto **Mutant Detector**! Esta aplicación es una API REST que analiza secuencias de ADN para determinar si un humano es mutante. 💻🔬


![Mutant](https://github.com/user-attachments/assets/634d7188-629c-4993-b035-a6ad9d41e273)


## 📜 Funcionalidad

La API recibe una secuencia de ADN en formato JSON a través de una solicitud HTTP POST. Luego, utiliza un algoritmo de análisis para detectar patrones mutantes en la secuencia y responde si es mutante o no. También puedes obtener estadísticas sobre el número de secuencias analizadas a través de una solicitud HTTP GET.

## 🚀 Tecnologías Utilizadas

- **Java** + **Spring Boot**: Para la lógica de negocio y el manejo de las solicitudes HTTP.
- **H2 Database**: Base de datos en memoria para almacenar temporalmente las secuencias de ADN y estadísticas.
- **Postman**: Para probar los endpoints de la API.
- **Gradle**: Herramienta de construcción y manejo de dependencias.
- **Intellij Idea**: Entorno de desarrollo integrado (IDE)

## 🌐 Endpoints de la API

### POST `/mutant`

Envía una secuencia de ADN en formato JSON para verificar si corresponde a un mutante. 

### GET `/stats`

Obtiene todas cuantos adn humanos y mutantes hay en la base de datos y saca el promedio de mutantes.

#### Ejemplo de solicitud en Postman

1. Abre Postman y selecciona el método `POST`.
2. Ingresa la URL de la API subida en render: `http://localhost:8080/mutant`.
3. En la pestaña **Body**, selecciona **raw** y **JSON**.
4. Ingresa el siguiente JSON o el que prefieras mientras cumpla con las condiciones de adn:

```json
{
  "dna": ["ATGCGA", "CAGTGC", "TTATGT", "AGAAGG", "CCCCTA", "TCACTG"]
}
