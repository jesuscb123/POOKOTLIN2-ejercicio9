
val menu = """
    Bienvenido al programa OrganizaTareas
    -------------------------------------
                ¿Qué desea hacer?
    1. Agregar nueva tarea.
    2. Eliminar tarea.
    3. Cambiar estado de una tarea.
    4. Listar todas las tareas.
    5. Salir del programa.
            """.trimIndent()


val menuEstado = """

                   Elige un estado: 
                   1. Realizado
                   2. Pendiente
    
            """.trimIndent()

fun pausa(){
    Thread.sleep(2000)
}

fun limpiarPantalla(){
    for(i in 1..10){
        println(" ")
    }
}

fun pedirOpcion(msj: String, opcionesMax: Int): Int{
    var opcionCorrecta = false
    var opcion = 0
    while (!opcionCorrecta){
        try {
            print(msj)
            opcion = readln().toInt()
            if (opcion !in 1..opcionesMax) {throw IllegalArgumentException("Error, introduce una opción disponible.")}
            opcionCorrecta = true
        }catch (e: NumberFormatException){
            println("Error, introduce un número.")
        }catch (e: IllegalArgumentException){
            println("$e")
        }
    }
    return opcion
}


fun agregarTarea(listaTareas: ListaTareas){
    print("Introduzca un identificador para la tarea: ")
    val identificadorTarea = readln()
    print("Introduzca una descripción de la tarea a realizar: ")
    val descripcionTarea = readln()
    val tareanueva = Tarea(identificadorTarea, descripcionTarea)
    if(listaTareas.agregarTarea(tareanueva)){
        println("La tarea con id ${tareanueva.idTarea} se ha agregado correctamente.")
    }else{
        println("La tarea no puedo agregarse debido a que el id $identificadorTarea ya existe.")
    }

}


fun eliminarTarea(listaTareas: ListaTareas) {
    listaTareas.mostrarTareas()
    println("¿Qué tarea deseas eliminar?")
    val tareaAeliminar = readln()
    if(listaTareas.eliminar(tareaAeliminar)){
        println("la tarea con id $tareaAeliminar con id $tareaAeliminar se ha eliminado correctamente.")
    }else{
        println("La tarea con id $tareaAeliminar con id $tareaAeliminar no existe.")
    }

}


fun cambiarEstado(listaTareas: ListaTareas){
    listaTareas.mostrarTareas()
    print("Escriba el identificador de la tarea: ")
    val identificadorTarea = readln()
    println(menuEstado)
    val opcionUsuario = pedirOpcion("Introduce una opción: ", opcionesMax = 2)
    when(opcionUsuario){
        1 ->{
            listaTareas.cambiarEstado(identificadorTarea,"realizado")

        }

        2 ->{
            listaTareas.cambiarEstado(identificadorTarea, "pendiente")
        }
    }
}


fun main(){
    val listaTareas = ListaTareas()
    var opcionesMax = 5
    var salir = false
    while (!salir){
        println(menu)
        val opcionUsuario = pedirOpcion("Introduce una opción: ", opcionesMax)
        when (opcionUsuario){
            1 ->{
                agregarTarea(listaTareas)
                pausa()
                limpiarPantalla()

            }

            2 ->{
                eliminarTarea(listaTareas)
                pausa()
                limpiarPantalla()
            }

            3 -> {

                cambiarEstado(listaTareas)
                pausa()
                limpiarPantalla()
            }

            4 -> {
                listaTareas.mostrarTareas()
                pausa()
                limpiarPantalla()

            }

            5 -> {
                salir = true
                println("Has finalizado el programa.")
            }
        }
    }
}