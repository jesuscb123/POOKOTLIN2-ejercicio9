import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
data class Tarea(val idTarea: String, val descrip: String) {
    var estado = "pendiente"



    fun formatearFecha(): String{
        val fechaHoraActual = LocalDateTime.now()
        val formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss")
        val fechaFormateada = fechaHoraActual.format(formatter)
        return fechaFormateada
    }




    override fun toString(): String {
        if (estado == "realizado"){
            val fechaActual = formatearFecha()
            return "Id: $idTarea, descripción $descrip $estado el día $fechaActual"
        }else{
            return "Id: $idTarea, descripción $descrip, estado: $estado "
        }
    }
}