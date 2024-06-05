import React from 'react';

function Header() {
    return (
        <header>
            {/* Contenido del encabezado */}
            <div className="wrap-header">
                <div className="header-titulo">
                    <div className="header-titulo-nombre">
                        <div className="cont-img">
                            <img className="img_logo" src="img/psicologia.svg" alt="logo" />
                        </div>
                        <h1 className="titulo">ASESORIAS PSICOLÓGICAS</h1>
                    </div>

                    <nav>
                        <ul>
                            <li><a href="#inicio">INICIO</a></li>
                            <li><a href="#main">¿QUIÉNES SOMOS?</a></li>
                            <li><a href="#contacto">CONTACTO</a></li>
                        </ul>
                    </nav>
                </div>

                <div className="contenedor">
                    <div className="header-texto">
                        <p className="parrafo-header-texto">Primera sesión</p>
                        <h1 className="h1-header-texto">GRATIS</h1>
                        <div>
                            <a href="#form-registro" id="enlace-registro">Agenda tu cita</a>
                        </div>
                    </div>
                </div>
            </div>
        </header>
    );
}

export default Header;
