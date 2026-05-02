package com.example.rutaescolarapp

import java.io.*
import java.net.HttpURLConnection
import java.net.URL
import java.net.URLEncoder

object Conexion {

    private const val URL_LOGIN = "http://10.0.2.2/ruta_escolar_api/login.php"
    private const val URL_REGISTRO = "http://10.0.2.2/ruta_escolar_api/registro.php"

    fun login(usuario: String, password: String): String {

        val datos = "usuario=" + URLEncoder.encode(usuario, "UTF-8") +
                "&password=" + URLEncoder.encode(password, "UTF-8")

        return enviarDatos(URL_LOGIN, datos)
    }

    fun registrar(usuario: String, rol: String, password: String): String {

        val datos = "usuario=" + URLEncoder.encode(usuario, "UTF-8") +
                "&rol=" + URLEncoder.encode(rol, "UTF-8") +
                "&password=" + URLEncoder.encode(password, "UTF-8")

        return enviarDatos(URL_REGISTRO, datos)
    }

    private fun enviarDatos(urlString: String, datos: String): String {
        return try {
            val url = URL(urlString)
            val conexion = url.openConnection() as HttpURLConnection

            conexion.requestMethod = "POST"
            conexion.doOutput = true

            val output = BufferedWriter(OutputStreamWriter(conexion.outputStream))
            output.write(datos)
            output.flush()
            output.close()

            val input = BufferedReader(InputStreamReader(conexion.inputStream))
            val respuesta = input.readLine()
            input.close()

            respuesta ?: "ERROR"

        } catch (e: Exception) {
            e.printStackTrace()
            "ERROR"
        }
    }
}