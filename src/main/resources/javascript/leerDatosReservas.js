function reservasAulas() 
{
    var idAula = "";
    var fecha = "";

    let elementos = document.getElementsByClassName("aula");
    for(let i = 0; i < elementos.length; i++)
    {
        if(idAula == "")
        {
            idAula += elementos[i].innerHTML;
        }
        i++;
        if(fecha == "")
        {
            fecha += elementos[i].innerHTML;
        }
        window.alert("ID Aula: "+idAula+"\nFecha: "+fecha);
        idAula = "";
        fecha = "";
    }
}

function reservasCarritosPC()
{
    var id = "";
    var carritoId = "";
    var ubicacionPrestamo = "";
    var fechaReserva = "";

    let elementos = document.getElementsByClassName("carroPC");

    for(let i = 0; i < elementos.length; i++)
    {
        if(id == "")
        {
            id += elementos[i].innerHTML;
        }
        i++;
        if(carritoId == "")
        {
            carritoId += elementos[i].innerHTML;
        }
        i++;
        if(ubicacionPrestamo == "")
        {
            ubicacionPrestamo += elementos[i].innerHTML;
        }
        i++;
        if(fechaReserva == "")
        {
            fechaReserva += elementos[i].innerHTML;
        }
        i++;
        window.alert("Id: "+id+"\nId del carrito: "+carritoId+"\nUbicacion del prestamo: "+ubicacionPrestamo+"\nFecha de la reserva: "+fechaReserva);
        id = "";
        carritoId = "";
        ubicacionPrestamo = "";
        fechaReserva = "";
    }
}

function reservasCarritosTablet()
{
    var id = "";
    var carritoId = "";
    var ubicacionPrestamo = "";
    var fechaReserva = "";

    let elementos = document.getElementsByClassName("carroTablet");

    for(let i = 0; i < elementos.length; i++)
    {
        if(id == "")
        {
            id += elementos[i].innerHTML;
        }
        i++;
        if(carritoId == "")
        {
            carritoId += elementos[i].innerHTML;
        }
        i++;
        if(ubicacionPrestamo == "")
        {
            ubicacionPrestamo += elementos[i].innerHTML;
        }
        i++;
        if(fechaReserva == "")
        {
            fechaReserva += elementos[i].innerHTML;
        }
        i++;
        window.alert("Id: "+id+"\nId del carrito: "+carritoId+"\nUbicacion del prestamo: "+ubicacionPrestamo+"\nFecha de la reserva: "+fechaReserva);
        id = "";
        carritoId = "";
        ubicacionPrestamo = "";
        fechaReserva = "";
    }
}