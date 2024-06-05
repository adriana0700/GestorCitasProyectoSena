import React from 'react';

function Footer() {
    return (
        <footer id="contacto">
            <div className="contenedor contenedor-footer">
                <h1 className="titulo">Contacto</h1>
                <div className="cont-img-redes">
                    <img className="img-redes" src="img/facebook.svg" alt="" />
                    <img className="img-redes" src="img/instagram.svg" alt="" />
                    <img className="img-redes" src="img/whatsapp.svg" alt="" />
                </div>
                <p>Medellín - Colombia</p>
                <div className="iconos">
                    <small>
                        Icons made by
                        <a href="https://www.flaticon.com/authors/roundicons" title="Roundicons">Roundicons</a>
                        from <a href="https://www.flaticon.com/" title="Flaticon">www.flaticon.com</a>
                    </small>
                </div>
            </div>
        </footer>
    );
}

export default Footer;
