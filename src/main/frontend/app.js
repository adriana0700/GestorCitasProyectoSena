import React from 'react';
import Header from './Header'; // Importa el componente Header
import Footer from './Footer'; // Importa el componente Footer
import HomePage from './HomePage'; // Importa el componente HomePage
import AppointmentForm from './AppointmentForm'; // Importa el componente AppointmentForm

function App() {
    return (
        <div>
            <Header /> {/* Renderiza el componente Header */}
            <HomePage /> {/* Renderiza el componente HomePage */}
            <AppointmentForm /> {/* Renderiza el componente AppointmentForm */}
            <Footer /> {/* Renderiza el componente Footer */}
        </div>
    );
}

export default App;
