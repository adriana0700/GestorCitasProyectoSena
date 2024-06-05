import React from 'react';

function AppointmentForm() {
    return (
        <section className="contenedor-registro">
            <div class="contenedor">
                        <form action="/Modulo1GestionCitas/agregar" id="form-registro" method="POST">
                            <div>
                                <label for=><h3>Agenda Tu Cita</h3> </label>
                            </div>
                            <div>
                                <label for="nombre">Nombre</label>
                                <input type="text" id="nombre" name="nombre" class="campo" required minlength="4" maxlength="30" pattern="[A-Za-z\s]+">
                                <div class="error"></div>
                            </div>
                            <div>
                                <label for="edad">Edad</label>
                                <input type="number" id="edad" name="edad" class="campo" required minlength="1" maxlength="2" pattern="\d+">
                                <div class="error"></div>
                            </div>
                            <div>
                                <label for="tipoDocumento">Tipo de Documento</label>
                                <input type="text" id="tipoDocumento" name="tipoDocumento" class="campo" required minlength="2" maxlength="7" pattern="[A-Za-z\s]+">
                                <div class="error"></div>
                            </div>
                            <div>
                                <label for="numeroDocumento">No.Documento</label>
                                <input type="text" id="numeroDocumento" name="numeroDocumento" class="campo" required pattern="\d+">
                                <div class="error"></div>
                            </div>
                            <div>
                                <label for="fechaCita">Indique la fecha y hora en la que desea ser atendido</label>
                                <input type="text" id="fechaCita" name="fechaCita" class="campo" required>
                                <div class="error"></div>
                            </div>
                            <input type="submit" id="btn-submit-form" value="Enviar" class="enviar">
                        </form>
                        <!-- Mensaje de éxito -->
                        <div id="mensaje-exito" style="display: none; color: green;">
                            ¡El usuario ha sido registrado exitosamente!
                        </div>
                    </div>
        </section>
    );
}

export default AppointmentForm;
