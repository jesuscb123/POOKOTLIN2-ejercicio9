class ListaTareas() {
    val listaTareas = mutableSetOf<Tarea>()


    fun agregarTarea(tareaParaAgregar: Tarea): Boolean {
        if(listaTareas.isEmpty()){
            listaTareas.add(tareaParaAgregar)
        }else{
            for(tarea in listaTareas){
                if (tarea.idTarea == tareaParaAgregar.idTarea){
                    return false
                }else{
                    listaTareas.add(tareaParaAgregar)
                }
            }
        }
        return true
    }
    fun cambiarEstado(idTarea: String, estado: String): Boolean{
        for (tarea in listaTareas){
            if(tarea in listaTareas){
                if (tarea.idTarea == idTarea)
                    tarea.estado = estado
                return true
            }
        }
        return false
    }
    fun eliminar(idTarea: String): Boolean{
        if(listaTareas.isEmpty()){
            return false
        }else{
            for(tarea in listaTareas){
                if(tarea.idTarea != idTarea){
                    return false
                }else{
                    listaTareas.remove(tarea)
                }
            }
        }
        return true
    }



    fun mostrarTareas(){
        for (tarea in listaTareas){
                println("$tarea")
            }
        }
    }
