# 🧬 Mutant Detector API

¡Bienvenido al proyecto **Mutant Detector**! Esta aplicación es una API REST que analiza secuencias de ADN para determinar si un humano es mutante. 💻🔬

<p align="center">
  <img src="[https://via.placeholder.com/600x300](https://mir-s3-cdn-cf.behance.net/project_modules/1400/c38c5190615179.5e1c727911b9a.gif)" alt="Banner del Proyecto (reemplaza con tu GIF animado de portada)">
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
